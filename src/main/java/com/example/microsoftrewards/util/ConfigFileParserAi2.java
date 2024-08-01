package com.example.microsoftrewards.util;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.microsoftrewards.excel.Excel;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigFileParserAi2 {

    private static Map<String, String> funcMap = new HashMap<>();
    private static Map<String, String> ldpMap = new HashMap<>();
    private static final String excelName = "E:\\Local\\MicroSoftRewards\\src\\main\\resources\\templates\\data.xlsx";

    public static void main(String[] args) {
        String filePath = "E:\\Local\\MicroSoftRewards\\src\\main\\resources\\templates\\crdt.txt"; // 替换为实际的文件路径
        initFuncMap();
        initLdpMap();
        parseConfigFile(filePath);
    }

    private static void initFuncMap() {
        funcMap.put("27241", "组合申请报单");
        funcMap.put("27236", "组合申请查询");
    }

    private static void initLdpMap() {
        ldpMap.put("27241", "ldp");
        ldpMap.put("27236", "ldp.page[27411]");
    }

    public static void parseConfigFile(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                contentBuilder.append(currentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String content = contentBuilder.toString();
        Pattern methodPattern = Pattern.compile("//@funcNo\\((\\d+)\\).*?\\{(.*?\\n\\})", Pattern.DOTALL);
        Matcher methodMatcher = methodPattern.matcher(content);
        List<Excel> excels = new ArrayList<>();
        while (methodMatcher.find()) {
            String funcNo = methodMatcher.group(1);
            String methodContent = methodMatcher.group(2);
            if (!funcMap.containsKey(funcNo)) {
                continue;
            }
            System.out.println("Function Number: " + funcNo);
            excels.add(buildHead());
            excels.addAll(extractParams("Request Parameters", methodContent, "@reqMsg.*?\\{(.*?)\\};", funcNo, funcMap.get(funcNo), ldpMap.get(funcNo)));
            excels.addAll(extractParams("Response Parameters", methodContent, "@rspMsg.*?\\{(.*?)\\};", null, null, null));

            System.out.println("---------------------------------------");
        }
        writeToExcel(excels);
    }

    private static List<Excel> extractParams(String paramType, String content, String regex,  String funcNo,
                                             String name, String ldp) {
        Pattern paramPattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher paramMatcher = paramPattern.matcher(content);
        List<Excel> list = new ArrayList<>();
        boolean firstLine = true;
        if (paramMatcher.find()) {
            String paramContent = paramMatcher.group(1);

            // 打印结构体的字段和注释
            Pattern fieldPattern = Pattern.compile("(uint16_t|uint32_t|uint64_t|int16_t|int32_t|int64_t|char|double)\\s+(\\w+(?:\\[\\d*\\])?);\\s*(//.*|/\\*.*\\*/)?");
            Matcher fieldMatcher = fieldPattern.matcher(paramContent);

            System.out.println(paramType + ":");
            while (fieldMatcher.find()) {
                String fieldName = fieldMatcher.group(2).replaceAll("\\[.*?\\]", ""); // 移除方括号及其内容
                String comment = fieldMatcher.group(3) != null ? fieldMatcher.group(3).trim() : ""; // 获取注释

                if(shouldExclude(fieldName)) {
                    continue;
                }
                Excel excel = new Excel();
                if (firstLine) {
                    if (StringUtils.isNotBlank(funcNo)) {
                        excel.setFuncNo(funcNo);
                    }
                    if (StringUtils.isNotBlank(name)) {
                        excel.setFuncName(name);
                    }
                    if (StringUtils.isNotBlank(ldp)) {
                        excel.setFuncType(ldp);
                    }
                    if (StringUtils.isNotBlank(ldp) && ldp.contains("ldp.page")) {
                        excel.setCollection("Y");
                    } else if ("ldp".equals(ldp)) {
                        excel.setCollection("NL");
                    }
                    firstLine = false;
                }
                if (!shouldExclude(fieldName)) {
                    String fieldType = fieldMatcher.group(1);
                    excel.setType(fieldType);
                    excel.setEnName(fieldName);
                    excel.setEnName2(fieldName);
                    if (StringUtils.isNotBlank(comment)) {
                        comment = comment.replace("/**<", "").replace("*/", "").replace("//", "").replace("/","").trim();
                        excel.setChName(comment.replaceAll("",""));
                    }
                    if("Request Parameters".equals(paramType)) {
                        excel.setInput("I");
                    }
                    if ("Response Parameters".equals(paramType)) {
                        excel.setInput("O");
                    }
                    System.out.println(" " + fieldType + " " + fieldName + "; " + comment);
                }
                list.add(excel);
            }
            System.out.println();
        }
        return list;
    }

    private static boolean shouldExclude(String fieldName) {
        return fieldName.equals("uHeadSize") ||
                fieldName.equals("uRequestNumber") ||
                fieldName.equals("szReserve") ||
                fieldName.equals("iPositionSn") ||
                fieldName.equals("cFlags") ||
                fieldName.equals("szReserve");
    }

    public static Excel buildHead() {
        Excel excel = new Excel();
        excel.setFuncNo("功能编号");
        excel.setFuncName("功能名称");
        excel.setInput("输入输出");
        excel.setEnName("参数字段");
        excel.setType("参数类型");
        excel.setEnName2("LDP参数字段");
        excel.setChName("参数名称");
        excel.setFuncType("功能类型");
        excel.setCollection("是否结果集");
        return excel;
    }

    private static void writeToExcel(List<Excel> dataList) {
        String fileName = excelName;
        File file = new File(fileName);
        file.delete();

        ExcelWriter excelWriter = EasyExcel.write(fileName, Excel.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("Sheet1").build();
        excelWriter.write(dataList, writeSheet);
        excelWriter.finish();
    }
}



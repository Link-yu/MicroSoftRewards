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
import java.util.*;

public final class ReadFile {


    private static final String fileName = "E:\\Local\\MicroSoftRewards\\src\\main\\resources\\templates\\crdt.txt";

    private static final String excelName = "E:\\Local\\MicroSoftRewards\\src\\main\\resources\\templates\\data.xlsx";

    private static final String PREFIX = "//@funcNo(";
    private static final HashMap map = new HashMap();
    static {
//        map.put()
    }


    private static Map<String, String> getHashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("27291","普通委托性能统计");
        return map;
    }

    private static Map<String, String> getLdp() {
        Map<String, String> map = new HashMap<>();
        map.put("27291","ldp");
        return map;
    }

    public static void main(String[] args) {
        List<String> failedList = new ArrayList<>();
        ReadFile.readCfg(failedList);
    }


    public static void readLine() {
        File file = new File(fileName);
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int pick = 0;
            while ((line = br.readLine()) != null) {
                if (!line.trim().contains("fundreal IDataset")) {
                    continue;
                }
                System.out.println(line);
                int i = 2;
                while (i-- > 0) {
                    line = br.readLine();
                    System.out.println(line);
                }
                System.out.println("");
            }
        } catch (Exception e) {

        }
    }

    /**
     * 解析file指定的cfg文件，并将解析出来的入参和出参写入到excel中，调用writeToExcel()方法写入到excel中。
     * 1. //@funcNo(27291)表示功能，其中27291表示功能号
     * 2. //@reqMsg表示入参，嵌套两层struct，第二层嵌套的struct的内容是入参；
     * 3. //@rspMsg表示出参，也是嵌套两层struct，第二层struct表示出参
     *
     */
    public static void parserCrdtCfg() {
        String file = "E:\\Local\\MicroSoftRewards\\src\\main\\resources\\templates\\crdt.txt";

    }

    public static void readCfg(List<String> failedList) {
        Set<String> typeSet = getTypeSet();
        Map<String, String> map = getHashMap();
        Map<String, String> ldpMap = getLdp();
        List<Excel> excels = new ArrayList<>();
        List<String> list = new ArrayList<>();
        File file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String funcNo : map.keySet()) {
            for (int i = 0; i < list.size();i++) {
                if(!list.get(i).contains(funcNo)) {
                    continue;
                }

                excels.add(buildHead());


                // 处理请求参数
                if (list.get(i+1).trim().equals("reqMsg") && list.get(i+2).trim().equals("{")) {
                    boolean needHead = true;
                    for (int j = i + 3; j < list.size();j++) {
                        if (list.get(j).trim().equals("}")) {
                            break;
                        }
                        String line = list.get(j);
                        excels.add(buildExcel(typeSet, line, "I", needHead ? funcNo : null, needHead ? map.get(funcNo): null, needHead ? ldpMap.get(funcNo): null));
                        needHead = false;
                        i = j+1;
                    }
                }

                // 处理返回参数
                if (list.get(i+1).trim().equals("rspMsg") && list.get(i+2).trim().equals("{")) {
                    for (int j = i+3; j < list.size();j++) {
                        if (list.get(j).trim().equals("}")) {
                            break;
                        }
                        String line = list.get(j);
                        excels.add(buildExcel(typeSet, line, "O", null, null, null));
                        i = j+1;
                    }
                }
            }
        }
        writeToExcel(excels);
    }

    private static Excel buildExcel(Set<String> typeSet, String line, String io, String funcNo,
                                    String name, String ldp) {
        String paramType = "";
        int index = 0;;
        for (String type : typeSet) {
            if (line.contains(type)) {
                paramType = type;
                break;
            }
        }
        line = line.replace(paramType, "");
        String[] parts = line.split(";");
        String[] tempArray = new String[9];
        int i = 0;
        for (String part : parts) {
            if (StringUtils.isBlank(part)) {
                continue;
            }
            String temp = part.replaceAll("\\[\\d*\\]", "").replaceAll(";", "").replaceAll("\\*", "").replaceAll("/", "").replaceAll("<", "");
            if (StringUtils.isBlank(temp) || StringUtils.isNumeric(temp)) {
                continue;
            }
            System.out.print(temp.trim());
            System.out.print(" ");
            tempArray[i++] = temp.trim();
        }
        Excel excel = new Excel();
        if (StringUtils.isNotBlank(funcNo)) {
            excel.setFuncNo(funcNo);
        }
        if (StringUtils.isNotBlank(name)) {
            excel.setFuncName(name);
        }
        if (StringUtils.isNotBlank(ldp)) {
            excel.setFuncType(ldp);
        }

        excel.setInput(io);
        excel.setType(paramType);
        excel.setEnName(underScoreToLowerCamel(tempArray[0]));
        excel.setEnName2(tempArray[0]);
        excel.setChName(tempArray[1]);
        return excel;
    }

    public static String underScoreToLowerCamel(String input) {
        if (!input.contains("_")) {
            return input;
        }
        StringBuilder result = new StringBuilder();
        String[] words = input.split("_");
        result.append(words[0]);
        for (int i = 1; i < words.length; i++) {
            result.append(Character.toUpperCase(words[i].charAt(0)))
                    .append(words[i].substring(1));
        }
        return result.toString();
    }


    private static Set<String> getTypeSet() {
        Set<String> set = new HashSet<>();
        set.add("uint16_t");
        set.add("uint32_t");
        set.add("char");
        set.add("int64_t");
        set.add("int32_t");
        set.add("int8_t");
        set.add("double");
        return set;
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
    public static void read(String s) {
        List<Excel> excels = new ArrayList<>();
        File file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean flag = true;
            while ((line = br.readLine()) != null) {
                if (line.trim().contains("********")) {
                    Excel excel = new Excel();
                    excel.setInput("********");
                    excel.setType("********");
                    excel.setEnName("********");
                    excel.setEnName2("********");
                    excel.setChName("********");
                    excels.add(excel);
                    flag = false;
                    continue;
                }
                String[] parts = line.split("&");
                Excel excel = new Excel();
                String[] tempArray = new String[10];
                int i = 0;
                for (String part : parts) {
                    if (StringUtils.isBlank(part)) {
                        continue;
                    }
                    String temp = part.replaceAll("\\[\\d*\\]", "").replaceAll(";", "").replaceAll("\\*", "").replaceAll("/", "").replaceAll("<", "");
                    if (StringUtils.isBlank(temp) || StringUtils.isNumeric(temp)) {
                        continue;
                    }
                    System.out.print(temp.trim());
                    System.out.print(" ");
                    tempArray[i++] = temp.trim();
                }
//                if (flag) {
//                    excel.setInput("I");
//                } else {
//                    excel.setInput("O");
//                }
                excel.setInput(s);
                excel.setType(tempArray[0]);
                excel.setEnName(tempArray[1]);
                excel.setEnName2(tempArray[1]);
                excel.setChName(tempArray[2]);
                excels.add(excel);
                System.out.println();
                System.out.println("*****************************");
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeToExcel(excels);
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

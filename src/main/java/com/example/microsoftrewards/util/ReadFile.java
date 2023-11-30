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


    private static final String fileName = "E:\\Local\\MicroSoftRewards\\src\\main\\resources\\templates\\crdt.cfg";

    private static final String excelName = "E:\\Local\\MicroSoftRewards\\src\\main\\resources\\templates\\data.xlsx";
    private static final HashMap map = new HashMap();
    static {
//        map.put()
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

    public static void readCfg(List<String> functionIdSet) {
        Set<String> typeSet = getTypeSet();
        Map<String, String> map = getHashMap();
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

        for (String funcNo : functionIdSet) {
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
                        excels.add(buildExcel(typeSet, line, "I", needHead ? funcNo : null, needHead ? map.get(funcNo): null, needHead ? "ldp": null));
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

    private static Excel buildExcel(Set<String> typeSet, String line, String io, String funcNo, String name, String ldp) {
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
        excel.setEnName(tempArray[0]);
        excel.setEnName2(tempArray[0]);
        excel.setChName(tempArray[1]);
        return excel;
    }

    private static Map<String, String> getHashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("11220","融券卖出所得查询");
        map.put("11241","专项头寸信息查询");
        map.put("11249","头寸账户信息查询");
        map.put("11271","个人信用资产信息查询");
        map.put("11209","会话信息查询");
        map.put("11210","单客户后台二级费用查询");
        map.put("11212","单客户场内开放式基金费用查询");
        map.put("11211","单客户两融后台二级费用查询");
        map.put("11213","单客户两融场内开放式基金费用查询");
        map.put("11280","单客户扩展信息查询");
        map.put("11281","单客户适当性偏好控制信息查询");
        map.put("11284","前台费用信息查询");
        map.put("7724","大宗交易费用查询");
        map.put("11551","单客户两融股转二级费用");
        map.put("11218","单客户合约利率查询");
        map.put("11219","单客户合约优惠利率查询");
        map.put("11221","单客户个人担保证券资格查询");
        map.put("11222","单客户个人标的证券资格查询");
        map.put("11223","单客户维持担保比例查询");
        map.put("11237","单客户信用合同查询");
        map.put("11246","单客户费用待扣收查询");
        map.put("11254","两融费用待扣收流水查询");
        map.put("11252","融券卖出所得流水查询");
        map.put("10710","客户展期信息查询");
        map.put("11265","两融单一证券集中度个人查询");
        map.put("11266","两融信用证券分组集中度个人查询");
        map.put("11276","单客户资产汇总信息查询");
        map.put("11282","单客户白名单查询");
        map.put("11283","单客户风险客户名单查询");
        map.put("11290","单客户指令信息查询");
        map.put("11293","两融单一证券集中度套餐参数信息查询");
        map.put("11294","两融信用证券分组集中度套餐参数信息查询");
        map.put("10326","证券分组集中度白名单查询");
        return map;
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

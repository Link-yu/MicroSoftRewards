package com.example.microsoftrewards.stock;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Stock
 * @Description TODO
 * @Author yulk48789
 * @Date 2024-09-18 11:10
 * @Version 1.0
 **/
class ParamData {
    String paramName;
    String paramType;

    public ParamData(String paramName, String paramType) {
        this.paramName = paramName;
        this.paramType = paramType;
    }
}
public class Stock {
    public static List<ParamData> parseInputData(String inputData) {
        List<ParamData> data = new ArrayList<>();
        String[] lines = inputData.split("\n");
        for (String line : lines) {
            String[] parts = line.split(", ");
            if (parts.length == 2) {
                data.add(new ParamData(parts[0], parts[1]));
            }
        }
        return data;
    }

    public static void main(String[] args) {
        String inputData = "l_login_operator, int\n"
                + "l_company_no, int\n"
                + "l_fund_id, int\n"
                + "l_asset_id, int\n"
                + "l_basecombi_id, int\n"
                + "l_other_combi_id, int\n"
                + "l_daily_instruction_no, int\n"
                + "l_index_daily_modify, int\n"
                + "vc_inter_code, string\n"
                + "c_entrust_direction, string\n"
                + "l_amount, double\n"
                + "en_price, double\n"
                + "en_balance, double\n"
                + "vc_stockholder_id, string\n"
                + "l_entrust_serial_no, int\n"
                + "l_operator_no, int\n"
                + "l_iswrite, int\n"
                + "c_businflag, string\n"
                + "l_currency_date, int\n"
                + "l_daily_maxamount, int\n"
                + "l_temp_no, int\n"
                + "c_preinstruction_flag, string\n"
                + "l_begin_date, int\n"
                + "l_end_date, int\n"
                + "l_rival_id, int\n"
                + "en_interest, double\n"
                + "vc_other_inter_code, string\n"
                + "c_risk_influence_flag, string\n"
                + "c_launch_flag, string\n"
                + "c_busin_class, string\n"
                + "c_risk_type, string\n"
                + "l_batch_serial_no, int\n"
                + "l_total_trigger_amount, int\n"
                + "c_invest_type, string\n"
                + "c_price_type, string\n"
                + "c_other_invest_type, string\n"
                + "l_instruction_no, int\n"
                + "l_index_modify_instruction, int\n"
                + "l_uftistry, int\n"
                + "c_busin_uft, string\n"
                + "l_hg_days, int\n"
                + "l_backcurrency_date, int\n"
                + "en_yield_ratio, double";

        // Parse input data
        List<ParamData> data = parseInputData(inputData);

        int paramId = 3000;  // Initial param_id
        int parentId = -1;  // parent_id from example
        int apiId = 151;  // api_id from example

        // SQL Template
        String sqlTemplate = "INSERT INTO `tcheck_api_param_list` (`param_id`, `param_name_cn`, `parent_id`, `api_id`, `param_name`, `param_type`, `use_flag`, `func_name`, `create_time`, `param_value`) VALUES (%d, '%s', %d, %d, '%s', '%s', NULL, NULL, NULL, NULL);";

        for (ParamData paramData : data) {
            String sql = String.format(sqlTemplate, paramId, paramData.paramName, parentId, apiId, paramData.paramName, paramData.paramType);
            System.out.println(sql);
            paramId++;
        }
    }
//    public static void main(String[] args) {
//        String str1 = "EntsCount, l_issplit, entrust1, c_risk_type, l_fund_id, l_asset_id, l_basecombi_id, l_instruction_no, l_index_modify_instruction, l_daily_instruction_no, l_index_daily_modify, vc_inter_code, c_entrust_direction, l_amount, en_price, en_balance, vc_stockholder_id, l_entrust_serial_no, l_operator_no, l_iswrite, l_uftistry, c_invest_type, en_interest, c_risk_influence_flag, c_launch_flag, c_busin_class, c_price_type, l_batch_serial_no, vc_report_seat";
//
//        String str2 = "EntsCount, l_issplit, entrust1, c_risk_type, l_fund_id, l_asset_id, l_basecombi_id, l_instruction_no, l_index_modify_instruction, l_daily_instruction_no, l_index_daily_modify, vc_inter_code, c_entrust_direction, l_amount, en_price, en_balance, vc_stockholder_id, l_entrust_serial_no, l_operator_no, l_iswrite, l_uftistry, c_invest_type, c_risk_influence_flag, c_launch_flag, c_busin_class, c_price_type, l_batch_serial_no, vc_report_seat";
//        String str3 = "EntsCount, l_issplit, entrust1, c_risk_type, l_fund_id, l_asset_id, l_basecombi_id, l_instruction_no, l_index_modify_instruction, l_daily_instruction_no, l_index_daily_modify, vc_inter_code, c_entrust_direction, l_amount, en_price, en_balance, vc_stockholder_id, l_entrust_serial_no, l_operator_no, l_iswrite, l_uftistry, c_invest_type, en_interest, c_risk_influence_flag, c_launch_flag, c_busin_class, l_rival_id, c_price_type, l_batch_serial_no, vc_report_seat, c_bulkunderweight_flag, c_busin_uft";
//        Map<String, String> str1Map = new HashMap<>();
//
//        List<String> str1List = Arrays.asList(str1.split(", "));
//        List<String> str2List = Arrays.asList(str2.split(", "));
//        List<String> str3List = Arrays.asList(str3.split(", "));
//        for (String st:str1List) {
//            if (!str1Map.containsKey(st)) {
//                str1Map.put(st, st);
//            }
//        }
//        System.out.println("str2");
//        for (String st:str2List) {
//            if(str1Map.containsKey(st)) {
//                continue;
//            }
//            System.out.println(st);
//        }
//        System.out.println("++++++++++++++++++++");
//        System.out.println("str3");
//        for (String st:str3List) {
//            if(str1Map.containsKey(st)) {
//                continue;
//            }
//            System.out.println(st);
//        }
//    }

//    public static void main(String[] args) {
//        String xmlInput = "<l_company_no>7777</l_company_no>\n" +
//                "<l_fund_id>20011</l_fund_id>\n" +
//                "<l_asset_id>276</l_asset_id>\n" +
//                "<l_basecombi_id>276</l_basecombi_id>\n" +
//                "<l_other_combi_id>0</l_other_combi_id>\n" +
//                "<l_daily_instruction_no>0</l_daily_instruction_no>\n" +
//                "<l_index_daily_modify>0</l_index_daily_modify>\n" +
//                "<vc_inter_code>000004SZ</vc_inter_code>\n" +
//                "<c_entrust_direction>{</c_entrust_direction>\n" +
//                "<l_amount>200.0000</l_amount>\n" +
//                "<en_price>10.0000</en_price>\n" +
//                "<en_balance>2000.0000</en_balance>\n" +
//                "<vc_stockholder_id>0600000520</vc_stockholder_id>\n" +
//                "<l_entrust_serial_no>0</l_entrust_serial_no>\n" +
//                "<l_operator_no>21040001</l_operator_no>\n" +
//                "<l_iswrite>0</l_iswrite>\n" +
//                "<c_businflag>0</c_businflag>\n" +
//                "<l_currency_date>0</l_currency_date>\n" +
//                "<l_daily_maxamount>0.0000</l_daily_maxamount>\n" +
//                "<l_temp_no>2056528</l_temp_no>\n" +
//                "<c_preinstruction_flag>0</c_preinstruction_flag>\n" +
//                "<l_begin_date>0</l_begin_date>\n" +
//                "<l_end_date>0</l_end_date>\n" +
//                "<l_rival_id>0</l_rival_id>\n" +
//                "<en_interest>0.0000</en_interest>\n" +
//                "<vc_other_inter_code>0</vc_other_inter_code>\n" +
//                "<c_risk_influence_flag>1</c_risk_influence_flag>\n" +
//                "<c_stock_target_type></c_stock_target_type>\n" +
//                "<c_launch_flag>1</c_launch_flag>\n" +
//                "<c_busin_class>x</c_busin_class>\n" +
//                "<c_risk_type>1</c_risk_type>\n" +
//                "<l_batch_serial_no>0</l_batch_serial_no>\n" +
//                "<l_total_trigger_amount>0</l_total_trigger_amount>\n" +
//                "<c_invest_type>1</c_invest_type>\n" +
//                "<c_price_type>0</c_price_type>\n" +
//                "<c_other_invest_type>0</c_other_invest_type>\n" +
//                "<l_instruction_no>0</l_instruction_no>\n" +
//                "<l_index_modify_instruction>0</l_index_modify_instruction>\n" +
//                "<l_uftistry>1</l_uftistry>\n" +
//                "<c_busin_uft>0</c_busin_uft>\n" +
//                "<l_hg_days>0</l_hg_days>\n" +
//                "<zrt_is_restructed></zrt_is_restructed>\n" +
//                "<vc_mortagage_info></vc_mortagage_info>\n" +
//                "<c_covered_call></c_covered_call>\n" +
//                "<c_first_settle_type></c_first_settle_type>\n" +
//                "<c_second_settle_type></c_second_settle_type>\n" +
//                "<l_backcurrency_date>20240227</l_backcurrency_date>\n" +
//                "<c_special_flag></c_special_flag>\n" +
//                "<c_bulkunderweight_flag></c_bulkunderweight_flag>\n" +
//                "<en_yield_ratio>0</en_yield_ratio>\n";
//
//        // 匹配XML标签和值的正则表达式
//        Pattern pattern = Pattern.compile("<(\\w+)>([^<]+)</\\1>");
//
//        Matcher matcher = pattern.matcher(xmlInput);
//        StringBuilder resultBuilder = new StringBuilder();
//
//        // 提取所有匹配的标签和值
//        while (matcher.find()) {
//            String tagName = matcher.group(1);
//            resultBuilder.append(tagName).append(", ");
//        }
//
//        String result = resultBuilder.toString();
//        System.out.print(result);  // 打印输出所有标签和值
//    }
}

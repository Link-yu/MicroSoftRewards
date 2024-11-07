package com.example.microsoftrewards.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlParser {
    String sql = "INSERT INTO `pbtools`.`tcheck_api_param_list` (`param_id`, `api_id`, `parent_id`, `param_name`, `param_type`, `param_value`, `func_name`) VALUES ($1, 4, 33, '$2', 'string', '$3', NULL);";

    public static void main(String[] args) {
        char s = 'S';
        pring(s);
    }

    private static void pring(int num) {
        System.out.println(num);
    }
    /**
     *
     * @param args
     */
    public static void main2(String[] args) {
        String input ="<l_login_operator>88070002</l_login_operator>" +
                "<l_fund_id>9030233</l_fund_id>" +
                        "<l_basecombi_id>419</l_basecombi_id>" +
                        "<c_market_no>1</c_market_no>" +
                        "<vc_report_code>600570</vc_report_code>" +
                        "<vc_stockholder_id>8807sh</vc_stockholder_id>" +
                        "<c_entrust_direction>1</c_entrust_direction>" +
                        "<l_entrust_amount>100</l_entrust_amount>" +
                        "<en_entrust_price>30.0000</en_entrust_price>" +
                        "<l_batch_serial_no>0</l_batch_serial_no>" +
                        "<c_price_type>0</c_price_type>" +
                        "<c_invest_type>1</c_invest_type>" +
                        "<l_autotrade_no>0</l_autotrade_no>" +
                        "<c_fair_flag>0</c_fair_flag>" +
                        "<l_valid_date>0</l_valid_date>" +
                        "<l_market_valid_date>20240709</l_market_valid_date>" +
                        "<iOverInstProcess>1</iOverInstProcess>" +
                        "<c_append_entrust>0</c_append_entrust>" +
                        "<vc_confirm_no>0</vc_confirm_no>" +
                        "<en_balance>3000.0000</en_balance>" +
                        "<l_hint_warning>1</l_hint_warning>" +
                        "<vc_algo_ordid></vc_algo_ordid>" +
                        "<l_comp_id>0</l_comp_id>" +
                        "<c_dma>1</c_dma>" +
                        "<vc_valid_type>DAY</vc_valid_type>" +
                        "<c_busin_class>1</c_busin_class>" +
                        "<l_daily_instruction_no>0</l_daily_instruction_no>" +
                        "<l_index_daily_modify>0</l_index_daily_modify>" +
                        "<c_launch_flag>1</c_launch_flag>" +
                        "<c_entrust_origin>2</c_entrust_origin>" +
                        "<vc_third_reff>1</vc_third_reff>" +
                        "<l_invest_adviser>88070002</l_invest_adviser>" +
                        "<l_operator_no>88070002</l_operator_no>" +
                        "<l_extsystem_id>70598795</l_extsystem_id>" +
                        "<l_adviser_split_amount>1000000</l_adviser_split_amount>" +
                        "<l_instruction_no>0</l_instruction_no>" +
                        "<l_index_modify_instruction>0</l_index_modify_instruction>" +
                        "<vc_ip_address>10.188.136.210</vc_ip_address>" +
                        "<vc_terminalinfo_extend>" +
                        "BFEBFBFF000806C1;10.188.136.210;;;DESKTOP-CO1DPFR;^CA30-F2A2^NTFS^120G;PB1.0V202401.01.000;" +
                        "10.0.19045;YYDS;10.188.136.210;5CG1233VMJ;HP;HP ELITEBOOK 840 G8 NOTEBOOK PC;586C25519893;" +
                        "10.188.136.210;[159-2026]192.168.39.159 6123;CA30-F2A2;5404" +
                        "</vc_terminalinfo_extend>" +
                        "<vc_mac>586C25519893</vc_mac>" +
                        "<vc_volserial_no>6_BF53_0001_001B_448B_49AD_146A.</vc_volserial_no>" +
                        "<vc_adviser_station>IP.10.188.136.210 MAC.586C25519893 HD.6_BF53_0001_001B_448B_49AD_146A.</vc_adviser_station>";
        String sql2 = "<l_login_operator>88070002</l_login_operator><l_fund_id>9030233</l_fund_id><l_basecombi_id>419</l_basecombi_id><c_market_no>1</c_market_no><vc_report_code>600570</vc_report_code><vc_stockholder_id>8807sh</vc_stockholder_id><c_entrust_direction>1</c_entrust_direction><l_entrust_amount>100</l_entrust_amount><en_entrust_price>30.0000</en_entrust_price><l_batch_serial_no>0</l_batch_serial_no><c_price_type>0</c_price_type><c_invest_type>1</c_invest_type><l_autotrade_no>0</l_autotrade_no><c_fair_flag>0</c_fair_flag><l_valid_date>0</l_valid_date><l_market_valid_date>20240709</l_market_valid_date><iOverInstProcess>1</iOverInstProcess><c_append_entrust>0</c_append_entrust><vc_confirm_no>0</vc_confirm_no><en_balance>3000.0000</en_balance><l_hint_warning>1</l_hint_warning><vc_algo_ordid></vc_algo_ordid><l_comp_id>0</l_comp_id><c_dma>1</c_dma><vc_valid_type>DAY</vc_valid_type><c_busin_class>1</c_busin_class><l_daily_instruction_no>0</l_daily_instruction_no><l_index_daily_modify>0</l_index_daily_modify><c_launch_flag>1</c_launch_flag><c_entrust_origin>2</c_entrust_origin><vc_third_reff>1</vc_third_reff><l_invest_adviser>88070002</l_invest_adviser><l_operator_no>88070002</l_operator_no><l_extsystem_id>70598795</l_extsystem_id><l_adviser_split_amount>1000000</l_adviser_split_amount><l_instruction_no>0</l_instruction_no><l_index_modify_instruction>0</l_index_modify_instruction><vc_ip_address>10.188.136.210</vc_ip_address><vc_terminalinfo_extend>BFEBFBFF000806C1;10.188.136.210;;;DESKTOP-CO1DPFR;^CA30-F2A2^NTFS^120G;PB1.0V202401.01.000;10.0.19045;YYDS;10.188.136.210;5CG1233VMJ;HP;HP ELITEBOOK 840 G8 NOTEBOOK PC;586C25519893;10.188.136.210;[159-2026]192.168.39.159 6123;CA30-F2A2;5404</vc_terminalinfo_extend><vc_mac>586C25519893</vc_mac><vc_volserial_no>6_BF53_0001_001B_448B_49AD_146A.</vc_volserial_no><vc_adviser_station>IP.10.188.136.210 MAC.586C25519893 HD.6_BF53_0001_001B_448B_49AD_146A.</vc_adviser_station>";
        // 使用正则表达式来匹配标签和内容
        Pattern pattern = Pattern.compile("<(\\w+)>((.|\\s)*?)<\\/\\1>");
        Matcher matcher = pattern.matcher(sql2);


        int num = 34;
        // 遍历所有匹配的标签和值
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
    }

    /**
     * 根据入参生成sql, 替换sql中的num,s1,s2字段，并返回
     * @param num
     * @param s1
     * @param s2
     * @return
     */
    private static String generateSql(int num, String s1, String s2) {
        // 使用String.format方法来替换sql模板中的占位符
        String sqlTemplate = "INSERT INTO `pbtools`.`tcheck_api_param_list` (`param_id`, `api_id`, `parent_id`, `param_name`, `param_type`, `param_value`, `func_name`) VALUES (%d, 4, 33, '%s', 'string', '%s', NULL);";

        // 将num, s1, s2分别替换到sql模板中的占位符位置
        String sql = String.format(sqlTemplate, num, s1, s2);

        // 返回生成的sql语句
        return sql;
    }
}

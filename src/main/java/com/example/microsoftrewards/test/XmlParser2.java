package com.example.microsoftrewards.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class XmlParser2 {

    private static String tables = "bat_tarbitaryinfo\n" +
            "bat_tassetcash\n" +
            "bat_tbankstageassetstock\n" +
            "bat_tbankstagefundstock\n" +
            "bat_tbankstageunitstock\n" +
            "bat_tbankunitstock\n" +
            "bat_tfuturestageassetstock\n" +
            "bat_tfuturestagefundstock\n" +
            "bat_tfuturestageunitstock\n" +
            "bat_tfutureunitstock\n" +
            "bat_thgregister\n" +
            "bat_thgregister_xy\n" +
            "bat_tholdingdetail\n" +
            "bat_thsstageassetstock\n" +
            "bat_thsstagefundstock\n" +
            "bat_thsstagesecurityloan\n" +
            "bat_thsstageunitstock\n" +
            "bat_thsunitstock\n" +
            "bat_tliqfundproperty\n" +
            "bat_tliqfundproperty\n" +
            "bat_tmortgage_xy\n" +
            "bat_toutstageassetstock\n" +
            "bat_toutstagefundstock\n" +
            "bat_toutstageunitstock\n" +
            "bat_toutunitstock\n" +
            "bat_tpendsettle\n" +
            "bat_tshareoutinfo\n" +
            "bat_tstagearbitaryinfo\n" +
            "bat_tstageassetcash\n" +
            "bat_tstageexpireprofit\n" +
            "bat_tstagefinancedebt\n" +
            "bat_tstagehgregister\n" +
            "bat_tstagehgregister_xy\n" +
            "bat_tstageholdingdetail\n" +
            "bat_tstagemortgage\n" +
            "bat_tstagemortgage_xy\n" +
            "bat_tstageqqzhcc\n" +
            "bat_tstagesubject\n" +
            "bat_tstageuncomplete\n" +
            "bat_tsubjectdata\n" +
            "bat_tuncomplete\n" +
            "bat_tuncomplete_out\n" +
            "bat_tychgregister\n" +
            "fk_tfinrepurchase\n" +
            "fk_tfutmarketamountsum\n" +
            "fk_thisentrusflow\n" +
            "fk_thisentrusflow_pb1sync\n" +
            "fk_thisinsflow\n" +
            "fk_thisinsflow_pb1sync\n" +
            "fk_tmarketamountsum\n" +
            "fk_triskapprove\n" +
            "fk_triskopenset\n" +
            "fk_triskopensetvalue\n" +
            "fk_triskrule_all\n" +
            "fk_ttradebalance_pb1sync\n" +
            "fk_ttradebalancesum\n" +
            "fk_ttradecount_pb1sync\n" +
            "fk_ttradecountsum\n" +
            "fk_tupdownrangesum\n" +
            "fkqy_thisentrusts\n" +
            "fkqy_thisfuturesinfo\n" +
            "fkqy_thisstockinfo\n" +
            "func_key_fk_jtwd\n" +
            "func_key_his_realdeal\n" +
            "func_key_pub_zs\n" +
            "fund_share_adjust\n" +
            "hisjy_tadvise\n" +
            "hisjy_tadviseapprove\n" +
            "hisjy_tadvisestock\n" +
            "hisjy_tentrusts\n" +
            "hisjy_toutdealconfirm\n" +
            "hisjy_toutexecconfirm\n" +
            "hiszl_tinsrisk\n" +
            "hiszl_tinstruction\n" +
            "hiszl_tinstructionstock\n" +
            "hiszl_toutfutureinsoperation\n" +
            "hiszl_tpledgedbond\n" +
            "inter_code\n" +
            "jy_tadviseapproveconfig\n" +
            "jy_tassetasset\n" +
            "jy_tassetday_sync\n" +
            "jy_tbankhgregister\n" +
            "jy_tbankmortgage\n" +
            "jy_tftrenabledetail_sync\n" +
            "jy_tfundstock\n" +
            "jy_tfutfundstock_sync\n" +
            "jy_tfutunitstock_sync\n" +
            "jy_thgregister\n" +
            "jy_tholdingdetail_sync\n" +
            "jy_tinsadviseapproveconfig\n" +
            "jy_toptionfundstock_sync\n" +
            "jy_toptionunitstock_sync\n" +
            "jy_toutbankfundstock\n" +
            "jy_toutbankpendsettle\n" +
            "jy_toutbankunitstock\n" +
            "jy_trccombimodel\n" +
            "jy_trccombimodeldetail\n" +
            "jy_tsubjectdata\n" +
            "jy_tuncomplete\n" +
            "jy_tunitstock\n" +
            "jy_txyhgmortgage\n" +
            "jy_txyhgregister\n" +
            "pub_tbroker_branch\n" +
            "pub_tcompany\n" +
            "pub_tcompanynode\n" +
            "pub_tcomstocktype\n" +
            "pub_tdimension\n" +
            "pub_tfileentrustfund\n" +
            "pub_tfileentrustfund\n" +
            "pub_tseat\n" +
            "pub_tterminal_auth\n" +
            "pub_ttraderivalgroup\n" +
            "pub_ttraderivalgroupnumber\n" +
            "qs_ti_tbankdealsettle_curr\n" +
            "qs_ti_tcashbusiness\n" +
            "qs_ti_tdealmortgage_xy\n" +
            "qs_ti_tentrusts_op\n" +
            "qs_ti_tentrusts_qh\n" +
            "qs_ti_tentrusts_xh\n" +
            "qs_ti_toutdealsettle_curr\n" +
            "qs_ti_trealdeal_op\n" +
            "qs_ti_trealdeal_qh\n" +
            "qs_ti_trealdeal_xh\n" +
            "qs_ti_trealdeal_xy\n" +
            "qs_ti_trealdealdetail_etf\n" +
            "qs_ti_tstockbusiness_bank\n" +
            "qs_ti_tstockbusiness_out\n" +
            "qs_ti_tstockbusiness_qh\n" +
            "qs_ti_tstockbusiness_qq\n" +
            "qs_ti_tstockbusiness_xh\n" +
            "yh_fundgroup\n" +
            "yh_tadvauthorizset\n" +
            "yh_tadvflowspeedcontrol\n" +
            "yh_tappendoperinfo\n" +
            "yh_tappendoperinfo\n" +
            "yh_tapprovegroup_insflow\n" +
            "yh_tasset\n" +
            "yh_tassetcaptacct\n" +
            "yh_tassetcaptacct\n" +
            "yh_tbondappraise\n" +
            "yh_tbondvaluemodel\n" +
            "yh_tcapitalaccount\n" +
            "yh_tcapitalaccount\n" +
            "yh_tcapitalaccount\n" +
            "yh_tcapitalacctbiz\n" +
            "yh_tcapitalacctbiz\n" +
            "yh_tcombi\n" +
            "yh_tcombiseat\n" +
            "yh_tcombistockholder\n" +
            "yh_tcombistockholder\n" +
            "yh_tfeehs\n" +
            "yh_tfeeyh\n" +
            "yh_tfixedtradeoperator\n" +
            "yh_tfundgroupconfig\n" +
            "yh_tfundinfo\n" +
            "yh_tfundinfo\n" +
            "yh_tfundmgrrate\n" +
            "yh_tfundmgrrate\n" +
            "yh_tfundparamvalue\n" +
            "yh_tfuturestockholder\n" +
            "yh_tfuturestockholder\n" +
            "yh_tholder_captacct\n" +
            "yh_tholder_captacct\n" +
            "yh_tinterbankid\n" +
            "yh_tinterbankid\n" +
            "yh_toperassetright\n" +
            "yh_toperator\n" +
            "yh_topercombiright\n" +
            "yh_toperfundright\n" +
            "yh_topersiteinfo\n" +
            "yh_torganappraise\n" +
            "yh_trivalappraise\n" +
            "yh_trzrqarg\n" +
            "yh_tselffutmarketgroup\n" +
            "yh_tselfstockdetail\n" +
            "yh_tselfstockgroup\n" +
            "yh_tstockholder\n" +
            "yh_tstockholder\n" +
            "yh_tufxfundright\n" +
            "yh_tufxpriviliagectrl\n" +
            "zl_tautodispense\n" +
            "zl_toptradeinfo";
    public static void main(String[] args) {
        // 指定要读取的文件路径
        String filePath = "E:\\Local\\MicroSoftRewards\\src\\main\\resources\\templates\\pb.txt";
        // 读取文件并处理内容
        try {
            processFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processFile(String filePath) throws IOException {
        // 使用BufferedReader读取文件内容
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        String currentTable = null;
        // 使用Map将表名映射到字段差异集合
        Map<String, Set<String>> tableDifferences = new HashMap<>();

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.startsWith("------>")) {
                // 新表的差异开始，获取当前表名
                currentTable = line.substring(7).trim();
                if (!tableDifferences.containsKey(currentTable)) {
                    tableDifferences.put(currentTable, new HashSet<>());
                }
            } else if (currentTable != null) {
                // 当前表的字段差异，加入Map中
                String fieldName = line.split(",")[0].trim();
                tableDifferences.get(currentTable).add(fieldName);
            }
        }
        reader.close();

        // 打印每个表及其差异字段
        for (Map.Entry<String, Set<String>> entry : tableDifferences.entrySet()) {
            String tableName = entry.getKey();
            if (!tables.contains(tableName)) {
                continue;
            }
            Set<String> fields = entry.getValue();
            System.out.print("Table: " + tableName);
            System.out.println();
            for (String field : fields) {
                System.out.print(field + ",");
            }
            System.out.println("");
            System.out.println("+++++++++++++++++");
        }
    }
}


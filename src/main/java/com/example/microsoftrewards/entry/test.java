package com.example.microsoftrewards.entry;

import com.alibaba.fastjson.JSON;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

public class test {
    public static void main(String[] args) throws IOException{
//        test.getExchangeDateSql();
        test.getSysDictionarySql();
//        test.getStkModelSql();
//        test.getStkTypeSql();
//        test.getStkAdFareSql();
//        test.getBusinFlagSql();
//        test.getSysConfigSql();
//          test.getExchangeErrCode();

    }
    public static void getExchangeErrCode() throws IOException{
        String filePath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\json\\exchangeerrcode.json";
        String outOraclePath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\oracle\\30-ARCS20_exchangeerrcode_path.sql";
        String outMysqlPath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\mysql\\30-ARCS20_exchangeerrcode_path.sql";
        String outDmPath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\dm\\30-ARCS20_exchangeerrcode_path.sql";
        String data = test.getContent(filePath);
        Gson gson = new Gson();
        ResultData<ExchangeErrcode> data1 = gson.fromJson(data, new TypeToken<ResultData<ExchangeErrcode>>(){}.getType());
        PrintWriter outOracle = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outOraclePath), "UTF-8"));
        PrintWriter outMysql = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outMysqlPath), "UTF-8"));
        PrintWriter outDm = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outDmPath), "UTF-8"));
        for (ExchangeErrcode exchangeErrcode:data1.getRECORDS()){
            outOracle.println(test.getOracleInsertSql(getCommonSql(exchangeErrcode)));
            outOracle.flush();
            outDm.println(test.getOracleInsertSql(getCommonSql(exchangeErrcode)));
            outDm.flush();
            outMysql.println(test.getMysqlInsertSql(getCommonSql(exchangeErrcode)));
            outMysql.flush();
        }
    }


    public static void getSysConfigSql() throws IOException{
        String filePath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\json\\sysconfig_lanyl.json";
        String outOraclePath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\oracle\\009-HS_MSSECU-SysConfig-Init.sql";
        String outMysqlPath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\mysql\\009-HS_MSSECU-SysConfig-Init.sql";
        String outDmPath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\dm\\009-HS_MSSECU-SysConfig-Init.sql";
        String data = test.getContent(filePath);
        Gson gson = new Gson();
        ResultData<SysConfig> data1 = gson.fromJson(data, new TypeToken<ResultData<SysConfig>>(){}.getType());
        PrintWriter outOracle = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outOraclePath), "UTF-8"));
        PrintWriter outMysql = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outMysqlPath), "UTF-8"));
        PrintWriter outDm = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outDmPath), "UTF-8"));
        for (SysConfig sysConfig:data1.getRECORDS()){
            outOracle.println(test.getOracleInsertSql(getCommonSql(sysConfig)));
            outOracle.flush();
            outDm.println(test.getOracleInsertSql(getCommonSql(sysConfig)));
            outDm.flush();
            outMysql.println(test.getMysqlInsertSql(getCommonSql(sysConfig)));
            outMysql.flush();
        }
    }

    public static void getBusinFlagSql() throws IOException{
        String filePath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\json\\businflag_lanyl.json";
        String outOraclePath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\oracle\\008-HS_MSSECU-BusinFlag-Init.sql";
        String outMysqlPath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\mysql\\008-HS_MSSECU-BusinFlag-Init.sql";
        String outDmPath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\dm\\008-HS_MSSECU-BusinFlag-Init.sql";
        String data = test.getContent(filePath);
        Gson gson = new Gson();
        ResultData<BusinFlag> data1 = gson.fromJson(data, new TypeToken<ResultData<BusinFlag>>(){}.getType());
        PrintWriter outOracle = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outOraclePath), "UTF-8"));
        PrintWriter outMysql = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outMysqlPath), "UTF-8"));
        PrintWriter outDm = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outDmPath), "UTF-8"));
        for (BusinFlag businFlag:data1.getRECORDS()){
            outOracle.println(test.getOracleInsertSql(getCommonSql(businFlag)));
            outOracle.flush();
            outDm.println(test.getOracleInsertSql(getCommonSql(businFlag)));
            outDm.flush();
            outMysql.println(test.getMysqlInsertSql(getCommonSql(businFlag)));
            outMysql.flush();
        }
    }

    public static void getStkAdFareSql() throws IOException{
        String filePath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\json\\stkadfare_lanyl.json";
        String outOraclePath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\oracle\\011-HS_MSSECU-StkAdFare-Init.sql";
        String outMysqlPath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\mysql\\011-HS_MSSECU-StkAdFare-Init.sql";
        String outDmPath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\dm\\011-HS_MSSECU-StkAdFare-Init.sql";
        String data = test.getContent(filePath);
        Gson gson = new Gson();
        ResultData<StkAdFare> data1 = gson.fromJson(data, new TypeToken<ResultData<StkAdFare>>(){}.getType());
        PrintWriter outOracle = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outOraclePath), "UTF-8"));
        PrintWriter outMysql = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outMysqlPath), "UTF-8"));
        PrintWriter outDm = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outDmPath), "UTF-8"));
        for (StkAdFare stkAdFare:data1.getRECORDS()){
            outOracle.println(test.getOracleInsertSql(getCommonSql(stkAdFare)));
            outOracle.flush();
            outDm.println(test.getOracleInsertSql(getCommonSql(stkAdFare)));
            outDm.flush();
            outMysql.println(test.getMysqlInsertSql(getCommonSql(stkAdFare)));
            outMysql.flush();
        }
    }

    public static void getStkTypeSql() throws IOException{
        String filePath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\json\\stktype_lanyl.json";
        String outOraclePath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\oracle\\009-HS_MSSECU-StkType-Init.sql";
        String outMysqlPath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\mysql\\009-HS_MSSECU-StkType-Init.sql";
        String outDmPath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\dm\\009-HS_MSSECU-StkType-Init.sql";
        String data = test.getContent(filePath);
        Gson gson = new Gson();
        ResultData<StkType> data1 = gson.fromJson(data, new TypeToken<ResultData<StkType>>(){}.getType());
        PrintWriter outOracle = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outOraclePath), "UTF-8"));
        PrintWriter outMysql = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outMysqlPath), "UTF-8"));
        PrintWriter outDm = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outDmPath), "UTF-8"));
        for (StkType stkType:data1.getRECORDS()){
            outOracle.println(test.getOracleInsertSql(getCommonSql(stkType)));
            outOracle.flush();
            outDm.println(test.getOracleInsertSql(getCommonSql(stkType)));
            outDm.flush();
            outMysql.println(test.getMysqlInsertSql(getCommonSql(stkType)));
            outMysql.flush();
        }
    }

    public static void getStkModelSql() throws IOException{
        String filePath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\json\\stkmodel_lanyl.json";
        String outOraclePath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\oracle\\010-HS_MSSECU-StkModel-Init.sql";
        String outMysqlPath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\mysql\\010-HS_MSSECU-StkModel-Init.sql";
        String outDmPath = "C:\\Users\\lanyl48583\\Desktop\\new_sqls\\sql\\dm\\010-HS_MSSECU-StkModel-Init.sql";
        String data = test.getContent(filePath);
        Gson gson = new Gson();
        ResultData<StkModel> data1 = gson.fromJson(data, new TypeToken<ResultData<StkModel>>(){}.getType());
        PrintWriter outOracle = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outOraclePath), "UTF-8"));
        PrintWriter outMysql = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outMysqlPath), "UTF-8"));
        PrintWriter outDm = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outDmPath), "UTF-8"));
        for (StkModel stkModel:data1.getRECORDS()){
            outOracle.println(test.getOracleInsertSql(getCommonSql(stkModel)));
            outOracle.flush();
            outDm.println(test.getOracleInsertSql(getCommonSql(stkModel)));
            outDm.flush();
            outMysql.println(test.getMysqlInsertSql(getCommonSql(stkModel)));
            outMysql.flush();
        }
    }

    public static void getSysDictionarySql() throws IOException{
        String filePath = "C:\\Users\\yulk48789\\Desktop\\new_sqls\\json\\sysdictionary_yulk.json";
        String outOraclePath = "C:\\Users\\yulk48789\\Desktop\\new_sqls\\sql\\oracle\\000-HS_MSSECU-SysDictionary_Patch.sql";
        String outMysqlPath = "C:\\Users\\yulk48789\\Desktop\\new_sqls\\sql\\mysql\\000-HS_MSSECU-SysDictionary_Patch.sql";
        String outDmPath = "C:\\Users\\yulk48789\\Desktop\\new_sqls\\sql\\dm\\000-HS_MSSECU-SysDictionary_Patch.sql";
        String data = test.getContent(filePath);
        SysDictionaryData data1 = JSON.parseObject(data, SysDictionaryData.class);
        PrintWriter outOracle = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outOraclePath), "UTF-8"));
        PrintWriter outMysql = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outMysqlPath), "UTF-8"));
        PrintWriter outDm = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outDmPath), "UTF-8"));
        for (SysDictionary sysDictionary:data1.getRECORDS()){
            outOracle.println(test.getOracleInsertSql(getCommonSql(sysDictionary)));
            outOracle.flush();
            outDm.println(test.getOracleInsertSql(getCommonSql(sysDictionary)));
            outDm.flush();
            outMysql.println(test.getMysqlInsertSql(getCommonSql(sysDictionary)));
            outMysql.flush();
        }
    }

    public static void getExchangeDateSql() throws IOException{
        String filePath = "C:\\Users\\lanyl48583\\Desktop\\exchangedate_new.json";
        String outOraclePath = "C:\\Users\\lanyl48583\\Desktop\\exchangedate_oracle.sql";
        String outMysqlPath = "C:\\Users\\lanyl48583\\Desktop\\exchangedate_mysql.sql";
        String data = test.getContent(filePath);
        Data data1 = JSON.parseObject(data, Data.class);
        PrintWriter outOracle = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outOraclePath), "UTF-8"));
        PrintWriter outMysql = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outMysqlPath), "UTF-8"));
        for (ExchangeDate exchangeDate:data1.getRECORDS()){
            outOracle.println(test.getOracleInsertSql(getCommonSql(exchangeDate)));
            outOracle.flush();
            outMysql.println(test.getMysqlInsertSql(getCommonSql(exchangeDate)));
            outMysql.flush();
        }
    }

    public static String getContent(String filePath){
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                if (StringUtils.isNoneBlank(line)) {
                    stringBuffer.append(line);
                }
            }
            br.close();
            return stringBuffer.toString();
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return null;
    }

    public static String getOracleInsertSql(String commonSql){
        String header = "declare v_rowcount number(10);\n" +
                "begin\n";
        String foot = "    end if;\n" +
                "\tcommit;\n" +
                "end;\n" +
                "/\n";
        return header + commonSql + foot;
    }

    public static String getCommonSql(ExchangeErrcode data){
        String sql =
                "     select count(1) into v_rowcount from dual\n" +
                        "     where exists (select 1 from HS_ARCS20.EXCHANGEERRCODE where LDP_ERROR_CODE  = "+data.getLdp_error_code()+");\n" +
                        "    if v_rowcount = 0 then\n" +
                        "        insert into HS_ARCS20.EXCHANGEERRCODE (LDP_ERROR_CODE, SH_ERROR_CODE, SZ_ERROR_CODE, BEHAVIORALRISK_TYPE_STR_NAME, MODI_DATE)\n" +
                        "\t\tvalues ("+data.getLdp_error_code()+", "+data.getSh_error_code()+", "+data.getSz_error_code()+", '"+data.getBehavioralrisk_type_str_name()+"', "+data.getModi_date()+");\n"+
                        "    else\n" +
                        "        update HS_ARCS20.EXCHANGEERRCODE set SH_ERROR_CODE="+data.getSh_error_code()+",SZ_ERROR_CODE="+data.getSz_error_code()+", BEHAVIORALRISK_TYPE_STR_NAME='"+data.getBehavioralrisk_type_str_name()+"' where LDP_ERROR_CODE="+data.getLdp_error_code()+";\n";
        return sql;
    }

    public static String getCommonSql(SysConfig sysConfig){
        String companyType = StringUtils.isBlank(sysConfig.getCompany_type()) ? " " : sysConfig.getCompany_type();
        String sysbusiType = StringUtils.isBlank(sysConfig.getSysbusi_type()) ? " " : sysConfig.getSysbusi_type();
        String accessLevel = StringUtils.isBlank(sysConfig.getAccess_level()) ? " " : sysConfig.getAccess_level();
        String remark = sysConfig.getRemark().replaceAll("'", "''");
        String sql =
                "     select count(1) into v_rowcount from dual\n" +
                        "     where exists (select 1 from hs_mssecu.sysconfig where config_no="+sysConfig.getConfig_no()+");\n" +
                        "    if v_rowcount = 0 then\n" +
                        "        insert into hs_mssecu.sysconfig (branch_no,config_no,config_name,config_type,manage_level,access_level," +
                        "en_system_str,data_type,char_config,int_config,str_config,remark,company_type,sysbusi_type) " +
                        "values ("+sysConfig.getBranch_no()+", "+sysConfig.getConfig_no()+", '"+sysConfig.getConfig_name()+"'," +
                        " '"+sysConfig.getConfig_type()+"', '"+sysConfig.getManage_level()+"', '"+accessLevel+"'," +
                        " '"+sysConfig.getEn_system_str()+"', '"+sysConfig.getData_type()+"', '"+sysConfig.getChar_config()+"'," +
                        " "+sysConfig.getInt_config()+", '"+sysConfig.getStr_config()+"', '"+remark+"'," +
                        " '"+companyType+"', '"+sysbusiType+"');\n" +
                        "        update hs_mssecu.sysconfig set branch_no = (select branch_no from hs_mssecu.sysarg) where config_no = "+sysConfig.getConfig_no()+" and branch_no = 8888 and exists(select branch_no from hs_mssecu.sysarg);\n";
        return sql;
    }

    public static String getCommonSql(BusinFlag businFlag){
        String sql =
                "     select count(1) into v_rowcount from dual\n" +
                        "     where exists (select 1 from hs_mssecu.businflag where business_flag="+businFlag.getBusiness_flag()+");\n" +
                        "    if v_rowcount = 0 then\n" +
                        "        insert into hs_mssecu.businflag (business_flag,business_name,business_subject,business_kind,business_group,borrow_lend,business_group_user,join_business_flag,opp_business_flag)\n" +
                        "\t\tvalues ("+businFlag.getBusiness_flag()+", '"+businFlag.getBusiness_name()+"', '"+businFlag.getBusiness_subject()+"', '"+businFlag.getBusiness_kind()+"'," +
                        " '"+businFlag.getBusiness_group()+"', '"+businFlag.getBorrow_lend()+"', '"+businFlag.getBusiness_group_user()+"', "+businFlag.getJoin_business_flag()+", "+businFlag.getOpp_business_flag()+");\n" ;
        return sql;
    }

    public static String getCommonSql(StkAdFare stkAdFare){
        String sql =
                "     select count(1) into v_rowcount from dual\n" +
                        "     where exists (select 1 from hs_mssecu.stkadfare where exchange_type='"+stkAdFare.getExchange_type()+"' and stock_type='"+stkAdFare.getStock_type()+"');\n" +
                        "    if v_rowcount = 0 then\n" +
                        "        insert into hs_mssecu.stkadfare(exchange_type,stock_type,frozen_adjustfare) values ('"+stkAdFare.getExchange_type()+"','"+stkAdFare.getStock_type()+"',"+stkAdFare.getFrozen_adjustfare()+");\n" ;
        return sql;
    }

    public static String getCommonSql(ExchangeDate exchangeDate){
        String sql =
                "     select count(1) into v_rowcount from dual\n" +
                        "     where exists (select 1 from hs_mssecu.exchangedate where FINANCE_TYPE = '"
                        + exchangeDate.getFinance_type() + "' and EXCHANGE_TYPE = '"+exchangeDate.getExchange_type()+"' and INIT_DATE = "+
                        exchangeDate.getInit_date()+" );\n" +
                        "    if v_rowcount = 0 then\n" +
                        "        insert into hs_mssecu.exchangedate (FINANCE_TYPE, EXCHANGE_TYPE, INIT_DATE, TREAT_FLAG, TRADE_FLAG, SETTLE_FLAG)\n" +
                        "\t\tvalues ('"+ exchangeDate.getFinance_type() +"', '"+exchangeDate.getExchange_type()+"', "+exchangeDate.getInit_date()+
                        ", '"+exchangeDate.getTreat_flag()+"', '"+exchangeDate.getTrade_flag()+"', '"+exchangeDate.getSettle_flag()+"');\n";
        return sql;
    }

    public static String getMysqlInsertSql(String commonSql){
        String header = "drop procedure if exists sp_db_mysql;\n" +
                "delimiter $$\n" +
                "  create procedure sp_db_mysql()\n" +
                "  begin\n" +
                "     declare v_rowcount int;\n";
        String foot = "    end if;\n" +
                "  end$$\n" +
                "delimiter ;\n" +
                "call sp_db_mysql();\n" +
                "drop procedure if exists sp_db_mysql;\n";
        return header + commonSql + foot;
    }


    public static String getCommonSql(SysDictionary sysDictionary){
        String companyType = StringUtils.isBlank(sysDictionary.getCompany_type()) ? " " : sysDictionary.getCompany_type();
        String sql ="     select count(1) into v_rowcount from dual\n" +
                "     where exists (select 1 from hs_mssecu.sysdictionary where dict_entry = '"
                + sysDictionary.getDict_entry() + "' and subentry = '"+sysDictionary.getSubentry()+"' );\n" +
                "    if v_rowcount = 0 then\n" +
                "        insert into hs_mssecu.sysdictionary (branch_no, dict_type, dict_entry, subentry, dict_prompt, dict_order_no, access_level, company_type)\n" +
                "\t\tVALUES ("+ sysDictionary.getBranch_no() +" , '"+sysDictionary.getDict_type()+"', "+sysDictionary.getDict_entry()+"," +
                " '"+sysDictionary.getSubentry()+"', '"+sysDictionary.getDict_prompt()+"', "+sysDictionary.getDict_order_no()+", '"+sysDictionary.getAccess_level()+"', '"+companyType+"');\n" +
                "        update hs_mssecu.sysdictionary set branch_no = (select branch_no from hs_mssecu.sysarg) where " +
                "dict_entry = '"+sysDictionary.getDict_entry()+"' and subentry ='"+sysDictionary.getSubentry()+"' and " +
                        "branch_no = 8888 and exists(select branch_no from hs_mssecu.sysarg);\n";
        return sql;
    }


    public static String getCommonSql(StkModel stkModel){
        String sql =
                "     select count(1) into v_rowcount from dual\n" +
                        "     where exists (select 1 from hs_mssecu.stkmodel where exchange_type = '"
                        + stkModel.getExchange_type() + "' and stock_type_ass = '"+stkModel.getStock_type_ass()+"' and stock_type = '"+
                        stkModel.getStock_type()+"' and  model_code = '"+stkModel.getModel_code()+"' and name_prefix = '"+stkModel.getName_prefix()+"' );\n" +
                        "    if v_rowcount = 0 then\n" +
                        "        insert into hs_mssecu.stkmodel (exchange_type, stock_type_ass, stock_type, model_code, prefix, update_date, update_time, count_direction, start_postion, name_prefix, relative_model, modifiable, sub_stock_type, use_date)\n" +
                        "\t\tvalues ('"+stkModel.getExchange_type()+"', '"+stkModel.getStock_type_ass()+"', '"+stkModel.getStock_type()+"', '"+stkModel.getModel_code()+"'," +
                        " '"+stkModel.getPrefix()+"', '"+stkModel.getUpdate_date()+"', '"+stkModel.getUpdate_time()+"', '"+stkModel.getCount_direction()+"', '"+stkModel.getStart_postion()+"', '"+stkModel.getName_prefix()+"', '"+stkModel.getRelative_model()+"'," +
                        " '"+stkModel.getModifiable()+"', '"+stkModel.getSub_stock_type()+"', '"+stkModel.getUse_date()+"');\n";
        return sql;
    }


    public static String getCommonSql(StkType StkType){
        String sql =
                "     select count(1) into v_rowcount from dual\n" +
                        "     where exists (select 1 from hs_mssecu.stktype where stock_type = '"
                        + StkType.getStock_type() + "' and exchange_type = '"+StkType.getExchange_type()+"' and stock_type_ass = '"+
                        StkType.getStock_type_ass()+"' and  sub_stock_type = '"+StkType.getSub_stock_type()+"' );\n" +
                        "    if v_rowcount = 0 then\n" +
                        "        insert into hs_mssecu.stktype (exchange_type,stock_type_ass,stock_type," +
                        "sub_stock_type,type_name," +
                        "update_date,update_time,money_type,frozen_code," +
                        "trustee,overdraw,asset_flag,amount_per_hand," +
                        "store_unit,report_unit,buy_unit,sell_unit,price_step,price_grade," +
                        "report_direction,fund_direction,stock_direction,fund_frozen," +
                        "fund_real_back,stock_real_back,match_type," +
                        "tn_type,fund_back_n,stock_back_n," +
                        "par_value,defaultprice_type,limitprice_type," +
                        "baseprice_type,buy_client,sell_client," +
                        "buy_holder,sell_holder,en_entrust_way," +
                        "elig_risk_level,limit_value_up,limit_value_low," +
                        "high_amount,low_amount,low_balance," +
                        "high_balance,cancel_low_balance,cancel_high_balance," +
                        "bondinv_flag,market_high_amount,market_low_amount," +
                        "market_buy_unit,market_sell_unit,fare_stock_type," +
                        "fare_sub_stock_type) \n" +
                        "\t\tvalues ('"+StkType.getExchange_type()+"', '"+StkType.getStock_type_ass()+"', '"+StkType.getStock_type()+"'," +
                        " '"+StkType.getSub_stock_type()+"', '"+StkType.getType_name()+"'," +
                        " "+StkType.getUpdate_date()+", "+StkType.getUpdate_time()+", '"+StkType.getMoney_type()+"', '"+StkType.getFrozen_code()+"'," +
                        " '"+StkType.getTrustee()+"', '"+StkType.getOverdraw()+"', '"+StkType.getAsset_flag()+"'," +
                        " "+StkType.getAmount_per_hand()+", "+StkType.getStore_unit()+", "+StkType.getReport_unit()+"," +
                        " "+StkType.getBuy_unit()+"," +
                        " "+StkType.getSell_unit()+", "+StkType.getPrice_step()+", "+StkType.getPrice_grade()+"," +
                        " '"+StkType.getReport_direction()+"', '"+StkType.getFund_direction()+"', '"+StkType.getStock_direction()+"', '"+StkType.getFund_frozen()+"'," +
                        " '"+StkType.getFund_real_back()+"', '"+StkType.getStock_real_back()+"', '"+StkType.getMatch_type()+"'," +
                        " '"+StkType.getTn_type()+"', "+StkType.getFund_back_n()+", "+StkType.getStock_back_n()+"," +
                        " "+StkType.getPar_value()+", '"+StkType.getDefaultprice_type()+"', '"+StkType.getLimitprice_type()+"'," +
                        " '"+StkType.getBaseprice_type()+"', '"+StkType.getBuy_client()+"', '"+StkType.getSell_client()+"'," +
                        " '"+StkType.getBuy_holder()+"', '"+StkType.getSell_holder()+"', '"+StkType.getEn_entrust_way()+"'," +
                        " "+StkType.getElig_risk_level()+", "+StkType.getLimit_value_up()+", "+StkType.getLimit_value_low()+"," +
                        " "+StkType.getHigh_amount()+", "+StkType.getLow_amount()+", "+StkType.getLow_balance()+"," +
                        " "+StkType.getHigh_balance()+", "+StkType.getCancel_low_balance()+", "+StkType.getCancel_high_balance()+"," +
                        " '"+StkType.getBondinv_flag()+"', "+StkType.getMarket_high_amount()+", "+StkType.getMarket_low_amount()+"," +
                        " "+StkType.getMarket_buy_unit()+", "+StkType.getMarket_sell_unit()+", '"+StkType.getFare_stock_type()+"'," +
                        " '"+StkType.getFare_sub_stock_type()+"');\n";
        return sql;
    }
}

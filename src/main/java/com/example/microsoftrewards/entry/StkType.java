package com.example.microsoftrewards.entry;

public class StkType {
    /**
     * 交易类别
     */
    private String exchange_type ;
    /**
     * 辅助证券类别
     */
    private Character stock_type_ass ;
    /**
     * 证券类别
     */
    private String stock_type ;
    /**
     * 证券子类
     */
    private String sub_stock_type ;
    /**
     * 证券类别名称
     */
    private String type_name ;
    /**
     * 更新日期
     */
    private Integer update_date ;
    /**
     * 更新时间
     */
    private Integer update_time ;
    /**
     * 币种类别
     */
    private String money_type ;
    /**
     * 冻结代码
     */
    private String frozen_code ;
    /**
     * 托管标志
     */
    private Character trustee ;
    /**
     * 新指定可卖空
     */
    private Character overdraw ;
    /**
     * 计算市值标志
     */
    private Character asset_flag ;
    /**
     * 合约乘数
     */
    private Integer amount_per_hand ;
    /**
     * 存放单位
     */
    private Integer store_unit ;
    /**
     * 申报单位
     */
    private Integer report_unit ;
    /**
     * 买入单位
     */
    private Integer buy_unit ;
    /**
     * 卖出单位
     */
    private Integer sell_unit ;
    /**
     * 最小价差(厘)
     */
    private Integer price_step ;
    /**
     * 档位价格(厘)
     */
    private Integer price_grade ;
    /**
     * 交易方向
     */
    private Character report_direction ;
    /**
     * 资金方向
     */
    private Character fund_direction ;
    /**
     * 证券方向
     */
    private Character stock_direction ;
    /**
     * 资金冻结方式
     */
    private Character fund_frozen ;
    /**
     * 回报资金标志
     */
    private Character fund_real_back ;
    /**
     * 回报证券标志
     */
    private Character stock_real_back ;
    /**
     * 配对方式
     */
    private Character match_type ;
    /**
     * 计算类型
     */
    private Character tn_type ;
    /**
     * 资金t+n天数
     */
    private Integer fund_back_n ;
    /**
     * 证券t+n天数
     */
    private Integer stock_back_n ;
    /**
     * 面值
     */
    private Double par_value ;
    /**
     * 缺省价格类型
     */
    private Character defaultprice_type ;
    /**
     * 限价类型
     */
    private Character limitprice_type ;
    /**
     * 基价类型
     */
    private Character baseprice_type ;
    /**
     * 买入允许客户类别
     */
    private String buy_client ;
    /**
     * 卖出允许客户类别
     */
    private String sell_client ;
    /**
     * 买入允许账户类别
     */
    private String buy_holder ;
    /**
     * 卖出允许账户类别
     */
    private String sell_holder ;
    /**
     * 允许委托方式
     */
    private String en_entrust_way ;
    /**
     * 适当性风险等级
     */
    private Integer elig_risk_level ;
    /**
     * 上限价数值
     */
    private Integer limit_value_up ;
    /**
     * 下限价数值
     */
    private Integer limit_value_low ;
    /**
     * 交易最高数量
     */
    private Double high_amount ;
    /**
     * 交易最低数量
     */
    private Double low_amount ;
    /**
     * 交易最少金额
     */
    private Double low_balance ;
    /**
     * 交易最高金额
     */
    private Double high_balance ;
    /**
     * 撤单最少金额
     */
    private Double cancel_low_balance ;
    /**
     * 撤单最高金额
     */
    private Double cancel_high_balance ;
    /**
     * 债券投资标志
     */
    private Character bondinv_flag ;
    /**
     * 市价交易最高数量
     */
    private Double market_high_amount ;
    /**
     * 市价交易最低数量
     */
    private Double market_low_amount ;
    /**
     * 市价买入单位
     */
    private Integer market_buy_unit ;
    /**
     * 市价卖出单位
     */
    private Integer market_sell_unit ;
    /**
     * 收费证券类别
     */
    private String fare_stock_type ;
    /**
     * 费用证券子类
     */
    private String fare_sub_stock_type ;

    public String getExchange_type() {
        return exchange_type;
    }

    public void setExchange_type(String exchange_type) {
        this.exchange_type = exchange_type;
    }

    public Character getStock_type_ass() {
        return stock_type_ass;
    }

    public void setStock_type_ass(Character stock_type_ass) {
        this.stock_type_ass = stock_type_ass;
    }

    public String getStock_type() {
        return stock_type;
    }

    public void setStock_type(String stock_type) {
        this.stock_type = stock_type;
    }

    public String getSub_stock_type() {
        return sub_stock_type;
    }

    public void setSub_stock_type(String sub_stock_type) {
        this.sub_stock_type = sub_stock_type;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public Integer getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Integer update_date) {
        this.update_date = update_date;
    }

    public Integer getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Integer update_time) {
        this.update_time = update_time;
    }

    public String getMoney_type() {
        return money_type;
    }

    public void setMoney_type(String money_type) {
        this.money_type = money_type;
    }

    public String getFrozen_code() {
        return frozen_code;
    }

    public void setFrozen_code(String frozen_code) {
        this.frozen_code = frozen_code;
    }

    public Character getTrustee() {
        return trustee;
    }

    public void setTrustee(Character trustee) {
        this.trustee = trustee;
    }

    public Character getOverdraw() {
        return overdraw;
    }

    public void setOverdraw(Character overdraw) {
        this.overdraw = overdraw;
    }

    public Character getAsset_flag() {
        return asset_flag;
    }

    public void setAsset_flag(Character asset_flag) {
        this.asset_flag = asset_flag;
    }

    public Integer getAmount_per_hand() {
        return amount_per_hand;
    }

    public void setAmount_per_hand(Integer amount_per_hand) {
        this.amount_per_hand = amount_per_hand;
    }

    public Integer getStore_unit() {
        return store_unit;
    }

    public void setStore_unit(Integer store_unit) {
        this.store_unit = store_unit;
    }

    public Integer getReport_unit() {
        return report_unit;
    }

    public void setReport_unit(Integer report_unit) {
        this.report_unit = report_unit;
    }

    public Integer getBuy_unit() {
        return buy_unit;
    }

    public void setBuy_unit(Integer buy_unit) {
        this.buy_unit = buy_unit;
    }

    public Integer getSell_unit() {
        return sell_unit;
    }

    public void setSell_unit(Integer sell_unit) {
        this.sell_unit = sell_unit;
    }

    public Integer getPrice_step() {
        return price_step;
    }

    public void setPrice_step(Integer price_step) {
        this.price_step = price_step;
    }

    public Integer getPrice_grade() {
        return price_grade;
    }

    public void setPrice_grade(Integer price_grade) {
        this.price_grade = price_grade;
    }

    public Character getReport_direction() {
        return report_direction;
    }

    public void setReport_direction(Character report_direction) {
        this.report_direction = report_direction;
    }

    public Character getFund_direction() {
        return fund_direction;
    }

    public void setFund_direction(Character fund_direction) {
        this.fund_direction = fund_direction;
    }

    public Character getStock_direction() {
        return stock_direction;
    }

    public void setStock_direction(Character stock_direction) {
        this.stock_direction = stock_direction;
    }

    public Character getFund_frozen() {
        return fund_frozen;
    }

    public void setFund_frozen(Character fund_frozen) {
        this.fund_frozen = fund_frozen;
    }

    public Character getFund_real_back() {
        return fund_real_back;
    }

    public void setFund_real_back(Character fund_real_back) {
        this.fund_real_back = fund_real_back;
    }

    public Character getStock_real_back() {
        return stock_real_back;
    }

    public void setStock_real_back(Character stock_real_back) {
        this.stock_real_back = stock_real_back;
    }

    public Character getMatch_type() {
        return match_type;
    }

    public void setMatch_type(Character match_type) {
        this.match_type = match_type;
    }

    public Character getTn_type() {
        return tn_type;
    }

    public void setTn_type(Character tn_type) {
        this.tn_type = tn_type;
    }

    public Integer getFund_back_n() {
        return fund_back_n;
    }

    public void setFund_back_n(Integer fund_back_n) {
        this.fund_back_n = fund_back_n;
    }

    public Integer getStock_back_n() {
        return stock_back_n;
    }

    public void setStock_back_n(Integer stock_back_n) {
        this.stock_back_n = stock_back_n;
    }

    public Double getPar_value() {
        return par_value;
    }

    public void setPar_value(Double par_value) {
        this.par_value = par_value;
    }

    public Character getDefaultprice_type() {
        return defaultprice_type;
    }

    public void setDefaultprice_type(Character defaultprice_type) {
        this.defaultprice_type = defaultprice_type;
    }

    public Character getLimitprice_type() {
        return limitprice_type;
    }

    public void setLimitprice_type(Character limitprice_type) {
        this.limitprice_type = limitprice_type;
    }

    public Character getBaseprice_type() {
        return baseprice_type;
    }

    public void setBaseprice_type(Character baseprice_type) {
        this.baseprice_type = baseprice_type;
    }

    public String getBuy_client() {
        return buy_client;
    }

    public void setBuy_client(String buy_client) {
        this.buy_client = buy_client;
    }

    public String getSell_client() {
        return sell_client;
    }

    public void setSell_client(String sell_client) {
        this.sell_client = sell_client;
    }

    public String getBuy_holder() {
        return buy_holder;
    }

    public void setBuy_holder(String buy_holder) {
        this.buy_holder = buy_holder;
    }

    public String getSell_holder() {
        return sell_holder;
    }

    public void setSell_holder(String sell_holder) {
        this.sell_holder = sell_holder;
    }

    public String getEn_entrust_way() {
        return en_entrust_way;
    }

    public void setEn_entrust_way(String en_entrust_way) {
        this.en_entrust_way = en_entrust_way;
    }

    public Integer getElig_risk_level() {
        return elig_risk_level;
    }

    public void setElig_risk_level(Integer elig_risk_level) {
        this.elig_risk_level = elig_risk_level;
    }

    public Integer getLimit_value_up() {
        return limit_value_up;
    }

    public void setLimit_value_up(Integer limit_value_up) {
        this.limit_value_up = limit_value_up;
    }

    public Integer getLimit_value_low() {
        return limit_value_low;
    }

    public void setLimit_value_low(Integer limit_value_low) {
        this.limit_value_low = limit_value_low;
    }

    public Double getHigh_amount() {
        return high_amount;
    }

    public void setHigh_amount(Double high_amount) {
        this.high_amount = high_amount;
    }

    public Double getLow_amount() {
        return low_amount;
    }

    public void setLow_amount(Double low_amount) {
        this.low_amount = low_amount;
    }

    public Double getLow_balance() {
        return low_balance;
    }

    public void setLow_balance(Double low_balance) {
        this.low_balance = low_balance;
    }

    public Double getHigh_balance() {
        return high_balance;
    }

    public void setHigh_balance(Double high_balance) {
        this.high_balance = high_balance;
    }

    public Double getCancel_low_balance() {
        return cancel_low_balance;
    }

    public void setCancel_low_balance(Double cancel_low_balance) {
        this.cancel_low_balance = cancel_low_balance;
    }

    public Double getCancel_high_balance() {
        return cancel_high_balance;
    }

    public void setCancel_high_balance(Double cancel_high_balance) {
        this.cancel_high_balance = cancel_high_balance;
    }

    public Character getBondinv_flag() {
        return bondinv_flag;
    }

    public void setBondinv_flag(Character bondinv_flag) {
        this.bondinv_flag = bondinv_flag;
    }

    public Double getMarket_high_amount() {
        return market_high_amount;
    }

    public void setMarket_high_amount(Double market_high_amount) {
        this.market_high_amount = market_high_amount;
    }

    public Double getMarket_low_amount() {
        return market_low_amount;
    }

    public void setMarket_low_amount(Double market_low_amount) {
        this.market_low_amount = market_low_amount;
    }

    public Integer getMarket_buy_unit() {
        return market_buy_unit;
    }

    public void setMarket_buy_unit(Integer market_buy_unit) {
        this.market_buy_unit = market_buy_unit;
    }

    public Integer getMarket_sell_unit() {
        return market_sell_unit;
    }

    public void setMarket_sell_unit(Integer market_sell_unit) {
        this.market_sell_unit = market_sell_unit;
    }

    public String getFare_stock_type() {
        return fare_stock_type;
    }

    public void setFare_stock_type(String fare_stock_type) {
        this.fare_stock_type = fare_stock_type;
    }

    public String getFare_sub_stock_type() {
        return fare_sub_stock_type;
    }

    public void setFare_sub_stock_type(String fare_sub_stock_type) {
        this.fare_sub_stock_type = fare_sub_stock_type;
    }
}

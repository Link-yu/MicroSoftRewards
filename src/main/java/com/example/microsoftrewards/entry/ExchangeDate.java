package com.example.microsoftrewards.entry;

public class ExchangeDate {
    private String finance_type;
    private String exchange_type;
    private int init_date;
    private String treat_flag;
    private String trade_flag;
    private String settle_flag;
    private String special_trade_flag;

    public String getFinance_type() {
        return finance_type;
    }

    public void setFinance_type(String finance_type) {
        this.finance_type = finance_type;
    }

    public String getExchange_type() {
        return exchange_type;
    }

    public void setExchange_type(String exchange_type) {
        this.exchange_type = exchange_type;
    }

    public int getInit_date() {
        return init_date;
    }

    public void setInit_date(int init_date) {
        this.init_date = init_date;
    }

    public String getTreat_flag() {
        return treat_flag;
    }

    public void setTreat_flag(String treat_flag) {
        this.treat_flag = treat_flag;
    }

    public String getTrade_flag() {
        return trade_flag;
    }

    public void setTrade_flag(String trade_flag) {
        this.trade_flag = trade_flag;
    }

    public String getSettle_flag() {
        return settle_flag;
    }

    public void setSettle_flag(String settle_flag) {
        this.settle_flag = settle_flag;
    }

    public String getSpecial_trade_flag() {
        return special_trade_flag;
    }

    public void setSpecial_trade_flag(String special_trade_flag) {
        this.special_trade_flag = special_trade_flag;
    }
}

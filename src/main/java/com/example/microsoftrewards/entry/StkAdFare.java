package com.example.microsoftrewards.entry;

import java.io.Serializable;

public class StkAdFare implements Serializable {

    /**
     * 交易类别
     */
    private String exchange_type;
    /**
     * 证券类别
     */
    private String stock_type;
    /**
     * 资金调整值
     */
    private Double frozen_adjustfare;

    public String getExchange_type() {
        return exchange_type;
    }

    public void setExchange_type(String exchange_type) {
        this.exchange_type = exchange_type;
    }

    public String getStock_type() {
        return stock_type;
    }

    public void setStock_type(String stock_type) {
        this.stock_type = stock_type;
    }

    public Double getFrozen_adjustfare() {
        return frozen_adjustfare;
    }

    public void setFrozen_adjustfare(Double frozen_adjustfare) {
        this.frozen_adjustfare = frozen_adjustfare;
    }
}

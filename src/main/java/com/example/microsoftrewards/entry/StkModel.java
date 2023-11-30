package com.example.microsoftrewards.entry;

import java.io.Serializable;

public class StkModel implements Serializable {
    /**
     * 交易类别
     */
    private String exchange_type;
    /**
     * 辅助证券类别
     */
    private Character stock_type_ass;
    /**
     * 证券类别
     */
    private String stock_type;
    /**
     * 模板代码
     */
    private String model_code;
    /**
     * 前缀
     */
    private String prefix;
    /**
     * 更新日期
     */
    private Integer update_date;
    /**
     * 更新时间
     */
    private Integer update_time;
    /**
     * 计算方向
     */
    private Character count_direction;
    /**
     * 起始位置
     */
    private Integer start_postion;
    /**
     * 名称片断
     */
    private String name_prefix;
    /**
     * 相关模板
     */
    private String relative_model;
    /**
     * 能否修改
     */
    private Character modifiable ;
    /**
     * 证券子类
     */
    private String sub_stock_type ;
    /**
     * 使用日期
     */
    private Integer use_date ;

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

    public String getModel_code() {
        return model_code;
    }

    public void setModel_code(String model_code) {
        this.model_code = model_code;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
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

    public Character getCount_direction() {
        return count_direction;
    }

    public void setCount_direction(Character count_direction) {
        this.count_direction = count_direction;
    }

    public Integer getStart_postion() {
        return start_postion;
    }

    public void setStart_postion(Integer start_postion) {
        this.start_postion = start_postion;
    }

    public String getName_prefix() {
        return name_prefix;
    }

    public void setName_prefix(String name_prefix) {
        this.name_prefix = name_prefix;
    }

    public String getRelative_model() {
        return relative_model;
    }

    public void setRelative_model(String relative_model) {
        this.relative_model = relative_model;
    }

    public Character getModifiable() {
        return modifiable;
    }

    public void setModifiable(Character modifiable) {
        this.modifiable = modifiable;
    }

    public String getSub_stock_type() {
        return sub_stock_type;
    }

    public void setSub_stock_type(String sub_stock_type) {
        this.sub_stock_type = sub_stock_type;
    }

    public Integer getUse_date() {
        return use_date;
    }

    public void setUse_date(Integer use_date) {
        this.use_date = use_date;
    }
}

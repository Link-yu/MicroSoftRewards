package com.example.microsoftrewards.entry;

import java.io.Serializable;

public class BusinFlag implements Serializable {
    /**
     * 业务标志
     */
    private Integer business_flag;
    /**
     * 业务名称
     */
    private String business_name;
    /**
     * 业务科目
     */
    private String business_subject;
    /**
     * 业务类型
     */
    private Character business_kind;
    /**
     * 业务分类
     */
    private String business_group;
    /**
     * 借贷标志
     */
    private Character borrow_lend;
    /**
     * 用户定义业务分类
     */
    private String business_group_user;
    /**
     * 冲销对应业务标志
     */
    private Integer join_business_flag;
    /**
     * 反向对应业务标志
     */
    private Integer opp_business_flag;

    public Integer getBusiness_flag() {
        return business_flag;
    }

    public void setBusiness_flag(Integer business_flag) {
        this.business_flag = business_flag;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getBusiness_subject() {
        return business_subject;
    }

    public void setBusiness_subject(String business_subject) {
        this.business_subject = business_subject;
    }

    public Character getBusiness_kind() {
        return business_kind;
    }

    public void setBusiness_kind(Character business_kind) {
        this.business_kind = business_kind;
    }

    public String getBusiness_group() {
        return business_group;
    }

    public void setBusiness_group(String business_group) {
        this.business_group = business_group;
    }

    public Character getBorrow_lend() {
        return borrow_lend;
    }

    public void setBorrow_lend(Character borrow_lend) {
        this.borrow_lend = borrow_lend;
    }

    public String getBusiness_group_user() {
        return business_group_user;
    }

    public void setBusiness_group_user(String business_group_user) {
        this.business_group_user = business_group_user;
    }

    public Integer getJoin_business_flag() {
        return join_business_flag;
    }

    public void setJoin_business_flag(Integer join_business_flag) {
        this.join_business_flag = join_business_flag;
    }

    public Integer getOpp_business_flag() {
        return opp_business_flag;
    }

    public void setOpp_business_flag(Integer opp_business_flag) {
        this.opp_business_flag = opp_business_flag;
    }
}

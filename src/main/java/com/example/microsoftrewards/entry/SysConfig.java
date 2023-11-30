package com.example.microsoftrewards.entry;

import java.io.Serializable;

public class SysConfig implements Serializable {

    /**
     * 分支机构编号
     */
    private Integer branch_no;
    /**
     * 配置编号
     */
    private Integer config_no;
    /**
     * 配置名称
     */
    private String config_name;
    /**
     * 配置类型
     */
    private Character config_type ;
    /**
     * 管理级别
     */
    private Character manage_level ;
    /**
     * 存取级别
     */
    private String access_level ;
    /**
     * 允许使用的系统串
     */
    private String en_system_str;
    /**
     * 数据类型
     */
    private Character data_type ;
    /**
     * 字符值
     */
    private Character char_config ;
    /**
     * 整数值
     */
    private Integer int_config;
    /**
     * 字符串值
     */
    private String str_config;
    /**
     * 备注
     */
    private String remark;
    /**
     * 公司类型
     */
    private String company_type ;
    /**
     * 系统业务分类
     */
    private String sysbusi_type ;

    public Integer getBranch_no() {
        return branch_no;
    }

    public void setBranch_no(Integer branch_no) {
        this.branch_no = branch_no;
    }

    public Integer getConfig_no() {
        return config_no;
    }

    public void setConfig_no(Integer config_no) {
        this.config_no = config_no;
    }

    public String getConfig_name() {
        return config_name;
    }

    public void setConfig_name(String config_name) {
        this.config_name = config_name;
    }

    public Character getConfig_type() {
        return config_type;
    }

    public void setConfig_type(Character config_type) {
        this.config_type = config_type;
    }

    public Character getManage_level() {
        return manage_level;
    }

    public void setManage_level(Character manage_level) {
        this.manage_level = manage_level;
    }

    public String getAccess_level() {
        return access_level;
    }

    public void setAccess_level(String access_level) {
        this.access_level = access_level;
    }

    public String getEn_system_str() {
        return en_system_str;
    }

    public void setEn_system_str(String en_system_str) {
        this.en_system_str = en_system_str;
    }

    public Character getData_type() {
        return data_type;
    }

    public void setData_type(Character data_type) {
        this.data_type = data_type;
    }

    public Character getChar_config() {
        return char_config;
    }

    public void setChar_config(Character char_config) {
        this.char_config = char_config;
    }

    public Integer getInt_config() {
        return int_config;
    }

    public void setInt_config(Integer int_config) {
        this.int_config = int_config;
    }

    public String getStr_config() {
        return str_config;
    }

    public void setStr_config(String str_config) {
        this.str_config = str_config;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCompany_type() {
        return company_type;
    }

    public void setCompany_type(String company_type) {
        this.company_type = company_type;
    }

    public String getSysbusi_type() {
        return sysbusi_type;
    }

    public void setSysbusi_type(String sysbusi_type) {
        this.sysbusi_type = sysbusi_type;
    }
}

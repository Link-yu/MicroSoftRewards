package com.example.microsoftrewards.entry;

public class SysDictionary {
    /**
     * 分支机构编号
     */
    private Integer branch_no;
    /**
     * 字典类型
     */
    private Character dict_type;
    /**
     * 字典条目
     */
    private Integer dict_entry;
    /**
     * 字典子项
     */
    private String subentry;
    /**
     * 子项名称
     */
    private String dict_prompt;
    /**
     * 子项序列
     */
    private Long dict_order_no;
    /**
     * 存取级别
     */
    private Character access_level;
    /**
     * 公司类型
     */
    private String company_type;

    public Integer getBranch_no() {
        return branch_no;
    }

    public void setBranch_no(Integer branch_no) {
        this.branch_no = branch_no;
    }

    public Character getDict_type() {
        return dict_type;
    }

    public void setDict_type(Character dict_type) {
        this.dict_type = dict_type;
    }

    public Integer getDict_entry() {
        return dict_entry;
    }

    public void setDict_entry(Integer dict_entry) {
        this.dict_entry = dict_entry;
    }

    public String getSubentry() {
        return subentry;
    }

    public void setSubentry(String subentry) {
        this.subentry = subentry;
    }

    public String getDict_prompt() {
        return dict_prompt;
    }

    public void setDict_prompt(String dict_prompt) {
        this.dict_prompt = dict_prompt;
    }

    public Long getDict_order_no() {
        return dict_order_no;
    }

    public void setDict_order_no(Long dict_order_no) {
        this.dict_order_no = dict_order_no;
    }

    public Character getAccess_level() {
        return access_level;
    }

    public void setAccess_level(Character access_level) {
        this.access_level = access_level;
    }

    public String getCompany_type() {
        return company_type;
    }

    public void setCompany_type(String company_type) {
        this.company_type = company_type;
    }
}

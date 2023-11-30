package com.example.microsoftrewards.entry;

public class ExchangeErrcode {
    /**
     * LDP错误号
     */
    private Integer ldp_error_code;
    /**
     * 上交所错误号
     */
    private Integer sh_error_code;
    /**
     * 深交所错误号
     */
    private Integer sz_error_code;
    /**
     * 行为风险指标类型串名称
     */
    private String behavioralrisk_type_str_name;
    /**
     * 最后修改日期
     */
    private Integer modi_date;

    public Integer getLdp_error_code() {
        return ldp_error_code;
    }

    public void setLdp_error_code(Integer ldp_error_code) {
        this.ldp_error_code = ldp_error_code;
    }

    public Integer getSh_error_code() {
        return sh_error_code;
    }

    public void setSh_error_code(Integer sh_error_code) {
        this.sh_error_code = sh_error_code;
    }

    public Integer getSz_error_code() {
        return sz_error_code;
    }

    public void setSz_error_code(Integer sz_error_code) {
        this.sz_error_code = sz_error_code;
    }

    public String getBehavioralrisk_type_str_name() {
        return behavioralrisk_type_str_name;
    }

    public void setBehavioralrisk_type_str_name(String behavioralrisk_type_str_name) {
        this.behavioralrisk_type_str_name = behavioralrisk_type_str_name;
    }

    public Integer getModi_date() {
        return modi_date;
    }

    public void setModi_date(Integer modi_date) {
        this.modi_date = modi_date;
    }
}

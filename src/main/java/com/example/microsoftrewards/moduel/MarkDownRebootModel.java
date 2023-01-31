package com.example.microsoftrewards.moduel;

import lombok.Data;

@Data
public class MarkDownRebootModel {
    /**
     * 此消息类型为固定markdown
     */
    public String msgtype = "markdown";

    public MarkDownModel markdown;

    public AtMobiles at;
}

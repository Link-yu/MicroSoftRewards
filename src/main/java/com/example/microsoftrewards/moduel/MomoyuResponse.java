package com.example.microsoftrewards.moduel;

import lombok.Data;

import java.util.List;

@Data
public class MomoyuResponse {
    private Integer status;

    private String message;

    private List<Momoyu> data;
}

package com.example.microsoftrewards.dl;

import com.example.microsoftrewards.moduel.Momoyu;
import lombok.Data;

import java.util.List;

@Data
public class DongLiangResponse {
    private String msg;

    private String code;

    private List<DongLiangJob> data;
}

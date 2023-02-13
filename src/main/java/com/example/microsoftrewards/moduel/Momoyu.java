package com.example.microsoftrewards.moduel;

import lombok.Data;

import java.util.List;

@Data
public class Momoyu {
    private String id;

    private Integer sort;

    private String name;

    private List<MomoyuItem> data;
}

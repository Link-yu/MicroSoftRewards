package com.example.microsoftrewards.util;

import java.io.IOException;
import java.net.InetAddress;

public class NetworkUtil {
    public static boolean checkNetwork() {
        boolean network = false;
        try {
            network = InetAddress.getByName("www.baidu.com").isReachable(3000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return network;
    }
}

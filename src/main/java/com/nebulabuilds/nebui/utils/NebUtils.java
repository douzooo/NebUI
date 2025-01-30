package com.nebulabuilds.nebui.utils;

import java.util.UUID;

public class NebUtils {


    public static String generateId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}

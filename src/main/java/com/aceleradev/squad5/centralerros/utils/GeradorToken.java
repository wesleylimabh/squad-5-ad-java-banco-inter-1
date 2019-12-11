package com.aceleradev.squad5.centralerros.utils;

import java.util.UUID;

public class GeradorToken {

    public static String gerarToken(){

        return UUID.randomUUID().toString().replace("-","");

    }

}

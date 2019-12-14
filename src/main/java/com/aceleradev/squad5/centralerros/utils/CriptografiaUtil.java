package com.aceleradev.squad5.centralerros.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class CriptografiaUtil {
    private CriptografiaUtil (){

    }

    public static String criptografa(String str){
        return new BCryptPasswordEncoder().encode(str);
    }
}

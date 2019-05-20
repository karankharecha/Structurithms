package com.structurithms;

import com.structurithms.utils.Utils;

public class CaesarCipher extends Utils {

    public static String encrypt(String target, int key){
        return performCaesar(target, key, true);
    }

    public static String decrypt(String target, int key){
        return performCaesar(target, key, false);
    }

    private static String performCaesar(String target, int key, boolean flag){
        key = key % 26;
        StringBuilder textBuilder = new StringBuilder();
        for(int i=0;i<target.length();i++){
            int value = target.codePointAt(i);
            if (isAlphabet(value)){
                value = flag ? (getValue(value + key, value, true)) : (getValue(value - key, value, false));
            }
            textBuilder.append((char)(value));
        }
        return textBuilder.toString();
    }

}

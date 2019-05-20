package com.structurithms.utils;

public class Utils {

    protected static int getValue(int value, int code, boolean operation){
        return operation ?
                (value > 122 && code >= 97 && code <= 122
                        || value > 90 && code >= 65 && code <= 90) ?
                        value -= 26 : value :
                (value < 97 && code >= 97 && code <= 122
                        || value < 65 && code >= 65 && code <= 90) ?
                        value += 26 : value;

    }

    protected static boolean isAlphabet(int value){
        return (value >=65 && value <= 90 || value >=97 && value <=122);
    }

}
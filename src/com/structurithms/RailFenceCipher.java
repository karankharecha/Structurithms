package com.structurithms;

import com.structurithms.utils.Utils;

import java.util.ArrayList;

public class RailFenceCipher extends Utils {

    public static String encrypt(String plnText, int layers) {
        if (layers >= plnText.length() || layers == 1) {
            return plnText;
        }
        ArrayList<StringBuilder> stringBuilders = new ArrayList<>();
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plnText.length(); i++) {
            try {
                stringBuilders.get(i % layers).append(plnText.charAt(i));
            } catch (Exception e) {
                stringBuilders.add(new StringBuilder().append(plnText.charAt(i)));
            }
        }
        for (StringBuilder sb : stringBuilders) {
            cipherText.append(sb);
        }
        return cipherText.toString();
    }

    public static String decrypt(String encryptedStr, int layers) {
        if (layers >= encryptedStr.length() || layers == 1) {
            return encryptedStr;
        }
        int idx = 0, count = 0;
        StringBuilder plainText = new StringBuilder();
        plainText.setLength(encryptedStr.length());
        for (int i = 0; i < encryptedStr.length(); i++) {
            plainText.setCharAt(idx, encryptedStr.charAt(i));
            idx += layers;
            if (idx >= encryptedStr.length()) {
                count++;
                idx = count;
            }
        }
        return plainText.toString();
    }

}

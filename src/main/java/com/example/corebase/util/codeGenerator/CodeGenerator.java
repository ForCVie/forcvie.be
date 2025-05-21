package com.example.corebase.util.codeGenerator;

import java.util.Random;

public class CodeGenerator {

    public static String generateCode(String prefix, int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            code.append(characters.charAt(index));
        }

        return prefix + code.toString();
    }
}

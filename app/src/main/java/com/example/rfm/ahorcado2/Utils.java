package com.example.rfm.ahorcado2;

import java.util.Arrays;

public class Utils {

    /*public static Boolean isCorrecto(String letraInput, String letraOriginal) {
        return letraInput.equalsIgnoreCase(letraOriginal) ? true : false;
    }*/

/*    public static String textoResultado(String letraInput, String[] palabraOriginal, String textoResultado) {
        Arrays.asList(palabraOriginal).stream().map(s -> !s.equalsIgnoreCase("c") ? "?" : s).collect(Collectors.joining())
        return null;
    }*/

    public static boolean isValidLetter(String inputText) {
        return inputText.matches("([A-Za-z])") ? true : false;
    }
}

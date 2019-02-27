package com.example.rfm.ahorcado2;

public class Utils {

    public static boolean isCorrectLetter(String letraOriginal, String letraIntroducida) {
        return letraIntroducida.equalsIgnoreCase(letraOriginal) ? true : false;
    }
}

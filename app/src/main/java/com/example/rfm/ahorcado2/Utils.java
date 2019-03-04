package com.example.rfm.ahorcado2;

class Utils {

    static boolean isValidLetter(String inputText) {
        return inputText.matches("([A-Za-z])");
    }

    static String isCorrectLetter(String palabraSecreta, String inputText) {
        return palabraSecreta.replaceAll("([^" + inputText.toLowerCase() + "])", "?");
    }

}

package fr.melaine.gerard.passwordgenerator.generator;

import java.util.Random;

public class PasswordGenerator {
    private static final String alphabetLowercase = "abcdefghijklmnopqrstuvwxyz";
    private static final String alphabetUppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String numbers = "0123456789";
    private static final String specialCharacters = "!@#$%^&*()_+";

    public static String generatePassword(int length, int complexity) {
        Random random = new Random();
        String fullAlphabet = getAlphabetFromComplexity(complexity);
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(fullAlphabet.charAt(random.nextInt(fullAlphabet.length())));
        }

        return password.toString();
    }

    private static String getAlphabetFromComplexity(int complexity) {
        switch (complexity) {
            case 1:
                return alphabetLowercase;
            case 2:
                return alphabetLowercase + alphabetUppercase;
            case 3:
                return alphabetLowercase + alphabetUppercase + numbers;
            case 4:
                return alphabetLowercase + alphabetUppercase + numbers + specialCharacters;
        }

        // N'arrivera normalement jamais
        return "";
    }
}

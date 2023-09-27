package fr.melaine.gerard.passwordgenerator.generator;

import java.util.Random;

public class PasswordGenerator {
    private static final String alphabetLowercase = "abcdefghijklmnopqrstuvwxyz";
    private static final String alphabetUppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String numbers = "0123456789";
    private static final String specialCharacters = "!@#$%^&*()_+";
    public static String generatePassword(int length) {
        Random random = new Random();
        String fullAlphabet = alphabetLowercase + alphabetUppercase + numbers + specialCharacters;
        StringBuilder password = new StringBuilder();

        for (int i = 0 ; i < length ; i++) {
            password.append(fullAlphabet.charAt(random.nextInt(fullAlphabet.length())));
        }

        return password.toString();
    }
}

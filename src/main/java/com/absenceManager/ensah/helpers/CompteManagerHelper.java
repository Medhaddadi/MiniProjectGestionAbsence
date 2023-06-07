package com.absenceManager.ensah.helpers;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.slf4j.Logger;

import java.util.List;
import java.util.Set;

public class CompteManagerHelper {
    private Logger logger;
    public static String genaratePassword() {
        CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.generatePassword(10, digits);
        return password;
    }

    public static String genarateLogin(String nom, String prenom, List<String> logins) {
        String username = nom.toLowerCase() + prenom.toLowerCase();
        if (logins == null) return username;
        else {
            if (logins.contains(username)) {
                int i = 1;
                while (logins.contains(username + i)) {
                    i++;
                }
                username = username + i;
            }
            System.out.println("username: " + username);
            return username;
        }
    }

}

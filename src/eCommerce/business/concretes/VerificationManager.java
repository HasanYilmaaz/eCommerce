package eCommerce.business.concretes;

import eCommerce.business.abstracts.VerificationService;
import eCommerce.dataAccess.abstracts.UserDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificationManager implements VerificationService {
    private UserDao userDao;

    String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";


    @Override
    public boolean checkFirstName(String firstName) {
        if (firstName.length() > 2) {
            return true;
        } else {
            System.out.println("İsminiz en az 2 karakterden oluşmalıdır.");
            return false;
        }
    }

    @Override
    public boolean checkLastName(String lastName) {
        if (lastName.length() > 2) {
            return true;
        } else {
            System.out.println("Soyadınız en az 2 karakterden oluşmalıdır.");
            return false;
        }

    }

    @Override
    public boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            System.out.println("Lütfen e-maili düzgün bir biçimde giriniz");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean checkPassword(String password) {
        if (password.length() >= 6) {
            return true;
        } else {
            System.out.println("Parolanız en az 6 karakterden oluşmalı");
        }
        return false;
    }

    @Override
    public boolean checkEmailOnDB(String email) {
        Pattern emailPattern = Pattern.compile(email);
        Matcher emailMatcher = emailPattern.matcher(email);
        if (!emailMatcher.matches()) {

        }
        System.out.println("Bu e-posta zaten sistemde kayıtlı");
        return false;



    }
}


package eCommerce;

import eCommerce.business.abstracts.UserService;
import eCommerce.business.abstracts.VerificationService;
import eCommerce.business.concretes.EmailVerificationManager;
import eCommerce.business.concretes.UserManager;
import eCommerce.business.concretes.VerificationManager;
import eCommerce.core.concretes.RegisterGoogleManager;
import eCommerce.core.concretes.RegisterNManager;
import eCommerce.dataAccess.concretes.xUserDao;
import eCommerce.entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        User user = new User(1,"hasan","yılmaz","hasan1234@gmail.com","123456");
        UserService service = new UserManager(new VerificationManager(),new xUserDao(),new RegisterNManager(),new EmailVerificationManager());
        UserService service1 = new UserManager(new VerificationManager(),new xUserDao(),new RegisterGoogleManager(),
                new EmailVerificationManager());
        service.register(user);
        System.out.println("\n");
        User user1 = new User(2,"hakan","yılmaz","hasan1234@gmail.com","12345");
        service.register(user1); //Aynı e-posta hatası
        System.out.println("\n");
        User user2 = new User(3,"ahmet","yılmaz","xyz@gmail.com","123456");
        service1.register(user2);
        System.out.println("\n");

        System.out.println("----------LOGIN---------");
        service.login("hasan1234@gmail.com","123456");
        System.out.println("\n");
        System.out.println("--------Hatalı giriş-------------");
        service.login("hasan1234@gmail.com","12345");



    }
}

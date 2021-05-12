package eCommerce.business.concretes;

import eCommerce.business.abstracts.EmailVerificationService;
import eCommerce.business.abstracts.UserService;
import eCommerce.business.abstracts.VerificationService;
import eCommerce.core.abstracts.RegisterService;
import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class UserManager implements UserService {

    private VerificationService verificationService;
    private UserDao userDao;
    private RegisterService registerService;
    private EmailVerificationService emailVerification;
    public User user;

    public UserManager(VerificationService verificationService, UserDao userDao, RegisterService registerService,
                       EmailVerificationService emailVerification) {
        super();
        this.verificationService = verificationService;
        this.userDao = userDao;
        this.registerService = registerService;
        this.emailVerification = emailVerification;
    }

    @Override
    public void register(User user) {
        if (verificationService.checkEmail(user.geteMail())
                && verificationService.checkFirstName(user.getFirstName())
                && verificationService.checkLastName(user.getLastName())
                && verificationService.checkPassword(user.getPassword())
                || verificationService.checkEmailOnDB(user.geteMail())){
            userDao.add(user);
            registerService.register(user);
            System.out.println("Email doğrulamanızı size gönderilen e-posta üzerinden yapabilirsiniz.");
            emailVerification.isClicked("Tıklandı");
            System.out.println("Email doğrulaması başarılı.");
            return;
        }
    }


    @Override
    public void login(String email, String password) {
        for (int i = 0; i < userDao.getAll().size(); i++) {
            if (userDao.getAll().get(i).geteMail().equals(email) && userDao.getAll().get(i).getPassword().equals(password)) {
                System.out.println("Başarıyla Giriş Yapıldı.");
                return;
            } else {
                System.out.println("Email veya şifre Hatalı tekrar dene.");
                return;
            }
        }
    }
}

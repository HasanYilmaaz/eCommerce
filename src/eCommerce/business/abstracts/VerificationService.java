package eCommerce.business.abstracts;

public interface VerificationService {
    boolean checkFirstName(String firstName);
    boolean checkLastName(String lastName);
    boolean checkEmail(String email);
    boolean checkPassword(String password);
    boolean checkEmailOnDB(String email);

}

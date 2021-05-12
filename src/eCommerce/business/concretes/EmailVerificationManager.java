package eCommerce.business.concretes;

import eCommerce.business.abstracts.EmailVerificationService;

public class EmailVerificationManager implements EmailVerificationService {
    @Override
    public boolean isClicked(String string) {
        return true;
    }
}

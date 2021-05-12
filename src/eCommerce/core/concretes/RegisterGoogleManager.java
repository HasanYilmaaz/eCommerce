package eCommerce.core.concretes;

import GoogleLogin.GoogleOAuthManager;
import eCommerce.core.abstracts.RegisterService;
import eCommerce.entities.concretes.User;

public class RegisterGoogleManager implements RegisterService {
    @Override
    public void register(User user) {
        GoogleOAuthManager googleOAuthManager = new GoogleOAuthManager();
        googleOAuthManager.register(user.getFirstName());
    }
}

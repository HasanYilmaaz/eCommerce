package eCommerce.core.concretes;

import eCommerce.core.abstracts.RegisterService;
import eCommerce.entities.concretes.User;

public class RegisterNManager implements RegisterService {
    @Override
    public void register(User user) {
        System.out.println("Sisteme in memory sistemi ile kayıt oldunuz");
    }
}

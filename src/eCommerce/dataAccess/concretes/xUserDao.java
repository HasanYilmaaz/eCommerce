package eCommerce.dataAccess.concretes;

import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class xUserDao implements UserDao {

    private List<User> users;

    public xUserDao(){
        this.users = new ArrayList<User>();
    }

    @Override
    public void add(User user) {
        this.users.add(user);
        System.out.println("User added to System: "+ user.getFirstName()+ " " +user.getLastName());
    }

    @Override
    public void update(User user) {

        System.out.println("User's info updated.");

    }

    @Override
    public void delete(User user) {
        System.out.println("User deleted"+ user.getFirstName());
    }

    @Override
    public List<User> getAll() {
        return this.users;
    }
}

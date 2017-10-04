package model;

import java.util.ArrayList;
import java.util.List;

public class UserAdmin extends User {
    protected List<Account> accounts = new ArrayList<>(); //счета


    public UserAdmin() {
    }

    public UserAdmin(String email,Role role, String password) {
        super(email, role, password);

    }
}

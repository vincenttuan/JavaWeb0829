package com.web.fastfood.login;

import com.web.fastfood.DB;

public class LoginDao {
    public boolean login(String username, String password) {
        return DB.users.entrySet().stream()
                .filter(u -> u.getKey().equals(username) && u.getValue().equals(password))
                .findAny()
                .isPresent();
    }
}

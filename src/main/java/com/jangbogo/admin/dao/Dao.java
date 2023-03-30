package com.jangbogo.admin.dao;

import com.jangbogo.admin.security.UserDetailsDto;

import java.util.ArrayList;

public interface Dao {

    public UserDetailsDto selectUser(String username);

    public ArrayList<String> getAuthList(String username);

    public void userSignUp(String username, String password, char enable);

    public void giveAuth(String username, String authority);
}

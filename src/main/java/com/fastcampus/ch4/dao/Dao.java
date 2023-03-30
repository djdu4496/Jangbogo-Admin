package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.security.UserDetailsDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

public interface Dao {

    public UserDetailsDto selectUser(String username);

    public ArrayList<String> getAuthList(String username);

    public void userSignUp(String username, String password, char enable);

    public void giveAuth(String username, String authority);
}

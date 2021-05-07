package com.padel.business.abstracts;

import com.padel.entities.concretes.User;

public interface UserService {
    public void register(User user);
    public void signIn(User user);
    public void signInWithGoogle(String email,String password);
}

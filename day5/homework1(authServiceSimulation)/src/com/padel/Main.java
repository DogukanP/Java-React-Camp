package com.padel;

import com.padel.business.concretes.InputControlManager;
import com.padel.business.concretes.UserManager;
import com.padel.core.concretes.GoogleAuthManagerAdapter;
import com.padel.dataAccess.concretes.abcUserDao;
import com.padel.entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        User user = new User("doğukan","padel","d.padel@outlook.com","134567");
        UserManager userManager = new UserManager(new InputControlManager(new abcUserDao()),new abcUserDao(),new GoogleAuthManagerAdapter());
        userManager.register(user);
        userManager.signInWithGoogle("d.padel@outlook.com","123456");
    }
}

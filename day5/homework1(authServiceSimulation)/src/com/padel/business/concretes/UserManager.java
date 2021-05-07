package com.padel.business.concretes;

import com.padel.business.abstracts.InputControlService;
import com.padel.business.abstracts.UserService;
import com.padel.core.abstracts.AuthService;
import com.padel.dataAccess.abstracts.UserDao;
import com.padel.entities.concretes.User;

public class UserManager implements UserService {
    InputControlService inputControlService;
    UserDao userDao;
    AuthService authService;
    public UserManager(InputControlService inputControlService, UserDao userDao , AuthService authService){
        this.inputControlService = inputControlService;
        this.userDao = userDao;
        this.authService = authService;
    }

    @Override
    public void register(User user) {
        if(inputControlService.inputControl(user)){
            userDao.add(user);
            System.out.println("Hesap oluşturuldu: " + user.getFirstName() + " " + user.getLastName());
        }else System.out.println("Kayıt işlemi başarısız.");
    }

    @Override
    public void signIn(User user) {
        if(userDao.loginControl(user.getEmail(),user.getPassword())){
            System.out.println("Giriş başarılı");
        }else System.out.println("Giriş başarısız.");
    }

    @Override
    public void signInWithGoogle(String email, String password) {
        authService.signInWithExternalService();
    }

}

package com.padel.business.concretes;

import com.padel.business.abstracts.InputControlService;
import com.padel.dataAccess.abstracts.UserDao;
import com.padel.entities.concretes.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputControlManager implements InputControlService {
    UserDao userDao;
    public InputControlManager(UserDao userDao){
        this.userDao = userDao;
    }


    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    @Override

    public boolean inputControl(User user) {
        if(validate(user.getEmail())){
            if(userDao.emailControl(user)){
                if (user.getFirstName().length() < 2 || user.getLastName().length() < 2){
                    System.out.println("İsim ve soyisim en az iki karakter içermelidir");
                    return false;
                }
                else if(user.getPassword().length() <6 ){
                    System.out.println("Parola en az altı karakterden oluşmalıdır");
                    return false;
                }
                return true;
            }else {
                System.out.println("Bu mail adresi ile daha önce kayıt olunmuş.");
                return false;
            }
        }
        System.out.println("Lütfen geçerli bir mail adresi girin.");
        return false;
    }
}

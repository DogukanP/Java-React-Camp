package com.padel.HRMS.business.concretes;

import com.padel.HRMS.business.abstracts.EmailVerificationService;
import com.padel.HRMS.business.abstracts.SystemWorkerService;
import com.padel.HRMS.business.abstracts.UserService;
import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.ErrorDataResult;
import com.padel.HRMS.core.utilities.results.SuccessDataResult;
import com.padel.HRMS.dataAccess.abstracts.SystemWorkerDao;
import com.padel.HRMS.entities.concretes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class SystemWorkerManager implements SystemWorkerService {
    @Autowired
    private SystemWorkerDao systemWorkerDao;
    private EmailVerificationService emailVerificationService;
    private UserService userService;


    public SystemWorkerManager(SystemWorkerDao systemWorkerDao,EmailVerificationService emailVerificationService,UserService userService) {
        super();
        this.systemWorkerDao = systemWorkerDao;
        this.emailVerificationService = emailVerificationService;
        this.userService = userService;
    }

    @Override
    public DataResult<List<SystemWorker>> getAll() {
        return new SuccessDataResult<List<SystemWorker>>(this.systemWorkerDao.findAll(),"Başarılı Şekilde İş Arayanlar Listelendi");
    }

    @Override
    public DataResult<SystemWorker> add(SystemWorker systemWorker) {
        if(!firstNameChecker(systemWorker)) {
            return new ErrorDataResult<SystemWorker>(null,"Ad Bilgisi Doldurulmak Zorundadır");
        }
        else if(!lastNameChecker(systemWorker)) {
            return new ErrorDataResult<SystemWorker>(null,"SoyAdı Bilgisi Doldurulmak Zorundadır");
        }

        else if(!emailNullChecker(systemWorker)) {
            return new ErrorDataResult<SystemWorker>(null,"Email Bilgisi Doldurulmak Zorundadır");
        }
        else if(!isRealEmail(systemWorker)) {
            return new ErrorDataResult<SystemWorker>(null,"Email Adresiniz Yanlış");
        }

        else if(!passwordNullChecker(systemWorker)) {
            return new ErrorDataResult<SystemWorker>(null,"Şifre Bilgisi Doldurulmak Zorundadır");
        }

        else if(systemWorkerDao.findAllByEmail(systemWorker.getEmailAddress()).stream().count() != 0 ) {
            return new ErrorDataResult<SystemWorker>(null,"Email Zaten Kayıtlı");
        }
        User savedUser = this.userService.add(systemWorker);
        this.emailVerificationService.generateCode(new EmailVerification(),savedUser.getId());
        return new SuccessDataResult<SystemWorker>(this.systemWorkerDao.save(systemWorker),"İş Arayan Hesabı Eklendi , Doğrulama Kodu Gönderildi:"+systemWorker.getId());
    }

    private boolean firstNameChecker(SystemWorker systemWorker) {
        if(systemWorker.getFirstName().isBlank() || systemWorker.getFirstName().equals(null)) {
            return false;
        }
        return true;
    }

    private boolean lastNameChecker(SystemWorker systemWorker) {
        if(systemWorker.getLastName().isBlank() || systemWorker.getLastName().equals(null)) {
            return false;
        }
        return true;
    }

    private boolean emailNullChecker(SystemWorker systemWorker) {
        if(systemWorker.getEmailAddress().isBlank() || systemWorker.getEmailAddress().equals(null)) {
            return false;
        }
        return true;
    }

    private boolean passwordNullChecker(SystemWorker systemWorker) {
        if(systemWorker.getPassword().isBlank() || systemWorker.getPassword().equals(null)) {
            return false;
        }
        return true;
    }

    private boolean isRealEmail(SystemWorker systemWorker) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(systemWorker.getEmailAddress());
        if(!matcher.matches()) {
            return false;
        }
        return true;

    }

}

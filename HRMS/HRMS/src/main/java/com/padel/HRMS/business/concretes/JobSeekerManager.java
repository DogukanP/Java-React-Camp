package com.padel.HRMS.business.concretes;


import com.padel.HRMS.business.abstracts.EmailVerificationService;
import com.padel.HRMS.business.abstracts.JobSeekerService;
import com.padel.HRMS.business.abstracts.UserService;
import com.padel.HRMS.core.utilities.IdentityValidation;
import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.ErrorDataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.core.utilities.results.SuccessDataResult;
import com.padel.HRMS.dataAccess.abstracts.JobSeekerDao;
import com.padel.HRMS.dataAccess.abstracts.UserDao;
import com.padel.HRMS.entities.concretes.EmailVerification;
import com.padel.HRMS.entities.concretes.JobSeeker;
import com.padel.HRMS.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class JobSeekerManager implements JobSeekerService {
    @Autowired
    private JobSeekerDao jobSeekerDao;
    private EmailVerificationService emailVerificationService;
    private UserService userService;


    public JobSeekerManager(JobSeekerDao jobSeekerDao,EmailVerificationService emailVerificationService,UserService userService) {
        super();
        this.jobSeekerDao = jobSeekerDao;
        this.emailVerificationService = emailVerificationService;
        this.userService = userService;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"Başarılı Şekilde İş Arayanlar Listelendi");
    }

    @Override
    public DataResult<JobSeeker> add(JobSeeker jobSeeker) {
        if(!firstNameChecker(jobSeeker)) {
            return new ErrorDataResult<JobSeeker>(null,"Ad Bilgisi Doldurulmak Zorundadır");
        }
        else if(!lastNameChecker(jobSeeker)) {
            return new ErrorDataResult<JobSeeker>(null,"SoyAdı Bilgisi Doldurulmak Zorundadır");
        }

        else if(!IdentityValidation.isRealPerson(jobSeeker.getIdentificationNumber())) {
            return new ErrorDataResult<JobSeeker>(null,"Kimlik Doğrulanamadı");
        }
        else if(jobSeeker.getIdentificationNumber().isBlank()) {
            return new ErrorDataResult<JobSeeker>(null,"Tc Kimlik Bilgisi Boş Bırakılamaz");
        }

        else if(!birthDateChecker(jobSeeker)) {
            return new ErrorDataResult<JobSeeker>(null,"Doğum Tarihi Bilgisi Doldurulmak Zorundadır");
        }

        else if(!emailNullChecker(jobSeeker)) {
            return new ErrorDataResult<JobSeeker>(null,"Email Bilgisi Doldurulmak Zorundadır");
        }
        else if(!isRealEmail(jobSeeker)) {
            return new ErrorDataResult<JobSeeker>(null,"Email Adresiniz Yanlış");
        }

        else if(!passwordNullChecker(jobSeeker)) {
            return new ErrorDataResult<JobSeeker>(null,"Şifre Bilgisi Doldurulmak Zorundadır");
        }

        else if(jobSeekerDao.findAllByEmail(jobSeeker.getEmailAddress()).stream().count() != 0 ) {
            return new ErrorDataResult<JobSeeker>(null,"Email Zaten Kayıtlı");
        }
        else if(jobSeekerDao.findAllByIdentificationNumber(jobSeeker.getIdentificationNumber()).stream().count() != 0 ) {
            return new ErrorDataResult<JobSeeker>(null,"TC Numarası Zaten Kayıtlı");
        }
        User savedUser = this.userService.add(jobSeeker);
        this.emailVerificationService.generateCode(new EmailVerification(),savedUser.getId());
        return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.save(jobSeeker),"İş Arayan Hesabı Eklendi , Doğrulama Kodu Gönderildi:"+jobSeeker.getId());
    }

    private boolean firstNameChecker(JobSeeker jobSeeker) {
        if(jobSeeker.getFirstName().isBlank() || jobSeeker.getFirstName().equals(null)) {
            return false;
        }
        return true;
    }

    private boolean lastNameChecker(JobSeeker jobSeeker) {
        if(jobSeeker.getLastName().isBlank() || jobSeeker.getLastName().equals(null)) {
            return false;
        }
        return true;
    }

    private boolean birthDateChecker(JobSeeker jobSeeker) {
        if(jobSeeker.getBirthDate().equals(null)) {
            return false;
        }
        return true;
    }

    private boolean emailNullChecker(JobSeeker jobSeeker) {
        if(jobSeeker.getEmailAddress().isBlank() || jobSeeker.getEmailAddress().equals(null)) {
            return false;
        }
        return true;
    }

    private boolean passwordNullChecker(JobSeeker jobSeeker) {
        if(jobSeeker.getPassword().isBlank() || jobSeeker.getPassword().equals(null)) {
            return false;
        }
        return true;
    }

    private boolean isRealEmail(JobSeeker jobSeeker) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(jobSeeker.getEmailAddress());
        if(!matcher.matches()) {
            return false;
        }
        return true;

    }
}

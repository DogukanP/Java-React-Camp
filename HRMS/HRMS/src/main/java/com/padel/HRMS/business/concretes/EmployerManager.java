package com.padel.HRMS.business.concretes;

import com.padel.HRMS.business.abstracts.EmailVerificationService;
import com.padel.HRMS.business.abstracts.EmployerService;
import com.padel.HRMS.business.abstracts.UserService;
import com.padel.HRMS.core.utilities.results.*;
import com.padel.HRMS.dataAccess.abstracts.EmployerDao;
import com.padel.HRMS.entities.concretes.EmailVerification;
import com.padel.HRMS.entities.concretes.Employer;
import com.padel.HRMS.entities.concretes.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private EmailVerificationService emailVerificationService;
    private UserService userService;

    public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService,
                           UserService userService) {
        super();
        this.employerDao = employerDao;
        this.emailVerificationService = emailVerificationService;
        this.userService = userService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Başarılı Şekilde Employer Listelendi");
    }

    @Override
    public DataResult<Employer> add(Employer employer) {
        if(!companyNameChecker(employer)) {
            return new ErrorDataResult<Employer>(null,"Şirket Adı Doldurulmak Zorundadır");
        }
        else if(!webSiteChecker(employer)) {
            return new ErrorDataResult<Employer>(null,"WebSite Adresi Doldurulmak Zorundadır");
        }
        else if(!isRealEmployer(employer)) {
            return new ErrorDataResult<Employer>(null,"Geçersiz Email Adresi");
        }
        else if(!passwordNullChecker(employer)) {
            return new ErrorDataResult<Employer>(null,"Şifre Bilgisi Doldurulmak Zorundadır");
        }
        else if(!isRealPhoneNumber(employer)) {
            return new ErrorDataResult<Employer>(null,"Telefon Numarası Geçersiz");
        }
        else if(!isEmailAlreadyRegistered(employer)) {
            return new ErrorDataResult<Employer>(null,"Email Zaten Kayıtlı");
        }
        User savedUser = this.userService.add(employer);
        this.emailVerificationService.generateCode(new EmailVerification(),savedUser.getId());
        return new SuccessDataResult<Employer>(this.employerDao.save(employer),"İş Veren Hesabı Eklendi, Doğrulama Kodu Gönderildi ID:"+employer.getId());
    }

    private boolean companyNameChecker(Employer employer) {
        if(employer.getCompanyName().isBlank() || employer.getCompanyName() == null) {
            return false;
        }
        return true;
    }

    private boolean webSiteChecker(Employer employer) {
        if(employer.getWebAddress().isBlank() || employer.getWebAddress() == null) {
            return false;
        }
        return true;
    }

    private boolean isRealEmployer(Employer employer) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employer.getEmailAddress());
        if(!matcher.matches()) {
            return false;
        }
        else if(!employer.getEmailAddress().contains(employer.getWebAddress())) {
            return false;
        }
        return true;

    }

    private boolean isEmailAlreadyRegistered(Employer employer) {
        if(employerDao.findAllByEmail(employer.getEmailAddress()).stream().count() != 0) {
            return false;
        }
        return true;
    }

    private boolean passwordNullChecker(Employer employer) {
        if(employer.getPassword().isBlank() || employer.getPassword() == null) {
            return false;
        }
        return true;
    }

    private boolean isRealPhoneNumber(Employer employer) {
        String patterns
                = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
		/*
		 * ÖRNEK TELEFON NUMARALARI
		 * String[] validPhoneNumbers
      = {"2055550125","202 555 0125", "(202) 555-0125", "+111 (202) 555-0125",
      "636 856 789", "+111 636 856 789", "636 85 67 89", "+111 636 85 67 89"};
		 */
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(employer.getPhoneNumber());
        if(!matcher.matches()) {
            return false;
        }
        return true;

    }
}


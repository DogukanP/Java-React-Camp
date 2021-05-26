package com.padel.HRMS.business.concretes;

import com.padel.HRMS.business.abstracts.EmailVerificationService;
import com.padel.HRMS.core.utilities.GenerateRandomCode;
import com.padel.HRMS.core.utilities.results.ErrorDataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.core.utilities.results.SuccessDataResult;
import com.padel.HRMS.dataAccess.abstracts.EmailVerificationDao;
import com.padel.HRMS.entities.concretes.EmailVerification;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailVerificationManager implements EmailVerificationService {
    private EmailVerificationDao emailVerificationDao;

    @Autowired
    public EmailVerificationManager(EmailVerificationDao emailVerificationDao) {
        super();
        this.emailVerificationDao = emailVerificationDao;
    }

    @Override
    public void generateCode(EmailVerification code, Integer id) {
        EmailVerification code_ = code;
        code.setCode(null);
        code.setVerified(false);
        if(code.isVerified() == false) {
            GenerateRandomCode generator = new GenerateRandomCode();
            String code_create = generator.create();
            code.setCode(code_create);
            code.setUserId(id);

            emailVerificationDao.save(code);

        }
        return ;
    }

    @Override
    public Result verify(String verificationCode, Integer id) {
        EmailVerification ref = emailVerificationDao.findByUserId(id).stream().findFirst().get();
        if(ref.getCode().equals(verificationCode) && ref.isVerified() != true) {
            ref.setVerified(true);
            return  new SuccessDataResult<EmailVerification>(this.emailVerificationDao.save(ref),"Başarılı");
        }
        else if(ref.isVerified() == true) {
            return  new ErrorDataResult<EmailVerification>(null,"Zaten Doğrulanmış Hesap");
        }
        return  new ErrorDataResult<EmailVerification>(null,"Doğrulama Kodu Geçersiz");
    }
}

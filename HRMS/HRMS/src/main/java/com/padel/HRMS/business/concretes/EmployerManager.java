package com.padel.HRMS.business.concretes;

import com.padel.HRMS.business.abstracts.EmployerService;
import com.padel.HRMS.dataAccess.abstracts.UserDao;
import com.padel.HRMS.core.utilities.results.*;
import com.padel.HRMS.dataAccess.abstracts.EmployerDao;
import com.padel.HRMS.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    final private EmployerDao employerDao;
    final private UserDao userDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserDao userDao) {
        super();
        this.employerDao = employerDao;
        this.userDao = userDao;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result add(Employer employer) {
        String domain = employer.getWebAddress().split("www.")[1];
        System.out.println(domain);
        if(this.userDao.getByEmail(employer.getEmail()).stream().count() == 0 && domain.equals((employer.getEmail().split("@")[1]))){
            this.employerDao.save(employer);
            return new SuccessResult("Data eklendi");
        }else return new ErrorResult("Data eklenemedi (email şirket web sitesi ile aynı domaine sahip olmalıdır - email zaten kullanılıyor. )");
    }
}


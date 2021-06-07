package com.padel.HRMS.business.concretes;

import com.padel.HRMS.business.abstracts.LanguageService;
import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.core.utilities.results.SuccessDataResult;
import com.padel.HRMS.core.utilities.results.SuccessResult;
import com.padel.HRMS.dataAccess.abstracts.LanguageDao;
import com.padel.HRMS.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    final private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public Result add(Language language) {
        this.languageDao.save(language);
        return new SuccessResult("Data eklendi");
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>( this.languageDao.findAll(),"Data listelendi");
    }

}

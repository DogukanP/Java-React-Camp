package com.padel.HRMS.business.abstracts;

import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    Result add(Language language);
    DataResult<List<Language>> getAll();
}

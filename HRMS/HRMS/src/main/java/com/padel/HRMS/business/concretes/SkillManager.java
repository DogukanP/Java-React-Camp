package com.padel.HRMS.business.concretes;

import com.padel.HRMS.business.abstracts.SkillService;
import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.core.utilities.results.SuccessDataResult;
import com.padel.HRMS.core.utilities.results.SuccessResult;
import com.padel.HRMS.dataAccess.abstracts.SkillDao;
import com.padel.HRMS.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SkillManager implements SkillService {
    final private SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao) {
        super();
        this.skillDao = skillDao;
    }

    @Override
    public Result add(Skill skill) {
        this.skillDao.save(skill);
        return new SuccessResult("Data eklendi");
    }

    @Override
    public DataResult<List<Skill>> getAll() {
        return new SuccessDataResult<List<Skill>>(this.skillDao.findAll(),"Data listelendi");
    }
}

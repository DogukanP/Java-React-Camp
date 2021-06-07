package com.padel.HRMS.business.abstracts;

import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.entities.concretes.Skill;

import java.util.List;

public interface SkillService {
    Result add(Skill skill);
    DataResult<List<Skill>> getAll();
}

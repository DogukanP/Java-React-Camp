package com.padel.HRMS.business.abstracts;

import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.entities.concretes.Resume;

import java.util.List;

public interface ResumeService {
    DataResult<List<Resume>> getAll();
    DataResult<List<Resume>> getByJobSeekerId(int id);
    Result add(Resume resume);
    DataResult<String> uploadPhoto(int id, String imageUrl);
}

package service;

import domain.models.binding.JobAddBinding;
import domain.models.service.JobServiceModel;

import java.util.List;

public interface JobService {

    void saveJob(JobAddBinding job);
    JobServiceModel findJob(String id);
    List<JobServiceModel> allJobs();
    void deleteJob(String id);
}

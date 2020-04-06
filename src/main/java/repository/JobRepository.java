package repository;

import domain.entity.JobApplication;

import java.util.List;

public interface JobRepository {

    void saveJob(JobApplication job);
    JobApplication findJob(String id);
    List<JobApplication> allJobs();
    void deleteJob(String id);
}

package service;

import domain.entity.JobApplication;
import domain.models.binding.JobAddBinding;
import domain.models.service.JobServiceModel;
import org.modelmapper.ModelMapper;
import repository.JobRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    @Inject
    public JobServiceImpl(JobRepository jobRepository, ModelMapper modelMapper) {
        this.jobRepository = jobRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveJob(JobAddBinding job) {
        jobRepository.saveJob(modelMapper.map(job, JobApplication.class));
    }

    @Override
    public JobServiceModel findJob(String id) {
        return modelMapper.map(jobRepository.findJob(id), JobServiceModel.class);
    }

    @Override
    public List<JobServiceModel> allJobs() {
        return jobRepository.allJobs().stream()
                .map(j->modelMapper.map(j, JobServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteJob(String id) {
        jobRepository.deleteJob(id);
    }
}

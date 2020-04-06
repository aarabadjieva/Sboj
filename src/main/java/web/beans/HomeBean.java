package web.beans;

import domain.view.JobView;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import service.JobService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Named
@RequestScoped
public class HomeBean extends BaseBean{

    private List<JobView> jobs;
    private JobService jobService;
    private ModelMapper modelMapper;

    @Inject
    public HomeBean(JobService jobService, ModelMapper modelMapper) {
        this.jobService = jobService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init() {
        jobs = jobService.allJobs().stream()
                .map(j -> modelMapper.map(j, JobView.class))
                .collect(Collectors.toList());
        getJobs().forEach(j->j.setSector(j.getSector().toLowerCase()));
    }

    public List<JobView> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobView> jobs) {
        this.jobs = jobs;
    }

}

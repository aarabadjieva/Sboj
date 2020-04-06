package web.beans.jobBeans;

import domain.models.binding.JobAddBinding;
import lombok.NoArgsConstructor;
import service.JobService;
import web.beans.BaseBean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@NoArgsConstructor
@Named
@RequestScoped
public class AddJobBean extends BaseBean {

    private JobService jobService;
    private JobAddBinding job;

    @Inject
    public AddJobBean(JobService jobService) {
        this.jobService = jobService;
    }

    @PostConstruct
    private void init(){
        job = new JobAddBinding();
    }

    public JobAddBinding getJob() {
        return job;
    }

    public void setJob(JobAddBinding job) {
        this.job = job;
    }

    public void addJob() throws IOException {
        try {
            jobService.saveJob(job);
            redirect("/home");
        }catch (Exception e){
            redirect("/add-job");
        }
    }
}

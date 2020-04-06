package web.beans.jobBeans;

import domain.view.JobView;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import service.JobService;
import web.beans.BaseBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@NoArgsConstructor
@Named
@RequestScoped
public class JobDetailsBean extends BaseBean {

    private JobService jobService;
    private ModelMapper modelMapper;

    @Inject
    public JobDetailsBean(JobService jobService, ModelMapper modelMapper) {
        this.jobService = jobService;
        this.modelMapper = modelMapper;
    }


    public JobView getJobById(String id) {
        return modelMapper.map(jobService.findJob(id), JobView.class);
    }

    public void deleteJob(String id) throws IOException {
        jobService.deleteJob(id);
        redirect("/home");
    }

}

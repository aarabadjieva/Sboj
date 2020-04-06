package repository;

import domain.entity.JobApplication;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class JobRepositoryImpl implements JobRepository {

    private final EntityManager entityManager;

    @Inject
    public JobRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveJob(JobApplication job) {
        entityManager.getTransaction().begin();
        entityManager.persist(job);
        entityManager.getTransaction().commit();
    }

    @Override
    public JobApplication findJob(String id) {
        List<JobApplication> jobs =  entityManager.createQuery("select j from JobApplication j where " +
                "j.id = :id", JobApplication.class).setParameter("id", id).getResultList();
        if (jobs.isEmpty()){
            return null;
        }
        return jobs.get(0);
    }

    @Override
    public List<JobApplication> allJobs() {
        return entityManager.createQuery("select j from JobApplication j", JobApplication.class).getResultList();
    }

    @Override
    public void deleteJob(String id) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from JobApplication j where j.id=:id")
                .setParameter("id", id).executeUpdate();
        entityManager.getTransaction().commit();
    }
}

package com.connect.JobAppRESTJPA.service;

import com.connect.JobAppRESTJPA.model.JobPost;
import com.connect.JobAppRESTJPA.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost){
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(List.of(
                new JobPost(1, "Java Developer", "Must have a good experience in core java", 2, List.of("Java", "Spring", "Hibernate")),
                new JobPost(2, "Python Developer", "Must have a good experience in core python", 1, List.of("Python", "Django", "Flask")),
                new JobPost(3, "React Developer", "Must have a good experience in core react", 3, List.of("React", "Redux", "Javascript")),
                new JobPost(4, "Angular Developer", "Must have a good experience in core angular", 1, List.of("Angular", "Redux", "TypeScript")),
                new JobPost(5, "Dotnet Developer", "Must have a good experience in core c# and Asp Dotnet", 2, List.of("Asp DotNet", "C#", "DotNet Core"))
        ));
        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }

}

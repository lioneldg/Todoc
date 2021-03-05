package com.cleanup.todoc.repositories;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.database.ProjectDao;
import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import java.util.List;

public class ProjectDataRepository {
    private final ProjectDao projectDao;

    public ProjectDataRepository(ProjectDao projectDao){
        this.projectDao = projectDao;
    }

    // CREATE
    public void createProject(Project project){
        projectDao.addProjects(project);
    }

    // READ
    public LiveData<List<Project>> getAllProjects(){
        return this.projectDao.getAllProjects();
    }

    public LiveData<Project> getProject(long projectId){
        return this.projectDao.getProjectById(projectId);
    }
}

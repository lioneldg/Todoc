package com.cleanup.todoc.repositories;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.database.ProjectDao;
import com.cleanup.todoc.model.Project;
import java.util.List;

public class ProjectDataRepository {
    private final ProjectDao projectDao;

    public ProjectDataRepository(ProjectDao projectDao){
        this.projectDao = projectDao;
    }

    // READ
    public LiveData<List<Project>> getAllProjects(){
        return this.projectDao.getAllProjects();
    }

}

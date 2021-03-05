package com.cleanup.todoc.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.cleanup.todoc.model.Project;
import java.util.List;

@Dao
public interface ProjectDao {

    // CREATE
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addProjects(Project... projects);

    // READ
    @Query("SELECT * FROM project")
    LiveData<List<Project>> getAllProjects();

    @Query("SELECT * FROM project WHERE id = :projectId")
    LiveData<Project> getProjectById(long projectId);
}
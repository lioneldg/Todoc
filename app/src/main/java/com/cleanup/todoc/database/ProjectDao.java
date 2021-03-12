package com.cleanup.todoc.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import com.cleanup.todoc.model.Project;
import java.util.List;

@Dao
public interface ProjectDao {

    // READ
    @Query("SELECT * FROM project")
    LiveData<List<Project>> getAllProjects();

}

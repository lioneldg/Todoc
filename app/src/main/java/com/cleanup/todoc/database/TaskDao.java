package com.cleanup.todoc.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.cleanup.todoc.model.Task;

import java.util.List;

@Dao
public interface TaskDao {

    // CREATE
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addTasks(Task... tasks);

    // READ
    @Query("SELECT * FROM task WHERE projectId IN (:projectId)")
    LiveData<List<Task>> tasksByProjectId(long projectId);

    @Query("SELECT * FROM task")
    LiveData<List<Task>> getAllTasks();

    // UPDATE
    @Update
    public void updateTasks(Task... tasks);

    // DELETE
    @Delete
    public void deleteTasks(Task... tasks);
}

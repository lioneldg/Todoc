package com.cleanup.todoc.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.cleanup.todoc.model.Task;

import java.util.List;

@Dao
public interface TaskDao {

    // CREATE
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addTask(Task task);

    @Query("SELECT * FROM task")
    LiveData<List<Task>> getAllTasks();

    // DELETE
    @Query("DELETE FROM task WHERE task.id=:id")
    void deleteTask(long id);

    @Query("DELETE FROM task")
    void deleteAll();
}

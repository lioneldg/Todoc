package com.cleanup.todoc.room;

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
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addTasks(Task... tasks);

    @Query("SELECT * FROM task WHERE projectId IN (:projectId)")
    List<Task> tasksByProjectId(long projectId);

    @Update
    public void updateTasks(Task... tasks);

    @Delete
    public void deleteTasks(Task... tasks);
}

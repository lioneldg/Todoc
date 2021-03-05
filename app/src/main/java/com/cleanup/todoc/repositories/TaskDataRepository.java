package com.cleanup.todoc.repositories;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.database.TaskDao;
import com.cleanup.todoc.model.Task;

import java.util.List;

public class TaskDataRepository {
    private final TaskDao taskDao;

    public TaskDataRepository(TaskDao taskDao){
        this.taskDao = taskDao;
    }

    // CREATE
    public void createTask(Task task){
        taskDao.addTasks(task);
    }

    // READ
    public LiveData<List<Task>> getTasks(long projectId){
        return this.taskDao.tasksByProjectId(projectId);
    }

    // UPDATE
    public void updateTask(Task task){
        taskDao.updateTasks(task);
    }

    // DELETE
    public void deleteTask(Task task){
        taskDao.deleteTasks(task);
    }


}

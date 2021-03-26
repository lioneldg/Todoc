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
        taskDao.addTask(task);
    }

    // READ
    public LiveData<List<Task>> getAllTasks(){
        return this.taskDao.getAllTasks();
    }

    // DELETE
    public void deleteTask(Task task){
        taskDao.deleteTask(task.getId());
    }


}

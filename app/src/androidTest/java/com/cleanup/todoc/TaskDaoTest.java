package com.cleanup.todoc;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.cleanup.todoc.database.AppDatabase;
import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class TaskDaoTest {
    // FOR DATA
    private AppDatabase database;
    private LiveData<List<Project>> allProjects;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void initDb() throws Exception {
        this.database = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppDatabase.class).addCallback(AppDatabase.prepopulateDatabase()).build();
    }

    @After
    public void closeDb() throws Exception {
        this.database.taskDao().deleteAll();
        database.close();
    }

    // DATA SET FOR TEST
    private static long PROJECT_ID = 1;
    private static Task TASK_DEMO = new Task(PROJECT_ID,"Task1",  new Date().getTime());

    @Test
    public void addTask() throws InterruptedException {
        // BEFORE : Adding a new task
        this.database.taskDao().addTask(TASK_DEMO);
        // TEST
        Task task = LiveDataTestUtils.getValue(this.database.taskDao().getAllTasks()).get(0);
        assertTrue(task.getName().equals(TASK_DEMO.getName()) && task.getProjectId() == PROJECT_ID);
    }

    @Test
    public void deleteTask() throws InterruptedException {
        // BEFORE : Adding a new task
        long id = this.database.taskDao().addTask(TASK_DEMO);
        // TEST
        this.database.taskDao().deleteTask(id);
        assertTrue(LiveDataTestUtils.getValue(this.database.taskDao().getAllTasks()).size() == 0);
    }

}

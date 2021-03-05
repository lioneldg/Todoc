package com.cleanup.todoc;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

import com.cleanup.todoc.database.AppDatabase;
import com.cleanup.todoc.database.TaskDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

//@RunWith(AndroidJUnit4.class)
public class TaskDaoTest {
   /* private TaskDao taskDao;
    private Database db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        userDao = db.getUserDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        User user = TestUtil.createUser(3);
        user.setName("george");
        userDao.insert(user);
        List<User> byName = userDao.findUsersByName("george");
        assertThat(byName.get(0), equalTo(user));
    }*/
}

package com.cleanup.todoc.database;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.OnConflictStrategy;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

@Database(entities = {Task.class, Project.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    // SINGLETON
    private static volatile AppDatabase INSTANCE;

    // DAO
    public abstract TaskDao taskDao();
    public abstract ProjectDao projectDao();

    // INSTANCE
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "MyDatabase.db").addCallback(prepopulateDatabase()).build();
                }
            }
        }
        return INSTANCE;
    }

    //is public to use it in TaskDaoTest
    public static Callback prepopulateDatabase(){
        return new Callback() {

            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

                ContentValues cv1 = new ContentValues();
                cv1.put("id", 1L);
                cv1.put("name", "Projet Tartampion");
                cv1.put("color", 0xFFEADAD1);

                ContentValues cv2 = new ContentValues();
                cv2.put("id", 2L);
                cv2.put("name", "Projet Lucidia");
                cv2.put("color", 0xFFB4CDBA);

                ContentValues cv3 = new ContentValues();
                cv3.put("id", 3L);
                cv3.put("name", "Projet Circus");
                cv3.put("color", 0xFFA3CED2);

                db.insert("Project", OnConflictStrategy.REPLACE, cv1);
                db.insert("Project", OnConflictStrategy.REPLACE, cv2);
                db.insert("Project", OnConflictStrategy.REPLACE, cv3);
            }
        };
    }
}

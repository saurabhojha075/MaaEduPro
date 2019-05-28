package com.example.maaedupro.controllers.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

import com.example.maaedupro.R;
import com.example.maaedupro.controllers.database.converter.ListTypeConverter;
import com.example.maaedupro.controllers.database.dao.UserDao;
import com.example.maaedupro.controllers.database.entities.User;




@Database(entities = {User.class},
        version = 1,exportSchema = false)
@TypeConverters({ListTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    //Migration
    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {

        }
    };


    //DB Instance
    private static AppDatabase dbInstance;

    public static AppDatabase getInstance(Context context) {
        if (dbInstance == null) {
            dbInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,
                    context.getString(R.string.db_name))
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()//.addMigrations(MIGRATION_1_2)
                    .build();
        }
        return dbInstance;
    }

    public static void destroyInstance() {
        if (dbInstance != null && dbInstance.isOpen()) dbInstance.close();
        dbInstance = null;
    }


    //Dao
    public abstract UserDao getUserDao();



}
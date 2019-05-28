package com.example.maaedupro.controllers.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.maaedupro.controllers.database.entities.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveUser(User... users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveUsersList(List<User> users);

    @Update
    void updateUser(User... users);


    @Query("UPDATE user SET userDetailName = :name, DOB =:dob, gender =:gender,userDetailEmail =:email WHERE userDetailId =:id")
    void updateUser(String name, String dob, String gender, String email, String id);


    @Query("SELECT * FROM user ")
    LiveData<User> getUserDetails();

    @Query("SELECT * FROM user WHERE userDetailId = :userId")
    User getNormalUserDetails(String userId);


    @Delete
    void deleteUser(User... users);

    @Query("DELETE FROM user")
    void deleteUser();
}
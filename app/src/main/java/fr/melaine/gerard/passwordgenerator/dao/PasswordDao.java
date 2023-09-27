package fr.melaine.gerard.passwordgenerator.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.melaine.gerard.passwordgenerator.entity.Password;

@Dao
public interface PasswordDao {
    @Query("SELECT * FROM password")
    List<Password> getAll();

    @Query("SELECT * FROM password WHERE uid IN (:passwordIds)")
    List<Password> loadAllByIds(int[] passwordIds);


    @Insert
    void insertAll(Password... passwords);

    @Delete
    void delete(Password password);
}

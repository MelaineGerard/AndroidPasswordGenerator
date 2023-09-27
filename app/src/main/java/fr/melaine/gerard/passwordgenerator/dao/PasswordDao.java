package fr.melaine.gerard.passwordgenerator.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.melaine.gerard.passwordgenerator.entity.Password;

@Dao
public interface PasswordDao {
    @Query("SELECT * FROM password")
    List<Password> getAll();

    @Query("SELECT * FROM password where password=:password")
    Password getByPassword(String password);

    @Insert
    void insertAll(Password... passwords);
}

package fr.melaine.gerard.passwordgenerator.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import fr.melaine.gerard.passwordgenerator.dao.PasswordDao;
import fr.melaine.gerard.passwordgenerator.entity.Password;

@Database(entities = {Password.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PasswordDao passwordDao();
}
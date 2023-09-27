package fr.melaine.gerard.passwordgenerator.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Password {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "password")
    public String password;

    public Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getUid() {
        return uid;
    }
}

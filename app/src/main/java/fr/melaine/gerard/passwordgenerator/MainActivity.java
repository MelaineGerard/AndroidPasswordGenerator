package fr.melaine.gerard.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.slider.Slider;

import fr.melaine.gerard.passwordgenerator.activity.PasswordListActivity;
import fr.melaine.gerard.passwordgenerator.dao.PasswordDao;
import fr.melaine.gerard.passwordgenerator.database.AppDatabase;
import fr.melaine.gerard.passwordgenerator.entity.Password;
import fr.melaine.gerard.passwordgenerator.generator.PasswordGenerator;

public class MainActivity extends AppCompatActivity {
    private static PasswordDao passwordDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "password_database").build();
        passwordDao = db.passwordDao();

        TextView label = findViewById(R.id.password_label);
        Button button = findViewById(R.id.password_generate);

        Button copyButton = findViewById(R.id.password_copy);
        Button saveButton = findViewById(R.id.password_save);
        Button showButton = findViewById(R.id.password_list);

        Slider complexitySlider = findViewById(R.id.slider_complexity);

        button.setOnClickListener(view -> label.setText(PasswordGenerator.generatePassword(24, (int) complexitySlider.getValue())));

        copyButton.setOnClickListener(view -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText(label.getText(), label.getText());
            clipboard.setPrimaryClip(clip);

            Toast.makeText(getApplicationContext(), "Mot de passe copié dans le presse papier", Toast.LENGTH_LONG).show();
        });

        saveButton.setOnClickListener(view -> AsyncTask.execute(() -> {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            Password password = passwordDao.getByPassword(label.getText().toString());

            if (password != null) {
                Toast.makeText(getApplicationContext(), "Mot de passe déjà sauvegardé !", Toast.LENGTH_LONG).show();
                return;
            }

            passwordDao.insertAll(new Password(label.getText().toString()));
            Toast.makeText(getApplicationContext(), "Mot de passe sauvegardé", Toast.LENGTH_LONG).show();
        }));

        showButton.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), PasswordListActivity.class)));
    }

    public static PasswordDao getPasswordDao() {
        return passwordDao;
    }
}
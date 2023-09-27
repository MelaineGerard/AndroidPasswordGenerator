package fr.melaine.gerard.passwordgenerator.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.melaine.gerard.passwordgenerator.MainActivity;
import fr.melaine.gerard.passwordgenerator.adapter.PasswordAdapter;
import fr.melaine.gerard.passwordgenerator.dao.PasswordDao;
import fr.melaine.gerard.passwordgenerator.databinding.ActivityPasswordListBinding;

import fr.melaine.gerard.passwordgenerator.R;
import fr.melaine.gerard.passwordgenerator.entity.Password;

public class PasswordListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_list);
        PasswordDao passwordDao = MainActivity.getPasswordDao();
        RecyclerView passwordRecyclerView = findViewById(R.id.password_list_recycler);
        passwordRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(passwordRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
        passwordRecyclerView.addItemDecoration(dividerItemDecoration);
        AsyncTask.execute(() -> {
            List<Password> passwords = passwordDao.getAll();
            passwordRecyclerView.setAdapter(new PasswordAdapter(passwords));
        });

    }
}
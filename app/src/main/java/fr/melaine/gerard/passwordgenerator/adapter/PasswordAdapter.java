package fr.melaine.gerard.passwordgenerator.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.melaine.gerard.passwordgenerator.R;
import fr.melaine.gerard.passwordgenerator.entity.Password;

public class PasswordAdapter extends RecyclerView.Adapter<PasswordAdapter.ViewHolder> {
    private final List<Password> passwords;

    public PasswordAdapter(List<Password> passwords) {
        this.passwords = passwords;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.password_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Password password = passwords.get(position);
        holder.getPasswordText().setText(String.format("%d. %s", password.getUid(), password.getPassword()));
    }

    @Override
    public int getItemCount() {
        return passwords.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView passwordText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            passwordText = itemView.findViewById(R.id.password_text);
        }

        public TextView getPasswordText() {
            return passwordText;
        }
    }
}

package com.example.contactlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private String[] contacts = new String[10];

    public ContactAdapter() {
        contacts[0] = "Saeed Hanafi";
        contacts[1] = "Ali Ahmadi";
        contacts[2] = "Roz Hanafi";
        contacts[3] = "Ali Asghari";
        contacts[4] = "Modammad Hanafi";
        contacts[5] = "Jamshid Musavi";
        contacts[6] = "Matin Mohammadi";
        contacts[7] = "Saman Ahmadi";
        contacts[8] = "Ali Samani";
        contacts[9] = "Saeed Alizadeh";
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.BindContact(contacts[position]);
    }

    @Override
    public int getItemCount() {
        return contacts.length;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView fullName;
        private TextView first_char;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.item_text);
            first_char = itemView.findViewById(R.id.item_circle);
        }

        public void BindContact(String fullName) {
            this.fullName.setText(fullName);
            first_char.setText(fullName.substring(0, 1));
        }
    }
}

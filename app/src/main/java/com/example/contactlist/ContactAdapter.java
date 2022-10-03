package com.example.contactlist;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private static final String TAG = "ContactAdapter";
    private ArrayList<String> contacts = new ArrayList<>();

    public ContactAdapter() {
        contacts.add("Saeed Hanafi");
        contacts.add("Ali Ahmadi");
        contacts.add("Roz Hanafi");
        contacts.add("Ali Asghari");
        contacts.add("Modammad Hanafi");
        contacts.add("Jamshid Musavi");
        contacts.add("Matin Mohammadi");
        contacts.add("Saman Ahmadi");
        contacts.add("Ali Samani");
        contacts.add("Saeed Alizadeh");
    }

    public void insertContact(String fullName) {
        contacts.add(0, fullName);
        notifyItemInserted(0);
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        Log.i(TAG, "onCreateViewHolder: ");
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: position => " + position);
        holder.BindContact(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), fullName, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

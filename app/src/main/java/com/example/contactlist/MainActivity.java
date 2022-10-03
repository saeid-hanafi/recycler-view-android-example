package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private ContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new ContactAdapter();
        recyclerView.setAdapter(adapter);

        EditText fullNameInsertText = findViewById(R.id.fullname_insert_text);
        ImageView insertBtn = findViewById(R.id.insert_btn);
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fullNameInsertText.length() > 0) {
                     adapter.insertContact(fullNameInsertText.getText().toString());
                     fullNameInsertText.setText("");
                     recyclerView.scrollToPosition(0);
                }else{
                    Toast.makeText(v.getContext(), "Input Field Is Empty!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
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

public class MainActivity extends AppCompatActivity implements ContactAdapter.OnChangeItem {
    private ContactAdapter adapter;
    private EditText fullNameInsertText;
    private ImageView insertBtn;
    private int currentPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new ContactAdapter(this);
        recyclerView.setAdapter(adapter);

        fullNameInsertText = findViewById(R.id.fullname_insert_text);
        insertBtn = findViewById(R.id.insert_btn);
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fullNameInsertText.length() > 0) {
                    if (currentPosition > -1) {
                        adapter.editContact(fullNameInsertText.getText().toString(), currentPosition);
                        recyclerView.scrollToPosition(currentPosition);
                    }else{
                        adapter.insertContact(fullNameInsertText.getText().toString());
                        recyclerView.scrollToPosition(0);
                    }
                    currentPosition = -1;
                    insertBtn.setImageResource(R.drawable.ic_baseline_add_24);
                    fullNameInsertText.setText("");
                }else{
                    Toast.makeText(v.getContext(), "Input Field Is Empty!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClickItem(String fullName, int position) {
        fullNameInsertText.setText(fullName);
        insertBtn.setImageResource(R.drawable.ic_baseline_done_24);
        currentPosition = position;
    }
}
package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        Picasso.get().load("https://www.yasertebat.com/public/images/banners/assemble-3.jpg")
                .placeholder(R.drawable.wallpaper)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
    }
}
package com.antoniomaina.moneycalculator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

// Todo: Back button on nav bar.
// Todo: Add menu

public class About extends AppCompatActivity {

    TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        initialize();
    }

    private void initialize() {
        tv_name = findViewById(R.id.about_tv_name);
        tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "http://www.antoniomaina.com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intent);
            }
        });
    }
}

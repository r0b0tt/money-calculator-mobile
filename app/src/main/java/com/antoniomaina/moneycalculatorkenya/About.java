package com.antoniomaina.moneycalculatorkenya;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class About extends AppCompatActivity {

    TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        initialize();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_report:
                String issuesLink = "https://github.com/r0b0tt/money-calculator-mobile/issues";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(issuesLink));
                startActivity(intent);
                return true;
            case R.id.menu_about:
                startActivity(new Intent(About.this, About.class));
                return true;
            case R.id.menu_feedbackRating:
                Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
                }
                return true;
            case R.id.menu_github:
                String githubLink = "https://github.com/r0b0tt/money-calculator-mobile";
                Intent gitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubLink));
                startActivity(gitIntent);

            default:
                return super.onOptionsItemSelected(item);
        }
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

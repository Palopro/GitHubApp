package com.vladh.githubapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vladh.githubapp.R;


public class DetailActivity extends AppCompatActivity {

    TextView username;
    TextView link;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = findViewById(R.id.user_image_header);
        username = findViewById(R.id.username);
        link = findViewById(R.id.link);

        String user = getIntent().getExtras().getString("login");
        String avatar = getIntent().getExtras().getString("avatar_url");
        String html = getIntent().getExtras().getString("html_url");

        username.setText(user);
        link.setText(html);
        Linkify.addLinks(link, Linkify.WEB_URLS);



        Glide.with(this)
                .load(avatar)
                .into(imageView);
        getSupportActionBar().setTitle("Details Activity");
    }

    private Intent createShareForeCastIntent() {
        String user = getIntent().getExtras().getString("login");
        String link = getIntent().getExtras().getString("html_url");
        return ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Check out this @" + user + ", " + link)
                .getIntent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        menuItem.setIntent(createShareForeCastIntent());
        return true;
    }
}

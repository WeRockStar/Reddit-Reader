package com.werockstar.redditreader.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.werockstar.redditreader.R;
import com.werockstar.redditreader.view.fragment.ReaderFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReaderFragment fragment = new ReaderFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentContainer, fragment)
                .commit();

    }
}

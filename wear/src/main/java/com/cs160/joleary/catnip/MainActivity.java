package com.cs160.joleary.catnip;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.wearable.view.GridViewPager;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    private TextView mTextView;
    private Button mFeedBtn;
    private Button past;
    private String zipcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("RUNNING ONCREATE", "yes");
//        mFeedBtn = (Button) findViewById(R.id.feed_btn);
        past = (Button) findViewById(R.id.pastElection);

        past.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(getBaseContext(), Presidential.class);
                sendIntent.putExtra("zipcode", zipcode);
                startService(sendIntent);
            }
        });
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
            zipcode = extras.getString("zipcode");
        }

        Log.e("zipcod before adapter: ", "null" + zipcode);
            final GridViewPager pager = (GridViewPager) findViewById(R.id.pager);
            pager.setAdapter(new GridViewFragmentActivity(this, getFragmentManager(), zipcode));
//        mFeedBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sendIntent = new Intent(getBaseContext(), WatchToPhoneService.class);
//                startService(sendIntent);
//            }
//        });
    }
}

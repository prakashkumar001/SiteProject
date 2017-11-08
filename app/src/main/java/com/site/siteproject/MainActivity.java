package com.site.siteproject;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ImageView left,right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        left=(ImageView) findViewById(R.id.left);
        right=(ImageView) findViewById(R.id.right);

        viewPager.setAdapter(new HomePageradapter(this));


        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(viewPager.getCurrentItem()==0)
                {

                }else
                {
                    viewPager.setCurrentItem(viewPager.getCurrentItem()-1);

                }

            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

            }
        });

    }
}

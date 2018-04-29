package com.example.android.tastifydemo;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class PagerAcitvity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_acitvity);

        ViewPager viewPager = findViewById(R.id.viewpager);
        CustomAdapter customAdapter = new CustomAdapter(PagerAcitvity.this,getSupportFragmentManager());
        viewPager.setAdapter(customAdapter);
        final TabLayout tabLayout = findViewById(R.id.tabLayout);

        final int images[] = {R.drawable.yellow_pickup,R.drawable.yellow_delivery,R.drawable.yellow_reached};


        View custom_layout = LayoutInflater.from(this).inflate(R.layout.custom_tab,null);

        tabLayout.setupWithViewPager(viewPager);

        for(int i =0 ; i<tabLayout.getTabCount();i++)
        {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(customAdapter.getTabView(i));
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                addSelectedChanges(tab);

            }

            private void addSelectedChanges(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                View indicator = view.findViewById(R.id.custom_tab_indicator);
                indicator.setBackgroundColor(Color.parseColor("#000000"));


                TextView textView = view.findViewById(R.id.custom_tab_text);
                textView.setTextColor(Color.parseColor("#000000"));
                textView.setTypeface(textView.getTypeface(), Typeface.BOLD);

                ImageView imageView = view.findViewById(R.id.custom_tab_image);
                ImageView imageView1 = view.findViewById(R.id.custom_tab_tick);
                imageView1.setImageResource(R.drawable.ok);

                int position = tab.getPosition();
                if(position == 1)
                {
                    imageView.setImageResource(R.drawable.yellow_pickup);
                }
                else if(position ==2)
                {
                    imageView.setImageResource(R.drawable.yellow_delivery);
                }
                else if(position == 3)
                {
                    imageView.setImageResource(R.drawable.yellow_reached);
                }
                imageView1.setVisibility(View.VISIBLE);

            }
            private void addUnselectedChanges(TabLayout.Tab tab)
            {
                View view = tab.getCustomView();
                View indicator = view.findViewById(R.id.custom_tab_indicator);
                indicator.setBackgroundColor(Color.parseColor("#A8A19E"));

                TextView textView = view.findViewById(R.id.custom_tab_text);
                textView.setTextColor(Color.parseColor("#A8A19E"));
                textView.setTypeface(textView.getTypeface(), Typeface.NORMAL);

                ImageView imageView = view.findViewById(R.id.custom_tab_image);
                ImageView imageView1 = view.findViewById(R.id.custom_tab_tick);

                int position = tab.getPosition();
                if(position == 1)
                {
                    imageView.setImageResource(R.drawable.pick_up);
                }
                else if(position ==2)
                {
                    imageView.setImageResource(R.drawable.destinations);
                }
                else if(position == 3)
                {
                    imageView.setImageResource(R.drawable.reached);
                }
                imageView1.setVisibility(View.GONE);



            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                addUnselectedChanges(tab);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });

        final Button tb1, tb2, tb3;
        tb1 = findViewById(R.id.triple_button1);
        tb2 = findViewById(R.id.triple_button2);
        tb3 = findViewById(R.id.triple_button3);

        tb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PagerAcitvity.this, tb1.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        tb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PagerAcitvity.this, tb2.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        tb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PagerAcitvity.this, tb3.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });










    }




}

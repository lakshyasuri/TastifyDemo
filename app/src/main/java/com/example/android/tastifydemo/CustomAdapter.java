package com.example.android.tastifydemo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends FragmentPagerAdapter {
    private Context mContext;
    public CustomAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return new SourceFragment();
        else if(position == 1)
            return new PickUpFragment();
        else if(position == 2)
            return new DestinationFragment();
        else
            return new ReachedFragment();

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0)
            return mContext.getString(R.string.source);
        else if(position == 1)
            return mContext.getString(R.string.pick_up);
        else if(position == 2)
            return mContext.getString(R.string.destination);
        else
            return mContext.getString(R.string.reached);
    }

    public View getTabView(int position)
    {
        String[] text = {mContext.getString(R.string.source),mContext.getString(R.string.pick_up),mContext.getString(R.string.destination),
                          mContext.getString(R.string.reached)};
        int[] images = {R.drawable.source_icon,R.drawable.pick_up,R.drawable.destinations,R.drawable.reached};
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_tab,null);

        TextView textView = v.findViewById(R.id.custom_tab_text);
        textView.setText(text[position]);

        ImageView imageView = v.findViewById(R.id.custom_tab_image);
        imageView.setImageResource(images[position]);

        ImageView imageView1 = v.findViewById(R.id.custom_tab_tick);
        imageView1.setImageResource(R.drawable.ok);
        imageView1.setVisibility(View.GONE);

        View indicator = v.findViewById(R.id.custom_tab_indicator);
        if(position == 0) {
            indicator.setBackgroundColor(Color.parseColor("#000000"));
            textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
            textView.setTextColor(Color.parseColor("#000000"));
        }
        else
            indicator.setBackgroundColor(Color.parseColor("#A8A19E"));

        return v;


    }
}

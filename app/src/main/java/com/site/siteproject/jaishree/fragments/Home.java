package com.site.siteproject.jaishree.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.site.siteproject.FullScreenViewPager;
import com.site.siteproject.R;
import com.site.siteproject.utils.ExtendedViewPager;
import com.site.siteproject.utils.GlobalClass;
import com.site.siteproject.utils.TouchImageView;

import java.util.ArrayList;

/**
 * Created by Prakash on 11/11/2017.
 */

public class Home extends Fragment {

    ArrayList<String> flatnames;
    RadioGroup radioGroup;
    ExtendedViewPager viewPager;
    RadioButton radioButton;
    GlobalClass global;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_jaishree, container, false);
        global=(GlobalClass)getActivity().getApplicationContext();
        flatnames=new ArrayList<>();
        flatnames.add("FLAT -1A");
        flatnames.add("FLAT -1B");
        flatnames.add("FLAT -1G");
        flatnames.add("FLAT -2A , 3A & 4A");
        flatnames.add("FLAT -2B , 3B & 4B");
        flatnames.add("FLAT -2C , 3C & 4C");
        flatnames.add("FLAT -2D , 3D & 4D");
        flatnames.add("FLAT -2E , 3E & 4E");
        flatnames.add("FLAT -2H, 3H & 4J");
        flatnames.add("FLAT -2J , 3J & 4K");


        init(view);




        viewPager.setAdapter(new CustomPagerAdapter(getActivity()));


        return view;

    }

    void flatintialise() {

        RadioGroup.LayoutParams rprms;

        for (int i = 0; i < flatnames.size(); i++) {
            radioButton = new RadioButton(getActivity());
            radioButton.setText(flatnames.get(i));
            radioButton.setTextSize(22);
            radioButton.setPadding(10, 10, 10, 10);
            radioButton.setChecked(i == 0);
            radioButton.setId(i);
            radioButton.setGravity(Gravity.CENTER);
            radioButton.setTextColor(getResources().getColorStateList(R.color.rbtn_textcolor_selector));
            radioButton.setButtonDrawable(null);
            radioButton.setBackgroundResource(R.drawable.jaishree_radio);
            global.setTypeface(radioButton);

            rprms = new RadioGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
            radioGroup.addView(radioButton, rprms);


        }


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                viewPager.setCurrentItem(i);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {



                radioGroup.check(position);


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(0);


    }
    public class CustomPagerAdapter extends PagerAdapter {

        private Context mContext;
        ArrayList<Integer> drawables = new ArrayList<Integer>();



        public CustomPagerAdapter(Context context) {

            mContext = context;
            drawables.add(R.drawable.jaishree_flat1);
            drawables.add(R.drawable.jaishree_flat1b);
            drawables.add(R.drawable.jaishree_flat1g);
            drawables.add(R.drawable.jaishree_flat2a3a4a);
            drawables.add(R.drawable.jaishree_flat2b3b4b);
            drawables.add(R.drawable.jaishree_flat2c3c4c);

            drawables.add(R.drawable.jaishree_flat2d3d4d);
            drawables.add(R.drawable.jaishree_flat2e3e4e);
            drawables.add(R.drawable.jaishree_flat2h3h4j);
            drawables.add(R.drawable.jaishree_flat2j3j4k);


        }

        @Override
        public Object instantiateItem(ViewGroup collection,final int position) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.viewpager_item, collection, false);
            ImageView imageView = (ImageView) layout.findViewById(R.id.flats);

            imageView.setImageResource(drawables.get(position));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(getActivity(), FullScreenViewPager.class);
                    i.putIntegerArrayListExtra("drawables",drawables);
                    i.putExtra("id", position);
                    startActivity(i);
                }
            });

            collection.addView(layout);
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

        @Override
        public int getCount() {
            return drawables.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /*@Override
        public CharSequence getPageTitle(int position) {

            radioGroup.check(position);

            return String.valueOf(position);
        }
*/

    }


    void init(View view)
    {
        radioGroup= (RadioGroup) view.findViewById(R.id.rg_header);
        viewPager = (ExtendedViewPager)view. findViewById(R.id.viewpager);

        flatintialise();

    }

}

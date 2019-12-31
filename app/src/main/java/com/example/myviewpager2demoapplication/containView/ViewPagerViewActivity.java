package com.example.myviewpager2demoapplication.containView;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myviewpager2demoapplication.R;
import com.example.myviewpager2demoapplication.containView.ViewpagerViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerViewActivity extends AppCompatActivity {

    @BindView(R.id.viewpage2)
    ViewPager2 mViewpage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_view);
        ButterKnife.bind(this);
        ViewpagerViewAdapter adapter=new ViewpagerViewAdapter();
        mViewpage2.setAdapter(adapter);
        mViewpage2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
    }
}

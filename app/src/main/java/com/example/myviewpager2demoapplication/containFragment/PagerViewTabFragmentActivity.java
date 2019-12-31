package com.example.myviewpager2demoapplication.containFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myviewpager2demoapplication.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PagerViewTabFragmentActivity extends AppCompatActivity {

    @BindView(R.id.tablayout)
    TabLayout mTablayout;
    @BindView(R.id.viewpager2)
    ViewPager2 mViewpager2;
    private List<Integer> mColorList = new ArrayList<Integer>();

    {
        mColorList.add(Color.BLUE);
        mColorList.add(Color.GRAY);
        mColorList.add(Color.LTGRAY);
        mColorList.add(Color.RED);
    }
    FragmentPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_view_tab_fragment);
        ButterKnife.bind(this);
        adapter=new FragmentPagerAdapter(getSupportFragmentManager(), new Lifecycle() {
            @Override
            public void addObserver(@NonNull LifecycleObserver observer) {

            }

            @Override
            public void removeObserver(@NonNull LifecycleObserver observer) {

            }

            @NonNull
            @Override
            public State getCurrentState() {
                return null;
            }
        });
        mViewpager2.setAdapter(adapter);
        mTablayout.addTab(mTablayout.newTab().setText("一"));
        mTablayout.addTab(mTablayout.newTab().setText("二"));
        mTablayout.addTab(mTablayout.newTab().setText("三"));
        mTablayout.addTab(mTablayout.newTab().setText("四"));
        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewpager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mViewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mTablayout.setScrollPosition(position,0,false);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fragment_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                mColorList.add(Color.YELLOW);
                mTablayout.addTab(mTablayout.newTab().setText("五"));
                adapter.notifyItemInserted(mColorList.size() - 1);
                break;
            case R.id.menu2:
                int position=mColorList.size() - 1;
                mColorList.remove(position);
                mTablayout.removeTabAt(position );
                adapter.notifyItemRemoved(position);
                break;
        }
        return true;
    }
    public class FragmentPagerAdapter extends FragmentStateAdapter {

        public FragmentPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }


        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return PagerFragment.getInstance(mColorList.get(position),position);
        }

        @Override
        public int getItemCount() {
            return mColorList.size();
        }
    }

}


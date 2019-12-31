package com.example.myviewpager2demoapplication.containFragment;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myviewpager2demoapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class PagerFragment extends Fragment {
    @BindView(R.id.tv_page)
    TextView mTvPage;
    @BindView(R.id.fl_page)
    FrameLayout mFlPage;
    private int color = Color.WHITE;
    private int position = 0;

    public PagerFragment() {
        // Required empty public constructor
    }

    public static PagerFragment getInstance(int color, int position) {
        PagerFragment fragment = new PagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("color", color);
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            color = bundle.getInt("color");
            position = bundle.getInt("position");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFlPage.setBackgroundColor(color);
        mTvPage.setText(String.format("第%d页",position+1));
    }
}

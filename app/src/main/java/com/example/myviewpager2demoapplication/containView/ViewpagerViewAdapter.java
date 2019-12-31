package com.example.myviewpager2demoapplication.containView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myviewpager2demoapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewpagerViewAdapter extends RecyclerView.Adapter<ViewpagerViewAdapter.ViewHolder> {
    private List<Integer> mColorList = new ArrayList<Integer>();

    {
        mColorList.add(android.R.color.black);
        mColorList.add(android.R.color.holo_purple);
        mColorList.add(android.R.color.holo_blue_dark);
        mColorList.add(android.R.color.holo_green_light);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewpage_view, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.mLlBack.setBackgroundResource(mColorList.get(position));
    holder.mTvName.setText(String.format("测试%d", position));
    }

    @Override
    public int getItemCount() {
        return mColorList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.ll_back)
        LinearLayout mLlBack;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

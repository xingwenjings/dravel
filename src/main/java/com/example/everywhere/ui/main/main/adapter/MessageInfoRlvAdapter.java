package com.example.everywhere.ui.main.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.everywhere.R;
import com.example.everywhere.bean.MessageInfoData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageInfoRlvAdapter extends RecyclerView.Adapter<MessageInfoRlvAdapter.VH> {

    private ArrayList<MessageInfoData> list;
    private Context context;

    //上一次触摸的点
    private int mLastX ,mLastY;

    //当前触摸item的位置
    private int mPosition;

    //item对应的布局
    private View mItemLayout;

    //删除按钮
    private TextView mDelete;

    //最大滑动距离
    private int mMaxLength;

    //是否在垂直滑动列表
    private int isDragging;

    //item是否在跟随手指滑动
    private int isItemMoving;

    //item是否开始自动滑动


    public MessageInfoRlvAdapter(ArrayList<MessageInfoData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.message_info_item, null);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        MessageInfoData data = list.get(i);
        if (data != null){
            vh.info.setText(data.getInfo());
            vh.time.setText(data.getTime());
            vh.inform.setText(data.getInform());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.info)
        TextView info;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.inform)
        TextView inform;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

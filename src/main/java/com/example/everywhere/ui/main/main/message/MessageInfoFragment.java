package com.example.everywhere.ui.main.main.message;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.everywhere.R;
import com.example.everywhere.base.BaseFragment;
import com.example.everywhere.bean.MessageInfoData;
import com.example.everywhere.presenter.MessageInfoFragPresenter;
import com.example.everywhere.ui.main.main.adapter.MessageInfoRlvAdapter;
import com.example.everywhere.view.main.MessageInfoFraView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageInfoFragment extends BaseFragment<MessageInfoFraView, MessageInfoFragPresenter> implements MessageInfoFraView {

    @BindView(R.id.re)
    RecyclerView re;
    @Override
    protected MessageInfoFragPresenter initPresenter() {
        return new MessageInfoFragPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.message_info_fragment;
    }

    @Override
    protected void initView() {
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<MessageInfoData> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MessageInfoData data = new MessageInfoData("系统通知", "09/" + i, "添加成功");
            list.add(data);
        }
        MessageInfoRlvAdapter adapter = new MessageInfoRlvAdapter(list, getContext());
        re.setAdapter(adapter);
    }


}

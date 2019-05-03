package com.example.everywhere.ui.main.main.message;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;


import com.example.everywhere.R;
import com.example.everywhere.base.BaseActivity;
import com.example.everywhere.base.BaseFragment;
import com.example.everywhere.presenter.MessagePresenter;
import com.example.everywhere.ui.main.main.adapter.MessageVpAdapter;
import com.example.everywhere.view.main.MessageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageActivity extends BaseActivity<MessageView, MessagePresenter> implements MessageView {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    protected MessagePresenter initPersenter() {
        return new MessagePresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.message_layout;
    }

    @Override
    protected void initView() {
        setSupportActionBar(toolBar);
        toolBar.setNavigationIcon(R.mipmap.back_white);
        toolBar.setTitle("");
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        fragments.add(new MessageFragment());
        fragments.add(new MessageInfoFragment());
        titles.add(getResources().getString(R.string.infrom));
        titles.add(getResources().getString(R.string.news));
        MessageVpAdapter adapter = new MessageVpAdapter(getSupportFragmentManager(), fragments, titles);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }

}

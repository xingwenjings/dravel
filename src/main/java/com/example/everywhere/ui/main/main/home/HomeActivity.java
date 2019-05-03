package com.example.everywhere.ui.main.main.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;

import com.example.everywhere.R;
import com.example.everywhere.base.BaseActivity;
import com.example.everywhere.presenter.HomePresenter;
import com.example.everywhere.view.main.HomeView;

import butterknife.BindView;

public class HomeActivity  extends BaseActivity<HomeView, HomePresenter> implements HomeView {
    @BindView(R.id.toolBar)
    Toolbar toolBar;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }



    @Override
    protected HomePresenter initPersenter() {
        return new HomePresenter();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getLayout() {
        return R.layout.home_layout;
    }


}


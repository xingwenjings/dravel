package com.example.everywhere.ui.main.main.message;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.everywhere.R;
import com.example.everywhere.base.BaseFragment;
import com.example.everywhere.presenter.MessageFragPresenter;
import com.example.everywhere.view.main.MessageFragView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends BaseFragment<MessageFragView,MessageFragPresenter> implements MessageFragView {

    @Override
    protected MessageFragPresenter initPresenter() {
        return new MessageFragPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.message_fragment;
    }
}

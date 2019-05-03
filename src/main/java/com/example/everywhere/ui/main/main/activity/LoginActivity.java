package com.example.everywhere.ui.main.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.everywhere.R;
import com.example.everywhere.base.BaseActivity;
import com.example.everywhere.base.BaseApp;
import com.example.everywhere.base.BaseMvpView;
import com.example.everywhere.base.BasePresenter;
import com.example.everywhere.base.Constants;
import com.example.everywhere.presenter.HomePresenter;
import com.example.everywhere.presenter.LoginPresenter;
import com.example.everywhere.ui.main.main.message.MessageActivity;
import com.example.everywhere.util.ToastUtil;
import com.example.everywhere.view.main.LoginView;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;
//5ccc3675570df3e26a0003e1    apk
import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements BaseMvpView {

    private static final String TAG = "LoginActivity";
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.btn_send_verify_code)
    Button btnSendVerifyCode;
    @BindView(R.id.wechat_login)
    ImageView wechatLogin;
    @BindView(R.id.login_layout)
    LinearLayout loginLayout;
    @BindView(R.id.et_one)
    EditText etOne;
    @BindView(R.id.et_two)
    EditText etTwo;
    @BindView(R.id.et_three)
    EditText etThree;
    @BindView(R.id.et_four)
    EditText etFour;
    @BindView(R.id.get_verify_layout)
    LinearLayout getVerifyLayout;
    @BindView(R.id.tv_loading)
    TextView tvLoading;
    @BindView(R.id.tv_qq)
    TextView tvQq;
    @BindView(R.id.tv_weibo)
    TextView tvWeibo;
    @BindView(R.id.countdown)
    TextView countdown;
    private String etPhoneString;
    private String etOneString;
    private String etTwoString;
    private String etThreeString;
    private String etFourString;
    private static final int MSG_CODE = 0;
    private int limitTime = 60;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == MSG_CODE){
                limitTime --;
                if (limitTime >0){
                    handler.sendEmptyMessageAtTime(MSG_CODE,1000);
                    countdown.setText("倒计时("+limitTime+"s)");
                }else {
                    //重新赋值进行赋值
                    limitTime = 60;
                }
            }
        }
    };
    @Override
    protected LoginPresenter initPersenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        etPhone.addTextChangedListener(new PhoneLengthWatcher());
        etOne.addTextChangedListener(new OneNumTextWatcher());
        etTwo.addTextChangedListener(new TwoNumTextWatcher());
        etThree.addTextChangedListener(new ThreeNumTextWatcher());
        etFour.addTextChangedListener(new FourNumTextWatcher());

    }

    @OnClick({R.id.btn_send_verify_code, R.id.wechat_login, R.id.et_phone, R.id.tv_qq, R.id.tv_weibo})
    protected void initListener(View view) {
        switch (view.getId()) {
            case R.id.btn_send_verify_code:
                etPhone();
            case R.id.tv_qq:
                authorization(SHARE_MEDIA.QQ);
                break;
            case R.id.tv_weibo:
                authorization(SHARE_MEDIA.YIXIN);
                break;
        }
    }


    //注册手机号之后登录方法
    private void etPhone() {
        if (etPhoneString != null) {
            if (etPhoneString.matches(Constants.telRegex)) {
                getVerifyLayout.setVisibility(View.VISIBLE);//获取验证码界面显示
                loginLayout.setVisibility(View.GONE);//注册手机号消失

            } else {
                ToastUtil.showShort("请输入正确的手机号");
            }
        } else {
            ToastUtil.showShort("手机号不能为空,小心程序崩溃");
        }

    }

    //监听电话输入框的变化
    class PhoneLengthWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            etPhoneString = s.toString();
            if (etPhoneString.length() == 11) {
                btnSendVerifyCode.setBackground(BaseApp.getRes().getDrawable(R.mipmap.button_highlight));
            }
        }
    }

    class OneNumTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            etOneString = s.toString();
        }
    }

    class TwoNumTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            etTwoString = s.toString();

        }
    }

    class ThreeNumTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            etTwoString = s.toString();

        }
    }

    class FourNumTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            etFourString = s.toString();
            if (etFourString != null && etFourString.length() == 1) {
                tvLoading.setVisibility(View.VISIBLE);
                try {
                    Thread.sleep(2000);
                    startActivity(new Intent(LoginActivity.this, MessageActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //授权
    private void authorization(SHARE_MEDIA share_media) {
        UMShareAPI.get(this).getPlatformInfo(this, share_media, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                Log.d(TAG, "onStart " + "授权开始");
            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                Log.d(TAG, "onComplete " + "授权完成");
/*
                //sdk是6.4.4的,但是获取值的时候用的是6.2以前的(access_token)才能获取到值,未知原因
                String uid = map.get("uid");
                String openid = map.get("openid");//微博没有
                String access_token = map.get("access_token");
                String refresh_token = map.get("refresh_token");//微信,qq,微博都没有获取到
                String expires_in = map.get("expires_in");
                String name = map.get("name");
                String gender = map.get("gender");
                String iconurl = map.get("iconurl");*/

            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                Log.d(TAG, "onError " + "授权失败");
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                Log.d(TAG, "onCancel " + "授权取消");
            }
        });


    }

    //QQ与新浪不需要添加Activity，但需要在使用QQ分享或者授权的Activity中
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}

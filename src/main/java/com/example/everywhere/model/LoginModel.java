package com.example.everywhere.model;


import com.example.everywhere.base.BaseModel;
import com.example.everywhere.bean.VerifyCodeBean;
import com.example.everywhere.net.BaseObserver;
import com.example.everywhere.net.HttpUtils;
import com.example.everywhere.net.ResultCallBack;
import com.example.everywhere.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * @author xts
 *         Created by asus on 2019/4/29.
 *         1.打log,交给日志拦截器
 *         2.无网络的情况下,没有提示
 *         3.加载数据需要loading界面
 */

public class LoginModel extends BaseModel {


}

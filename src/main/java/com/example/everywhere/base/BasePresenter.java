package com.example.everywhere.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseMvpView> {
    protected V mMvpView;
    protected ArrayList<BaseModel> models = new ArrayList<>();
    public void bind(V v) {
        this.mMvpView = v;
    }
    public BasePresenter(){//创建P层  会调用抽象方法 请求网络数据
        initModel();
    }

    protected abstract void initModel();

    public void onDestroy(){
        //打断M层与P层的关系
        mMvpView = null;
        //切断网络请求
        if (models.size() > 0){
            for (BaseModel model : models) {
                model.onDestroy();
            }
            models.clear();//请求集合
        }
    }


}

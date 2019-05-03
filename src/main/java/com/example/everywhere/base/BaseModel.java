package com.example.everywhere.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseModel {
    private CompositeDisposable mCompositeDisposable;
    public void addDisposable(Disposable d){
        if (mCompositeDisposable == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(d);
    }
    public void onDestroy(){
        //切换所有的Dissable对象
        mCompositeDisposable.clear();
    }
}

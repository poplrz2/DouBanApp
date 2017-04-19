package com.edu.doubanapp.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.edu.doubanapp.ui.base.interfaceutils.UiOperation;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Description:
 * @Author: Cyf on 2017/4/19.
 */

public abstract class BaseAcitvity extends AppCompatActivity implements UiOperation{

    private Context mContext;
    private Unbinder bind;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定视图
        setContentView(layoutContentId());
        //ButterKnife的初始化,绑定Activity,并获取Unbinder对象,用于解除绑定
        bind = ButterKnife.bind(this);
        mContext=this;

        initView();

        initListener();
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}

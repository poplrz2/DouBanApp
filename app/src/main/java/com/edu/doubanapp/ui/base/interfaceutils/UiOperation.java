package com.edu.doubanapp.ui.base.interfaceutils;

import android.view.View;

/**
 * @Description:
 * @Author: Cyf on 2017/4/19.
 */

public interface UiOperation extends View.OnClickListener {

    //获取布局Id
    int layoutContentId();

    //初始化View
    void initView();

    //初始化监听器
    void initListener();

    //控件的点击事件
    void onClick(View v);
}

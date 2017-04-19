package com.edu.doubanapp.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.doubanapp.ui.base.interfaceutils.UiOperation;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Description:
 * @Author: Cyf on 2017/4/19.
 */

public abstract class BaseFragment extends Fragment implements UiOperation{


    private Unbinder bind;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initListener();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(layoutContentId(),container,false);
        bind = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }

}

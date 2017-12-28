package com.example.administrator.xiangmuone.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.xiangmuone.utils.App;
import com.example.administrator.xiangmuone.utils.TUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<P extends BasePresenter, M extends BaseModel> extends Fragment {
//    private boolean hasCreateView;
//    private boolean isFragmentVisible;


    public P mPresenter;
    public M mModel;
    private View view;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        initVariable();
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mPresenter = TUtils.getT(this, 0);
        mModel = TUtils.getT(this, 1);
        if (this instanceof BaseView) {
            mPresenter.setMV(mModel, this);
        }
//        if (view == null) {
            view = inflater.inflate(getLayoutId(), container, false);

//        }

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
//        if (!hasCreateView && getUserVisibleHint()) {
//            onFragmentVisibleChange(true);
//            isFragmentVisible = true;
//        }
    }

    protected abstract void initView(View view);

    protected abstract int getLayoutId();

//
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (view == null) {
//            return;
//        }
//        hasCreateView = true;
//        if (isVisibleToUser) {
//            onFragmentVisibleChange(true);
//            isFragmentVisible = true;
//            return;
//        }
//        if (isFragmentVisible) {
//            onFragmentVisibleChange(false);
//            isFragmentVisible = false;
//        }
//    }
//
//    private void initVariable() {
//        hasCreateView = false;
//        isFragmentVisible = false;
//    }
//
//    protected void onFragmentVisibleChange(boolean isVisible) {
//    }
//

}

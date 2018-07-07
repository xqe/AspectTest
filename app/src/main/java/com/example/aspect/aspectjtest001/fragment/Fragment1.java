package com.example.aspect.aspectjtest001.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aspect.aoplib.ClassTrace;
import com.example.aspect.aspectjtest001.R;

@ClassTrace(002)
public class Fragment1 extends Fragment {

    private static final String TAG = "!!!!Fragment1";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement1, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: =====================");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG, "onHiddenChanged: =====================" + hidden);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e(TAG, "setUserVisibleHint: =====================" + isVisibleToUser);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: =====================");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "onDestroyView: =====================");
    }
}

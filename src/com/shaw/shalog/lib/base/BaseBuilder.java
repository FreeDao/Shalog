package com.shaw.shalog.lib.base;

import android.content.Context;

import com.shaw.shalog.R;

abstract public class BaseBuilder {

    private Context mContext;
    private int mTheme;
    
    public BaseBuilder(Context context) {
        this(context, R.style.Shalog);
    }
    
    public BaseBuilder(Context context, int theme) {
        mContext = context;
        mTheme = theme;
    }
    
    public int getTheme() {
        return mTheme;
    }
    
    public Context getContext() {
        return mContext;
    }
    
    abstract public BaseDialog create();
    
    abstract public BaseDialog show();

}

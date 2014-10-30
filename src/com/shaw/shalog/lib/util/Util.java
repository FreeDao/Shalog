package com.shaw.shalog.lib.util;

import android.content.Context;

public class Util {
    /**
     * 将px转换为dp
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dp(Context context, float pxValue)
    {
       float m= context.getResources().getDisplayMetrics().density ;
       return (int)(pxValue / m + 0.5f) ;
    }
}

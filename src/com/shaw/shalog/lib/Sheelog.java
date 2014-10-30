package com.shaw.shalog.lib;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

import com.shaw.shalog.R;
import com.shaw.shalog.lib.base.TouchableDialog;
import com.shaw.shalog.lib.base.TouchableBuilder;
import com.shaw.shalog.lib.util.Util;

public class Sheelog extends TouchableDialog {
    
    protected Sheelog(Context context, int layout, int theme) {
        super(context, layout, theme);
    }
    
    @Override
    public void show() {
        super.getWindow().setGravity(Gravity.BOTTOM);
        super.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        super.show();
    }


    /**
     * Sheelog的建造者
     *
     * @author shaw
     *
     */
    public static class Builder extends TouchableBuilder {
        
        /**
         * 用来判断是否需要更改titlebar width属性的数值,如果更改了sheet_view.xml,务必要重新算一下这个值
         * 计算方法:就是sheet_view中外边框和titlebar的宽度dp差  ===> shalog.getDialogView().getMeasuredWidth() - titlebar.getMeasuredWidth()
         * 虽然这俩值算出来的都不是宽度,但是差确实是宽度差
         */
        private static final int CONTENT_WIDTH_DIFF = 60;
        
        public Builder(Context context) {
            this(context, R.style.Sheelog);
        }
        
        public Builder(Context context, int theme) {
            super(context, theme);
        }

        @Override
        public Sheelog create() {
            Sheelog shalog = new Sheelog(super.getContext(), R.layout.sheet_view, super.getTheme());
            super.setupTitle(shalog);
            super.setupContent(shalog);
            super.setupButton(shalog);
            super.setupDonotshow(shalog);
            super.createListView(shalog);
            this.resize(shalog);
            super.setupCancelableAndDim(shalog);
            super.setupListener(shalog);
            return shalog;
        }
        
        private void resize(TouchableDialog shalog) {
            shalog.getDialogView().measure(MeasureSpec.makeMeasureSpec(LinearLayout.LayoutParams.WRAP_CONTENT, MeasureSpec.UNSPECIFIED),
                    MeasureSpec.makeMeasureSpec(LinearLayout.LayoutParams.WRAP_CONTENT, MeasureSpec.UNSPECIFIED));
            View contentpanel = shalog.getDialogView().findViewById(R.id.contentpanel);
            //当contentpanel比边框小很多时, 修正contentpanel的宽度为match_parent
            if(contentpanel.getVisibility() == View.VISIBLE && Util.px2dp(super.getContext(), shalog.getDialogView().getMeasuredWidth() - contentpanel.getMeasuredWidth()) > CONTENT_WIDTH_DIFF) {
                contentpanel.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
            }
        }
    }
    
}

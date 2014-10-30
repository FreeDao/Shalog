package com.shaw.shalog.lib;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.shaw.shalog.R;
import com.shaw.shalog.lib.base.ShalogInterface;
import com.shaw.shalog.lib.base.TouchableBuilder;
import com.shaw.shalog.lib.base.TouchableDialog;
import com.shaw.shalog.lib.util.Util;

public class Shalog extends TouchableDialog implements ShalogInterface {

    protected Shalog(Context context, int layout, int theme) {
        super(context, layout, theme);
    }
    
    /**
     * Shalog的建造者
     *
     * @author shaw
     *
     */
    public static class Builder extends TouchableBuilder {
        /**
         * 用来判断是否需要更改titlebar width属性的数值,如果更改了dialog_view.xml,务必要重新算一下这个值
         * 计算方法:就是dialog_view中外边框和titlebar的宽度dp差  ===> shalog.getDialogView().getMeasuredWidth() - titlebar.getMeasuredWidth()
         * 虽然这俩值算出来的都不是宽度,但是差确实是宽度差
         */
        private static final int TITLE_WIDTH_DIFF = 60;
        private static final int CONTENT_WIDTH_DIFF = 60;
        
        public Builder(Context context) {
            this(context, R.style.Shalog);
        }
        
        public Builder(Context context, int theme) {
            super(context, theme);
        }
        
        public Shalog create() {
            Shalog shalog = new Shalog(super.getContext(), R.layout.dialog_view, super.getTheme());
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
        
        /**
         * 根据dialog的宽度调整控件的宽度属性
         * @param shalog
         */
        private void resize(TouchableDialog shalog) {
            shalog.getDialogView().measure(MeasureSpec.makeMeasureSpec(LinearLayout.LayoutParams.WRAP_CONTENT, MeasureSpec.UNSPECIFIED),
                MeasureSpec.makeMeasureSpec(LinearLayout.LayoutParams.WRAP_CONTENT, MeasureSpec.UNSPECIFIED));
            View titlebar = shalog.getDialogView().findViewById(R.id.titlebar);
            View contentpanel = shalog.getDialogView().findViewById(R.id.contentpanel);
            //当titlebar比边框小很多时, 修正titlebar的宽度为match_parent
//            if(titlebar.getVisibility() == View.VISIBLE && Util.px2dp(super.getContext(), shalog.getDialogView().getMeasuredWidth() - titlebar.getMeasuredWidth()) > TITLE_WIDTH_DIFF) {
//                titlebar.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
//            }
            //当contentpanel比边框小很多时, 修正contentpanel的宽度为match_parent
            if(contentpanel.getVisibility() == View.VISIBLE && Util.px2dp(super.getContext(), shalog.getDialogView().getMeasuredWidth() - contentpanel.getMeasuredWidth()) > CONTENT_WIDTH_DIFF) {
                contentpanel.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
            }
        }
        
        /**
         * 测试用代码
         */
        private void RECALCULATE_WIDTH_DIFF() {
            View layout_view = LayoutInflater.from(super.getContext()).inflate(R.layout.dialog_view, null);
            View titlebar =  layout_view.findViewById(R.id.titlebar);
            layout_view.measure(MeasureSpec.makeMeasureSpec(LinearLayout.LayoutParams.WRAP_CONTENT, MeasureSpec.UNSPECIFIED),
                    MeasureSpec.makeMeasureSpec(LinearLayout.LayoutParams.WRAP_CONTENT, MeasureSpec.UNSPECIFIED));
            Log.d("asdas", layout_view.getMeasuredWidth()+"");
            Log.d("asdas", titlebar.getMeasuredWidth()+"");
            Toast.makeText(super.getContext(), "确保titlebar是宽度最长的view,将 " + Util.px2dp(super.getContext(), layout_view.getMeasuredWidth()-titlebar.getMeasuredWidth()) + " 作为WIDTH_DIFF的新值", Toast.LENGTH_LONG).show();
        }
        
    }

    
}

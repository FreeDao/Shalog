package com.shaw.shalog.lib;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.shaw.shalog.R;
import com.shaw.shalog.lib.base.BaseBuilder;
import com.shaw.shalog.lib.base.BaseDialog;

public class Toalog extends BaseDialog {
    /**两秒*/
    public static final int LENGTH_SHORT = 2000;
    /**五秒*/
    public static final int LENGTH_LONG = 5000;
    private int mDuration;
    
    protected Toalog(Context context, int layout, int theme, int duration) {
        super(context, layout, theme);
        WindowManager.LayoutParams params = super.getWindow().getAttributes();
        params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        mDuration = duration;
    }
    
    
    @Override
    public void show() {
        super.show();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Toalog.super.dismiss();
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, mDuration);
    }
    
    /**
     * Toalog的建造者
     *
     * @author shaw
     *
     */
    public static class Builder extends BaseBuilder {
        private CharSequence mTitle;
        private int mIconId;
        private Drawable mIcon;
        private CharSequence mContent;
        private int mDuration;
        
        public Builder(Context context) {
            this(context, Toalog.LENGTH_SHORT);
        }
        
        public Builder(Context context, int duration) {
            this(context, R.style.Toalog, duration);
        }
        
        public Builder(Context context, int theme, int duration) {
            super(context, theme);
            mDuration = duration;
        }
        
        /**
         * 设置标题
         * @param titleId
         * @return
         */
        public Builder setTitle(int titleId) {
            mTitle = super.getContext().getText(titleId);
            return this;
        }
        
        /**
         * 设置标题
         * @param title
         * @return
         */
        public Builder setTitle(CharSequence title) {
            mTitle = title;
            return this;
        }
        
        /**
         * 设置内容
         * @param contentId
         * @return
         */
        public Builder setContent(int contentId) {
            mContent = super.getContext().getText(contentId);
            return this;
        }

        /**
         * 设置内容
         * @param content
         * @return
         */
        public Builder setContent(CharSequence content) {
            mContent = content;
            return this;
        }
        
        /**
         * 设置大图标
         * @param iconId
         * @return
         */
        public Builder setIcon(int iconId) {
            mIconId = iconId;
            return this;
        }

        /**
         * 设置大图标
         * @param icon
         * @return
         */
        public Builder setIcon(Drawable icon) {
            mIcon = icon;
            return this;
        }
        
        /**
         * 设置时间长度,默认为{@link Toalog#LENGTH_SHORT}
         * @param duration
         * @return
         */
        public Builder setDuration(int duration) {
            mDuration = duration;
            return this;
        }
        
        @Override
        public Toalog create() {
            Toalog toalog = new Toalog(super.getContext(), R.layout.toast_view, super.getTheme(), mDuration);
            this.setupToalog(toalog);
            return toalog;
        }

        @Override
        public Toalog show() {
            Toalog toalog = this.create();
            toalog.show();
            return toalog;
        }

        private void setupToalog(final Toalog toalog) {
            ImageView icon = (ImageView) toalog.getDialogView().findViewById(R.id.icon);
            if (mIconId != 0) {
                icon.setImageResource(mIconId);
                icon.setVisibility(View.VISIBLE);
            }
            if (mIcon != null) {
                icon.setImageDrawable(mIcon);
                icon.setVisibility(View.VISIBLE);
            }
            if (mTitle != null) {
                TextView title = (TextView) toalog.getDialogView().findViewById(R.id.title);
                title.setText(mTitle);
                title.setVisibility(View.VISIBLE);
            }
            TextView contentText = (TextView) toalog.getDialogView().findViewById(R.id.content);
            if (mContent != null) {
                contentText.setVisibility(View.VISIBLE);
                contentText.setText(mContent);
            }
        }
    }
    
}

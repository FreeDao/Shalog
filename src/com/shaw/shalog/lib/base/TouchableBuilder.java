package com.shaw.shalog.lib.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.shaw.shalog.R;
import com.shaw.shalog.lib.Shalog;
import com.shaw.shalog.lib.Shalog.Builder;
import com.shaw.shalog.lib.util.Util;

abstract public class TouchableBuilder extends BaseBuilder {

    
        private CharSequence mTitle;
        private int mIconId;
        private Drawable mIcon;
        private boolean mHasRightButton;
        private Drawable mRightBtn;
        private int mRightBtnId;
        private View.OnClickListener mRightBtnListener;
        private View mContentView;
        private CharSequence mContent;
        private BaseAdapter mAdapter;
        private boolean mCancelable;
        private boolean mCancelableOnTouchOutside;
        private boolean mNoDim;
        
        private CharSequence mPositiveText;
        private ShalogInterface.OnClickListener mPositiveListener;
        private CharSequence mNeutralText;
        private ShalogInterface.OnClickListener mNeutralListener;
        private CharSequence mNegativeText;
        private ShalogInterface.OnClickListener mNegativeListener;
        private CharSequence mDonotshowText;
        private CompoundButton.OnCheckedChangeListener mDonotshowChangeListener;
        
        private ShalogInterface.OnCancelListener mCancelListener;
        private ShalogInterface.OnDismissListener mDismissListener;
        
        public TouchableBuilder(Context context) {
            this(context, R.style.Shalog);
        }

        public TouchableBuilder(Context context, int theme) {
            super(context, theme);
            mCancelable = true;
            mCancelableOnTouchOutside = true;
        }

        /**
         * 设置标题
         * @param titleId
         * @return
         */
        public TouchableBuilder setTitle(int titleId) {
            mTitle = super.getContext().getText(titleId);
            return this;
        }
        
        /**
         * 设置标题
         * @param title
         * @return
         */
        public TouchableBuilder setTitle(CharSequence title) {
            mTitle = title;
            return this;
        }
        
        /**
         * 设置右上角按钮监听器
         * @param listener
         * @return
         */
        public TouchableBuilder setRightButton(View.OnClickListener listener) {
            this.setRightButton(R.drawable.dialog_close_bg_selector, listener);
            return this;
        }
        
        /**
         * 设置右上角按钮图标及监听器
         * @param iconId
         * @param listener
         * @return
         */
        public TouchableBuilder setRightButton(int iconId, View.OnClickListener listener) {
            mHasRightButton = true;
            mRightBtnId = iconId;
            mRightBtnListener = listener;
            return this;
        }
        
        /**
         * 设置右上角按钮图标及监听器
         * @param icon
         * @param listener
         * @return
         */
        public TouchableBuilder setRightButton(Drawable icon, View.OnClickListener listener) {
            mHasRightButton = true;
            mRightBtn = icon;
            mRightBtnListener = listener;
            return this;
        }
        
        /**
         * 设置左上角图标
         * @param iconId
         * @return
         */
        public TouchableBuilder setIcon(int iconId) {
            mIconId = iconId;
            return this;
        }

        /**
         * 设置左上角图标
         * @param icon
         * @return
         */
        public TouchableBuilder setIcon(Drawable icon) {
            mIcon = icon;
            return this;
        }
        
        /**
         * 设置内容
         * @param contentId
         * @return
         */
        public TouchableBuilder setContent(int contentId) {
            mContent = super.getContext().getText(contentId);
            return this;
        }
        
        /**
         * 设置内容
         * @param content
         * @return
         */
        public TouchableBuilder setContent(CharSequence content) {
            mContent = content;
            return this;
        }
        
        /**
         * 设置contentview
         * @param viewId
         * @return
         */
        public TouchableBuilder setContentView(int viewId) {
            mContentView = LayoutInflater.from(super.getContext()).inflate(viewId, null);
            return this;
        }
        
        /**
         * 设置contentview
         * @param view
         * @return
         */
        public TouchableBuilder setContentView(View view) {
            mContentView = view;
            return this;
        }
        
        /**
         * 设置列表适配器
         * @param adapter
         * @return
         */
        public TouchableBuilder setAdapter(BaseAdapter adapter) {
            mAdapter = adapter;
            return this;
        }
        
        /**
         * 设置是否能被取消,默认为true
         * @param cancelable
         * @return
         */
        public TouchableBuilder setCancelable(boolean cancelable) {
            mCancelable = cancelable;
            return this;
        }
        
        /**
         * 设置能否通过触摸外围取消,默认为true
         * @param cancel
         * @return
         */
        public TouchableBuilder setCanceledOnTouchOutside(boolean cancel) {
            mCancelableOnTouchOutside = cancel;
            return this;
        }
        
        /**
         * 设置积极按钮及监听器
         * @param textId
         * @param listener
         * @return
         */
        public TouchableBuilder setPositiveButton(int textId, ShalogInterface.OnClickListener listener) {
            mPositiveText = super.getContext().getText(textId);
            mPositiveListener = listener;
            return this;
        }

        /**
         * 设置积极按钮及监听器
         * @param text
         * @param listener
         * @return
         */
        public TouchableBuilder setPositiveButton(CharSequence text, ShalogInterface.OnClickListener listener) {
            mPositiveText = text;
            mPositiveListener = listener;
            return this;
        }
        
        /**
         * 设置消极按钮及监听器
         * @param textId
         * @param listener
         * @return
         */
        public TouchableBuilder setNegativeButton(int textId, ShalogInterface.OnClickListener listener) {
            mNegativeText = super.getContext().getText(textId);
            mNegativeListener = listener;
            return this;
        }

        /**
         * 设置消极按钮及监听器
         * @param text
         * @param listener
         * @return
         */
        public TouchableBuilder setNegativeButton(CharSequence text, ShalogInterface.OnClickListener listener) {
            mNegativeText = text;
            mNegativeListener = listener;
            return this;
        }
        
        /**
         * 设置中立按钮及监听器
         * @param textId
         * @param listener
         * @return
         */
        public TouchableBuilder setNeutralButton(int textId, ShalogInterface.OnClickListener listener) {
            mNeutralText = super.getContext().getText(textId);
            mNeutralListener = listener;
            return this;
        }

        /**
         * 设置中立按钮及监听器
         * @param text
         * @param listener
         * @return
         */
        public TouchableBuilder setNeutralButton(CharSequence text, ShalogInterface.OnClickListener listener) {
            mNeutralText = text;
            mNeutralListener = listener;
            return this;
        }
        
        /**
         * 设置不再显示区域文字及监听器
         * @param textId
         * @param listener
         * @return
         */
        public TouchableBuilder setDonotshow(int textId, CompoundButton.OnCheckedChangeListener listener) {
            mDonotshowText = super.getContext().getText(textId);
            mDonotshowChangeListener = listener;
            return this;
        }
        
        /**
         * 设置不再显示区域文字及监听器
         * @param text
         * @param listener
         * @return
         */
        public TouchableBuilder setDonotshow(CharSequence text, CompoundButton.OnCheckedChangeListener listener) {
            mDonotshowText = text;
            mDonotshowChangeListener = listener;
            return this;
        }
        
        /**
         * 设置取消时的监听器(通过返回键或触摸外围引起的取消)
         * @param listener
         * @return
         */
        public TouchableBuilder setOnCancelListener(ShalogInterface.OnCancelListener listener) {
            mCancelListener = listener;
            return this;
        }
        
        /**
         * 设置对话框消失时的监听器
         * @param listener
         * @return
         */
        public TouchableBuilder setOnDismissListener(ShalogInterface.OnDismissListener listener) {
            mDismissListener = listener;
            return this;
        }
        
        /**
         * 设置没有模态背景,默认为false,也就是有模态背景
         * @param dim
         * @return
         */
        public TouchableBuilder setNoDim(boolean dim) {
            mNoDim = dim;
            return this;
        }
        
        /**
         * create
         */
        abstract public TouchableDialog create();
        
        @Override
        public TouchableDialog show() {
            TouchableDialog shalog = this.create();
            shalog.show();
            return shalog;
        }

        protected void setupTitle(final TouchableDialog shalog) {
            boolean showTitle = false;
            ImageView icon = (ImageView) shalog.getDialogView().findViewById(R.id.icon);
            if (mIconId != 0) {
                showTitle = true;
                icon.setImageResource(mIconId);
                icon.setVisibility(View.VISIBLE);
            }
            if (mIcon != null) {
                showTitle = true;
                icon.setImageDrawable(mIcon);
                icon.setVisibility(View.VISIBLE);
            }
            if (mTitle != null) {
                showTitle = true;
                TextView title = (TextView) shalog.getDialogView().findViewById(R.id.title);
                title.setText(mTitle);
                title.setVisibility(View.VISIBLE);
            }
            if (mHasRightButton) {
                showTitle = true;
                final ImageView rightBtn = (ImageView) shalog.getDialogView().findViewById(R.id.rigthbtn);
                rightBtn.setVisibility(View.VISIBLE);
                if (mRightBtn != null) {
                    rightBtn.setImageDrawable(mRightBtn);
                } else if (mRightBtnId != 0){
                    rightBtn.setImageResource(mRightBtnId);
                }
                rightBtn.setOnClickListener(new View.OnClickListener() {
                    
                    @Override
                    public void onClick(View v) {
                        if (mRightBtnListener != null) {
                            mRightBtnListener.onClick(rightBtn);
                        }
                        shalog.dismiss();
                    }
                });
            }
            if (showTitle) {
                shalog.getDialogView().findViewById(R.id.titlebar).setVisibility(View.VISIBLE);
            }
        }
        
        protected void setupContent(TouchableDialog shalog) {
            TextView contentText = (TextView) shalog.getDialogView().findViewById(R.id.content);
            ScrollView contentViewPanel = (ScrollView) shalog.getDialogView().findViewById(R.id.contentpanel);
            if (mContentView != null) {
                contentViewPanel.removeAllViews();
                contentViewPanel.addView(mContentView);
                contentViewPanel.setVisibility(View.VISIBLE);
            } else if (mContent != null) {
                contentViewPanel.setVisibility(View.VISIBLE);
                contentText.setText(mContent);
            }
        }
        
        protected void createListView(TouchableDialog shalog) {
            if (mAdapter == null) {
                return;
            }
            shalog.getDialogView().findViewById(R.id.listviewpanel).setVisibility(View.VISIBLE);
            ListView listView = (ListView) shalog.getDialogView().findViewById(R.id.listview);
            listView.setAdapter(mAdapter);
        }
        
        protected void setupButton(final TouchableDialog shalog) {
            if (mPositiveText != null || mNegativeText != null || mNeutralText != null) {
                ViewGroup buttonPanel = (ViewGroup) ((ViewStub) shalog.getDialogView().findViewById(R.id.buttonpanel)).inflate();//必须先让其可见(ViewStub)
                Button button;
                if (mPositiveText != null) {
                    button = (Button) buttonPanel.findViewById(R.id.positive);
                    button.setVisibility(View.VISIBLE);
                    button.setText(mPositiveText);
                    button.setOnClickListener(new View.OnClickListener() {
                        
                        @Override
                        public void onClick(View v) {
                            if (mPositiveListener != null) {
                                mPositiveListener.onClick(shalog, ShalogInterface.BUTTON_POSITIVE);
                            }
                            shalog.dismiss();
                        }
                    });
                }
                if (mNegativeText != null) {
                    button = (Button) buttonPanel.findViewById(R.id.negative);
                    button.setVisibility(View.VISIBLE);
                    button.setText(mNegativeText);
                    button.setOnClickListener(new View.OnClickListener() {
                        
                        @Override
                        public void onClick(View v) {
                            if (mNegativeListener != null) {
                                mNegativeListener.onClick(shalog, ShalogInterface.BUTTON_NEGATIVE);
                            }
                            shalog.dismiss();
                        }
                    });
                }
                if (mNeutralText != null) {
                    button = (Button) buttonPanel.findViewById(R.id.neutral);
                    button.setVisibility(View.VISIBLE);
                    button.setText(mNeutralText);
                    button.setOnClickListener(new View.OnClickListener() {
                        
                        @Override
                        public void onClick(View v) {
                            if (mNeutralListener != null) {
                                mNeutralListener.onClick(shalog, ShalogInterface.BUTTON_NEUTRAL);
                            }
                            shalog.dismiss();
                        }
                    });
                }
            }
        }
        
        protected void setupDonotshow(TouchableDialog shalog) {
            if (mDonotshowText != null) {
                ViewGroup donotshow = (ViewGroup) ((ViewStub) shalog.getDialogView().findViewById(R.id.donotshowpanel)).inflate();
                ViewGroup donotshow_btn = (ViewGroup) shalog.getDialogView().findViewById(R.id.rb_clickablebtn);
                final RadioButton rb_donotshow = (RadioButton) donotshow.findViewById(R.id.radiobtn);
                TextView rb_text = (TextView) donotshow.findViewById(R.id.cb_text);
                rb_text.setText(mDonotshowText);
                rb_donotshow.setOnCheckedChangeListener(mDonotshowChangeListener);
                donotshow_btn.setOnClickListener(new View.OnClickListener() {
                    
                    @Override
                    public void onClick(View v) {
                        rb_donotshow.setChecked(!rb_donotshow.isChecked());
                    }
                });
            }
        }
        
        protected void setupCancelableAndDim(TouchableDialog shalog) {
            shalog.setCancelable(mCancelable);
            shalog.setCanceledOnTouchOutside(mCancelableOnTouchOutside);
            if (mNoDim) {
                shalog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            }
        }
        
        protected void setupListener(TouchableDialog shalog) {
            if (mCancelListener != null) {
                shalog.setOnCancelListener(mCancelListener);
            }
            if (mDismissListener != null) {
                shalog.setOnDismissListener(mDismissListener);
            }
        }
}

package com.shaw.shalog.lib.base;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

public class BaseDialog {
    private Dialog mDialog;
    private View mDialogView;
    
    protected BaseDialog(Context context, int layout, int theme) {
        mDialog = new Dialog(context, theme);
        mDialogView = LayoutInflater.from(context).inflate(layout, null);
        mDialog.setContentView(mDialogView);
    }
    
    public void show() {
        mDialog.show();
    }

    public void dismiss() {
        mDialogView = null;
        mDialog.dismiss();
    }
    
    public Dialog getDialog() {
        return mDialog;
    }
    
    public View getDialogView() {
        return mDialogView;
    }
    
    public Window getWindow() {
        return mDialog.getWindow();
    }
}

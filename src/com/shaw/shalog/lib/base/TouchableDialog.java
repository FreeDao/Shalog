package com.shaw.shalog.lib.base;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

public class TouchableDialog extends BaseDialog implements ShalogInterface {
    protected TouchableDialog(Context context, int layout, int theme) {
        super(context, layout, theme);
    }
    
    public void setCancelable(boolean cancel) {
        super.getDialog().setCancelable(cancel);
    }
    
    public void setCanceledOnTouchOutside(boolean cancel) {
        super.getDialog().setCanceledOnTouchOutside(cancel);
    }
    
    public void setOnCancelListener(final ShalogInterface.OnCancelListener listener) {
        super.getDialog().setOnCancelListener(new DialogInterface.OnCancelListener() {
            
            @Override
            public void onCancel(DialogInterface dialog) {
                listener.onCancel(TouchableDialog.this);
            }
        });
    }
    
    public void setOnDismissListener(final ShalogInterface.OnDismissListener listener) {
        super.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() {
            
            @Override
            public void onDismiss(DialogInterface dialog) {
                listener.onDismiss(TouchableDialog.this);
            }
        });
    }
}

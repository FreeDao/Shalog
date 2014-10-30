package com.shaw.shalog.lib.base;



public interface ShalogInterface {
    public static final int BUTTON_POSITIVE = -1;

    public static final int BUTTON_NEGATIVE = -2;

    public static final int BUTTON_NEUTRAL = -3;
    
    interface OnClickListener {
        /**
         * This method will be invoked when a button in the dialog is clicked.
         * 
         * @param dialog The dialog that received the click.
         * @param which The button that was clicked (e.g.
         *            {@link ShalogInterface#BUTTON_POSITIVE})
         */
        public void onClick(ShalogInterface dialog, int which);
    }
    
    interface OnCancelListener {
        /**
         * This method will be invoked when the dialog is canceled.
         * 
         * @param dialog The dialog that was canceled will be passed into the
         *            method.
         */
        public void onCancel(ShalogInterface dialog);
    }

    /**
     * Interface used to allow the creator of a dialog to run some code when the
     * dialog is dismissed.
     */
    interface OnDismissListener {
        /**
         * This method will be invoked when the dialog is dismissed.
         * 
         * @param dialog The dialog that was dismissed will be passed into the
         *            method.
         */
        public void onDismiss(ShalogInterface dialog);
    }

}

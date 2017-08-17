package com.hy.upknowledge;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

/**
 * Created by huyin on 2017/8/11.
 */

public class UserProgressDialog extends AlertDialog {

     public UserProgressDialog(Context context) {
          super(context, R.style.ProgressDialog);
          getWindow().setDimAmount(0);//设置昏暗度为0
          setCancelable(true);
          setCanceledOnTouchOutside(false);
     }

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.progress_dialog);

     }
}

package com.yinbao.www.listviewstyle;

import android.content.Context;
import android.widget.Toast;


/**
 * 提示框
 * Created by xing on 2016/1/14.
 */
public class MyToast {

    private static Toast mToast = null;


    /**
     * @param context 上下文对象
     * @param text    显示的内容
     * @param time    显示时间
     *
     * @return
     */
    public static void makeText(Context context, String text, int time) {
        if (mToast == null) {
            mToast = Toast.makeText(context.getApplicationContext(), text, time);
        } else {
            mToast.setText(text);
            mToast.setDuration(time);
        }
        mToast.show();
    }


    /**
     * @param context 上下文对象
     * @param text    显示的内容
     * @param time    显示时间
     */
    public static void makeText(Context context, int text, int time) {
        if (mToast == null) {
            mToast = Toast.makeText(context.getApplicationContext(), text, time);
        } else {
            try {
                mToast.setText(text);
                mToast.setDuration(time);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        mToast.show();
    }


}

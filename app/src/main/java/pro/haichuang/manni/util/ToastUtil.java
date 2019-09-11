package pro.haichuang.manni.util;

import android.widget.Toast;


/**
 * 作   者：
 * 描   述: 吐司工具类
 * 日   期: 2017/9/15 10:04
 * 更新日期: 2017/9/15
 */
public class ToastUtil {
    public static void toast(String message) {
        if (message == null || message.equals("")) {
            return;
        }
        Toast.makeText(Utils.getContext(),message, Toast.LENGTH_SHORT).show();
    }

    public static void show(String message) {
        if (message == null || message.equals("")) {
            return;
        }
        Toast.makeText(Utils.getContext(),message, Toast.LENGTH_SHORT).show();
    }

}

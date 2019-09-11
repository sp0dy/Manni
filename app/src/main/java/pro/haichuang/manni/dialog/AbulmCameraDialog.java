package pro.haichuang.manni.dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import pro.haichuang.manni.R;


public class AbulmCameraDialog {
    private TextView tv_take_photo;
    private TextView tv_form_abulm;
    private TextView tv_cancle;

    private Dialog dialog;
    private View view;

    public final int TAKEPHOTO = 1;
    public final int AUBLUM = 2;
    public final int CANCLE = 3;

    public AbulmCameraDialog(final Context context) {
        dialog = new Dialog(context, R.style.myDialogStyle);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        view = LayoutInflater.from(context).inflate(R.layout.dialog_mode_mine_abulm, null);
        dialog.setContentView(view);
        DisplayMetrics outMetrics = new DisplayMetrics();
        dialog.setCanceledOnTouchOutside(false);
        window.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        window.getAttributes().width = (width - (width / 7));
        //window.getAttributes().verticalMargin = ScreenUtils.dip2px(context,20);

        tv_take_photo = (TextView) window.findViewById(R.id.tv_xiangji);
        tv_form_abulm = (TextView) window.findViewById(R.id.tv_xiangce);
        tv_cancle = (TextView) window.findViewById(R.id.tv_cancle);
        tv_take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack(TAKEPHOTO);
            }
        });
        tv_form_abulm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack(AUBLUM);
            }
        });
        tv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack(CANCLE);
            }
        });

    }

    private void callBack(int c) {
        if (null != listener) {
            listener.onItemListener(c);
        }
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemListener(int choose);
    }

    public void showDialog() {
        if (null != dialog && dialog.isShowing() == false) {
            dialog.show();
        }
    }

    public boolean isShowing() {
        if (null != dialog && dialog.isShowing()) {
            return true;
        }
        return false;
    }

    public void dismiss() {
        if (null != dialog && dialog.isShowing()) {
            dialog.dismiss();
        }
    }


}

package pro.haichuang.manni.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.haichuang.manni.R;
import pro.haichuang.manni.data.Constant;
import pro.haichuang.manni.event.EventCenter;

/**
 * @ProjectName: Manni
 * @Package: pro.haichuang.manni.util
 * @ClassName: VipDialog
 * @Description: java类作用描述
 * @Author: 作者名:zhouyan
 * @CreateDate: 2019/9/11 23:04
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/9/11 23:04
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class VipDialog extends Dialog {
    @BindView(R.id.tv_cancle)
    TextView tvCancle;
    @BindView(R.id.tv_go_pay)
    TextView tvGoPay;

    public VipDialog(Context context) {
        super(context);
    }

    public VipDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_vip);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_cancle, R.id.tv_go_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cancle:
                dismiss();
                break;
            case R.id.tv_go_pay:
                EventBus.getDefault().post(new EventCenter<String>(Constant.MOVE_VIP));
                dismiss();
                break;
        }
    }
}

package pro.haichuang.manni.aty;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.haichuang.manni.R;
import pro.haichuang.manni.base.BaseAty;
import pro.haichuang.manni.data.Constant;
import pro.haichuang.manni.event.EventCenter;

public class IdCardAty extends BaseAty {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.tv_code)
    TextView tvCode;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.tv_send_code)
    TextView tvSendCode;
    @BindView(R.id.tv_next)
    TextView tvNext;

    @Override
    public int getLayout() {
        return R.layout.aty_phone;
    }

    @Override
    protected void initView() {
        tvTitle.setText("验证身份信息");
        tvSendCode.setVisibility(View.GONE);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onEventData(EventCenter center) {
        if (center.getEventCode()==Constant.CLOSE_VIP_ATY){
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_next)
    public void onViewClicked() {
        EventBus.getDefault().post(new EventCenter<String>(Constant.CLOSE_VIP_ATY));
        finish();
    }
}

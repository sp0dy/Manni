package pro.haichuang.manni.aty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.haichuang.manni.R;
import pro.haichuang.manni.base.BaseAty;
import pro.haichuang.manni.data.Constant;
import pro.haichuang.manni.event.EventCenter;

public class AboutPhoneAty extends BaseAty {
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

    private String type;

    @Override
    public int getLayout() {
        return R.layout.aty_phone;
    }

    @Override
    protected void initView() {
        type = getIntent().getStringExtra("type");
        if (type.equals("edit")){
            tvTitle.setText("修改手机号");
        }else if (type.equals("verify")){
            tvTitle.setText("验证手机号");
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onEventData(EventCenter center) {
        if (center.getEventCode()== Constant.CLOSE_VIP_ATY || center.getEventCode()==Constant.CLOSE_PHONE){
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_send_code, R.id.tv_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_send_code:
                break;
            case R.id.tv_next:
                if (type.equals("verify")){
                    startActivity(new Intent(AboutPhoneAty.this,IdCardAty.class));
                }else {
                    startActivity(new Intent(AboutPhoneAty.this,IdCardAty.class));
                }
                break;
        }
    }
}

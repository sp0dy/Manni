package pro.haichuang.manni.aty;

import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.haichuang.manni.R;
import pro.haichuang.manni.base.BaseAty;
import pro.haichuang.manni.event.EventCenter;

public class RegisterAty extends BaseAty {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.tv_code)
    EditText tvCode;
    @BindView(R.id.tv_send_code)
    TextView tvSendCode;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.et_pwd_affirm)
    EditText etPwdAffirm;
    @BindView(R.id.checkbox)
    AppCompatCheckBox checkbox;
    @BindView(R.id.tv_agreement)
    TextView tvAgreement;
    @BindView(R.id.tv_ok)
    TextView tvOk;
    @BindView(R.id.ll_agreement)
    LinearLayout llAgreement;

    private String type;

    @Override
    public int getLayout() {
        return R.layout.aty_register;
    }

    @Override
    protected void initView() {
        type = getIntent().getStringExtra("type");
        if (type.equals("register")) {
            tvTitle.setText("注册");
        } else if (type.equals("forgetpwd")) {
            tvTitle.setText("重置密码");
            llAgreement.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onEventData(EventCenter center) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_send_code, R.id.tv_agreement, R.id.tv_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_send_code:
                break;
            case R.id.tv_agreement:
                break;
            case R.id.tv_ok:
                break;
        }
    }
}

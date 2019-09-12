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
import pro.haichuang.manni.event.EventCenter;

public class LoginActivity extends BaseAty {

    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.ed_password)
    EditText edPassword;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.tv_forget)
    TextView tvForget;
    @BindView(R.id.tv_login)
    TextView tvLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        edPhone.setText("123456789");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onEventData(EventCenter center) {

    }

    @OnClick({R.id.tv_register, R.id.tv_forget, R.id.tv_login})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.tv_register:
                intent = new Intent(LoginActivity.this, RegisterAty.class);
                intent.putExtra("type", "register");
                break;
            case R.id.tv_forget:
                intent = new Intent(LoginActivity.this, RegisterAty.class);
                intent.putExtra("type", "forgetpwd");
                break;
            case R.id.tv_login:
                Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}

package pro.haichuang.manni.aty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.haichuang.manni.R;
import pro.haichuang.manni.base.BaseAty;
import pro.haichuang.manni.data.Constant;
import pro.haichuang.manni.event.EventCenter;
import pro.haichuang.manni.util.ToastUtil;

public class AgreementAty extends BaseAty {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.checkbox)
    AppCompatCheckBox checkbox;
    @BindView(R.id.tv_agreement)
    TextView tvAgreement;
    @BindView(R.id.tv_next)
    TextView tvNext;
    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    public int getLayout() {
        return R.layout.aty_agreement;
    }

    @Override
    protected void initView() {
        tvTitle.setText("付费协议");
    }

    @Override
    protected void initData() {
        tvContent.setText(Constant.agreement);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    checkbox.setChecked(true);
                }else {
                    checkbox.setChecked(false);
                }
            }
        });
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

    @OnClick({R.id.tv_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_next:
                if (checkbox.isChecked()==false){
                    ToastUtil.toast("您未同意付费协议");
                    return;
                }
                Intent intent = new Intent(AgreementAty.this, AboutPhoneAty.class);
                intent.putExtra("type","verify");
                startActivity(intent);
                break;
        }
    }
}

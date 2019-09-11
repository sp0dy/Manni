package pro.haichuang.manni.aty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.haichuang.manni.R;
import pro.haichuang.manni.base.BaseAty;
import pro.haichuang.manni.event.EventCenter;

public class MyInfoAty extends BaseAty {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.img_icon)
    RoundedImageView imgIcon;
    @BindView(R.id.img_icon_more)
    ImageView imgIconMore;
    @BindView(R.id.rl_icon)
    RelativeLayout rlIcon;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.img_name_more)
    ImageView imgNameMore;
    @BindView(R.id.rl_name)
    RelativeLayout rlName;
    @BindView(R.id.tv_vip)
    TextView tvVip;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.img_phone_more)
    ImageView imgPhoneMore;
    @BindView(R.id.rl_phone)
    RelativeLayout rlPhone;

    @Override
    public int getLayout() {
        return R.layout.aty_myinfo;
    }

    @Override
    protected void initView() {
        tvTitle.setText("个人信息");
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

    @OnClick({R.id.rl_icon, R.id.rl_name, R.id.rl_phone})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.rl_icon:

                break;
            case R.id.rl_name:
                intent = new Intent(MyInfoAty.this,EditMyInfoAty.class);
                break;
            case R.id.rl_phone:
                intent = new Intent(MyInfoAty.this,AboutPhoneAty.class);
                intent.putExtra("type","edit");
                break;
        }
        if (null!=intent){
            startActivity(intent);
        }
    }
}

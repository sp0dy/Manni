package pro.haichuang.manni.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import pro.haichuang.manni.R;
import pro.haichuang.manni.aty.AgreementAty;
import pro.haichuang.manni.base.BaseFgm;
import pro.haichuang.manni.data.Constant;
import pro.haichuang.manni.event.EventCenter;

public class VipFgm extends BaseFgm {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_not_vip)
    TextView tvNotVip;
    @BindView(R.id.tv_open)
    TextView tvOpen;
    @BindView(R.id.tv_refund)
    RelativeLayout tvRefund;
    @BindView(R.id.rl_vip)
    LinearLayout rlVip;
    @BindView(R.id.rl_ali_pay)
    RelativeLayout rlAliPay;
    @BindView(R.id.rl_wx_pay)
    RelativeLayout rlWxPay;
    @BindView(R.id.tv_go_pay)
    TextView tvGoPay;
    @BindView(R.id.rl_vip_pay)
    RelativeLayout rlVipPay;
    Unbinder unbinder;
    @BindView(R.id.rl_not_vip)
    RelativeLayout rlNotVip;

    @Override
    protected int getContentId() {
        return R.layout.fgm_vip;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onEventComing(EventCenter center) {
        //第一次进入并已同意协议和验证信息，显示充值界面
        if (center.getEventCode() == Constant.CLOSE_VIP_ATY) {
            rlNotVip.setVisibility(View.GONE);
            rlVipPay.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_open, R.id.tv_refund, R.id.tv_go_pay})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.tv_open:
                intent = new Intent(getContext(), AgreementAty.class);
                break;
            case R.id.tv_refund:
                break;
            case R.id.tv_go_pay:
                intent = new Intent();
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}

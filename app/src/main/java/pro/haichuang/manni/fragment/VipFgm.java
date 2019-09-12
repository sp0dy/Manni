package pro.haichuang.manni.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.sql.Ref;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import pro.haichuang.manni.R;
import pro.haichuang.manni.aty.AgreementAty;
import pro.haichuang.manni.aty.RefundAty;
import pro.haichuang.manni.base.BaseFgm;
import pro.haichuang.manni.data.Constant;
import pro.haichuang.manni.event.EventCenter;

public class VipFgm extends BaseFgm {
    @BindView(R.id.tv_not_vip)
    TextView tvNotVip;
    @BindView(R.id.tv_open)
    TextView tvOpen;
    @BindView(R.id.tv_refund)
    RelativeLayout tvRefund;
    Unbinder unbinder;

    TextView tvTitle;
    RelativeLayout rlAliPay;
    RelativeLayout rlWxPay;
    TextView tvGoPay;
    RelativeLayout rlVipPay;
    LinearLayout rlVip;
    RelativeLayout rlNotVip;
    ImageView ImgAli,ImgWx;

    @Override
    protected int getContentId() {
        return R.layout.fgm_vip;
    }

    @Override
    protected void initView() {
        tvTitle = view.findViewById(R.id.tv_title);
        rlVip = view.findViewById(R.id.rl_vip);
        rlVipPay = view.findViewById(R.id.rl_vip_pay);
        rlNotVip = view.findViewById(R.id.rl_not_vip);
        rlAliPay = view.findViewById(R.id.rl_ali_pay);
        rlWxPay = view.findViewById(R.id.rl_wx_pay);
        tvGoPay = view.findViewById(R.id.tv_go_pay);
        ImgAli = view.findViewById(R.id.img_selected_ali);
        ImgWx = view.findViewById(R.id.img_selected_wx);
//        rlVip.setVisibility(View.VISIBLE);
//        rlVipPay.setVisibility(View.GONE);
//        rlNotVip.setVisibility(View.GONE);

        tvTitle.setText("会员中心");
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

    @OnClick({R.id.tv_open, R.id.tv_refund, R.id.tv_go_pay,R.id.rl_ali_pay,R.id.rl_wx_pay})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.tv_open:
                intent = new Intent(getContext(), AgreementAty.class);
                break;
            case R.id.tv_refund:
                intent = new Intent(getContext(), RefundAty.class);
                break;
            case R.id.rl_ali_pay:
                ImgAli.setVisibility(View.VISIBLE);
                ImgWx.setVisibility(View.GONE);
                break;
            case R.id.rl_wx_pay:
                ImgAli.setVisibility(View.GONE);
                ImgWx.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_go_pay:
                rlVip.setVisibility(View.VISIBLE);
                rlVipPay.setVisibility(View.GONE);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}

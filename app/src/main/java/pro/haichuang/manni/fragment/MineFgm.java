package pro.haichuang.manni.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import pro.haichuang.manni.R;
import pro.haichuang.manni.aty.MyInfoAty;
import pro.haichuang.manni.base.BaseFgm;
import pro.haichuang.manni.event.EventCenter;

public class MineFgm extends BaseFgm {
    @BindView(R.id.img_icon)
    ImageView imgIcon;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_dianhua)
    TextView tvDianhua;
    @BindView(R.id.rl_account_safety)
    RelativeLayout rlAccountSafety;
    @BindView(R.id.tv_size)
    TextView tvSize;
    @BindView(R.id.rl_release)
    RelativeLayout rlRelease;
    @BindView(R.id.tv_login_out)
    TextView tvLoginOut;
    Unbinder unbinder;
    @BindView(R.id.rl_info)
    RelativeLayout rlInfo;

    @Override
    protected int getContentId() {
        return R.layout.fgm_mine;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onEventComing(EventCenter center) {

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

    @OnClick({R.id.rl_account_safety, R.id.rl_release, R.id.tv_login_out,R.id.rl_info})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.rl_account_safety:
                break;
            case R.id.rl_release:
                break;
            case R.id.tv_login_out:
                break;
            case R.id.rl_info:
                intent = new Intent(getContext(), MyInfoAty.class);
                break;
        }
        if (intent!=null){
            startActivity(intent);
        }
    }

}

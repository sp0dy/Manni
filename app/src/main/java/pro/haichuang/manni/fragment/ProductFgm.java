package pro.haichuang.manni.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.liaoinstan.springview.widget.SpringView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pro.haichuang.manni.R;
import pro.haichuang.manni.base.BaseFgm;
import pro.haichuang.manni.event.EventCenter;

public class ProductFgm extends BaseFgm {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.product_recy)
    RecyclerView productRecy;
    @BindView(R.id.spring_view)
    SpringView springView;
    Unbinder unbinder;

    @Override
    protected int getContentId() {
        return R.layout.fgm_product;
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
}

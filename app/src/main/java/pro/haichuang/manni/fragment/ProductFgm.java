package pro.haichuang.manni.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pro.haichuang.manni.R;
import pro.haichuang.manni.aty.adapter.HomeAdp;
import pro.haichuang.manni.base.BaseFgm;
import pro.haichuang.manni.dialog.VipDialog;
import pro.haichuang.manni.event.EventCenter;

public class ProductFgm extends BaseFgm {
    TextView tvTitle;
    RecyclerView productRecy;
    SpringView springView;
    Unbinder unbinder;

    private List<String> list;
    private LinearLayoutManager manager;
    private HomeAdp homeAdp;
    private VipDialog vipDialog;

    @Override
    protected int getContentId() {
        return R.layout.fgm_product;
    }

    @Override
    protected void initView() {
        tvTitle=view.findViewById(R.id.tv_title);
        productRecy = view.findViewById(R.id.product_recy);
        springView = view.findViewById(R.id.spring_view);
        tvTitle.setText("产品");

        springView.setHeader(new DefaultHeader(getContext()));
        springView.setFooter(new DefaultFooter(getContext()));
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        vipDialog = new VipDialog(getContext());
        list.add("asdasd");
        list.add("asdasd");
        list.add("asdasd");
        list.add("asdasd");
        list.add("asdasd");
        list.add("asdasd");
        manager = new LinearLayoutManager(getContext());
        productRecy.setLayoutManager(manager);
        homeAdp = new HomeAdp(list);
        productRecy.setAdapter(homeAdp);

        homeAdp.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                vipDialog.show();
            }
        });

        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                springView.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {
                springView.onFinishFreshAndLoad();
            }
        });
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

package pro.haichuang.manni.fragment;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import pro.haichuang.manni.R;
import pro.haichuang.manni.aty.adapter.HomeAdp;
import pro.haichuang.manni.base.BaseFgm;
import pro.haichuang.manni.data.Constant;
import pro.haichuang.manni.dialog.VipDialog;
import pro.haichuang.manni.event.EventCenter;

public class HomeFgm extends BaseFgm {
    @BindView(R.id.home_banner)
    Banner homeBanner;
    RecyclerView homeRecy;
    NestedScrollView scrollView;
    Unbinder unbinder;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    TextView tvMore;

    private List<String> list;
    private LinearLayoutManager manager;
    private HomeAdp homeAdp;
    private VipDialog vipDialog;

    @Override
    protected int getContentId() {
        return R.layout.fgm_home;
    }

    @Override
    protected void initView() {
        homeRecy = view.findViewById(R.id.home_recy);
        tvMore = view.findViewById(R.id.tv_more);
        scrollView = view.findViewById(R.id.scroll);
        manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
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
        homeRecy.setLayoutManager(manager);
        homeAdp = new HomeAdp(list);
        homeRecy.setAdapter(homeAdp);

        homeAdp.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                vipDialog.show();
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

    @OnClick(R.id.tv_more)
    public void onViewClicked() {
        EventBus.getDefault().post(new EventCenter<String>(Constant.MOVE_PRODUCT));
    }
}

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
import org.greenrobot.eventbus.EventBus;
import java.util.ArrayList;
import java.util.List;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import pro.haichuang.manni.R;
import pro.haichuang.manni.aty.adapter.HomeAdp;
import pro.haichuang.manni.base.BaseFgm;
import pro.haichuang.manni.custview.BannerViewPager;
import pro.haichuang.manni.data.Constant;
import pro.haichuang.manni.dialog.VipDialog;
import pro.haichuang.manni.event.EventCenter;

public class HomeFgm extends BaseFgm {
    BannerViewPager homeBanner;
    RecyclerView homeRecy;
    NestedScrollView scrollView;
    Unbinder unbinder;
    TextView tvTitle;
    TextView tvMore;

    private List<String> list;
    private List<String> imgs = new ArrayList<>();
    private LinearLayoutManager manager;
    private HomeAdp homeAdp;
    private VipDialog vipDialog;

    @Override
    protected int getContentId() {
        return R.layout.fgm_home;
    }

    @Override
    protected void initView() {
        homeBanner = view.findViewById(R.id.home_banner);
        homeRecy = view.findViewById(R.id.home_recy);
        tvTitle = view.findViewById(R.id.tv_title);
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

        imgs.add("http://www.07073.com/uploads/110414/845972_133840_1.jpg");
        imgs.add("http://img5.imgtn.bdimg.com/it/u=3987907653,720009510&fm=26&gp=0.jpg");
        imgs.add("http://pic13.nipic.com/20110304/5298727_235601547319_2.jpg");
        imgs.add("http://pic13.nipic.com/20110304/5298727_235601547319_2.jpg");
        imgs.add("http://pic38.nipic.com/20140304/2531170_094852103000_2.jpg");
        homeBanner.initBanner(imgs, true)//开启3D画廊效果
                .addPageMargin(10, 50)//参数1page之间的间距,参数2中间item距离边界的间距
                .addPoint(imgs.size())//添加指示器
                .addStartTimer(2)//自动轮播5秒间隔
                .addPointBottom(7)
                .addRoundCorners(12)//圆角
                .finishConfig()//这句必须加
                .addBannerListener(new BannerViewPager.OnClickBannerListener() {
                    @Override
                    public void onBannerClick(int position) {
                        //点击item
                    }
                });

        homeAdp.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                vipDialog.show();
            }
        });

//        homeBanner.setImages(imgs);
//        homeBanner.setImageLoader(new ImageLoader() {
//            @Override
//            public void displayImage(Context context, Object path, ImageView imageView) {
//                Glide.with(context).load(path).apply(new RequestOptions().error(R.mipmap.ic_launcher)).into(imageView);
//            }
//        });
//        homeBanner.start();
//        homeBanner.setOnBannerClickListener(new OnBannerClickListener() {
//            @Override
//            public void OnBannerClick(int position) {
//
//            }
//        });
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

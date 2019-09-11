package pro.haichuang.manni.aty;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.haichuang.manni.R;
import pro.haichuang.manni.base.BaseAty;
import pro.haichuang.manni.event.EventCenter;
import pro.haichuang.manni.fragment.HomeFgm;
import pro.haichuang.manni.fragment.MineFgm;
import pro.haichuang.manni.fragment.ProductFgm;
import pro.haichuang.manni.fragment.VipFgm;

public class MainActivity extends BaseAty {
    @BindView(R.id.rd_home)
    RadioButton rdHome;
    @BindView(R.id.rd_cp)
    RadioButton rdCp;
    @BindView(R.id.rd_vip)
    RadioButton rdVip;
    @BindView(R.id.rd_mine)
    RadioButton rdMine;
    @BindView(R.id.rd_group)
    RadioGroup rdGroup;
    @BindView(R.id.main_frag)
    FrameLayout mainFrag;

    private List<Fragment> fragmentList = new ArrayList<>();
    private FragmentTransaction transaction;
    private FragmentManager fm;
    private Fragment fragment;
    private int index = 0;

    @Override
    public int getLayout() {
        return R.layout.aty_main;
    }

    @Override
    protected void initView() {
        fragmentList = getFragment();
        fm = getSupportFragmentManager();
        transaction = fm.beginTransaction();
        this.fragment = fragmentList.get(0);
        rdHome.setChecked(true);

        transaction.replace(R.id.main_frag, this.fragment);
        transaction.commit();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onEventData(EventCenter center) {

    }

    private void changeUi(int i) {
        if (index == i) {
            return;
        }
        fm = getSupportFragmentManager();
        transaction = fm.beginTransaction();
        //隐藏上一个界面
        transaction.hide(fragmentList.get(index));
        //判断是否添加界面
        if (!fragmentList.get(i).isAdded()) {
            transaction.add(R.id.main_frag, fragmentList.get(i)).show(fragmentList.get(i));
        } else {
            transaction.show(fragmentList.get(i));
        }
        transaction.commit();
        index = i;
    }

    public List<Fragment> getFragment() {
        fragmentList.add(new HomeFgm());
        fragmentList.add(new ProductFgm());
        fragmentList.add(new VipFgm());
        fragmentList.add(new MineFgm());
        return fragmentList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rd_home, R.id.rd_cp, R.id.rd_vip, R.id.rd_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rd_home:
                changeUi(0);
                break;
            case R.id.rd_cp:
                changeUi(1);
                break;
            case R.id.rd_vip:
                changeUi(2);
                break;
            case R.id.rd_mine:
                changeUi(3);
                break;
        }
    }
}

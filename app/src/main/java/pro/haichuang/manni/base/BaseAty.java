package pro.haichuang.manni.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import butterknife.ButterKnife;
import pro.haichuang.manni.event.EventCenter;

public abstract class BaseAty extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        initView();
        initData();
    }

    public abstract int getLayout();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void onEventData(EventCenter center);

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(EventCenter center){
        if (null!=center){
            onEventData(center);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

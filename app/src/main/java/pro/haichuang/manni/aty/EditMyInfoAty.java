package pro.haichuang.manni.aty;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.haichuang.manni.R;
import pro.haichuang.manni.base.BaseAty;
import pro.haichuang.manni.data.Constant;
import pro.haichuang.manni.event.EventCenter;

public class EditMyInfoAty extends BaseAty {
    @BindView(R.id.tv_cancle)
    TextView tvCancle;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_ok)
    TextView tvOk;
    @BindView(R.id.et_name)
    EditText etName;

    @Override
    public int getLayout() {
        return R.layout.aty_editmyinfo;
    }

    @Override
    protected void initView() {
        tvTitle.setText("修改昵称");
        tvCancle.setVisibility(View.VISIBLE);
        tvOk.setVisibility(View.VISIBLE);
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

    @OnClick({R.id.tv_cancle, R.id.tv_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cancle:
                finish();
                break;
            case R.id.tv_ok:
                //TODO 网络请求上传名字成功返回结果
                EventBus.getDefault().post(new EventCenter(Constant.UPDATA_NAME,etName.getText().toString()));
                finish();
                break;
        }
    }
}

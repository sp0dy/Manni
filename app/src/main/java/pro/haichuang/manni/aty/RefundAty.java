package pro.haichuang.manni.aty;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.haichuang.manni.R;
import pro.haichuang.manni.base.BaseAty;
import pro.haichuang.manni.event.EventCenter;

/**
 * @ProjectName: Manni
 * @Package: pro.haichuang.manni.aty
 * @ClassName: RefundAty
 * @Description: java类作用描述
 * @Author: 作者名:zhouyan
 * @CreateDate: 2019/9/11 23:13
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/9/11 23:13
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class RefundAty extends BaseAty {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_ali_account)
    EditText tvAliAccount;
    @BindView(R.id.recy_photo)
    RecyclerView recyPhoto;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.et_remark)
    EditText etRemark;
    @BindView(R.id.et_product)
    EditText etProduct;
    @BindView(R.id.tv_commit)
    TextView tvCommit;

    @Override
    public int getLayout() {
        return R.layout.aty_refund;
    }

    @Override
    protected void initView() {

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

    @OnClick(R.id.tv_commit)
    public void onViewClicked() {
    }
}

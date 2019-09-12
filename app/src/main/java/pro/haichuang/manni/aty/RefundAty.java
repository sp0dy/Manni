package pro.haichuang.manni.aty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.haichuang.manni.R;
import pro.haichuang.manni.aty.adapter.ImgsAdp;
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

    private String img_path;
    private ImgsAdp imgsAdp;
    private List<String> imglist;

    @Override
    public int getLayout() {
        return R.layout.aty_refund;
    }

    @Override
    protected void initView() {
        tvTitle.setText("退款");
    }

    @Override
    protected void initData() {
        imglist = new ArrayList<>();
        GridLayoutManager manager = new GridLayoutManager(this,3);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyPhoto.setLayoutManager(manager);
        imgsAdp = new ImgsAdp(this,imglist);
        recyPhoto.setAdapter(imgsAdp);
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
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PictureConfig.CHOOSE_REQUEST) {
            List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
            if (selectList.size() > 0) {
                if (selectList.get(0).isCut()) {
                    img_path = selectList.get(0).getCutPath();
                } else {
                    img_path = selectList.get(0).getPath();
                }
                imglist.add(img_path);
                imgsAdp.notifyDataSetChanged();
            }
        }
    }
}

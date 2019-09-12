package pro.haichuang.manni.aty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.haichuang.manni.R;
import pro.haichuang.manni.base.BaseAty;
import pro.haichuang.manni.data.Constant;
import pro.haichuang.manni.event.EventCenter;
import pro.haichuang.manni.util.CommonDialog;

public class MyInfoAty extends BaseAty {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.img_icon)
    RoundedImageView imgIcon;
    @BindView(R.id.img_icon_more)
    ImageView imgIconMore;
    @BindView(R.id.rl_icon)
    RelativeLayout rlIcon;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.img_name_more)
    ImageView imgNameMore;
    @BindView(R.id.rl_name)
    RelativeLayout rlName;
    @BindView(R.id.tv_vip)
    TextView tvVip;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.img_phone_more)
    ImageView imgPhoneMore;
    @BindView(R.id.rl_phone)
    RelativeLayout rlPhone;

    private String img_path;

    @Override
    public int getLayout() {
        return R.layout.aty_myinfo;
    }

    @Override
    protected void initView() {
        tvTitle.setText("个人信息");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onEventData(EventCenter center) {
        if (center.getEventCode()== Constant.UPDATA_NAME){
            tvName.setText(center.getData().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rl_icon, R.id.rl_name, R.id.rl_phone})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.rl_icon:
                toSelectPic();
                break;
            case R.id.rl_name:
                intent = new Intent(MyInfoAty.this,EditMyInfoAty.class);
                break;
            case R.id.rl_phone:
                intent = new Intent(MyInfoAty.this,AboutPhoneAty.class);
                intent.putExtra("type","edit");
                break;
        }
        if (null!=intent){
            startActivity(intent);
        }
    }


    /**
     * 选择图片上传
     */
    private void toSelectPic() {
        final CommonDialog.Builder builder = new CommonDialog.Builder(this).fullWidth().fromBottom()
                .setView(R.layout.dialog_mode_mine_abulm);
        builder.setOnClickListener(R.id.tv_cell, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
            }
        });
        builder.setOnClickListener(R.id.tv_xiangji, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
                PictureSelector.create(MyInfoAty.this)
                        .openCamera(PictureMimeType.ofImage())
                        .selectionMode(PictureConfig.SINGLE)
                        .withAspectRatio(1, 1)
                        .enableCrop(true)
                        .showCropFrame(false)
                        .showCropGrid(false)
                        .freeStyleCropEnabled(true)
                        .circleDimmedLayer(false)
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });
        builder.setOnClickListener(R.id.tv_xiangce, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
                PictureSelector.create(MyInfoAty.this)
                        .openGallery(PictureMimeType.ofImage())
                        .selectionMode(PictureConfig.SINGLE)
                        .withAspectRatio(1, 1)
                        .enableCrop(true)
                        .showCropFrame(false)
                        .showCropGrid(false)
                        .freeStyleCropEnabled(true)
                        .circleDimmedLayer(false)
                        .forResult(PictureConfig.CHOOSE_REQUEST);

            }
        });
        builder.create().show();
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
                Glide.with(this).load(img_path).into(imgIcon);
            }
        }
    }
}

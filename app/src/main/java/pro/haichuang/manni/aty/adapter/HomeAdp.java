package pro.haichuang.manni.aty.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import pro.haichuang.manni.R;

/**
 * @ProjectName: Manni
 * @Package: pro.haichuang.manni.aty.adapter
 * @ClassName: HomeAdp
 * @Description: java类作用描述
 * @Author: 作者名:zhouyan
 * @CreateDate: 2019/9/11 22:44
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/9/11 22:44
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class HomeAdp extends BaseQuickAdapter<String, BaseViewHolder> {
    public HomeAdp(@Nullable List<String> data) {
        super(R.layout.adp_home,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageView ImgIcon = helper.getView(R.id.img_icon);
        TextView tvTitle = helper.getView(R.id.tv_title);
        TextView tvContent = helper.getView(R.id.tv_content);
        RelativeLayout rlItem = helper.getView(R.id.rl_item);
    }
}

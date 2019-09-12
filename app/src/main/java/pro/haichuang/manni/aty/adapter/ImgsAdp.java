package pro.haichuang.manni.aty.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;

import java.util.List;
import pro.haichuang.manni.R;
import pro.haichuang.manni.aty.RefundAty;
import pro.haichuang.manni.util.CommonDialog;

public class ImgsAdp extends RecyclerView.Adapter<ImgsAdp.ViewHodler> {

    private Context context;
    private List<String> strings;

    public ImgsAdp(Context context, List<String> strings) {
        this.context = context;
        this.strings = strings;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adp_imgs, null);
        ViewHodler hodler = new ViewHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, final int position) {
        final CommonDialog.Builder builder = new CommonDialog.Builder(context).fullWidth().fromBottom()
                .setView(R.layout.dialog_mode_mine_abulm);

        if (strings != null && position< strings.size()){
            Glide.with(context).load(strings.get(position)).into(holder.img_circle);
            holder.img_circle.setVisibility(View.VISIBLE);
            holder.img_add.setVisibility(View.GONE);
            holder.tv_del.setVisibility(View.VISIBLE);
        } else {
            holder.img_circle.setVisibility(View.GONE);
            holder.img_add.setVisibility(View.VISIBLE);
            holder.tv_del.setVisibility(View.GONE);
        }
        holder.img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.create().show();
            }
        });
        holder.tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strings.remove(position);
                notifyDataSetChanged();
            }
        });

        builder.setOnClickListener(R.id.tv_xiangji, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
                PictureSelector.create((RefundAty)context)
                        .openCamera(PictureMimeType.ofImage())
                        .selectionMode(PictureConfig.SINGLE)
                        .withAspectRatio(1, 1)
                        .enableCrop(true)
                        .showCropFrame(false)
                        .showCropGrid(false)
                        .freeStyleCropEnabled(true)
                        .circleDimmedLayer(true)
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });
        builder.setOnClickListener(R.id.tv_xiangce, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
                PictureSelector.create((RefundAty)context)
                        .openGallery(PictureMimeType.ofImage())
                        .selectionMode(PictureConfig.SINGLE)
                        .withAspectRatio(1, 1)
                        .enableCrop(true)
                        .showCropFrame(false)
                        .showCropGrid(false)
                        .freeStyleCropEnabled(true)
                        .circleDimmedLayer(true)
                        .forResult(PictureConfig.CHOOSE_REQUEST);

            }
        });
    }

    @Override
    public int getItemCount() {
        if (strings.size() < 10) {
            return strings.size() + 1;
        }
        return strings.size();
    }

    class ViewHodler extends BaseViewHolder {
        ImageView img_circle, img_add;
        TextView tv_del;

        public ViewHodler(View view) {
            super(view);
            img_circle = view.findViewById(R.id.img_circle);
            img_add = view.findViewById(R.id.img_add);
            tv_del = view.findViewById(R.id.tv_del);
        }
    }

}

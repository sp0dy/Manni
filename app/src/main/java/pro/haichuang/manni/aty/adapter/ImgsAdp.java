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
import java.util.List;
import pro.haichuang.manni.R;
import pro.haichuang.manni.dialog.AbulmCameraDialog;

public class ImgsAdp extends RecyclerView.Adapter<ImgsAdp.ViewHodler> {

    private Context context;
    private List<String> strings;
    private AbulmCameraDialog abulmCameraDialog;

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
        abulmCameraDialog = new AbulmCameraDialog(context);
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
                abulmCameraDialog.showDialog();
            }
        });
        holder.tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strings.remove(position);
                notifyDataSetChanged();
            }
        });

//        abulmCameraDialog.setOnItemClickListener(new AbulmCameraDialog.OnItemClickListener() {
//            @Override
//            public void onItemListener(int choose) {
//                if (choose == abulmCameraDialog.TAKEPHOTO) {
//                    RxPermissions permissions = new RxPermissions((RefundAty) context);
//                    if (!permissions.isGranted(Manifest.permission.CAMERA)) {
//                        permissions.request(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO)
//                                .subscribe(new Observer<Boolean>() {
//                                    @Override
//                                    public void onSubscribe(Disposable d) {
//
//                                    }
//
//                                    @Override
//                                    public void onNext(Boolean aBoolean) {
//                                        Intent intent = new Intent(context, CameraActivity.class);
//                                        intent.putExtra("types","push");
//                                        context.startActivity(intent);
//                                        abulmCameraDialog.dismiss();
//                                    }
//
//                                    @Override
//                                    public void onError(Throwable e) {
//
//                                    }
//
//                                    @Override
//                                    public void onComplete() {
//
//                                    }
//                                });
//                    } else {
//                        Intent intent = new Intent(context, CameraActivity.class);
//                        intent.putExtra("types","push");
//                        context.startActivity(intent);
//                        abulmCameraDialog.dismiss();
//                    }
//                } else if (choose == abulmCameraDialog.AUBLUM) {
//                    RxPermissions permissions = new RxPermissions((AddPinGoodsAty) context);
//                    if (!permissions.isGranted(Manifest.permission.CAMERA)) {
//                        permissions.request(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO)
//                                .subscribe(new Observer<Boolean>() {
//                                    @Override
//                                    public void onSubscribe(Disposable d) {
//
//                                    }
//
//                                    @Override
//                                    public void onNext(Boolean aBoolean) {
//                                        if (aBoolean) {
//                                            EasyPhotos.createAlbum((AddPinGoodsAty) context, true, new MyGlideEngin())
//                                                    .setCount(1)
//                                                    .setFileProviderAuthority("com.xhc.merlot.cameraProvider")
//                                                    .start(AddPinGoodsAty.getPhoto());
//                                        }
//                                    }
//
//                                    @Override
//                                    public void onError(Throwable e) {
//
//                                    }
//
//                                    @Override
//                                    public void onComplete() {
//
//                                    }
//                                });
//                    } else {
//                        EasyPhotos.createAlbum((AddPinGoodsAty) context, true, new MyGlideEngin())
//                                .setCount(1)
//                                .setFileProviderAuthority("com.xhc.merlot.cameraProvider")
//                                .start(AddPinGoodsAty.getPhoto());
//                    }
//                    abulmCameraDialog.dismiss();
//                } else if (choose == abulmCameraDialog.CANCLE) {
//                    abulmCameraDialog.dismiss();
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        if (strings.size() < 6) {
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

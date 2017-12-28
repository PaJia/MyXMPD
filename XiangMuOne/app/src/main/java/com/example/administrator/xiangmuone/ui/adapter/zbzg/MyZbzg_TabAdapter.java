package com.example.administrator.xiangmuone.ui.adapter.zbzg;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.bean.zbzg.Zbzg_recyBean;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
public class MyZbzg_TabAdapter extends RecyclerView.Adapter<MyZbzg_TabAdapter.ViewHolder> {
    private List<Zbzg_recyBean.LiveBean> list;
    private Context mcontext;
    private TxVideoPlayerController mController;

    public MyZbzg_TabAdapter(List<Zbzg_recyBean.LiveBean> list, Context context) {
        this.list = list;
        this.mcontext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mcontext, R.layout.zbzg_fu_recy_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        mController = new TxVideoPlayerController(mcontext);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(list.get(position).getTitle());
        holder.textView1.setText(list.get(position).getBrief());
        mController.setTitle(null);
//        Glide.with(context).load(list.get(position).getImage()).into(holder.imageView);
        Glide.with(holder.itemView.getContext())
                .load(list.get(position).getImage())
                .crossFade()
                .into(mController.imageView());

        holder.imageView.setPlayerType(NiceVideoPlayer.TYPE_IJK); // or NiceVideoPlayer.TYPE_NATIVE
        holder.imageView.setUp("http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/14/bfe0d8eaad33462d8a6346820100f91b_h264818000nero_aac32.mp4", null);
        holder.imageView.setController(mController);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public NiceVideoPlayer imageView;
        private TextView textView, textView1;
        private CheckBox checkBox;

        public ViewHolder(final View itemView) {
            super(itemView);
            imageView = (NiceVideoPlayer) itemView.findViewById(R.id.zbzg_video_player);
            textView = (TextView) itemView.findViewById(R.id.xmzb_zb_bt);
            textView1 = (TextView) itemView.findViewById(R.id.xmzb_xy);
            checkBox = (CheckBox) itemView.findViewById(R.id.xmzb_zb_sx);

            checkBox.setButtonDrawable(R.drawable.live_china_detail_down);


            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        textView1.setVisibility(View.GONE);
                        checkBox.setButtonDrawable(R.drawable.live_china_detail_down);
                    } else {
                        checkBox.setButtonDrawable(R.drawable.live_china_detail_up);
                        textView1.setVisibility(View.VISIBLE);
                    }
                }

            });



        }

    }


}

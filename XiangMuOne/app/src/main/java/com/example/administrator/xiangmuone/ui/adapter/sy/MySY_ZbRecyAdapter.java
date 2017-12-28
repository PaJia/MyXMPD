package com.example.administrator.xiangmuone.ui.adapter.sy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.bean.sy.ShouYeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
public class MySY_ZbRecyAdapter extends RecyclerView.Adapter<MySY_ZbRecyAdapter.ViewHolder> implements View.OnClickListener {
    List<ShouYeBean.DataBean.ChinaliveBean.ListBeanX> list;
    Context context;

    public MySY_ZbRecyAdapter(List<ShouYeBean.DataBean.ChinaliveBean.ListBeanX> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.myrecy_item,null);
        ViewHolder viewHolder=new ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.imageView);
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.xc_image);
            textView= (TextView) itemView.findViewById(R.id.xc_te);
        }
    }

    public interface OnClickItem {
        void setClick(View v, int position);
    }

    private OnClickItem item=null;

    @Override
    public void onClick(View v) {
        if (item != null) {
            item.setClick(v, (int) v.getTag());
        }
    }

    public void setOnClick(OnClickItem item) {
        this.item = item;
    }
}

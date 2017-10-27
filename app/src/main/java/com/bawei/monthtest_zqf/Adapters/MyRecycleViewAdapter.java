package com.bawei.monthtest_zqf.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.monthtest_zqf.JavaBean.NewBean;
import com.bawei.monthtest_zqf.R;
import com.bawei.monthtest_zqf.Utils.ImageLoaderUtils;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> implements View.OnClickListener {
    private NewBean bean;
    private Context context;
    private View view;

    public MyRecycleViewAdapter(NewBean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.item, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return myViewHolder;
    }

    @Override
    public void onClick(View view) {
        if(mMyItemclickListener!=null){
//            mMyItemclickListener.itemclick(view, (Integer) view.getTag());
            mMyItemclickListener.itemclick(view, (Integer) view.getTag());
        }
    }

    public interface MyItemclickListener{
        void itemclick(View view, int position);
    }
    public MyItemclickListener mMyItemclickListener;

    public void setmMyItemclickListener(MyItemclickListener mMyItemclickListener) {
        this.mMyItemclickListener = mMyItemclickListener;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvTitle.setText(bean.apk.get(position).name);
        holder.tvContent.setText(bean.apk.get(position).categoryName);
        ImageLoaderUtils.setImageView(bean.apk.get(position).iconUrl,context,holder.image);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return bean.apk.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView image;
        private final TextView tvTitle;
        private final TextView tvContent;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvContent = itemView.findViewById(R.id.tvContent);
        }
    }
}
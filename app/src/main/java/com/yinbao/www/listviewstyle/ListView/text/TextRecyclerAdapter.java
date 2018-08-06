package com.yinbao.www.listviewstyle.ListView.text;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yinbao.www.listviewstyle.R;

import java.util.List;

/**
 * 创建时间:2018/7/30
 * 编写人:Administrator
 * 包名路径:com.yinbao.www.listviewstyle.ListView.text
 * 功能描述:
 */

public class TextRecyclerAdapter extends RecyclerView.Adapter<TextRecyclerAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private Context mContext;

    public TextRecyclerAdapter(List<String> list, Context context) {
        mData = list;
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_text_list_view, null);
        //设置item的宽高（宽最大，高根据内容）
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,  int position) {
        String data=mData.get(position);
        holder.mTextView.setText(data);
        if (mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(v,pos);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mData.size() > 0 ? mData.size() : 0;
    }

    //自定义ViewHolder，用于加载图片
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        ViewHolder(View view) {
            super(view);
            mTextView= (TextView) view.findViewById(R.id.id_tv_item_text_list_view);
        }
    }


    //---------------------------点击事件----------------------------------
    public interface OnItemListener {
        void onItemClick(View view, int position);
    }

    private OnItemListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }



}

package com.yinbao.www.listviewstyle.ListView.select;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yinbao.www.listviewstyle.R;

import java.util.List;

/**
 * 创建时间:2018/7/28
 * 编写人:Administrator
 * 包名路径:com.yinbao.www.listviewstyle.ListView.text
 * 功能描述:
 * 1，选择状态的适配器
 */

public class SelectAdapter extends BaseAdapter {

    private List<SelectDataBean> mData;
    private LayoutInflater mInflater;

    public SelectAdapter(Context context, List<SelectDataBean> data) {
        mData = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size() > 0 ? mData.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SelectDataBean data = mData.get(position);
        ViewHolder mViewHolder = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = mInflater.inflate(R.layout.item_select_list_view, null);
            mViewHolder = new ViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mImageView.setImageResource(R.mipmap.ic_launcher);
        mViewHolder.mTextView.setText(data.getData());

        if (data.getStatus() == 1) {
            mViewHolder.mImgSelect.setVisibility(View.VISIBLE);//显示
        } else {
            mViewHolder.mImgSelect.setVisibility(View.INVISIBLE);//隐藏，但是占位置

        }

        return convertView;
    }


    private static class ViewHolder {
        ImageView mImageView;
        TextView mTextView;
        ImageView mImgSelect;

        ViewHolder(View view) {
            mImageView = (ImageView) view.findViewById(R.id.id_img_item_list_view);
            mTextView = (TextView) view.findViewById(R.id.id_tv_item_list_view);
            mImgSelect = (ImageView) view.findViewById(R.id.id_img_ok_item_list_view);
        }
    }

}

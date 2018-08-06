package com.yinbao.www.listviewstyle.ListView.group;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yinbao.www.listviewstyle.R;

import java.util.List;

/**
 * 创建时间:2018/7/28
 * 编写人:Administrator
 * 包名路径:com.yinbao.www.listviewstyle.ListView.text
 * 功能描述:
 */

public class TextGroupAdapter extends BaseAdapter {

    private List<TypeDataBean> mData;
    private LayoutInflater mInflater;
    private Context mContext;
    /**
     * 旧分组号
     */
    private int oldGroupId;

    public TextGroupAdapter(Context context, List<TypeDataBean> data) {
        mData = data;
        mContext = context;
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


    /**
     * 分组的关键点
     *
     * @return
     */
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getGroupId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TypeDataBean data = mData.get(position);
        ViewHolder mViewHolder = null;
        int group = getItemViewType(position);
        if (group == 1) {
            if (oldGroupId == group) {
                if (convertView == null || convertView.getTag() == null) {
                    convertView = mInflater.inflate(R.layout.item_group_text_list_view, null);
                    mViewHolder = new ViewHolder(convertView);
                    convertView.setTag(mViewHolder);
                } else {
                    mViewHolder = (ViewHolder) convertView.getTag();
                }

            } else {
                convertView = mInflater.inflate(R.layout.item_group_text_list_view, null);
                mViewHolder = new ViewHolder(convertView);
                convertView.setTag(mViewHolder);
                oldGroupId = group;
            }
            convertView.setBackgroundColor(mContext.getResources().getColor(R.color.colorAccent));
            mViewHolder.mGroupTextView.setText(data.getData().getGroupName());
        } else {
            if (oldGroupId == group) {
                if (convertView == null || convertView.getTag() == null) {
                    convertView = mInflater.inflate(R.layout.item_text_list_view, null);
                    mViewHolder = new ViewHolder(convertView);
                    convertView.setTag(mViewHolder);
                } else {
                    mViewHolder = (ViewHolder) convertView.getTag();
                }
            } else {
                convertView = mInflater.inflate(R.layout.item_text_list_view, null);
                mViewHolder = new ViewHolder(convertView);
                convertView.setTag(mViewHolder);
                oldGroupId = group;
            }

            mViewHolder.mTextView.setText(data.getData().getData());

        }


        return convertView;
    }


    static class ViewHolder {
        TextView mTextView;
        TextView mGroupTextView;

        public ViewHolder(View view) {
            mTextView = (TextView) view.findViewById(R.id.id_tv_item_text_list_view);
            mGroupTextView = (TextView) view.findViewById(R.id.id_tv_group_title);
        }
    }

}

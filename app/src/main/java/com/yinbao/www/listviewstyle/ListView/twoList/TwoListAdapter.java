package com.yinbao.www.listviewstyle.ListView.twoList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yinbao.www.listviewstyle.R;

import java.util.List;
import java.util.Map;

/**
 * 创建时间:2018/7/28
 * 编写人:Administrator
 * 包名路径:com.yinbao.www.listviewstyle.ListView.text
 * 功能描述:
 */

public class TwoListAdapter extends BaseExpandableListAdapter {

    private List<String> mGroupList;
    private Map<String, List<String>> mChildMap;
    private LayoutInflater mInflater;

    /**
     * @param context
     * @param groupList
     * @param chilMap
     */
    public TwoListAdapter(Context context, List<String> groupList, Map<String,
        List<String>> chilMap) {
        mGroupList = groupList;
        mChildMap = chilMap;
        mInflater = LayoutInflater.from(context);
    }

    /**
     * 分组数
     *
     * @return
     */
    @Override
    public int getGroupCount() {
        return mGroupList.size();
    }

    /**
     * 子分组数
     *
     * @param groupPosition
     *
     * @return
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        String key = mGroupList.get(groupPosition);
        return mChildMap.get(key).size();
    }

    /**
     * 获取指定分组名
     *
     * @param groupPosition
     *
     * @return
     */
    @Override
    public Object getGroup(int groupPosition) {
        return mGroupList.get(groupPosition);
    }

    /**
     * 获取指定分组下面子分组的数据
     *
     * @param groupPosition
     * @param childPosition
     *
     * @return
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        String key = mGroupList.get(groupPosition);
        List<String> mList = mChildMap.get(key);
        return mList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        //每个item的id是否是固定？一般为true
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String mName = (String) getGroup(groupPosition);//获取当前分组名称
        ViewHolderGroup mViewHolderGroup = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = mInflater.inflate(R.layout.item_text_list_view, null);
            mViewHolderGroup = new ViewHolderGroup(convertView);
            convertView.setTag(mViewHolderGroup);
        } else {
            mViewHolderGroup = (ViewHolderGroup) convertView.getTag();
        }
        mViewHolderGroup.mTextView.setText(mName);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String mData = (String) getChild(groupPosition,childPosition);//获取当前分组下子分组名称

        ViewHolderChild mViewHolderChild = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = mInflater.inflate(R.layout.item_img_text_list_view, null);
            mViewHolderChild = new ViewHolderChild(convertView);
            convertView.setTag(mViewHolderChild);
        } else {
            mViewHolderChild = (ViewHolderChild) convertView.getTag();
        }
        mViewHolderChild.mTextView.setText(mData);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        //二级列表中的item是否能够被选中？可以改为true
        return true;
    }


    /**
     * 分组布局
     */
    private static class ViewHolderGroup {
        TextView mTextView;

        ViewHolderGroup(View view) {
            mTextView = (TextView) view.findViewById(R.id.id_tv_item_text_list_view);
        }
    }


    /**
     * 子分组布局
     */
    private static class ViewHolderChild {
        ImageView mImageView;
        TextView mTextView;

        ViewHolderChild(View view) {
            mImageView = (ImageView) view.findViewById(R.id.id_img_item_list_view);
            mTextView = (TextView) view.findViewById(R.id.id_tv_item_list_view);
        }
    }

}

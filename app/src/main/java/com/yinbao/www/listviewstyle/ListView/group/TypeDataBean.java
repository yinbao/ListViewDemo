package com.yinbao.www.listviewstyle.ListView.group;

/**
 * 创建时间:2018/7/30
 * 编写人:Administrator
 * 包名路径:com.yinbao.www.listviewstyle.ListView.group
 * 功能描述:
 * 1,分组内容的对象
 */

public class TypeDataBean {

    /**
     * 分组ID(是否为标题)
     */
    private int mGroupId;
    /**
     * 内容
     */
    private GroupDataBean mData;


    public TypeDataBean(int groupId, GroupDataBean data) {
        mGroupId = groupId;
        mData = data;
    }

    public int getGroupId() {
        return mGroupId;
    }

    public void setGroupId(int groupId) {
        mGroupId = groupId;
    }

    public GroupDataBean getData() {
        return mData;
    }

    public void setData(GroupDataBean data) {
        mData = data;
    }
}

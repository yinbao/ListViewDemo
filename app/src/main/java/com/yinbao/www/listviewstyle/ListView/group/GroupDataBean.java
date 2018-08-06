package com.yinbao.www.listviewstyle.ListView.group;

/**
 * 创建时间:2018/7/30
 * 编写人:Administrator
 * 包名路径:com.yinbao.www.listviewstyle.ListView.group
 * 功能描述:
 * 1,内容的对象
 *
 */

public class GroupDataBean {

    /**
     * 分组名称
     */
    private String mGroupName;
    /**
     * 内容
     */
    private String mData;

    public GroupDataBean(String groupName, String data) {
        mGroupName = groupName;
        mData = data;
    }

    public String getGroupName() {
        return mGroupName;
    }

    public void setGroupName(String groupName) {
        mGroupName = groupName;
    }

    public String getData() {
        return mData;
    }

    public void setData(String data) {
        mData = data;
    }


}

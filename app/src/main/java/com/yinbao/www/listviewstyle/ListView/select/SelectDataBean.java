package com.yinbao.www.listviewstyle.ListView.select;

/**
 * 创建时间:2018/8/4
 * 编写人:Administrator
 * 包名路径:com.yinbao.www.listviewstyle.ListView.select
 * 功能描述:
 * 1，选择设备的数据bean
 */

public class SelectDataBean {


    /**
     * 数据
     */
    private String mData;
    /**
     * 状态，0未选中，1选中
     */
    private int status;

    public SelectDataBean(String data, int status) {
        mData = data;
        this.status = status;
    }

    public String getData() {
        return mData;
    }

    public void setData(String data) {
        mData = data;
    }

    /**
     * 0未选中，1选中
     * @return
     */
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "selectDataBean{" +
            "mData='" + mData + '\'' +
            ", status=" + status +
            '}';
    }
}

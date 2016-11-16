package com.nlte.usersys.usermgr.domain;

import java.sql.ResultSet;

/**分页时所需要的信息
 * Created by hp on 2016/11/11.
 */
public class DataPage {

    private int curPage = 0;//当前页码
    private int pageSizes = 20;//每页记录数
    private int pages;//总页数
    private int totalRows; //总记录数
    private ResultSet data;//当前页数据

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageSizes() {
        return pageSizes;
    }

    public void setPageSizes(int pageSizes) {
        this.pageSizes = pageSizes;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public ResultSet getData() {
        return data;
    }

    public void setData(ResultSet data) {
        this.data = data;
    }
}

package back.bean;

import java.util.List;

public class Pagebean {
    int totalDate;//
    int totalPage;
    int pageDate;//
    int currentPage = 1;//
    int pageBegin;
    int pageEnd;
    List list;

    public Pagebean() {
    }

    public Pagebean(int totalDate, int totalPage, int pageDate, int currentPage, int pageBegin, int pageEnd, List list) {
        this.totalDate = totalDate;
        this.totalPage = totalPage;
        this.pageDate = pageDate;
        this.currentPage = currentPage;
        this.pageBegin = pageBegin;
        this.pageEnd = pageEnd;
        this.list = list;
    }

    public int getTotalDate() {
        return totalDate;
    }

    public void setTotalDate(int totalDate) {
        this.totalDate = totalDate;
    }

    public int getTotalPage() {
        if (totalDate % pageDate == 0) return totalDate / pageDate;
        return (totalDate / pageDate) + 1;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageDate() {
        return pageDate;
    }

    public void setPageDate(int pageDate) {
        this.pageDate = pageDate;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageBegin() {
        return (currentPage - 1) * pageDate;
    }

    public void setPageBegin(int pageBegin) {
        this.pageBegin = pageBegin;
    }

    public int getPageEnd() {
        return currentPage * pageDate;
    }

    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}

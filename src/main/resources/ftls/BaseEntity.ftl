package ${BasePackageName}base;

import java.io.Serializable;

/**
 * 对象实体通用辅助Entity（含非数据库字段）
 * Author ${Author}
 * Date  ${Date}
 */
public class BaseEntity implements Serializable {

    private String pageNum;//当前页数

    private String pageSize;//每页数量

    private String totalCount;//总数

    private String[] orders;//排序字段

    public BaseEntity() {

    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String[] getOrders() {
        return orders;
    }

    public void setOrders(String[] orders) {
        this.orders = orders;
    }

}

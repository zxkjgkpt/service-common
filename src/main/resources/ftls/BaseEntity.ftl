package ${BasePackageName}base;

import java.io.Serializable;

/**
 * 对象实体通用辅助Entity（含非数据库字段）
 * Author ${Author}
 * Date  ${Date}
 */
public class BaseEntity implements Serializable {

    private Integer pageNum;//当前页数

    private Integer pageSize;//每页数量

    private Integer pageCount;//总页数

    private Long total;//总数

    private String[] orders;//排序字段

    public BaseEntity() {

    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String[] getOrders() {
        return orders;
    }

    public void setOrders(String[] orders) {
        this.orders = orders;
    }

}

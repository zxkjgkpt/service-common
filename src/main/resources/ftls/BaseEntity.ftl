package ${BasePackageName}base;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Map;

/**
 * 对象实体通用辅助Entity（含非数据库字段）
 * Author ${Author}
 * Date  ${Date}
 */
public class BaseEntity implements Serializable {

    public final static String ASC = "ASC";//升序
    public final static String DESC = "DESC";//降序

    @Transient
    private Integer pageNum;//当前页数

    @Transient
    private Integer pageSize;//每页数量

    @Transient
    private Integer pageCount;//总页数

    @Transient
    private Long total;//总数

    @Transient
    private String[] orders;//排序字段

    @Transient
    private Map<String, String> orders;//排序字段及排序方式（升序，降序）

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

    public Map<String, String> getOrders() {
        return orders;
    }

    public void setOrders(Map<String, String> orders) {
        this.orders = orders;
    }

}

package lisboyblog.service.admin;

import lisboyblog.pojo.Lable;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/15 21:37
 */
public interface LableService {
    /**
     * 添加一个新的标签
     * @param lable
     */
    void addlable(String lable);

    /**
     * 获取所有标签
     * @return
     */
    List<Lable> findAll();

    /**
     * 根据id删除标签
     * @param id
     */
    void deletelable(Long id);
}

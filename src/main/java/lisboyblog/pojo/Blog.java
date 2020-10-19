package lisboyblog.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/7/16 21:42
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Blog implements Serializable {

    @TableId
    private Long id;

    //主题图片
    private String imgs;

    //发表人
    private String name;

    //标题
    private String title;

    //分类
    private String category;

    //正文
    private String text;

    //点赞数量
    private Long likes;

    //收藏人数
    private Long views;

    //是否上推荐
    private String recommend;

    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date creationtime;

    //更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatetime;

}

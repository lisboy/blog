package lisboyblog.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/9/10 9:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {

    private Long id;

    //博客名
    private String blogname;

    //博客url
    private String url;

    //博客logo
    private String logo;

    //介绍
    private String introduction;

    //分类
    private String classification;

    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date creationtime;

    //更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatetime;
}

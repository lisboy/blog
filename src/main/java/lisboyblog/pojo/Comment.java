package lisboyblog.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/16 23:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @TableId
    private Long id;

    //博客id
    private Long blogid;

    //评论人
    private String name;

    //评论人email
    private String email;

    //评论内容
    private String content;

    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date creationtime;

    //更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatetime;
}

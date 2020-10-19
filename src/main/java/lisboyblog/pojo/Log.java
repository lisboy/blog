package lisboyblog.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/16 13:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log implements Serializable {

    private Long id;

    //日志内容
    private String log;

    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date creationtime;

    //更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatetime;
}

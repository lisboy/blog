package lisboyblog.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/15 21:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lable {

    @TableId
    private Long id;
    //标签
    private String lable;
}

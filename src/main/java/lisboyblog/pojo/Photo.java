package lisboyblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/17 19:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photo {

    private Long id;

    //图片地址
    private String url;
}

package lisboyblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/17 10:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Furl {

    private Long id;

    //下载介绍
    private String description;

    //连接url
    private String url;

    //链接密码
    private String pwd;
}

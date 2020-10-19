package lisboyblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/9/13 12:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pending {

    private Long id;
    private String blogname;
    private String url;
    private String logo;
    private String description;
    private String email;
}

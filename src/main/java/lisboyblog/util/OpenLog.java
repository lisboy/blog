package lisboyblog.util;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/16 13:48
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpenLog {

    String operModul() default ""; // 操作模块
    String operType() default "";  // 操作类型
    String operDesc() default "";  // 操作说明

}

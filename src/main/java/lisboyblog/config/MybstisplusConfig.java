package lisboyblog.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/10 19:49
 */
@Slf4j
@Configuration
@Component
public class MybstisplusConfig implements MetaObjectHandler {

    /**
     * 开启更新与添加时间戳
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start inset fill");
        this.setFieldValByName("creationtime", new Date(), metaObject);
        this.setFieldValByName("updatetime", new Date(), metaObject);
    }

    /**
     * 开启自动更新时间戳
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updatetime", new Date(), metaObject);
    }
}

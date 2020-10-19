package lisboyblog.util;

import lisboyblog.pojo.Log;
import lisboyblog.service.admin.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/16 13:54
 */
@Component
@Aspect
@Slf4j
public class UtilLog {

    @Autowired
    LogService logService;

    @Pointcut("@annotation(lisboyblog.util.OpenLog)")
    public void annotationPoinCut(){}

    /**
     * 获得添加log注解的注释
     * @param joinPoint
     * @throws Throwable
     */
    @Before("annotationPoinCut()")
    public void doAround(JoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        OpenLog openLog = method.getAnnotation(OpenLog.class);
        String type = openLog.operType();
        String modul = openLog.operModul();
        String desc = openLog.operDesc();
        String str="执行模块:"+modul+"----"+"执行方法:"+desc+"----"+"执行类型:"+type;
        logService.addLog(str);
    }

}

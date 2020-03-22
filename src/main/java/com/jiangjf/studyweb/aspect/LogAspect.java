package com.jiangjf.studyweb.aspect;

import com.jiangjf.studyweb.annotation.Log;
import com.jiangjf.studyweb.dao.SysLogDao;
import com.jiangjf.studyweb.domain.SysLog;
import com.jiangjf.studyweb.util.HttpContextUtils;
import com.jiangjf.studyweb.util.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogDao sysLogDao;

    @Pointcut("@annotation(com.jiangjf.studyweb.annotation.Log)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        Object obj = null;
        long beginTime = System.currentTimeMillis();
        Object[] args = point.getArgs();
        try {
            // 执行方法
            obj = point.proceed(args);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 执行时长（毫秒）
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(point, time);
        return obj;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            SysLog sysLog = new SysLog();
            Log logAnnotation = method.getAnnotation(Log.class);
            if (logAnnotation != null) {
                // 注解上的描述
                sysLog.setOperation(logAnnotation.value());
            }
            // 请求的方法名
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = signature.getName();
            sysLog.setMethod(className + "." + methodName + "()");
            // 请求的方法参数值
            Object[] args = joinPoint.getArgs();
            // 请求的方法参数名称
            LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
            String[] paramNames = u.getParameterNames(method);
            if (args != null && paramNames != null) {
                String params = "";
                for (int i = 0; i < args.length; i++) {
                    params += "  " + paramNames[i] + ": " + args[i];
                }
                sysLog.setParams(params);
            }
            // 获取request
            HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
            // 设置IP地址
            sysLog.setIp(IPUtils.getIpAddress(request));
            // 模拟一个用户名
            sysLog.setUsername("jiangjf");
            sysLog.setTime((int) time);
            Date date = new Date();
            sysLog.setCreateTime(date);
            // 保存系统日志
            sysLogDao.saveSysLog(sysLog);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

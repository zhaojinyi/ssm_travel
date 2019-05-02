package com.zjy.controller;

import com.zjy.domain.SysLog;
import com.zjy.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/2
 * @Description: com.zjy.controller
 */
@Component
@Aspect
public class LogAop {

    private Date visitTime;  // 开始时间
    private Class clazz;  //访问的类
    private Method method;  //访问的方法
    private String url;     // 访问的url
    private String ip;     //  访问的id地址
    private String username;
    private Long time;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    //前置通知    获取方法开始时间内，执行的类是哪一个，执行的是什么方法
    @Before("execution(* com.zjy.controller.*.*(..))")
    public void doBefore(JoinPoint point) throws NoSuchMethodException {
        visitTime = new Date();  // 当前时间就是开始时间
        clazz = point.getTarget().getClass();  // 具体的访问的类
        String methodName = point.getSignature().getName();  //  获取访问的方法的名称

        //  获取具体执行的方法的methods对象
        Object[] args = point.getArgs();
        if(args == null || args.length == 0) {
            method = clazz.getMethod(methodName);  //  只能获取带无参的方法
        } else {
            Class[] classArgs = new Class[args.length];
            for(int i=0; i<args.length; i++){
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, classArgs);
        }
    }

    //后置通知
    @After("execution(* com.zjy.controller.*.*(..))")
    public void doAfter(JoinPoint point){

        time = new Date().getTime() - visitTime.getTime();

        //  获取url
        if(clazz != null && method != null && clazz != LogAop.class) {
            //  获取类上的@RequestMapping("/order”)
            RequestMapping clazzAnnotation = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
            if(clazzAnnotation != null) {
                String[] classValue = clazzAnnotation.value();
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if(methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];
                    // 获取访问的ip地址
                    ip = request.getRemoteAddr();

                    //  通过springSecurity
                    //  如何获取当前操作的用户
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User)context.getAuthentication().getPrincipal();
                    username = user.getUsername();

                    // 通过session获取当前用户
                    // User users = (User)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");

                    //  将日志信息封装到SysLog对象
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutiontime(time);
                    sysLog.setIp(ip);
                    sysLog.setUrl(url);
                    sysLog.setVisittime(visitTime);
                    sysLog.setUsername(username);
                    sysLog.setMethod("[类名] "+clazz.getName()+"[方法名] "+method.getName());

                    //  调用service 完成添加
                    sysLogService.save(sysLog);
                }
            }

        }

    }

}

package com.example.sbjt.common.aspects;

import com.alibaba.fastjson.JSON;
import com.example.sbjt.common.annos.Alog;
import com.example.sbjt.common.beans.ALogVo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.rmi.server.LoaderHandler;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @auth: Created by zk on 2018/7/12
 * @description: 日志切面 通过jpa关联引入的
 */
@Aspect
@Component
public class AlogAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private ALogVo aLogVo = null;

    private Date start; //请求时间

    private Date end;  //响应时间

    private Map<String,Object> params = null;  //请求参数


    @Pointcut(value = "execution(* com.example.sbjt.web.controller.*.*(..))")
    public void controllerPointcut(){}

    @Before(value = "controllerPointcut()")
    public void doBofore(JoinPoint joinPoint) throws ClassNotFoundException {
        System.out.println("*******前置通知********");
        aLogVo = new ALogVo();
        start = new Date();

        HttpServletRequest request = getRequest();
        aLogVo.setC_uri(request.getRequestURI());

        Map<String, String[]> map = request.getParameterMap();
        params = new HashMap<>();
        if (map != null && map.size()>0){
            for (Map.Entry<String, String[]> entry : map.entrySet()) {
                params.put(entry.getKey(),entry.getValue()[0]);
            }
        }
        aLogVo.setFromParams(params);
        aLogVo.setB_methodType(request.getMethod());
        String targetName = joinPoint.getTarget().getClass().getName();
        System.out.println("目标类全路径名：" + targetName);

        String methodName = joinPoint.getSignature().getName();
        System.out.println("目标方法名（正在访问的方法）：" + methodName);

        Object[] args = joinPoint.getArgs(); //方法参数：数组类型
        System.out.println("方法参数：（数组类型的）");
        for (Object arg : args) {
            System.out.println(arg.toString());
        }
        Class aClass = Class.forName(targetName);
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)){
                Alog alog = method.getAnnotation(Alog.class);
                if(alog != null){
                    aLogVo.setA_methodName(alog.value());
                }else {
                    aLogVo.setA_methodName("该接口没有标注记录");
                }
            }
        }
    }

    //@Around(value = "controllerPointcut()")
    public void doRound(ProceedingJoinPoint joinPoint){
        System.out.println("********环绕通知开始********");

    }


    @After(value = "controllerPointcut()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("*******后置通知*******");
    }

    @AfterReturning(value = "controllerPointcut()",returning = "result")
    public void doAfterReturn(JoinPoint joinPoint,Object result){
        System.out.println("*******后置返回通知********");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        end = new Date();
        long time = end.getTime()-start.getTime();
        aLogVo.setD_startTime(sdf.format(start));
        aLogVo.setE_spendTime(String.valueOf(time) + "ms");
        aLogVo.setResult(result);

        log.debug("日志输出结果：alogVo-->{}",JSON.toJSONString(aLogVo));
    }

    @AfterThrowing(value = "controllerPointcut()")
    public void doAfterThrowing(){
        System.out.println("*********异常通知*********");
    }

    public HttpServletRequest getRequest(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return servletRequestAttributes.getRequest();
    }
}

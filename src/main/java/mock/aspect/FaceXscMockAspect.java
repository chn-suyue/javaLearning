package mock.aspect;

import mock.annotation.FaceXscMock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
public class FaceXscMockAspect {
    @Pointcut("@annotation(mock.annotation.FaceXscMock)")
    public void mockPointCut() {
    }

    @Around("mockPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        if (mockIfNecessary()) {
            return doMock(point);
        } else {
            return point.proceed();
        }
    }

    private boolean mockIfNecessary() {
        String xscMockFlag = "true";
//        String xscMockFlag = DynamicServerConfigAccessUtil.getValue("xsc.mock.flag", "false");
//        log.info("FaceXscMockAspect checkNeedMock xscMockFlag: {}", xscMockFlag);
        return "true".equals(xscMockFlag);
    }

    private Object doMock(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String result = null;
        if (method.isAnnotationPresent(FaceXscMock.class)) {
            //请求参数
            Object[] args = joinPoint.getArgs();
            String serviceId = args[1].toString();
//            log.info("FaceXscMockAspect doMock serviceId: {}", serviceId);
            switch (serviceId) {
                case "1001772":
                    //三要素认证
                    result = "";
                    break;
                case "1001549":
                    //人脸比对
                    result = "";
                    break;
                case "1002644":
                    //二要素认证
                    result = "";
                    break;
                default:
                    result = "";
                    break;
            }
        }
//        log.info("FaceXscMockAspect doMock result: {}", result);
        return result;
    }
}

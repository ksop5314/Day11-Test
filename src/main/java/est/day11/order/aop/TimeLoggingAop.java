package est.day11.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class TimeLoggingAop {

    @Pointcut("execution(* est.day11.order..*(..))")
    public void pointcut() {}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        long startTimeMs = System.currentTimeMillis();

        try {
            return joinPoint.proceed(); // 핵심 로직 실행
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        } finally {
            long endTimeMs = System.currentTimeMillis();
            log.info("메서드 실행 시간: {}ms", endTimeMs - startTimeMs);
        }
    }

}

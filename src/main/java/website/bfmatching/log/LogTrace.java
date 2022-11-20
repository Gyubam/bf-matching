package website.bfmatching.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogTrace {

    @Around("execution(* website.bfmatching.service..*(..))")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[log] {}", joinPoint.getSignature());

        Long startTimeMs = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        Long endTimeMs = System.currentTimeMillis();

        Long resultTimeMs = endTimeMs - startTimeMs;

        log.info("[log] Execution Time = {}ms", resultTimeMs);
        return result;
    }
}

package com.bankaya.core.aop;

import com.bankaya.core.model.WebLog;
import com.bankaya.core.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WebLogAspect {

    final LogRepository logRepository;

    @Around("@annotation(webLogAnnotation)")
    public Object log(ProceedingJoinPoint joinPoint,WebLogAnnotation webLogAnnotation) throws Throwable {

        logRepository.save(WebLog.builder()
                        .webMethod(webLogAnnotation.webMethod().name())
                        .originIp(getIp(joinPoint))
                        .requestDate(ZonedDateTime.now())
                .build());
        log.info("Log guardado correctamente - {}",ZonedDateTime.now());
        return joinPoint.proceed();
    }

    protected String getIp(JoinPoint point) {
        Object[] args = point.getArgs();
        return (String) args[1];
    }

}

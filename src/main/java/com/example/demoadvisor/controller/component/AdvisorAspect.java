package com.example.demoadvisor.controller.component;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.stream.Stream;

@Aspect
@Component
@Profile({"x", "component"})
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class AdvisorAspect {

    @Autowired
    private ApplicationContext applicationContext;

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RestController)")
    void restController() {
    }

    @SneakyThrows
    @Around("restController()")
    public Object invokeAdvisor(ProceedingJoinPoint pjp) {
        final var interfaceType = Stream.ofNullable(pjp.getTarget())
                .map(ClassUtils::getAllInterfacesAsSet)
                .flatMap(Collection::stream)
                .filter(superInterface -> superInterface.isAnnotationPresent(RequestMapping.class))
                .findAny();

        if (interfaceType.isPresent()
                && pjp.getSignature() instanceof MethodSignature) {
            final var clazz = interfaceType.get();
            final var advisorOrReal = applicationContext.getBean(clazz);
            final var signature = (MethodSignature) pjp.getSignature();
            return signature.getMethod().invoke(advisorOrReal, pjp.getArgs());
        }

        return pjp.proceed(pjp.getArgs());
    }

}
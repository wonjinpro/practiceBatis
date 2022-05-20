package com.wonjin.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationUse {
	
	@Pointcut(value="execution(* com.wonjin.member.service.MemberService.*(..))")
	public void pointcut1() {}
	
	@Before(value="pointcut1()")
	public void pringLog(JoinPoint jp) {
		String methodName= jp.getSignature().getName();
		System.out.println(methodName);
	}
}

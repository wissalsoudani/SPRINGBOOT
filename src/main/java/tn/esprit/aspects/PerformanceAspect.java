package tn.esprit.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

@Component
@Aspect
@Slf4j
public class PerformanceAspect {


	@Around("execution(* tn.esprit.Services.IClientService.addClient(..))")
	public Object executionTime(ProceedingJoinPoint pjp) throws Throwable {

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object obj = pjp.proceed();

		stopWatch.stop();

		String methodName = pjp.getSignature().getName();

		log.info("The runtime of the method ( "+ methodName + " ) = " + stopWatch.getTotalTimeMillis() + " milliseconds.");

		return obj;
	}
//	
	//@Around("execution(* tn.esprit.Services.IClientService.retrieveAllClients(..))")
	public List<Object> executionTime2(ProceedingJoinPoint pjp) throws Throwable {

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		List<Object> result = new ArrayList<Object>();
		result=	(List<Object>) pjp.proceed();

		stopWatch.stop();

		String methodName = pjp.getSignature().getName();

		log.info("The runtime of the method ( {} ) =  {}  milliseconds.",methodName,stopWatch.getTotalTimeMillis());

		return result;
	}


}
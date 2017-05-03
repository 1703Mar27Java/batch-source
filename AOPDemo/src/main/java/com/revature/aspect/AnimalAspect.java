package com.revature.aspect;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.revature.service.BearService;
import com.revature.service.TigerService;

@Aspect
@Component
public class AnimalAspect {
	
	//pointcuts get matched against public methods ONLY.
	
	@AfterReturning(
			pointcut="execution(* wake*(..))")
	public void afterWakeAnimal(JoinPoint jp){
		System.out.println("that was not a good choice.");
	}
	
	@Around("execution(* *CatchesYou(..))")
	public void afterCatchesYou(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("You're too slow");
		pjp.proceed();
		//System.out.println(pjp.getTarget());
		if (pjp.getTarget().toString().contains("BearService")){
			BearService bs = (BearService) pjp.getTarget();
			if(!bs.getBearFull()){
				bs.setBearFull(true);
				System.out.println("bear ate you");
			}else{
				System.out.println("bear hug, no noms");
			}
		}
		if (pjp.getTarget().toString().contains("TigerService")){
			TigerService ts = (TigerService) pjp.getTarget();
			if(!ts.getTigerFull()){
				ts.setTigerFull(true);
				System.out.println("tiger ate you");
			}else{
				System.out.println("tiger ate before its nap.");
			}
		}
	}
	
	

}

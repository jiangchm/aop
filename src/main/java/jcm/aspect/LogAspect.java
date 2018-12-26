package jcm.aspect;

import jcm.annotation.LogAnnotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Aspect
public class LogAspect {

	private Log log = LogFactory.getLog(getClass()) ;
	
	private String argsToJsonString(Object[] args){
		ObjectMapper om = new ObjectMapper() ;
		String argsStr = null ;
		try {
			argsStr = om.writeValueAsString(args) ;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return argsStr ;
	}
	
	@Before("@annotation(la)")
	public void before(JoinPoint pjp,LogAnnotation la){
		String classname = pjp.getSourceLocation().getWithinType().getName() ;
		String methodname = pjp.getSignature().getName() ;
		Object[] args = pjp.getArgs() ;
		if(la.needlog()){
			log.info("start invoking "+classname+",method:"+methodname+",parameter:"+argsToJsonString(args));
		}
	}
	
	@After("@annotation(la)")
	public void after(JoinPoint pjp,LogAnnotation la){
		String classname = pjp.getSourceLocation().getWithinType().getName() ;
		String methodname = pjp.getSignature().getName() ;
		Object[] args = pjp.getArgs() ;
		if(la.needlog()){
			log.info("end invoking "+classname+",method:"+methodname+",parameter:"+argsToJsonString(args));
		}
	}
	
}

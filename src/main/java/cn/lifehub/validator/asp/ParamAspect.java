package cn.lifehub.validator.asp;

import cn.lifehub.validator.comp.ParamterCheckComp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ParamAspect {
	@Autowired
	private ParamterCheckComp paramterCheckComp;

	@Pointcut("@annotation(ParamCheck)")
	public void check() {

	}

	@Around(value = "check()")
	public Object doBefore(JoinPoint joinPoint) throws Throwable {
		Object object = null;
		// 参数校验，未抛出异常表示验证OK
		long st = System.currentTimeMillis();
		// try {
		paramterCheckComp.checkValid(joinPoint.getSignature().getName(), joinPoint.getTarget(), joinPoint.getArgs());
		System.out.println("doBefore use time mills: " + (System.currentTimeMillis() - st));
		// } catch (Exception e) {
		// System.out.println("doBefore use time mills: " +
		// (System.currentTimeMillis() - st));
		// System.out.println(e.getMessage());
		// }
		object = ((ProceedingJoinPoint) joinPoint).proceed();
		return object;
	}

}

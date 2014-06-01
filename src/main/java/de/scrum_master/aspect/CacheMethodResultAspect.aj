package de.scrum_master.aspect;

import de.scrum_master.app.Cacheable;
import org.aspectj.lang.reflect.MethodSignature;

public aspect CacheMethodResultAspect {
	Object around() : execution(@Cacheable * *(..)) {
		System.out.println(thisJoinPointStaticPart);
		MethodSignature methodSignature = (MethodSignature) thisJoinPointStaticPart.getSignature();
		Cacheable cacheable = methodSignature.getMethod().getAnnotation(Cacheable.class);

		String cacheScope = cacheable.scope();
		System.out.println("  Cacheable scope:       " + cacheScope);

		String uniqueName = cacheable.uniqueName();
		System.out.println("  Cacheable unique name: " + uniqueName);

		String methodLine = methodSignature.getDeclaringTypeName() + "." + methodSignature.getName() +
			"@" + thisJoinPointStaticPart.getSourceLocation().getLine();
		System.out.println("  Method line:           " + methodLine);

		return proceed();
	}
}

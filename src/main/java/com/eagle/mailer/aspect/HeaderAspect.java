package com.eagle.mailer.aspect;

import java.util.Objects;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import com.eagle.mailer.context.MailerContext;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@AllArgsConstructor
@Slf4j
public class HeaderAspect {
	    private static final String LOGS = "{} - Client Id {} received.";
	    private static final String CLIENT_ID = "Client-ID";

	    private final WebRequest request;

	    @Before("execution(* com.eagle.mailer.controller.*.*(..))")
	    public void beforeController(JoinPoint joinPoint) {
	        String clientId = request.getHeader(CLIENT_ID);
	        log.info(LOGS, joinPoint, clientId);

	        clientId = Objects.nonNull(clientId) ? clientId : "";
	        MailerContext.setClientId(clientId);
	    }

	    @After("execution(* com.eagle.mailer.controller.*.*(..))")
	    public void afterController(JoinPoint joinPoint) {
	    	MailerContext.clear();
	    }

}

package com.itwill1.bean.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singletoneBean")
@Scope(value = "prototype")
public class SingletoneScopeBean {
	public void SingletonScopeBean() {
		System.out.println("### SingletonBean()기본생성자:"+this);
	}
}

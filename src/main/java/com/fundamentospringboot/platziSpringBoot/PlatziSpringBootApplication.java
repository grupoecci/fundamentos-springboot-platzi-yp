package com.fundamentospringboot.platziSpringBoot;

import com.fundamentospringboot.platziSpringBoot.bean.*;
import com.fundamentospringboot.platziSpringBoot.component.ComponentDependency;
import com.fundamentospringboot.platziSpringBoot.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class PlatziSpringBootApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependendy myBeanWithDependendy;
	private MyOwn myOwn;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	public PlatziSpringBootApplication (@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependendy myBeanWithDependendy, MyOwn myOwn, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo)	{
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependendy = myBeanWithDependendy;
		this.myOwn = myOwn;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(PlatziSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependendy.printWithDependency();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyy");
		myOwn.saludar("Yair", formatoFecha.parse("20/09/1995"));
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() +"-"+userPojo.getPassword() + "-" + userPojo.getAge());
	}
}

package com.fundamentospringboot.platziSpringBoot.configuration;

import com.fundamentospringboot.platziSpringBoot.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    @Bean
    public MyBean beanOperation(){
        return  new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationOperation(){
        return  new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependendy beanOperationOperationWithDependency(MyOperation myOperation){
        return  new MyBeanWithDependencyImplement(myOperation);
    }

    @Bean
    public MyOwn myOwn(){
        return  new MyOwnImplement();
    }
}

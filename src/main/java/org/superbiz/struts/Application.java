package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;
import javax.servlet.Filter;
import java.util.Collections;

import static java.util.Collections.*;


@SpringBootApplication
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public FilterRegistrationBean filterDispatcher()
    {
        return buildRegistrationBean(0,new FilterDispatcher());
    }

    @Bean
    public FilterRegistrationBean actionContextCleanup()
    {
        return buildRegistrationBean(1,new ActionContextCleanUp());
    }

    @Bean
    public FilterRegistrationBean pageFilter()
    {
        return buildRegistrationBean(2,new PageFilter());
    }


    private FilterRegistrationBean buildRegistrationBean(int order, Filter filter)
    {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setUrlPatterns(singletonList("/*"));
        filterRegistrationBean.setOrder(order);

        return filterRegistrationBean;

    }


}

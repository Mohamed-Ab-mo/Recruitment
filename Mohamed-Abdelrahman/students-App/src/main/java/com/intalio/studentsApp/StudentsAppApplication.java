package com.intalio.studentsApp;

import javax.faces.webapp.FacesServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sun.faces.config.ConfigureListener;

@SpringBootApplication
public class StudentsAppApplication implements ServletContextAware{

	public static void main(String[] args) {
		SpringApplication.run(StudentsAppApplication.class, args);
	}

	//config jsf without web.xml or faces-config
			@Bean
		    public ServletRegistrationBean<Servlet> facesServletRegistration() {
		        ServletRegistrationBean registration = new ServletRegistrationBean(
		            new FacesServlet(), "*.xhtml");
		        registration.setLoadOnStartup(1);
		        return registration;
		    }

		    @Bean
		    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		        return new ServletListenerRegistrationBean<ConfigureListener>(
		            new ConfigureListener());
		    }

		    @Override
		    public void setServletContext(ServletContext servletContext) {
		        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());     
		        
		    }
		    
		    @Bean
		    public ViewResolver getViewResolver() {
		        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		        resolver.setPrefix("/view/");
		        resolver.setSuffix(".xhtml");
		        return resolver;
		    }
}

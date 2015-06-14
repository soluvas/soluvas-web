package org.soluvas.web.site;

import ch.qos.logback.classic.selector.servlet.ContextDetachingSCL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

/**
 * {@link org.springframework.context.annotation.Import} this on your Starter app's {@link WebMvcConfigurerAdapter}.
 * Created by ceefour on 6/14/15.
 */
@Configuration
public class BasicWebAppConfig {

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    @Bean
    public ContextDetachingSCL contextDetachingSCL() {
        return new ContextDetachingSCL();
    }


}

package org.soluvas.web.login;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author rudi
 * @deprecated Configure each e.g. GoogleManagerImpl using a multitenant-aware @Configuration. 
 */
@Configuration @Lazy
@ComponentScan("org.soluvas.web.login")
@Deprecated
public class WebLoginConfig {

}

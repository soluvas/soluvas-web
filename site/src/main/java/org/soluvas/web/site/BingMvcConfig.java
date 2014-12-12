package org.soluvas.web.site;

import org.soluvas.web.site.bing.BingVerifyController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ceefour
 *
 */
@Configuration
@ComponentScan(basePackageClasses=BingVerifyController.class)
public class BingMvcConfig {

}

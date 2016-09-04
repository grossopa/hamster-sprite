/**
 * 
 */
package org.hamster.sprite.portal;

import javax.sql.DataSource;

import org.hamster.core.web.spring.boot.AbstractApplication;
import org.hamster.sprite.portal.consts.SecurityConsts;
import org.hamster.sprite.portal.consts.WebConsts;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * main application entrance
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("org.hamster.sprite.dao.entity")
@EnableJpaRepositories("org.hamster.sprite.dao")
@ComponentScan({ "org.hamster.sprite" })
public class Application extends AbstractApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        AbstractApplication.create(Application.class).run(args);
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.primary")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //@formatter:off
            http
                .authorizeRequests()
                    .regexMatchers("["+ WebConsts.P_PUBLIC+ "|" + WebConsts.W_PUBLIC + "]")
                    .permitAll()
                    .anyRequest().fullyAuthenticated()
                    .and()
                .formLogin()
                    .usernameParameter(SecurityConsts.PARAM_USERNAME)
                    .passwordParameter(SecurityConsts.PARAM_PASSWORD)
                    .successHandler()
                    
                
                    
            //@formatter:on
        }

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN", "USER").and().withUser("user").password("user").roles("USER");
        }

        public static class DefaultAuthenticationSuccessHandler extends AuthenticationSuccessHandler {

        }

    }

}

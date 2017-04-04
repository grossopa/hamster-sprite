/**
 * 
 */
package org.hamster.sprite.portal;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hamster.core.dao.repository.DefaultTokenRepository;
import org.hamster.core.web.spring.boot.AbstractApplication;
import org.hamster.sprite.dao.SpriteDaoConfiguration;
import org.hamster.sprite.portal.consts.SecurityConsts;
import org.hamster.sprite.portal.consts.WebConsts;
import org.hamster.sprite.service.user.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

/**
 * main application entrance
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@SpringBootApplication
@ComponentScan("org.hamster.sprite")
public class Application extends AbstractApplication {

    public static void main(String[] args) {
        AbstractApplication.create(Application.class).run(args);
    }

    @Bean(name = "requestCache")
    public RequestCache requestCache() {
        return new HttpSessionRequestCache();
    }

    @Configuration
    public static class DaoConfiguration extends SpriteDaoConfiguration {

    }

    @Configuration
    public static class WebConfiguration extends SpriteWebConfiguration {

    }

    @Configuration
    @EnableWebSecurity
    @Order(SecurityProperties.BASIC_AUTH_ORDER - 100)
    public static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

        private static final Logger log = LoggerFactory.getLogger(ApplicationSecurity.class);

        @Resource(name = "usernamePasswordAuthenticationProvider")
        private AuthenticationProvider authenticationProvider;

        @Autowired
        private UserService userService;

        @Autowired
        private RequestCache requestCache;

        @Autowired
        private DefaultTokenRepository defaultTokenRepository;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //@formatter:off
            http
            .userDetailsService(userService)
            .authorizeRequests()
                .antMatchers("/page/**", "/ws/**")
                    .authenticated()
                .antMatchers("/page/public/**", "/static/**", "/test/**")
                    .permitAll()
                .and()
            .requestCache()
                .requestCache(requestCache)
                .and()
            .logout()
                .logoutUrl("/ws/user/logout")
                .and()
            .formLogin()
                .loginPage(WebConsts.getUrl("P_USER_LOGIN"))
                .loginProcessingUrl("/ws/user/login")
                .failureUrl("/page/user/login?login_error=t")
                .defaultSuccessUrl(WebConsts.getUrl("P_USER_HOME"), true)
                .usernameParameter(SecurityConsts.PARAM_USERNAME)
                .passwordParameter(SecurityConsts.PARAM_PASSWORD)
                .successHandler(new DefaultAuthenticationSuccessHandler())
                .failureHandler(new DefaultAuthenticationFailureHandler())
                .permitAll()
                .and()
            .rememberMe()
                .tokenRepository(defaultTokenRepository)
                .rememberMeCookieName("rememberMe")
                .and()
            .httpBasic();
            http.csrf().disable();
            http.headers().frameOptions().disable();
            //@formatter:on
        }

        public static class DefaultAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                    Authentication authentication) throws IOException, ServletException {
                super.onAuthenticationSuccess(request, response, authentication);
                log.info("Hit Success");
            }

        }

        public static class DefaultAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                    AuthenticationException exception) throws IOException, ServletException {
                super.onAuthenticationFailure(request, response, exception);
                log.info("Hit Failure {0}", exception);
            }

        }

    }
}

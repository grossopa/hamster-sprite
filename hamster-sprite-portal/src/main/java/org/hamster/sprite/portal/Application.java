/**
 * 
 */
package org.hamster.sprite.portal;

import javax.sql.DataSource;

import org.hamster.core.api.environment.builder.DefaultEnvironmentBuilder;
import org.hamster.core.api.environment.builder.EnvironmentBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("org.hamster.sprite.dao.entity")
@EnableJpaRepositories("org.hamster.sprite.dao")
@ComponentScan({"org.hamster.sprite"})
public class Application {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.setProperty(DefaultEnvironmentBuilder.ENVIRONMENT_VARIABLE, environmentBuilder().build().toString());
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    @Primary
    @ConfigurationProperties(prefix="datasource.primary")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
    
    public static EnvironmentBuilder environmentBuilder() {
        return new DefaultEnvironmentBuilder();
    }
    

}

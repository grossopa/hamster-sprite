/**
 * 
 */
package org.hamster.sprite.dao;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@Configuration
@ComponentScan("org.hamster.core.dao.repository")
@EntityScan({ "org.hamster.core.dao.entity", "org.hamster.sprite.dao.entity" })
@EnableJpaRepositories({ "org.hamster.core.dao.repository", "org.hamster.sprite.dao.repository" })
public class SpriteDaoConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.primary")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}

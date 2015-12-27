/**
 * 
 */
package org.hamster.sprite.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hamster.core.dao.entity.base.ManageableEntity;
import org.hamster.sprite.dao.consts.TableConsts;

/**
 * The application provider holds the credentials
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Entity
@Table(name = TableConsts.TABLE_PREFIX + "application")
public class ApplicationEntity extends ManageableEntity {

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "url", length = TableConsts.URL_LENGTH, nullable = true)
    private String url;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param url
     *            the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

}

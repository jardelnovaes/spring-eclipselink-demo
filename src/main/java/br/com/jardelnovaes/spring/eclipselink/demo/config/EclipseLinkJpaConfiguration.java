package br.com.jardelnovaes.spring.eclipselink.demo.config;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class EclipseLinkJpaConfiguration extends JpaBaseConfiguration {

    private final JpaProperties jpaProperties;

    protected EclipseLinkJpaConfiguration(DataSource dataSource,
                                          JpaProperties properties,
                                          ObjectProvider<JtaTransactionManager> jtaTransactionManager) {
        super(dataSource, properties, jtaTransactionManager);
        this.jpaProperties = properties;
    }

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new EclipseLinkJpaVendorAdapter();
    }

    @Override
    protected Map<String, Object> getVendorProperties(DataSource dataSource) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(PersistenceUnitProperties.WEAVING, "true");

        var ddlGen = jpaProperties.isGenerateDdl()
                ? PersistenceUnitProperties.CREATE_OR_EXTEND
                : PersistenceUnitProperties.NONE;
        map.put(PersistenceUnitProperties.DDL_GENERATION, ddlGen);
        return map;
    }
}

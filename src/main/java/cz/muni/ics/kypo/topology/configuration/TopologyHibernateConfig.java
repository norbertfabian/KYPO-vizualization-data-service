package cz.muni.ics.kypo.topology.configuration;

import cz.muni.ics.kypo.topology.multiTenant.DataSourceFactory;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Norbert Fabian
 */

@Configuration
@EnableTransactionManagement
@Import(TopologyAppConfig.class)
@PropertySources({
        @PropertySource(value = { "classpath:application.properties" }),
        @PropertySource(value = { "file:${path.to.db.config.file}" })
})
public class TopologyHibernateConfig {

    @Autowired
    private Environment environment;

    @Autowired
    private DataSourceFactory dataSourceFactory;

    @Autowired
    private AbstractDataSourceBasedMultiTenantConnectionProviderImpl multiTenantConnectionProvider;

    @Autowired
    private CurrentTenantIdentifierResolver currentTenantIdentifierResolver;

    @Bean(name = "topologySessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setPackagesToScan("cz.muni.ics.kypo.topology.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean(name = "defaultDataSource")
    public DataSource defaultDataSource() {
        return dataSourceFactory.create(environment.getRequiredProperty("topology.jdbc.defaultHost"));
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect",
                environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql",
                environment.getRequiredProperty("topology.hibernate.show_sql"));
        properties.put("hibernate.format_sql",
                environment.getRequiredProperty("topology.hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto",
                environment.getRequiredProperty("topology.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.enable_lazy_load_no_trans",
                environment.getRequiredProperty("topology.hibernate.enable_lazy_load_no_trans"));

        // MultiTenant connection properties
        properties.put("hibernate.multiTenancy", MultiTenancyStrategy.DATABASE);
        properties.put("hibernate.tenant_identifier_resolver", currentTenantIdentifierResolver);
        properties.put("hibernate.multi_tenant_connection_provider", multiTenantConnectionProvider);
        return properties;
    }

    @Bean(name = "topologyTransactionManager")
    @Autowired
    public HibernateTransactionManager transactionManager(@Qualifier("topologySessionFactory") SessionFactory topologySessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(topologySessionFactory);
        txManager.setAutodetectDataSource(false);
        return txManager;
    }
}

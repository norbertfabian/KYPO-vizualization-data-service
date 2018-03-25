package cz.muni.ics.kypo.topology.multiTenant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * This class creates datasources based on the properties set at the properties file.
 * Created by norbert on 25.9.17.
 */
@Service
public class DataSourceFactory {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceFactory.class);

    @Autowired
    private Environment environment;

    /**
     * Creates and returns a datasource using the properties from the properties file.
     * The {host} placeholder at the jdbc.url property is replaced by the given sandbox host address.
     * @param address Sandbox host address.
     * @return Datasource
     */
    public DataSource create(String address) {
        logger.debug("Creating datasource for sandbox address " + address);
        DriverManagerDataSource dataSource = createCommon();
        dataSource.setUrl(environment.getRequiredProperty("topology.jdbc.dynamicUrl").replace("{host}", address));
        return dataSource;
    }

    /**
     * Creates a DriverManagerDataSource with set common properties for all the databases
     * like username, password, driver.
     * @return DriverManagerDataSource with set common properties
     */
    private DriverManagerDataSource createCommon() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
}

package cz.muni.ics.kypo.topology.multiTenant;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * This class provides data source based on the tenant identifier.
 * Created by norbert on 22.9.17.
 */
@Service
public class MultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    private static final Logger logger = LoggerFactory.getLogger(MultiTenantConnectionProviderImpl.class);

    @Autowired
    @Qualifier("defaultDataSource")
    private DataSource defaultDataSource;

    @Autowired
    private DataSourceLookup dataSourceLookup;

    /**
     * Select datasource in situations where not tenantId is used (e.g. startup processing).
     */
    @Override
    protected DataSource selectAnyDataSource() {
        logger.debug("Obtaining default dataSource");
        return defaultDataSource;
    }
    /**
     * Returns a DataSource based on tenantId.
     */
    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        logger.debug("Obtaining dataSource with the tenant identifier " + tenantIdentifier);
        DataSource ds = dataSourceLookup.getDataSource(tenantIdentifier);
        return ds;
    }

    /**
     * Releases a Hibernate connection of the given tenant identifier.
     * @param tenant
     * @throws SQLException
     */
    protected void releaseConnection(String tenant) throws SQLException {
        logger.debug("Releasing connection of tenant identifier " + tenant);
        releaseAnyConnection(getConnection(tenant));
    }
}

package cz.muni.ics.kypo.topology.multiTenant;

import cz.muni.ics.kypo.topology.multiTenant.tenant.TenantDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by norbert on 25.9.17.
 */
@Service
public class DynamicDatasourceLookup implements DataSourceLookup {

    private Map<String, TenantDataSource> dataSources = new ConcurrentHashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(DynamicDatasourceLookup.class);

    @Autowired
    private DataSourceFactory dataSourceFactory;

    @Autowired
    private SiteToAddressResolver addressResolver;

    @Autowired
    private MultiTenantConnectionProviderImpl multiTenantConnectionProvider;

    /**
     * Returns the datasource of the tenant identifier. If Datasource not found, look for the address of the database
     * using SiteToAddressResolver and create a new datasource for the given tenant.
     * @param tenant TenantConst identifier.
     * @return Datasource represented by the tenant identifier.
     * @throws DataSourceLookupFailureException Thrown when database address not found by tenant identifier.
     */
    @Override
    public DataSource getDataSource(String tenant) throws DataSourceLookupFailureException {
        TenantDataSource tenantDataSource = dataSources.get(tenant);
        if(tenantDataSource == null) {
            String address = addressResolver.toAddress(tenant);
            DataSource dataSource = dataSourceFactory.create(address);
             tenantDataSource = new TenantDataSource(dataSource, tenant);
            addDataSource(tenant, tenantDataSource);
        }
        tenantDataSource.setLastTimeUsed(System.currentTimeMillis());
        return tenantDataSource.getDataSource();
    }

    public void addDataSource(String tenant, TenantDataSource tenantDataSource) {
        dataSources.put(tenant, tenantDataSource);
    }

    /**
     * Release Hibernate connection of the given tenant identifier and removes it's datasource.
     * @param tenant TenantConst identifier.
     * @throws SQLException Indicates a problem closing the connection.
     */
    public void removeDataSource(String tenant) throws SQLException {
        multiTenantConnectionProvider.releaseConnection(tenant);
        logger.debug("Removing datasource of tenant identifier " + tenant);
        dataSources.remove(tenant);
    }


    /**
     * Returns all registered tenant data sources.
     * @return Collection of TenantDetails.
     */
    public Collection<TenantDataSource> getCurrentTenantDatasources() {
        return dataSources.values();
    }
}

package cz.muni.ics.kypo.topology.multiTenant.scheduled;

import cz.muni.ics.kypo.topology.multiTenant.DynamicDatasourceLookup;
import cz.muni.ics.kypo.topology.multiTenant.tenant.TenantDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by norbert on 2.10.17.
 */
@Service
public class DataSourceCleaner {

    // 30 minutes in milliseconds
    public static final int THIRTY_MINUTES = 1800000;

    // 20 minutes in milliseconds
    public static final int TWENTY_MINUTES = 1200000;

    private static final Logger logger = LoggerFactory.getLogger(DataSourceCleaner.class);

    @Autowired
    private DynamicDatasourceLookup dynamicDatasourceLookup;


    /**
     * Scheduled task for cleaning the unused data sources every 30 minutes.
     */
    @Async
    @Scheduled(fixedDelay = THIRTY_MINUTES)
    public void cleanUnusedDataSources() {
        logger.info("Data source cleaner fired.");
        long currentTime = System.currentTimeMillis();
        Collection<TenantDataSource> currentTenants = dynamicDatasourceLookup.getCurrentTenantDatasources();
        for(TenantDataSource tenantDatasource : currentTenants) {
            if(currentTime - tenantDatasource.getLastTimeUsed() > TWENTY_MINUTES) {
                try {
                    logger.debug("Removing datasource for tenant " + tenantDatasource.getTenant());
                    dynamicDatasourceLookup.removeDataSource(tenantDatasource.getTenant());
                } catch (SQLException e) {
                    logger.error(e.getMessage(), e.getStackTrace());
                }
            }
        }
    }
}

package cz.muni.ics.kypo.topology.multiTenant;

import cz.muni.ics.kypo.topology.multiTenant.tenant.TenantContext;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * This class is used to get the current tenant identifier.
 * Created by norbert on 22.9.17.
 */
@Service
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

    private static final Logger logger = LoggerFactory.getLogger(CurrentTenantIdentifierResolverImpl.class);

    /**
     * Resolves the current tenant identifier by reading it from the TenantContext.
     * @return Current tenant identifier.
     */
    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = TenantContext.getCurrentTenant();
        logger.debug("Resolved tenant " + tenant);
        return tenant;
    }

    /**
     * Should we validate that the tenant identifier on "current sessions" that already exist
     * when CurrentSessionContext.currentSession() is called
     * matches the value returned here from resolveCurrentTenantIdentifier()?
     * @return true indicates that the extra validation will be performed; false indicates it will not.
     */
    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}

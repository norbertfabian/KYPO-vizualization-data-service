package cz.muni.ics.kypo.topology.multiTenant.tenant;

/**
 * This class is used to store the current tenant by sessions.
 * The current tenant identifier resolver looks in this class to find out the current tenant.
 * Created by norbert on 22.9.17.
 */
public class TenantContext {

    private static ThreadLocal<String> currentTenant = new ThreadLocal<>();

    /**
     * Sets the current tenant identifier for the session.
     * @param tenant TenantConst identifier.
     */
    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    /**
     * Returns the current tenant identifier for the session.
     * @return Current tenant identifier
     */
    public static String getCurrentTenant() {
        return currentTenant.get();
    }
}

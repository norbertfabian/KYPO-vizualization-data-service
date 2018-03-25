package cz.muni.ics.kypo.topology.multiTenant.tenant;

import javax.sql.DataSource;

/**
 * Pojo object for holding the information about the datasource usage.
 *
 * Created by norbert on 2.10.17.
 */
public class TenantDataSource {

    private DataSource dataSource;

    private String tenant;

    private Long lastTimeUsed;

    public TenantDataSource(DataSource dataSource, String tenant) {
        this.dataSource = dataSource;
        this.tenant = tenant;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public Long getLastTimeUsed() {
        return lastTimeUsed;
    }

    public void setLastTimeUsed(Long lastTimeUsed) {
        this.lastTimeUsed = lastTimeUsed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TenantDataSource that = (TenantDataSource) o;

        return getTenant().equals(that.getTenant());
    }

    @Override
    public int hashCode() {
        return getTenant().hashCode();
    }
}

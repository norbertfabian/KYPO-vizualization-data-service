package cz.muni.ics.kypo.topology.dao.impl;

import cz.muni.ics.kypo.topology.dao.interfaces.AssignedLogicalRoleDAO;
import cz.muni.ics.kypo.topology.model.AssignedLogicalRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Norbert Fabian
 */
@Repository
public class AssignedLogicalRoleDAOImpl extends AbstractDAO implements AssignedLogicalRoleDAO {

    public void create(AssignedLogicalRole assignedLogicalRole) {
        getSession().save(assignedLogicalRole);
    }

    public void update(AssignedLogicalRole assignedLogicalRole) {
        getSession().saveOrUpdate(assignedLogicalRole);
    }

    public void delete(AssignedLogicalRole assignedLogicalRole) {
        getSession().delete(assignedLogicalRole);
    }

    public AssignedLogicalRole get(Long id) {
        return (AssignedLogicalRole) getSession().get(AssignedLogicalRole.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AssignedLogicalRole> getAll() {
        return getSession().createCriteria(AssignedLogicalRole.class).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AssignedLogicalRole> getByRelativeTime(Long relativeTime) {
        return getSession().createSQLQuery(
                "SELECT" +
                    "  * " +
                    "FROM" +
                    " assigned_logical_role alr " +
                    "WHERE" +
                    "  (alr.from IS NULL" +
                    "  OR (:relativeTime >= extract(epoch from alr.from)))" +
                    "  AND (alr.to IS NULL" +
                    "  OR (:relativeTime <= extract(epoch from alr.to)))")
                .addEntity(AssignedLogicalRole.class)
                .setLong("relativeTime", relativeTime)
                .list();
    }
}

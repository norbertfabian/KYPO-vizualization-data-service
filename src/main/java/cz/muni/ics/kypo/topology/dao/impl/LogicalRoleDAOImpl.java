package cz.muni.ics.kypo.topology.dao.impl;

import cz.muni.ics.kypo.topology.dao.interfaces.LogicalRoleDAO;
import cz.muni.ics.kypo.topology.model.LogicalRole;
import org.springframework.stereotype.Repository;

/**
 * @author Norbert Fabian
 */
@Repository
public class LogicalRoleDAOImpl extends AbstractDAO implements LogicalRoleDAO {

    public void create(LogicalRole logicalRole) {
        getSession().save(logicalRole);
    }

    public void update(LogicalRole logicalRole) {
        getSession().saveOrUpdate(logicalRole);
    }

    public void delete(LogicalRole logicalRole) {
        getSession().delete(logicalRole);
    }

    public LogicalRole get(Long id) {
        return (LogicalRole) getSession().get(LogicalRole.class, id);
    }
}

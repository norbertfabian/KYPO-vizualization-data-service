package cz.muni.ics.kypo.topology.dao.interfaces;

import cz.muni.ics.kypo.topology.model.LogicalRole;

/**
 * @author Norbert Fabian
 */
public interface LogicalRoleDAO {

    void create(LogicalRole logicalRole);

    void update(LogicalRole logicalRole);

    void delete(LogicalRole logicalRole);

    LogicalRole get(Long id);
}

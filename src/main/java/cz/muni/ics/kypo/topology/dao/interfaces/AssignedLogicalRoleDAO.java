package cz.muni.ics.kypo.topology.dao.interfaces;

import cz.muni.ics.kypo.topology.model.AssignedLogicalRole;

import java.util.List;

/**
 * @author Norbert Fabian
 */
public interface AssignedLogicalRoleDAO {

    void create(AssignedLogicalRole assignedLogicalRole);

    void update(AssignedLogicalRole assignedLogicalRole);

    void delete(AssignedLogicalRole assignedLogicalRole);

    AssignedLogicalRole get(Long id);

    List<AssignedLogicalRole> getAll();

    List<AssignedLogicalRole> getByRelativeTime(Long relativeTime);

}

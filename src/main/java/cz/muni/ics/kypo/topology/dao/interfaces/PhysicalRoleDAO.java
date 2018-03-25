package cz.muni.ics.kypo.topology.dao.interfaces;

import cz.muni.ics.kypo.topology.model.PhysicalRole;

/**
 * @author Norbert Fabian
 */
public interface PhysicalRoleDAO {

    void create(PhysicalRole physicalRole);

    void update(PhysicalRole physicalRole);

    void delete(PhysicalRole physicalRole);

    PhysicalRole get(Long id);
}

package cz.muni.ics.kypo.topology.dao.impl;

import cz.muni.ics.kypo.topology.dao.interfaces.PhysicalRoleDAO;
import cz.muni.ics.kypo.topology.model.PhysicalRole;
import org.springframework.stereotype.Repository;

/**
 * @author Norbert Fabian
 */
@Repository
public class PhysicalRoleDAOImpl extends AbstractDAO implements PhysicalRoleDAO {

    public void create(PhysicalRole physicalRole) {
        getSession().save(physicalRole);
    }

    public void update(PhysicalRole physicalRole) {
        getSession().saveOrUpdate(physicalRole);
    }

    public void delete(PhysicalRole physicalRole) {
        getSession().delete(physicalRole);
    }

    public PhysicalRole get(Long id) {
        return (PhysicalRole) getSession().get(PhysicalRole.class, id);
    }
}

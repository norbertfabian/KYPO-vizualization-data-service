package cz.muni.ics.kypo.topology.dao.impl;

import cz.muni.ics.kypo.topology.dao.interfaces.HardwareDAO;
import cz.muni.ics.kypo.topology.model.Hardware;
import org.springframework.stereotype.Repository;

/**
 * Created by norbert on 7.8.17.
 */
@Repository
public class HardwareDAOImpl extends AbstractDAO implements HardwareDAO {
    @Override
    public void create(Hardware hardware) {
        getSession().save(hardware);
    }

    @Override
    public void update(Hardware hardware) {
        getSession().saveOrUpdate(hardware);
    }

    @Override
    public void delete(Hardware hardware) {
        getSession().delete(hardware);
    }

    @Override
    public Hardware get(Long id) {
        return (Hardware) getSession().get(Hardware.class, id);
    }
}

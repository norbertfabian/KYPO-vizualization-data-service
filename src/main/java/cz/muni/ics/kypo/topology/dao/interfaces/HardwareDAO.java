package cz.muni.ics.kypo.topology.dao.interfaces;

import cz.muni.ics.kypo.topology.model.Hardware;

/**
 * @author Norbert Fabian
 */
public interface HardwareDAO {

    void create(Hardware hardware);

    void update(Hardware hardware);

    void delete(Hardware hardware);

    Hardware get(Long id);
}

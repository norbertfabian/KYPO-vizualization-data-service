package cz.muni.ics.kypo.topology.dao.interfaces;

import cz.muni.ics.kypo.topology.model.Connectable;

/**
 * @author Norbert Fabian
 */
public interface ConnectableDAO {

    void create(Connectable connectable);

    void update(Connectable connectable);

    void delete(Connectable connectable);

    Connectable get(Long id);
}

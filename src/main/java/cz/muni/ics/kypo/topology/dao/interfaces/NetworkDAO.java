package cz.muni.ics.kypo.topology.dao.interfaces;

import cz.muni.ics.kypo.topology.model.Network;

import java.util.List;

/**
 * @author Norbert Fabian
 */
public interface NetworkDAO {

    void create(Network network);

    void update(Network network);

    void delete(Network network);

    Network get(Long id);

    List<Network> getAll();
}

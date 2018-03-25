package cz.muni.ics.kypo.topology.dao.interfaces;

import cz.muni.ics.kypo.topology.model.NodeInterface;

/**
 * @author Norbert Fabian
 */
public interface NodeInterfaceDAO {

    void create(NodeInterface nodeInterface);

    void update(NodeInterface nodeInterface);

    void delete(NodeInterface nodeInterface);

    NodeInterface get(Long id);
}

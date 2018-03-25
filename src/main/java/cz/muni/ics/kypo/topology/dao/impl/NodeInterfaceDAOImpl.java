package cz.muni.ics.kypo.topology.dao.impl;

import cz.muni.ics.kypo.topology.dao.interfaces.NodeInterfaceDAO;
import cz.muni.ics.kypo.topology.model.NodeInterface;
import org.springframework.stereotype.Repository;

/**
 * @author Norbert Fabian
 */
@Repository
public class NodeInterfaceDAOImpl extends AbstractDAO implements NodeInterfaceDAO {

    public void create(NodeInterface nodeInterface) {
        getSession().save(nodeInterface);
    }

    public void update(NodeInterface nodeInterface) {
        getSession().saveOrUpdate(nodeInterface);
    }

    public void delete(NodeInterface nodeInterface) {
        getSession().delete(nodeInterface);
    }

    public NodeInterface get(Long id) {
        return (NodeInterface) getSession().get(NodeInterface.class, id);
    }
}

package cz.muni.ics.kypo.topology.dao.impl;

import cz.muni.ics.kypo.topology.dao.interfaces.NodeDAO;
import cz.muni.ics.kypo.topology.model.Node;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Norbert Fabian
 */
@Repository
public class NodeDAOImpl extends AbstractDAO implements NodeDAO {

    public void create(Node node) {
        getSession().save(node);
    }

    public void update(Node node) {
        getSession().saveOrUpdate(node);
    }

    public void delete(Node node) {
        getSession().delete(node);
    }

    public Node get(Long id) {
        return (Node) getSession().get(Node.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Node> getAll() {
        return getSession().createCriteria(Node.class).list();
    }
}

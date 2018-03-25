package cz.muni.ics.kypo.topology.dao.interfaces;

import cz.muni.ics.kypo.topology.model.Node;

import java.util.List;

/**
 * @author Norbert Fabian
 */
public interface NodeDAO {

    void create(Node node);

    void update(Node node);

    void delete(Node node);

    Node get(Long id);

    List<Node> getAll();
}

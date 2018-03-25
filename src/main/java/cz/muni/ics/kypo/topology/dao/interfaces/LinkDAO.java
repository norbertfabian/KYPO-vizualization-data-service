package cz.muni.ics.kypo.topology.dao.interfaces;

import cz.muni.ics.kypo.topology.model.Link;

import java.util.List;

/**
 * @author Norbert Fabian
 */
public interface LinkDAO {

    void create(Link link);

    void update(Link link);

    void delete(Link link);

    Link get(Long id);

    List<Link> getAll();
}

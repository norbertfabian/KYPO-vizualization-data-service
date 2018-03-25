package cz.muni.ics.kypo.topology.dao.impl;

import cz.muni.ics.kypo.topology.dao.interfaces.LinkDAO;
import cz.muni.ics.kypo.topology.model.Link;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Norbert Fabian
 */
@Repository
public class LinkDAOImpl extends AbstractDAO implements LinkDAO {

    public void create(Link link) {
        getSession().save(link);
    }

    public void update(Link link) {
        getSession().saveOrUpdate(link);
    }

    public void delete(Link link) {
        getSession().delete(link);
    }

    public Link get(Long id) {
        return (Link) getSession().get(Link.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Link> getAll() {
        return getSession().createCriteria(Link.class).list();
    }
}

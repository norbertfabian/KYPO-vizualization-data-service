package cz.muni.ics.kypo.topology.dao.impl;

import cz.muni.ics.kypo.topology.dao.interfaces.ConnectableDAO;
import cz.muni.ics.kypo.topology.model.Connectable;
import org.springframework.stereotype.Repository;

/**
 * @author Norbert Fabian
 */
@Repository
public class ConnectableDAOImpl extends AbstractDAO implements ConnectableDAO {

    public void create(Connectable connectable) {
        getSession().save(connectable);
    }

    public void update(Connectable connectable) {
        getSession().saveOrUpdate(connectable);
    }

    public void delete(Connectable connectable) {
        getSession().delete(connectable);
    }

    public Connectable get(Long id) {
        return (Connectable) getSession().get(Connectable.class, id);
    }
}

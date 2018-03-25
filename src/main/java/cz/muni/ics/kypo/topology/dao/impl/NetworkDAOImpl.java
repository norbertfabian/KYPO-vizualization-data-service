package cz.muni.ics.kypo.topology.dao.impl;

import cz.muni.ics.kypo.topology.dao.interfaces.NetworkDAO;
import cz.muni.ics.kypo.topology.model.Network;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Norbert Fabian
 */
@Repository
public class NetworkDAOImpl extends AbstractDAO implements NetworkDAO {

    public void create(Network network) {
        getSession().save(network);
    }

    public void update(Network network) {
        getSession().saveOrUpdate(network);
    }

    public void delete(Network network) {
        getSession().delete(network);
    }

    public Network get(Long id) {
        return (Network) getSession().get(Network.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Network> getAll() {
        return getSession().createCriteria(Network.class).list();
    }
}

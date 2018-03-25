package cz.muni.ics.kypo.topology.dao.impl;

import cz.muni.ics.kypo.topology.dao.interfaces.PropertyDAO;
import cz.muni.ics.kypo.topology.model.Property;
import org.springframework.stereotype.Repository;

/**
 * @author Norbert Fabian
 */
@Repository
public class PropertyDAOImpl extends AbstractDAO implements PropertyDAO {

    public void create(Property property) {
        getSession().save(property);
    }

    public void update(Property property) {
        getSession().saveOrUpdate(property);
    }

    public void delete(Property property) {
        getSession().delete(property);
    }

    public Property get(Long id) {
        return (Property) getSession().get(Property.class, id);
    }
}

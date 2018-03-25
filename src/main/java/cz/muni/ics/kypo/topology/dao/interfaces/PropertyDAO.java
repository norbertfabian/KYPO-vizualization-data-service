package cz.muni.ics.kypo.topology.dao.interfaces;

import cz.muni.ics.kypo.topology.model.Property;

/**
 * @author Norbert Fabian
 */
public interface PropertyDAO {

    void create(Property property);

    void update(Property property);

    void delete(Property property);

    Property get(Long id);
}

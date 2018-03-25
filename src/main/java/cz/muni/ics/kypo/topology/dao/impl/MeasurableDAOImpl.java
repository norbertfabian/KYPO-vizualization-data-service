package cz.muni.ics.kypo.topology.dao.impl;

import cz.muni.ics.kypo.topology.dao.interfaces.MeasurableDAO;
import cz.muni.ics.kypo.topology.model.Measurable;
import org.springframework.stereotype.Repository;

/**
 * @author Norbert Fabian
 */
@Repository
public class MeasurableDAOImpl extends AbstractDAO implements MeasurableDAO {

    public void create(Measurable measurable) {
        getSession().save(measurable);
    }

    public void update(Measurable measurable) {
        getSession().saveOrUpdate(measurable);
    }

    public void delete(Measurable measurable) {
        getSession().delete(measurable);
    }

    public Measurable get(Long id) {
        return (Measurable) getSession().get(Measurable.class, id);
    }
}

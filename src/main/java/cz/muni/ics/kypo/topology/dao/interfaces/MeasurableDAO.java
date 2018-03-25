package cz.muni.ics.kypo.topology.dao.interfaces;

import cz.muni.ics.kypo.topology.model.Measurable;

/**
 * @author Norbert Fabian
 */
public interface MeasurableDAO {

    void create(Measurable measurable);

    void update(Measurable measurable);

    void delete(Measurable measurable);

    Measurable get(Long id);
}

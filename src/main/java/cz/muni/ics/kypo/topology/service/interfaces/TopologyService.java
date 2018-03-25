package cz.muni.ics.kypo.topology.service.interfaces;

import cz.muni.ics.kypo.topology.transfer.InterfaceRoleTo;
import cz.muni.ics.kypo.topology.transfer.TopologyTo;

import java.util.Set;

/**
 * Interface of the TopologyService implementation.
 * Created by Norbert Fabian on 10.7.17.
 */
public interface TopologyService {

    /**
     * Creates and returns a TopologyTo instance using the data from the database.
     * @return TopologyTo instance.
     */
    TopologyTo getTopology();

    /**
     * Creates and returns a Set of InterfaceRoleTos using the data from the database
     * at the time specified by the experiment start and the absolute time.
     * @param experimentStart Time in milliseconds as Long representing the start of the experiment.
     * @param epochAbsoluteTime Time in milliseconds as Long representing the when time
     *                          from when we want the logical roles.
     * @return Set of InterfaceRoleTos.
     */
    Set<InterfaceRoleTo> getInterfaceRoles(Long experimentStart, Long epochAbsoluteTime);
}

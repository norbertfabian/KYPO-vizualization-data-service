package cz.muni.ics.kypo.topology.transfer.factory;

import cz.muni.ics.kypo.topology.model.AssignedLogicalRole;
import cz.muni.ics.kypo.topology.transfer.InterfaceRoleTo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Factory class for creating a InterfaceRoleTos.
 * Created by Norbert Fabian on 25.7.17.
 */
public class InterfaceRoleToFactory {

    /**
     * Creates a Set of InterfaceRoleTo using the data from given list of AssignedLogicalRoles.
     * @param alrs List of AssignedLogicalRoles.
     * @returnSet Set of InterfaceRoleTos.
     */
    public Set<InterfaceRoleTo> createSet(List<AssignedLogicalRole> alrs) {
        Set<InterfaceRoleTo> tos = new HashSet<>();
        for(AssignedLogicalRole alr: alrs) {
            tos.add(create(alr));
        }
        return tos;
    }

    /**
     * Creates an instance of InterfaceRoleTo using the data from the given AssignedLogicalRole.
     * @param alr Instance of InterfaceRoleTo with data from the given AssignedLogicalRole.
     * @return InterfaceRoleTo instance.
     */
    public InterfaceRoleTo create(AssignedLogicalRole alr) {
        InterfaceRoleTo interfaceRoleTo = new InterfaceRoleTo();
        interfaceRoleTo.setId(alr.getNode().getId());
        interfaceRoleTo.setRole(alr.getLogicalRole().getName());
        return interfaceRoleTo;
    }
}

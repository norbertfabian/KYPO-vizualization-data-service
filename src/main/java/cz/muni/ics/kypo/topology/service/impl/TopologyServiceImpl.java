package cz.muni.ics.kypo.topology.service.impl;

import cz.muni.ics.kypo.topology.dao.interfaces.AssignedLogicalRoleDAO;
import cz.muni.ics.kypo.topology.dao.interfaces.LinkDAO;
import cz.muni.ics.kypo.topology.dao.interfaces.NetworkDAO;
import cz.muni.ics.kypo.topology.model.*;
import cz.muni.ics.kypo.topology.service.interfaces.TopologyService;
import cz.muni.ics.kypo.topology.transfer.InterfaceRoleTo;
import cz.muni.ics.kypo.topology.transfer.TopologyTo;
import cz.muni.ics.kypo.topology.transfer.factory.InterfaceRoleToFactory;
import cz.muni.ics.kypo.topology.transfer.factory.TopologyToFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Service class for creating transfer objects for the TopologyController.
 * Created by Norbert Fabian on 10.7.17.
 */
@Service
@Transactional(transactionManager = "topologyTransactionManager")
public class TopologyServiceImpl implements TopologyService {

    private static final Logger logger = LoggerFactory.getLogger(TopologyServiceImpl.class);

    @Autowired
    private NetworkDAO networkDAO;

    @Autowired
    private LinkDAO linkDAO;

    @Autowired
    private AssignedLogicalRoleDAO assignedLogicalRoleDAO;

    @Override
    public TopologyTo getTopology() {
        logger.debug("Getting topology.");

        List<Network> networks = networkDAO.getAll();
        List<Link> links = linkDAO.getAll();

        TopologyToFactory topologyToFactory = new TopologyToFactory();
        TopologyTo topologyTo = topologyToFactory.create(links, networks);

        return topologyTo;
    }

    @Override
    public Set<InterfaceRoleTo> getInterfaceRoles(Long experimentStart, Long epochAbsoluteTime) {
        logger.debug("Getting node interface roles. "
                + "ExperimentStart = " + experimentStart + ", epochAbsoluteTime = " + epochAbsoluteTime);

        if(experimentStart == null) {
            return null;
        }
        Long epochRelativeTime = epochAbsoluteTime - experimentStart;

        List<AssignedLogicalRole> alrs = assignedLogicalRoleDAO.getByRelativeTime(epochRelativeTime);
        return new InterfaceRoleToFactory().createSet(alrs);
    }
}

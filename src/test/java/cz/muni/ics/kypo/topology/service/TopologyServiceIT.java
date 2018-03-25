package cz.muni.ics.kypo.topology.service;

import cz.muni.ics.kypo.topology.TestEntityFactory;
import cz.muni.ics.kypo.topology.configuration.HibernateTestConfig;
import cz.muni.ics.kypo.topology.model.AssignedLogicalRole;
import cz.muni.ics.kypo.topology.model.Network;
import cz.muni.ics.kypo.topology.model.Node;
import cz.muni.ics.kypo.topology.model.NodeInterface;
import cz.muni.ics.kypo.topology.service.interfaces.TopologyService;
import cz.muni.ics.kypo.topology.transfer.InterfaceRoleTo;
import cz.muni.ics.kypo.topology.transfer.TopologyTo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * Integration tests for TopologyService
 * Created by Norbert Fabian on 10.7.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TopologyServiceIT extends AbstractTopologyServiceTest {

    @Autowired
    private TopologyService topologyService;

    @Autowired
    private TestEntityFactory entityFactory;

    @Test
    public void getTopologyTest() {
        Network network1 = entityFactory.persistedNetwork("Network1", 2);
        Network network2 = entityFactory.persistedNetwork("Network2", 2);
        entityFactory.connectBidirectionalPersisted(network1, network2);

        TopologyTo result = topologyService.getTopology();

        Assert.assertEquals("Wrong amount of nodes has been returned.",
                2, result.getChildren().size());
        Assert.assertEquals("Wrong amount of routerLinks has been returned.",
                2, result.getRouterLinks().size());
        Assert.assertEquals("Wrong amount of links has been returned.",
                8, result.getLinks().size());
        assertLinks(result.getLinks(), result.getChildren());
        assertRouterLinks(result.getRouterLinks(), result.getChildren());
    }

    @Test
    public void getTopologyOneNodeToTwoDifferentNetworksTest() {
        Node node = entityFactory.persistedNode("Node");
        NodeInterface nodeInterface1 = entityFactory.persistedNodeInterface(node);
        NodeInterface nodeInterface2 = entityFactory.persistedNodeInterface(node);
        Network network1 = entityFactory.persistedNetwork("Network1", 0);
        Network network2 = entityFactory.persistedNetwork("Network2", 0);
        entityFactory.connectBidirectionalPersisted(network1, nodeInterface1);
        entityFactory.connectBidirectionalPersisted(network2, nodeInterface2);

        TopologyTo result = topologyService.getTopology();

        Assert.assertEquals("Wrong amount of nodes has been returned.",
                2, result.getChildren().size());
        Assert.assertEquals("Wrong amount of routerLinks has been returned.",
                0, result.getRouterLinks().size());
        Assert.assertEquals("Wrong amount of links has been returned.",
                4, result.getLinks().size());
    }

    @Test
    public void getInterfaceRolesStartNullTest() {
        AssignedLogicalRole alr1 = entityFactory.persistedLogicalRole(toDate(0L), toDate(5L));

        Set<InterfaceRoleTo> result = topologyService.getInterfaceRoles(null, 13L);

        Assert.assertEquals("Result should be null.", null, result);
    }
}

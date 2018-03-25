package cz.muni.ics.kypo.topology.service;

import cz.muni.ics.kypo.topology.TestEntityFactory;
import cz.muni.ics.kypo.topology.dao.interfaces.AssignedLogicalRoleDAO;
import cz.muni.ics.kypo.topology.dao.interfaces.LinkDAO;
import cz.muni.ics.kypo.topology.dao.interfaces.NetworkDAO;
import cz.muni.ics.kypo.topology.model.Link;
import cz.muni.ics.kypo.topology.model.Network;
import cz.muni.ics.kypo.topology.service.impl.TopologyServiceImpl;
import cz.muni.ics.kypo.topology.transfer.RouterTo;
import cz.muni.ics.kypo.topology.transfer.TopologyTo;
import org.hibernate.service.spi.ServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit tests for TopologyService
 * Created by Norbert Fabian on 31.7.17.
 */
public class TopologyServiceTest extends AbstractTopologyServiceTest {

    @InjectMocks
    private TopologyServiceImpl topologyService;

    @Mock
    private NetworkDAO networkDAO;

    @Mock
    private LinkDAO linkDAO;

    @Mock
    private AssignedLogicalRoleDAO alrDao;

    private TestEntityFactory entityFactory;

    @Before
    public void setUpClass() throws ServiceException {
        MockitoAnnotations.initMocks(this);
        entityFactory = new TestEntityFactory();
    }

    @Test
    public void getTopologyTosCreationTest() {
        // Create networks
        Network network1 = entityFactory.network("Network1", 1, true);
        Network network2 = entityFactory.network("Network2", 1, true);
        entityFactory.connectBidirectional(network1, network2, true);
        List<Network> networksReturn = new ArrayList<>();
        networksReturn.add(network1);
        networksReturn.add(network2);

        // Get links from networks
        List<Link> linksReturn = new ArrayList<>();
        for(Network network: networksReturn) {
            linksReturn.addAll(network.getInputs());
            linksReturn.addAll(network.getOutputs());
        }

        Mockito.when(networkDAO.getAll()).thenReturn(networksReturn);
        Mockito.when(linkDAO.getAll()).thenReturn(linksReturn);

        TopologyTo result = topologyService.getTopology();

        Mockito.verify(networkDAO, Mockito.times(1)).getAll();
        Mockito.verify(linkDAO, Mockito.times(1)).getAll();
        Assert.assertEquals("Wrong amount of routers has been returned",
                2, result.getChildren().size());
        Assert.assertEquals("Wrong amount of routerLinks has been returned",
                2, result.getRouterLinks().size());
        Assert.assertEquals("Wrong amount of links has been returned",
                4, result.getLinks().size());
        assertLinks(result.getLinks(), result.getChildren());
        assertRouterLinks(result.getRouterLinks(), result.getChildren());
    }

    @Test
    public void getTopologyOneNetworkThreeNodesTest() {
        // Create networks
        List<Network> networksReturn = new ArrayList<>();
        networksReturn.add(entityFactory.network("Network1", 3, true));

        // Get links from networks
        List<Link> linksReturn = new ArrayList<>();
        for(Network network: networksReturn) {
            linksReturn.addAll(network.getInputs());
            linksReturn.addAll(network.getOutputs());
        }

        Mockito.when(networkDAO.getAll()).thenReturn(networksReturn);
        Mockito.when(linkDAO.getAll()).thenReturn(linksReturn);

        TopologyTo result = topologyService.getTopology();

        Mockito.verify(networkDAO, Mockito.times(1)).getAll();
        Mockito.verify(linkDAO, Mockito.times(1)).getAll();
        Assert.assertEquals("Wrong amount of routers has been returned", 1, result.getChildren().size());
        Assert.assertEquals("Wrong amount of routerLinks has been returned", 0, result.getRouterLinks().size());
        Assert.assertEquals("Wrong amount of links has been returned", 6, result.getLinks().size());
        assertLinks(result.getLinks(), result.getChildren());
        for(RouterTo router: result.getChildren()) {
            Assert.assertEquals("The amount of routers children is wrong.",
                    3, router.getChildren().size());
        }
    }

    @Test
    public void getTopologyTwoNetworksZeroNodesTest() {
        // Create networks
        Network network1 = entityFactory.network("Network1", 0, true);
        Network network2 = entityFactory.network("Network2", 0, true);
        entityFactory.connectBidirectional(network1, network2, true);
        List<Network> networksReturn = new ArrayList<>();
        networksReturn.add(network1);
        networksReturn.add(network2);

        // Get links from networks
        List<Link> linksReturn = new ArrayList<>();
        for(Network network: networksReturn) {
            linksReturn.addAll(network.getInputs());
            linksReturn.addAll(network.getOutputs());
        }

        Mockito.when(networkDAO.getAll()).thenReturn(networksReturn);
        Mockito.when(linkDAO.getAll()).thenReturn(linksReturn);

        TopologyTo result = topologyService.getTopology();

        Mockito.verify(networkDAO, Mockito.times(1)).getAll();
        Mockito.verify(linkDAO, Mockito.times(1)).getAll();
        Assert.assertEquals("Wrong amount of routers has been returned", 2, result.getChildren().size());
        Assert.assertEquals("Wrong amount of routerLinks has been returned", 2, result.getRouterLinks().size());
        Assert.assertEquals("Wrong amount of links has been returned", 0, result.getLinks().size());
        assertLinks(result.getLinks(), result.getChildren());
        assertRouterLinks(result.getRouterLinks(), result.getChildren());
        for(RouterTo router: result.getChildren()) {
            Assert.assertEquals("The amount of routers children is wrong.",
                    0, router.getChildren().size());
        }
    }

    @Test
    public void getTopologyCyclicThreeNetworksFiveNodesTest() {
        // Create networks
        Network network1 = entityFactory.network("Network1", 5, true);
        Network network2 = entityFactory.network("Network2", 5, true);
        Network network3 = entityFactory.network("Network3", 5, true);
        entityFactory.connectBidirectional(network1, network2, true);
        entityFactory.connectBidirectional(network1, network3, true);
        entityFactory.connectBidirectional(network2, network3, true);
        List<Network> networksReturn = new ArrayList<>();
        networksReturn.add(network1);
        networksReturn.add(network2);
        networksReturn.add(network3);

        // Get links from networks
        List<Link> linksReturn = new ArrayList<>();
        for(Network network: networksReturn) {
            linksReturn.addAll(network.getInputs());
            linksReturn.addAll(network.getOutputs());
        }

        Mockito.when(networkDAO.getAll()).thenReturn(networksReturn);
        Mockito.when(linkDAO.getAll()).thenReturn(linksReturn);

        TopologyTo result = topologyService.getTopology();

        Mockito.verify(networkDAO, Mockito.times(1)).getAll();
        Mockito.verify(linkDAO, Mockito.times(1)).getAll();
        Assert.assertEquals("Wrong amount of routers has been returned", 3, result.getChildren().size());
        Assert.assertEquals("Wrong amount of routerLinks has been returned", 6, result.getRouterLinks().size());
        Assert.assertEquals("Wrong amount of links has been returned", 30, result.getLinks().size());
        assertLinks(result.getLinks(), result.getChildren());
        assertRouterLinks(result.getRouterLinks(), result.getChildren());
        for(RouterTo router: result.getChildren()) {
            Assert.assertEquals("The amount of routers children is wrong.",
                    5, router.getChildren().size());
        }
    }

    @Test
    public void getInterfaceRolesByAbsoluteTimeTransferToRelativeTest() {
        ArgumentCaptor<Long> argument = ArgumentCaptor.forClass(Long.class);

        topologyService.getInterfaceRoles(100L, 150L);
        verify(alrDao).getByRelativeTime(argument.capture());

        Long expectedRelativeTime = 50L;
        assertEquals(expectedRelativeTime, argument.getValue());
    }
}

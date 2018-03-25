package cz.muni.ics.kypo.topology.loader;

import cz.muni.ics.kypo.dbmodel.core.model.*;
import cz.muni.ics.kypo.idm.dao.interfaces.*;
import cz.muni.ics.kypo.topology.dao.interfaces.*;
import cz.muni.ics.kypo.topology.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by norbert on 17.7.17.
 */

@Component
@Transactional(transactionManager = "idmTransactionManager")
public class SampleDataLoaderImpl implements SampleDataLoader {

    @Autowired
    private AssignedLogicalRoleDAO assignedLogicalRoleDao;

    @Autowired
    private LinkDAO linkDao;

    @Autowired
    private NetworkDAO networkDao;

    @Autowired
    private NodeDAO nodeDao;

    @Autowired
    private PhysicalRoleDAO physicalRoleDao;

    @Autowired
    private LogicalRoleDAO logicalRoleDao;

    @Autowired
    private PropertyDAO propertyDao;

    // IDM DAOs

    @Autowired
    private ScenarioInstanceParticipantDAO scenarioInstanceParticipantDao;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ScenarioRoleDAO scenarioRoleDAO;

    @Autowired
    private ScenarioDAO scenarioDAO;

    @Autowired
    private SandboxDAO sandboxDAO;

    /**
     * Creates a cyclic topology with 3 routers, 4 PC-s and 1 server.
     */
    @Override
    public void loadData() {
        System.out.println("Data loader lunched!");
//        load3Routers(true);
//        load1Node2Routers();
//        loadSandboxes();
    }


    public void loadSandboxes() {
        User user = new User();
        user.setDisplayName("User");
        user.setLiferayScreenName("LiferayScreenName");

        ScenarioRole scenarioRole = new ScenarioRole();
        scenarioRole.setName("scenarioRole");

        Scenario scenario = new Scenario();
        scenario.setName("Scenario");
        scenario.addScenarioRole(scenarioRole);

        Sandbox sandbox1 = new Sandbox();
        sandbox1.setName("Sandbox1Name");
        sandbox1.setUrl("kypodb");

        ScenarioInstanceParticipant sip1 = new ScenarioInstanceParticipant();
        sip1.setSiteId("sandbox1");
        sip1.setSandbox(sandbox1);
        sip1.setUser(user);
        sip1.setScenarioRole(scenarioRole);

        Sandbox sandbox2 = new Sandbox();
        sandbox2.setName("Sandbox3Name");
        sandbox2.setUrl("kypodb2");

        ScenarioInstanceParticipant sip2 = new ScenarioInstanceParticipant();
        sip2.setSiteId("sandbox2");
        sip2.setSandbox(sandbox2);
        sip2.setUser(user);
        sip2.setScenarioRole(scenarioRole);

        Sandbox sandbox3 = new Sandbox();
        sandbox3.setName("Sandbox3Name");
        sandbox3.setUrl("kypodb3");

        ScenarioInstanceParticipant sip3 = new ScenarioInstanceParticipant();
        sip3.setSiteId("sandbox3");
        sip3.setSandbox(sandbox3);
        sip3.setUser(user);
        sip3.setScenarioRole(scenarioRole);

        sandboxDAO.create(sandbox1);
        sandboxDAO.create(sandbox2);
        sandboxDAO.create(sandbox3);
        userDAO.create(user);
        scenarioDAO.create(scenario);
        scenarioRoleDAO.create(scenarioRole);
        scenarioInstanceParticipantDao.create(sip1);
        scenarioInstanceParticipantDao.create(sip2);
        scenarioInstanceParticipantDao.create(sip3);
    }

    public void load3Routers(boolean cyclic) {
        LogicalRole logicalRoleAttacker = new LogicalRole();
        logicalRoleAttacker.setName("attacker");
        LogicalRole logicalRoleVictim = new LogicalRole();
        logicalRoleVictim.setName("victim");

        PhysicalRole physicalRoleServer = new PhysicalRole();
        physicalRoleServer.setName("server");
        PhysicalRole physicalRolePc = new PhysicalRole();
        physicalRolePc.setName("desktop");

        Network network1 = new Network();
        network1.setCidr4("150.150.2.1");
        network1.setName("Lan1");

        Network network2 = new Network();
        network2.setCidr4("150.150.1.1");
        network2.setName("Lan2");

        Network network3 = new Network();
        network3.setCidr4("150.150.3.1");
        network3.setName("Lan3");

        Property propertyPc11 = new Property();
        propertyPc11.setName("RAM");
        propertyPc11.setUnit("GB");
        propertyPc11.setValue("8");

        Property propertyPc12 = new Property();
        propertyPc12.setName("HDD");
        propertyPc12.setUnit("GB");
        propertyPc12.setValue("500");

        Property propertyPc21 = new Property();
        propertyPc21.setName("RAM");
        propertyPc21.setUnit("GB");
        propertyPc21.setValue("8");

        Property propertyPc22 = new Property();
        propertyPc22.setName("HDD");
        propertyPc22.setUnit("GB");
        propertyPc22.setValue("500");

        Property propertyPc31 = new Property();
        propertyPc31.setName("RAM");
        propertyPc31.setUnit("GB");
        propertyPc31.setValue("8");

        Property propertyServer = new Property();
        propertyServer.setName("Ports");
        propertyServer.setUnit("ks");
        propertyServer.setValue("20");

        Property propertyLink11 = new Property();
        propertyLink11.setName("Bandwidth");
        propertyLink11.setUnit("MB/s");
        propertyLink11.setValue("100");

        Property propertyLink12 = new Property();
        propertyLink12.setName("Bandwidth");
        propertyLink12.setUnit("MB/s");
        propertyLink12.setValue("100");

        Property propertyLink21 = new Property();
        propertyLink21.setName("Bandwidth");
        propertyLink21.setUnit("MB/s");
        propertyLink21.setValue("100");

        Property propertyLink22 = new Property();
        propertyLink22.setName("Bandwidth");
        propertyLink22.setUnit("MB/s");
        propertyLink22.setValue("100");

        Property propertyNetworkLink1 = new Property();
        propertyNetworkLink1.setName("Bandwidth");
        propertyNetworkLink1.setUnit("MB/s");
        propertyNetworkLink1.setValue("100");

        Property propertyNetworkLink2 = new Property();
        propertyNetworkLink2.setName("Bandwidth");
        propertyNetworkLink2.setUnit("MB/s");
        propertyNetworkLink2.setValue("100");

        Property propertyServerLink1 = new Property();
        propertyServerLink1.setName("Bandwidth");
        propertyServerLink1.setUnit("MB/s");
        propertyServerLink1.setValue("100");

        Property propertyServerLink2 = new Property();
        propertyServerLink2.setName("Bandwidth");
        propertyServerLink2.setUnit("MB/s");
        propertyServerLink2.setValue("100");

        Property propertyNetworkLink32 = new Property();
        propertyNetworkLink32.setName("Bandwidth");
        propertyNetworkLink32.setUnit("MB/s");
        propertyNetworkLink32.setValue("100");

        Property propertyNetworkLink23 = new Property();
        propertyNetworkLink23.setName("Bandwidth");
        propertyNetworkLink23.setUnit("MB/s");
        propertyNetworkLink23.setValue("100");

        Property propertyPc3NetworkLink31 = new Property();
        propertyPc3NetworkLink31.setName("Bandwidth");
        propertyPc3NetworkLink31.setUnit("MB/s");
        propertyPc3NetworkLink31.setValue("100");

        Property propertyPc3NetworkLink32 = new Property();
        propertyNetworkLink32.setName("Bandwidth");
        propertyNetworkLink32.setUnit("MB/s");
        propertyNetworkLink32.setValue("100");

        Node nodePc1 = new Node();
        nodePc1.setName("Pc1");
        nodePc1.setPhysicalRole(physicalRolePc);
        nodePc1.addProperty(propertyPc11);
        nodePc1.addProperty(propertyPc12);
        propertyPc11.setMeasurable(nodePc1);
        propertyPc12.setMeasurable(nodePc1);

        Node nodePc2 = new Node();
        nodePc2.setName("Pc2");
        nodePc2.setPhysicalRole(physicalRolePc);
        nodePc2.addProperty(propertyPc21);
        nodePc2.addProperty(propertyPc22);
        propertyPc21.setMeasurable(nodePc2);
        propertyPc22.setMeasurable(nodePc2);

        Node nodeServer = new Node();
        nodeServer.setName("Server");
        nodeServer.setPhysicalRole(physicalRoleServer);
        nodeServer.addProperty(propertyServer);
        propertyServer.setMeasurable(nodeServer);

        Node nodePc3 = new Node();
        nodePc3.setName("Pc3");
        nodePc3.setPhysicalRole(physicalRolePc);
        nodePc3.addProperty(propertyPc31);
        propertyPc31.setMeasurable(nodePc3);

        NodeInterface nodeInterfacePc3 = new NodeInterface();
        nodeInterfacePc3.setIp4Addr("150.150.3.2");
        nodeInterfacePc3.setNode(nodePc3);
        nodePc3.addNodeInterface(nodeInterfacePc3);

        NodeInterface nodeInterfacePc1 = new NodeInterface();
        nodeInterfacePc1.setIp4Addr("150.150.2.2");
        nodeInterfacePc1.setNode(nodePc1);
        nodePc1.addNodeInterface(nodeInterfacePc1);

        NodeInterface nodeInterfacePc2 = new NodeInterface();
        nodeInterfacePc2.setIp4Addr("150.150.2.3");
        nodeInterfacePc2.setNode(nodePc2);
        nodePc2.addNodeInterface(nodeInterfacePc2);

        NodeInterface nodeInterfaceServer = new NodeInterface();
        nodeInterfaceServer.setIp4Addr("150.150.1.2");
        nodeInterfaceServer.setNode(nodeServer);
        nodeServer.addNodeInterface(nodeInterfaceServer);

        Link pc1RouterLink = new Link();
        pc1RouterLink.setSrcInterface("Pc1");
        pc1RouterLink.setSrcConnectable(nodeInterfacePc1);
        pc1RouterLink.setDstConnectable(network1);
        nodeInterfacePc1.addOutput(pc1RouterLink);
        network1.addInput(pc1RouterLink);
        pc1RouterLink.addProperty(propertyLink11);
        propertyLink11.setMeasurable(pc1RouterLink);

        Link routerPc1Link = new Link();
        routerPc1Link.setSrcInterface("Network1");
        routerPc1Link.setSrcConnectable(network1);
        routerPc1Link.setDstConnectable(nodeInterfacePc1);
        network1.addOutput(routerPc1Link);
        nodeInterfacePc1.addInput(routerPc1Link);
        routerPc1Link.addProperty(propertyLink12);
        propertyLink12.setMeasurable(routerPc1Link);

        Link pc2RouterLink = new Link();
        pc2RouterLink.setSrcInterface("Pc2");
        pc2RouterLink.setSrcConnectable(nodeInterfacePc2);
        pc2RouterLink.setDstConnectable(network1);
        nodeInterfacePc2.addOutput(pc2RouterLink);
        network1.addInput(pc2RouterLink);
        pc2RouterLink.addProperty(propertyLink21);
        propertyLink21.setMeasurable(pc2RouterLink);

        Link routerPc2Link = new Link();
        routerPc2Link.setSrcInterface("Network1");
        routerPc2Link.setSrcConnectable(network1);
        routerPc2Link.setDstConnectable(nodeInterfacePc2);
        network1.addOutput(routerPc2Link);
        nodeInterfacePc2.addInput(routerPc2Link);
        routerPc2Link.addProperty(propertyLink22);
        propertyLink22.setMeasurable(routerPc2Link);

        Link serverRouterLink = new Link();
        serverRouterLink.setSrcInterface("Network2");
        serverRouterLink.setSrcConnectable(network2);
        serverRouterLink.setDstConnectable(nodeInterfaceServer);
        network2.addOutput(serverRouterLink);
        nodeInterfaceServer.addInput(serverRouterLink);
        serverRouterLink.addProperty(propertyServerLink1);
        propertyServerLink1.setMeasurable(serverRouterLink);

        Link routerServerLink = new Link();
        routerServerLink.setSrcInterface("Server");
        routerServerLink.setSrcConnectable(nodeInterfaceServer);
        routerServerLink.setDstConnectable(network2);
        nodeInterfaceServer.addOutput(routerServerLink);
        network2.addInput(routerServerLink);
        routerServerLink.addProperty(propertyServerLink2);
        propertyServerLink2.setMeasurable(routerServerLink);

        Link network1Network2Link = new Link();
        network1Network2Link.setSrcInterface("Network1");
        network1Network2Link.setSrcConnectable(network1);
        network1Network2Link.setDstConnectable(network2);
        network1.addOutput(network1Network2Link);
        network2.addInput(network1Network2Link);
        propertyNetworkLink1.setMeasurable(network1Network2Link);
        network1Network2Link.addProperty(propertyNetworkLink1);

        Link network2Network1Link = new Link();
        network2Network1Link.setSrcInterface("Network2");
        network2Network1Link.setSrcConnectable(network2);
        network2Network1Link.setDstConnectable(network1);
        network2.addOutput(network2Network1Link);
        network1.addInput(network2Network1Link);
        propertyNetworkLink2.setMeasurable(network2Network1Link);
        network2Network1Link.addProperty(propertyNetworkLink2);

        Link network2Network3Link = new Link();
        network2Network3Link.setSrcInterface("Network2");
        network2Network3Link.setSrcConnectable(network2);
        network2Network3Link.setDstConnectable(network3);
        network2.addOutput(network2Network3Link);
        network3.addInput(network2Network3Link);
        propertyNetworkLink23.setMeasurable(network2Network3Link);
        network2Network3Link.addProperty(propertyNetworkLink23);

        Link network3Network2Link = new Link();
        network3Network2Link.setSrcInterface("Network3");
        network3Network2Link.setSrcConnectable(network3);
        network3Network2Link.setDstConnectable(network2);
        network3.addOutput(network3Network2Link);
        network2.addInput(network3Network2Link);
        propertyNetworkLink32.setMeasurable(network3Network2Link);
        network3Network2Link.addProperty(propertyNetworkLink32);

        Link pc3RouterLink = new Link();
        pc3RouterLink.setSrcInterface("Pc3");
        pc3RouterLink.setSrcConnectable(nodeInterfacePc3);
        pc3RouterLink.setDstConnectable(network3);
        nodeInterfacePc3.addOutput(pc3RouterLink);
        network3.addInput(pc3RouterLink);
        pc3RouterLink.addProperty(propertyPc3NetworkLink31);
        propertyPc3NetworkLink31.setMeasurable(pc3RouterLink);

        Link routerPc3Link = new Link();
        routerPc3Link.setSrcInterface("network3");
        routerPc3Link.setSrcConnectable(network3);
        routerPc3Link.setDstConnectable(nodeInterfacePc3);
        nodeInterfacePc3.addOutput(routerPc3Link);
        network3.addInput(routerPc3Link);
        routerPc3Link.addProperty(propertyPc3NetworkLink32);
        propertyPc3NetworkLink32.setMeasurable(routerPc3Link);

        AssignedLogicalRole assignedPc1Role = new AssignedLogicalRole();
        nodePc1.addAssignedLogicalRole(assignedPc1Role);
        assignedPc1Role.setNode(nodePc1);
        assignedPc1Role.setLogicalRole(logicalRoleAttacker);
        logicalRoleAttacker.addAssignedLogicalRole(assignedPc1Role);
        assignedPc1Role.setFrom(new Date());
        assignedPc1Role.setTo(new Date());

        AssignedLogicalRole assignedPc2Role = new AssignedLogicalRole();
        nodePc2.addAssignedLogicalRole(assignedPc2Role);
        assignedPc2Role.setNode(nodePc2);
        assignedPc2Role.setLogicalRole(logicalRoleVictim);
        logicalRoleVictim.addAssignedLogicalRole(assignedPc2Role);
        assignedPc2Role.setFrom(new Date());
        assignedPc2Role.setTo(new Date());

        // **********************************
        // ********** Persisting ************
        // **********************************
        logicalRoleDao.create(logicalRoleAttacker);
        logicalRoleDao.create(logicalRoleVictim);
        nodeDao.create(nodePc1);
        nodeDao.create(nodePc2);
        nodeDao.create(nodePc3);
        nodeDao.create(nodeServer);
        physicalRoleDao.create(physicalRolePc);
        physicalRoleDao.create(physicalRoleServer);
        assignedLogicalRoleDao.create(assignedPc1Role);
        assignedLogicalRoleDao.create(assignedPc2Role);
        networkDao.create(network1);
        networkDao.create(network2);
        networkDao.create(network3);
        linkDao.create(pc1RouterLink);
        linkDao.create(routerPc1Link);
        linkDao.create(pc2RouterLink);
        linkDao.create(routerPc2Link);
        linkDao.create(serverRouterLink);
        linkDao.create(routerServerLink);
        linkDao.create(network1Network2Link);
        linkDao.create(network2Network1Link);
        linkDao.create(network2Network3Link);
        linkDao.create(network3Network2Link);
        linkDao.create(routerPc3Link);
        linkDao.create(pc3RouterLink);
        propertyDao.create(propertyLink11);
        propertyDao.create(propertyLink12);
        propertyDao.create(propertyLink21);
        propertyDao.create(propertyLink22);
        propertyDao.create(propertyPc11);
        propertyDao.create(propertyPc12);
        propertyDao.create(propertyPc21);
        propertyDao.create(propertyPc22);
        propertyDao.create(propertyServer);
        propertyDao.create(propertyNetworkLink1);
        propertyDao.create(propertyNetworkLink2);
        propertyDao.create(propertyServerLink1);
        propertyDao.create(propertyServerLink2);
        propertyDao.create(propertyServerLink2);
        propertyDao.create(propertyNetworkLink23);
        propertyDao.create(propertyNetworkLink32);
        propertyDao.create(propertyPc3NetworkLink31);
        propertyDao.create(propertyPc3NetworkLink32);

        // **********************************
        // ************ Circle **************
        // **********************************

        if(cyclic) {
            Property propertyNetworkLink31 = new Property();
            propertyNetworkLink31.setName("Bandwidth");
            propertyNetworkLink31.setUnit("MB/s");
            propertyNetworkLink31.setValue("100");

            Link network1Network3Link = new Link();
            network1Network3Link.setSrcInterface("Network1");
            network1Network3Link.setSrcConnectable(network1);
            network1Network3Link.setDstConnectable(network3);
            network1.addOutput(network1Network3Link);
            network3.addInput(network1Network2Link);
            propertyNetworkLink31.setMeasurable(network1Network3Link);
            network1Network3Link.addProperty(propertyNetworkLink31);

            Link network3Network1Link = new Link();
            network3Network1Link.setSrcInterface("Network3");
            network3Network1Link.setSrcConnectable(network3);
            network3Network1Link.setDstConnectable(network1);
            network3.addOutput(network3Network1Link);
            network1.addInput(network3Network1Link);
            propertyNetworkLink32.setMeasurable(network3Network1Link);
            network3Network1Link.addProperty(propertyNetworkLink32);

            // Persisting data for cycling network topology.
            linkDao.create(network3Network1Link);
            linkDao.create(network1Network3Link);
        }
    }

    /**
     * Creates a topology with 2 routers, 1 PC with 2 interfaces connected to each router.
     */
    public void load1Node2Routers() {
        LogicalRole logicalRoleAttacker = new LogicalRole();
        logicalRoleAttacker.setName("attacker");

        PhysicalRole physicalRolePc = new PhysicalRole();
        physicalRolePc.setName("desktop");

        Property propertyPc11 = new Property();
        propertyPc11.setName("RAM");
        propertyPc11.setUnit("GB");
        propertyPc11.setValue("8");

        Network network1 = new Network();
        network1.setCidr4("150.150.1.1");
        network1.setName("Lan1");

        Network network2 = new Network();
        network2.setCidr4("150.150.2.1");
        network2.setName("Lan2");

        Node nodePc1 = new Node();
        nodePc1.setName("Pc1");
        nodePc1.setPhysicalRole(physicalRolePc);
        nodePc1.addProperty(propertyPc11);
        propertyPc11.setMeasurable(nodePc1);

        NodeInterface nodeInterface1 = new NodeInterface();
        nodeInterface1.setIp4Addr("150.150.1.2");
        nodeInterface1.setNode(nodePc1);
        nodePc1.addNodeInterface(nodeInterface1);

        NodeInterface nodeInterface2 = new NodeInterface();
        nodeInterface2.setIp4Addr("150.150.2.2");
        nodeInterface2.setNode(nodePc1);
        nodePc1.addNodeInterface(nodeInterface2);

        Property propertyLink11 = new Property();
        propertyLink11.setName("Bandwidth");
        propertyLink11.setUnit("MB/s");
        propertyLink11.setValue("100");

        Property propertyLink12 = new Property();
        propertyLink12.setName("Bandwidth");
        propertyLink12.setUnit("MB/s");
        propertyLink12.setValue("100");

        Property propertyLink21 = new Property();
        propertyLink21.setName("Bandwidth");
        propertyLink21.setUnit("MB/s");
        propertyLink21.setValue("100");

        Property propertyLink22 = new Property();
        propertyLink22.setName("Bandwidth");
        propertyLink22.setUnit("MB/s");
        propertyLink22.setValue("100");

        Link pcRouter1Link = new Link();
        pcRouter1Link.setSrcInterface("Pc");
        pcRouter1Link.setSrcConnectable(nodeInterface1);
        pcRouter1Link.setDstConnectable(network1);
        nodeInterface1.addOutput(pcRouter1Link);
        network1.addInput(pcRouter1Link);
        pcRouter1Link.addProperty(propertyLink11);
        propertyLink11.setMeasurable(pcRouter1Link);

        Link router1PcLink = new Link();
        router1PcLink.setSrcInterface("Network1");
        router1PcLink.setSrcConnectable(network1);
        router1PcLink.setDstConnectable(nodeInterface1);
        network1.addOutput(router1PcLink);
        nodeInterface1.addInput(router1PcLink);
        router1PcLink.addProperty(propertyLink12);
        propertyLink12.setMeasurable(router1PcLink);

        Link pcRouter2Link = new Link();
        pcRouter2Link.setSrcInterface("Pc");
        pcRouter2Link.setSrcConnectable(nodeInterface2);
        pcRouter2Link.setDstConnectable(network2);
        nodeInterface2.addOutput(pcRouter2Link);
        network2.addInput(pcRouter2Link);
        pcRouter2Link.addProperty(propertyLink21);
        propertyLink21.setMeasurable(pcRouter2Link);

        Link router2PcLink = new Link();
        router2PcLink.setSrcInterface("Network2");
        router2PcLink.setSrcConnectable(network2);
        router2PcLink.setDstConnectable(nodeInterface2);
        network2.addOutput(router2PcLink);
        nodeInterface2.addInput(router2PcLink);
        router2PcLink.addProperty(propertyLink22);
        propertyLink22.setMeasurable(router2PcLink);

        AssignedLogicalRole assignedPc1Role = new AssignedLogicalRole();
        nodePc1.addAssignedLogicalRole(assignedPc1Role);
        assignedPc1Role.setNode(nodePc1);
        assignedPc1Role.setLogicalRole(logicalRoleAttacker);
        logicalRoleAttacker.addAssignedLogicalRole(assignedPc1Role);
        assignedPc1Role.setFrom(new Date());
        assignedPc1Role.setTo(new Date());

        // **********************************
        // ********** Persisting ************
        // **********************************

        logicalRoleDao.create(logicalRoleAttacker);
        nodeDao.create(nodePc1);
        physicalRoleDao.create(physicalRolePc);
        assignedLogicalRoleDao.create(assignedPc1Role);
        networkDao.create(network1);
        networkDao.create(network2);
        linkDao.create(pcRouter1Link);
        linkDao.create(router1PcLink);
        linkDao.create(pcRouter2Link);
        linkDao.create(router2PcLink);
        propertyDao.create(propertyLink11);
        propertyDao.create(propertyLink12);
        propertyDao.create(propertyLink21);
        propertyDao.create(propertyLink22);
        propertyDao.create(propertyPc11);
    }
}

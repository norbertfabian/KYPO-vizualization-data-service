package cz.muni.ics.kypo.topology;

import cz.muni.ics.kypo.topology.dao.interfaces.*;
import cz.muni.ics.kypo.topology.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * This class is used as a factory for creating entities with test data.
 * Using this factory class avoids duplicate code when creating
 * entities in test methods.
 * @author Norbert Fabian
 */
@Component
public class TestEntityFactory {

    // Used to avoid generated long duplicates in the uniqueLong method.
    private static Set<Long> generatedLongs = new HashSet<>();

    @Autowired
    private AssignedLogicalRoleDAO assignedLogicalRoleDao;

    @Autowired
    private ConnectableDAO connectableDao;

    @Autowired
    private LinkDAO linkDao;

    @Autowired
    private MeasurableDAO measurableDao;

    @Autowired
    private NetworkDAO networkDao;

    @Autowired
    private NodeInterfaceDAO nodeInterfaceDao;

    @Autowired
    private NodeDAO nodeDao;

    @Autowired
    private PhysicalRoleDAO physicalRoleDao;

    @Autowired
    private LogicalRoleDAO logicalRoleDao;

    @Autowired
    private PropertyDAO propertyDao;

    private Random random = new Random();

    public Node persistedNode() {
        Node node = node("TestNode", true);
        nodeDao.create(node);
        return node;
    }

    public Node persistedNode(String name) {
        Node node = node(name, true);
        nodeDao.create(node);
        return node;
    }

    public Node node(String name) {
        return node(name, false);
    }

    public Node node(String name, boolean persistedPr) {
        Node node = new Node();
        node.setName(name);
        PhysicalRole physicalRole = persistedPr ? persistedPhysicalRole() : physicalRole();
        physicalRole.addNode(node);
        node.setPhysicalRole(physicalRole);
        return node;
    }



    public NodeInterface persistedNodeInterface(Node node) {
        NodeInterface nodeInterface = nodeInterface(false);
        node.addNodeInterface(nodeInterface);
        nodeInterface.setNode(node);
        nodeInterfaceDao.create(nodeInterface);
        return nodeInterface;
    }

    public NodeInterface nodeInterface(boolean hasId) {
        NodeInterface nodeInterface = new NodeInterface();
        if(hasId) {
            nodeInterface.setId(uniqueLong());
        }
        nodeInterface.setIp4Addr("192.168.1.1");
        return nodeInterface;
    }

    public AssignedLogicalRole persistedLogicalRole(Date from, Date to) {
        AssignedLogicalRole assignedLogicalRole = assignedLogicalRole(from, to);
        assignedLogicalRoleDao.create(assignedLogicalRole);
        return assignedLogicalRole;
    }

    public AssignedLogicalRole assignedLogicalRole(Date from, Date to) {
        AssignedLogicalRole assignedLogicalRole = new AssignedLogicalRole();
        assignedLogicalRole.setFrom(from);
        assignedLogicalRole.setTo(to);
        Node node = persistedNode(randomString());
        LogicalRole logicalRole = persistedLogicalRole(randomString());
        assignedLogicalRole.setNode(node);
        assignedLogicalRole.setLogicalRole(logicalRole);
        return assignedLogicalRole;
    }

    public LogicalRole persistedLogicalRole(String name) {
        LogicalRole logicalRole = logicalRole(name);
        logicalRoleDao.create(logicalRole);
        return logicalRole;
    }

    public LogicalRole logicalRole(String name) {
        LogicalRole logicalRole = new LogicalRole();
        logicalRole.setName(name);
        return logicalRole;
    }

    public PhysicalRole persistedPhysicalRole(String name) {
        PhysicalRole physicalRole = physicalRole(name);
        physicalRoleDao.create(physicalRole);
        return physicalRole;
    }

    public PhysicalRole persistedPhysicalRole() {
        PhysicalRole physicalRole = physicalRole();
        physicalRoleDao.create(physicalRole);
        return physicalRole;
    }

    public PhysicalRole physicalRole() {
        return physicalRole(randomString());
    }

    public PhysicalRole physicalRole(String name) {
        PhysicalRole physicalRole = new PhysicalRole();
        physicalRole.setName(name);
        return physicalRole;
    }

    public Network persistedNetwork(String name, int connectedNodesAmount) {
        return network(name, connectedNodesAmount, false, true);
    }

    public Network network(String name, int connectedNodesAmount, boolean hasId) {
        return network(name, connectedNodesAmount, hasId, false);
    }

    public Link linkNodeInterfaceToNetwork(boolean isNodeDest, NodeInterface nodeInterface) {
        return linkNodeInterfaceToNetwork(isNodeDest, nodeInterface, false);
    }


    public Link linkNodeInterfaceToNetwork(boolean isNodeDest, NodeInterface nodeInterface, boolean hasId) {
        Link link = new Link();
        if(hasId) {
            link.setId(uniqueLong());
        }
        if(isNodeDest) {
            link.setSrcInterface("Network");
            link.setDstConnectable(nodeInterface);
            nodeInterface.addInput(link);
        } else {
            link.setSrcInterface("Pc");
            link.setSrcConnectable(nodeInterface);
            nodeInterface.addOutput(link);
        }
        return link;
    }

    public void connectBidirectionalPersisted(Connectable connectable1, Connectable connectable2) {
        linkDao.create(connectConnectables(connectable1, connectable2, false));
        linkDao.create(connectConnectables(connectable2, connectable1, false));
    }

    public void connectBidirectional(Connectable network1, Connectable network2, boolean hasId) {
        connectConnectables(network1, network2, hasId);
        connectConnectables(network2, network1, hasId);
    }

    public Link connectConnectables(Connectable source, Connectable target, boolean hasId) {
        Link link = new Link();
        if(hasId) {
            link.setId(uniqueLong());
        }
        link.setSrcConnectable(source);
        link.setDstConnectable(target);
        link.setSrcInterface("srcIntrfc");
        source.addOutput(link);
        target.addInput(link);
        return link;
    }

    private Network network(String name, int connectedNodesAmount, boolean hasId, boolean persisted) {
        Network network = new Network();
        if(hasId) {
            network.setId(uniqueLong());
        }
        network.setName(name);
        network.setCidr4("192.168.1.1");
        if(persisted) {
            networkDao.create(network);
        }
        for(int i = 0; i < connectedNodesAmount; i++) {
            Node node = node("node" + i + randomString());
            if(hasId) {
                node.setId(uniqueLong());
            }
            NodeInterface nodeInterface = nodeInterface(hasId);
            nodeInterface.setNode(node);
            node.addNodeInterface(nodeInterface);
            if(persisted && !hasId) {
                physicalRoleDao.create(node.getPhysicalRole());
                nodeDao.create(node);
                nodeInterfaceDao.create(nodeInterface);
            }
            Link linkOut = linkNodeInterfaceToNetwork(true, nodeInterface, hasId);
            Link linkIn = linkNodeInterfaceToNetwork(false, nodeInterface, hasId);
            network.addInput(linkIn);
            network.addOutput(linkOut);
            linkIn.setDstConnectable(network);
            linkOut.setSrcConnectable(network);
            if(persisted && !hasId) {
                linkDao.create(linkIn);
                linkDao.create(linkOut);
            }
        }
        return network;
    }

    private String randomString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    private Long uniqueLong() {
        Long generatedId = random.nextLong();
        while (generatedLongs.contains(generatedId)) {
            generatedId = random.nextLong();
        }
        return generatedId;
    }
}

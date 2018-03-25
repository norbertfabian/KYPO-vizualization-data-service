package cz.muni.ics.kypo.topology.transfer;

import cz.muni.ics.kypo.topology.model.Network;
import cz.muni.ics.kypo.topology.model.Node;
import cz.muni.ics.kypo.topology.model.NodeInterface;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * Created by Norbert Fabian on 10.7.17.
 */
@ApiObject(name = "Abstract node", description = "Base class for other objects used as node in topology.")
public abstract class AbstractNodeTo extends AbstractTo {

    @ApiObjectField(description = "IPv4 address for node interfaces or cidr address for routers(networks).")
    private String address4;

    @ApiObjectField(description = "IPv6 address for node interfaces or cidr address for routers(networks).")
    private String address6;

    @ApiObjectField(description = "Name of the node.")
    private String name;

    @ApiObjectField(description = "Physical role of the node in the topology.")
    private String physicalRole;

    protected AbstractNodeTo(Network network) {
        this.id = network.getId();
        this.setName(network.getName());
        this.setAddress4(network.getCidr4());
        this.setAddress6(network.getCidr6());
        this.setPhysicalRole("router");
    }

    protected AbstractNodeTo(NodeInterface nodeInterface) {
        Node node = nodeInterface.getNode();
        this.id = nodeInterface.getId();
        this.physicalRole = node.getPhysicalRole().getName();
        this.name = node.getName();
        this.address4 = nodeInterface.getIp4Addr();
        this.address6 = nodeInterface.getIp6Addr();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhysicalRole() {
        return physicalRole;
    }

    public void setPhysicalRole(String physicalRole) {
        this.physicalRole = physicalRole;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getAddress6() {
        return address6;
    }

    public void setAddress6(String address6) {
        this.address6 = address6;
    }
}

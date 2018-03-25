package cz.muni.ics.kypo.topology.model;

import javax.persistence.*;

/**
 * @author Fabian Norbert
 */
@Entity
@Table(name = "node_interface")
public class NodeInterface extends Connectable {

    @Column(name = "ip4_addr")
    private String ip4Addr;

    @Column(name = "ip6_addr")
    private String ip6Addr;

    @ManyToOne
    @JoinColumn(name = "measurable_id")
    private Node node;

    public String getIp4Addr() {
        return ip4Addr;
    }

    public void setIp4Addr(String ip4Addr) {
        this.ip4Addr = ip4Addr;
    }

    public String getIp6Addr() {
        return ip6Addr;
    }

    public void setIp6Addr(String ip6Addr) {
        this.ip6Addr = ip6Addr;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}

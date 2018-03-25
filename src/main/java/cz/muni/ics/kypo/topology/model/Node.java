package cz.muni.ics.kypo.topology.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Fabian Norbert
 */
@Entity
@Table(name = "node")
public class Node extends Measurable {

    @Column(unique = true)
    private String name;

    @Fetch(FetchMode.JOIN)
    @OneToMany(mappedBy = "node", cascade=CascadeType.ALL)
    private Set<AssignedLogicalRole> assignedLogicalRoles = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "physical_role_id")
    private PhysicalRole physicalRole;

    @Fetch(FetchMode.JOIN)
    @OneToMany(mappedBy = "node", cascade=CascadeType.ALL)
    private Set<NodeInterface> nodeInterfaces = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AssignedLogicalRole> getAssignedLogicalRoles() {
        return assignedLogicalRoles;
    }

    public void setAssignedLogicalRoles(Set<AssignedLogicalRole> assignedLogicalRoles) {
        this.assignedLogicalRoles = assignedLogicalRoles;
    }

    public PhysicalRole getPhysicalRole() {
        return physicalRole;
    }

    public void setPhysicalRole(PhysicalRole physicalRole) {
        this.physicalRole = physicalRole;
    }

    public Set<NodeInterface> getNodeInterfaces() {
        return nodeInterfaces;
    }

    public void setNodeInterfaces(Set<NodeInterface> nodeInterfaces) {
        this.nodeInterfaces = nodeInterfaces;
    }

    public void addNodeInterface(NodeInterface nodeInterface) {
        nodeInterfaces.add(nodeInterface);
    }

    public void removeNodeInterface(NodeInterface nodeInterface) {
        nodeInterfaces.remove(nodeInterface);
    }

    public void addAssignedLogicalRole(AssignedLogicalRole assignedLogicalRole) {
        assignedLogicalRoles.add(assignedLogicalRole);
    }

    public void removeAssignedLogicalRole(AssignedLogicalRole assignedLogicalRole) {
        assignedLogicalRoles.remove(assignedLogicalRole);
    }
}

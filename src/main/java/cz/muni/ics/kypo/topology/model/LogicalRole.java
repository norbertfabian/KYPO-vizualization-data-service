package cz.muni.ics.kypo.topology.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fabian Norbert
 */
@Entity
@Table(name = "logical_role")
public class LogicalRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "logicalRole", cascade=CascadeType.ALL)
    private List<AssignedLogicalRole> assignedLogicalRoles = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AssignedLogicalRole> getAssignedLogicalRoles() {
        return assignedLogicalRoles;
    }

    public void setAssignedLogicalRoles(List<AssignedLogicalRole> assignedLogicalRoles) {
        this.assignedLogicalRoles = assignedLogicalRoles;
    }

    public void addAssignedLogicalRole(AssignedLogicalRole alr) {
        assignedLogicalRoles.add(alr);
    }

    public void removeAssignedLogicalRole(AssignedLogicalRole alr) {
        assignedLogicalRoles.remove(alr);
    }
}

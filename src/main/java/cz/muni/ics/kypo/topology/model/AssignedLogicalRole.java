package cz.muni.ics.kypo.topology.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Fabian Norbert
 */
@Entity
@Table(name = "assigned_logical_role")
public class AssignedLogicalRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private LogicalRole logicalRole;

    @ManyToOne
    @JoinColumn(name = "measurable_id")
    private Node node;

    @Column(name="`from`")
    private Date from;

    @Column(name="`to`")
    private Date to;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LogicalRole getLogicalRole() {
        return logicalRole;
    }

    public void setLogicalRole(LogicalRole logicalRole) {
        this.logicalRole = logicalRole;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }


}

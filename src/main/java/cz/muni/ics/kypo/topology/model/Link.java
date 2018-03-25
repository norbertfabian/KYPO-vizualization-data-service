package cz.muni.ics.kypo.topology.model;

import javax.persistence.*;

/**
 * @author Fabian Norbert
 */
@Entity
@Table(name = "link")
public class Link extends Measurable {

    @Column(name = "src_interface")
    private String srcInterface;

    @ManyToOne
    @JoinColumn(name = "src_connectable_id")
    private Connectable srcConnectable;

    @ManyToOne
    @JoinColumn(name = "dst_connectable_id")
    private Connectable dstConnectable;

    public String getSrcInterface() {
        return srcInterface;
    }

    public void setSrcInterface(String srcInterface) {
        this.srcInterface = srcInterface;
    }

    public Connectable getSrcConnectable() {
        return srcConnectable;
    }

    public void setSrcConnectable(Connectable srcConnectable) {
        this.srcConnectable = srcConnectable;
    }

    public Connectable getDstConnectable() {
        return dstConnectable;
    }

    public void setDstConnectable(Connectable dstConnectable) {
        this.dstConnectable = dstConnectable;
    }
}

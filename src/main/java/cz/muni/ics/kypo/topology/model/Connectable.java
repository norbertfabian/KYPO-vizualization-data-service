package cz.muni.ics.kypo.topology.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Fabian Norbert
 */
@Entity
@Table(name = "connectable")
public abstract class Connectable extends Hardware {

    private String firewall;

    @OneToMany(mappedBy = "srcConnectable")
    private Set<Link> outputs = new HashSet<>();

    @OneToMany(mappedBy = "dstConnectable")
    private Set<Link> inputs = new HashSet<>();

    public String getFirewall() {
        return firewall;
    }

    public void setFirewall(String firewall) {
        this.firewall = firewall;
    }

    public Set<Link> getOutputs() {
        return outputs;
    }

    public void setOutputs(Set<Link> links) {
        this.outputs = links;
    }

    public void addOutput(Link link) {
        outputs.add(link);
    }

    public void removeOutput(Link link) {
        outputs.remove(link);
    }

    public Set<Link> getInputs() {
        return inputs;
    }

    public void setInputs(Set<Link> links) {
        this.inputs = links;
    }

    public void addInput(Link link) {
        inputs.add(link);
    }

    public void removeInput(Link link) {
        inputs.remove(link);
    }
}

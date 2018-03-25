package cz.muni.ics.kypo.topology.transfer;

import cz.muni.ics.kypo.topology.model.Network;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by norbert on 8.8.17.
 */
@ApiObject(name = "Router Node", description = "Contains information about router node in the topology.")
public class RouterTo extends AbstractNodeTo {

    @ApiObjectField(description = "List of node interfaces connected to this router. " +
            "This field is called \"children\" in returned JSON because that name is " +
            "specifically needed by d3.js in visualization of topology.")
    private Set<AbstractNodeTo> children = new HashSet<>();

    public RouterTo(Network network) {
        super(network);
    }

    public Set<AbstractNodeTo> getChildren() {
        return children;
    }

    public void setChildren(Set<AbstractNodeTo> children) {
        this.children = children;
    }

    public void addChildren(AbstractNodeTo node) {
        this.children.add(node);
    }

    public void removeChildren(AbstractNodeTo node) {
        this.children.remove(node);
    }
}

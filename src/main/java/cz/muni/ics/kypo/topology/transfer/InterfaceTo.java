package cz.muni.ics.kypo.topology.transfer;

import cz.muni.ics.kypo.topology.model.NodeInterface;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * Created by norbert on 8.8.17.
 */
@ApiObject(name = "Node Interface", description = "Contains information about node's interface in topology.")
public class InterfaceTo extends AbstractNodeTo {

    @ApiObjectField(description = "Identifier of node-interface's host node (computer).")
    private Long hostNodeId;

    public InterfaceTo(NodeInterface nodeInterface) {
        super(nodeInterface);
        this.hostNodeId = nodeInterface.getNode().getId();
    }

    public Long getHostNodeId() {
        return hostNodeId;
    }

    public void setHostNodeId(Long hostNodeId) {
        this.hostNodeId = hostNodeId;
    }
}

package cz.muni.ics.kypo.topology.transfer;

import cz.muni.ics.kypo.topology.model.Link;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * Created by Norbert Fabian on 10.7.17.
 */
@ApiObject(name = "Link", description = "Link between interfaces.")
public class LinkTo extends AbstractTo{

    @ApiObjectField(description = "Identifier of the source interface.")
    private Long sourceId;

    @ApiObjectField(description = "Identifier of the target interface.")
    private Long targetId;

    public LinkTo() {
    }

    public LinkTo(Link link) {
        this.id = link.getId();
        this.sourceId = link.getSrcConnectable().getId();
        this.targetId = link.getDstConnectable().getId();
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }
}

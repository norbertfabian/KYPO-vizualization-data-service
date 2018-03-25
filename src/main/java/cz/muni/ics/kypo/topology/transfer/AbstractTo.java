package cz.muni.ics.kypo.topology.transfer;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * Created by Norbert Fabian on 24.7.17.
 */
@ApiObject(name = "Abstract Topology object", description = "Base class for other objects used in topology. Carries the ID of the object.")
public class AbstractTo {

    @ApiObjectField(description = "Identifier of the object.")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractTo that = (AbstractTo) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}

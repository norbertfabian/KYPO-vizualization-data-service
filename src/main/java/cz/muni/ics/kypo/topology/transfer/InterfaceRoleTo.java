package cz.muni.ics.kypo.topology.transfer;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * Created by norbert on 25.7.17.
 */
@ApiObject(name = "Node Interface Role", description = "Denotes the logical role of node interface in the network topology.")
public class InterfaceRoleTo extends AbstractTo {

    @ApiObjectField(description = "The logical role of the node interface.")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        InterfaceRoleTo that = (InterfaceRoleTo) o;

        return getRole() != null ? getRole().equals(that.getRole()) : that.getRole() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
        return result;
    }
}

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
@Table(name = "measurable")
public abstract class Measurable extends Hardware {

    @Fetch(FetchMode.JOIN)
    @OneToMany(mappedBy = "measurable", cascade=CascadeType.ALL)
    private Set<Property> properties = new HashSet<>();

    public Set<Property> getProperties() {
        return properties;
    }

    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public void removeProperty(Property property) {
        properties.remove(property);
    }
}

package cz.muni.ics.kypo.topology.model;

import javax.persistence.*;

/**
 * @author Fabian Norbert
 */
@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String value;

    private String unit;

    @ManyToOne
    @JoinColumn(name = "measurable_id")
    private Measurable measurable;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Measurable getMeasurable() {
        return measurable;
    }

    public void setMeasurable(Measurable measurable) {
        this.measurable = measurable;
    }
}

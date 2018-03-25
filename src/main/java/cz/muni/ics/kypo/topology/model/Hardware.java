package cz.muni.ics.kypo.topology.model;

import javax.persistence.*;

/**
 * Created by norbert on 7.8.17.
 */
@Entity
@Table(name = "hardware")
@Inheritance(strategy = InheritanceType.JOINED)
public class Hardware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

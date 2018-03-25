package cz.muni.ics.kypo.topology.model;

import javax.persistence.*;

/**
 * @author Fabian Norbert
 */
@Entity
@Table(name = "network")
public class Network extends Connectable {

    @Column(unique = true)
    private String name;

    private String cidr4;

    private String cidr6;

    @Column(name = "mng_ip_address")
    private String mngIpAddress;

    @Column(name = "mng_interface")
    private String mngInterface;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCidr4() {
        return cidr4;
    }

    public void setCidr4(String cidr4) {
        this.cidr4 = cidr4;
    }

    public String getCidr6() {
        return cidr6;
    }

    public void setCidr6(String cidr6) {
        this.cidr6 = cidr6;
    }

    public String getMngIpAddress() {
        return mngIpAddress;
    }

    public void setMngIpAddress(String mngIpAddress) {
        this.mngIpAddress = mngIpAddress;
    }

    public String getMngInterface() {
        return mngInterface;
    }

    public void setMngInterface(String mngInterface) {
        this.mngInterface = mngInterface;
    }
}

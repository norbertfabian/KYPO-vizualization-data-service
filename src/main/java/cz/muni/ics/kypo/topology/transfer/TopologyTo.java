package cz.muni.ics.kypo.topology.transfer;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Norbert Fabian on 10.7.17.
 */
@ApiObject(name = "Topology", description = "Describes the network topology. Topology consists of routers, node interfaces" +
        " connected to these routers and links between routers. Topology structure is specifically prepared for topology visualization.")
public class TopologyTo {

    @ApiObjectField(description = "List of routers in topology. This field is called \"children\" in returned JSON because that name is " +
            "specifically needed by d3.js in visualization of topology.")
    private Set<RouterTo> children = new HashSet<>();

    @ApiObjectField(description = "List of links between interfaces in topology.")
    private Set<LinkTo> links = new HashSet<>();

    @ApiObjectField(description = "List of links between routers in topology.")
    private Set<LinkTo> routerLinks = new HashSet<>();

    public Set<RouterTo> getChildren() {
        return children;
    }

    public void setChildren(Set<RouterTo> children) {
        this.children = children;
    }

    public Set<LinkTo> getLinks() {
        return links;
    }

    public void setLinks(Set<LinkTo> links) {
        this.links = links;
    }

    public Set<LinkTo> getRouterLinks() {
        return routerLinks;
    }

    public void setRouterLinks(Set<LinkTo> routerLinks) {
        this.routerLinks = routerLinks;
    }

    public void addChild(RouterTo routerTo) {
        this.children.add(routerTo);
    }

    public void removeChild(RouterTo routerTo) {
        this.children.remove(routerTo);
    }

    public void addLink(LinkTo link) {
        this.links.add(link);
    }

    public void removeLink(LinkTo link) {
        this.links.remove(link);
    }

    public void addRouterLink(LinkTo link) {
        this.routerLinks.add(link);
    }

    public void removeRouterLink(LinkTo link) {
        this.routerLinks.remove(link);
    }

}

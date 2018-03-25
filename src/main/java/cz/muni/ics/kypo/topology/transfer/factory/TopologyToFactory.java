package cz.muni.ics.kypo.topology.transfer.factory;

import cz.muni.ics.kypo.topology.model.*;
import cz.muni.ics.kypo.topology.transfer.InterfaceTo;
import cz.muni.ics.kypo.topology.transfer.LinkTo;
import cz.muni.ics.kypo.topology.transfer.RouterTo;
import cz.muni.ics.kypo.topology.transfer.TopologyTo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Factory class for creating a TopologyTo.
 * Created by Norbert Fabian on 25.7.17.
 */
public class TopologyToFactory {

    /**
     * Creates a TopologyTo instance.
     * @param links List of all links in the topology.
     * @param networks List of all networks in the topology.
     * @return TopologyTo instance.
     */
    public TopologyTo create(List<Link> links, List<Network> networks) {
        TopologyTo topologyTo = new TopologyTo();

        for(Link link: links) {
            LinkTo linkTo = new LinkTo(link);
            if(link.getSrcConnectable() instanceof Network && link.getDstConnectable() instanceof Network) {
                topologyTo.addRouterLink(linkTo);
            } else {
                topologyTo.addLink(linkTo);
            }
        }

        topologyTo.setChildren(createChildren(networks));

        return topologyTo;
    }

    /**
     * Creates a list of children for TopologyTo. The list contains NodeTos created from all the networks
     * with their children. Children of a AbstractNodeTo created from network contains only
     * child AbstractNodeTo created from a NodeInterface.
     * @param networks List of all the Networks of the topology.
     * @return Set of RouterTos created from Networks with their children.
     */
    private Set<RouterTo> createChildren(List<Network> networks) {
        Set<RouterTo> children = new HashSet<>();
        for(Network network: networks) {
            RouterTo routerTo = new RouterTo(network);

            // It's enough to iterate just the outputs
            // because between each Connectable there are links in both directions.
            for(Link link: network.getOutputs()) {
                Connectable destInterface = link.getDstConnectable();
                if(destInterface instanceof NodeInterface) {
                    NodeInterface nodeInterface = (NodeInterface) destInterface;
                    routerTo.addChildren(new InterfaceTo(nodeInterface));
                }
            }
            children.add(routerTo);
        }
        return children;
    }
}

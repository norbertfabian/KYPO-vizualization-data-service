package cz.muni.ics.kypo.topology.service;

import cz.muni.ics.kypo.topology.transfer.AbstractNodeTo;
import cz.muni.ics.kypo.topology.transfer.LinkTo;
import cz.muni.ics.kypo.topology.transfer.RouterTo;
import org.junit.Assert;

import java.util.Date;
import java.util.Set;

/**
 * Created by norbert on 1.8.17.
 */
public abstract class AbstractTopologyServiceTest {


    protected void assertLinks(Set<LinkTo> linkTos, Set<RouterTo> nodes) {
        for(LinkTo link: linkTos) {
            Assert.assertNotNull("Link source id is null", link.getSourceId());
            Assert.assertNotNull("Link target id is null", link.getTargetId());
            Assert.assertTrue("Link is not a router-node connection",
                    isExistingRouterNodeConnection(link, nodes));
        }
    }

    protected boolean isExistingRouterNodeConnection(LinkTo link, Set<RouterTo> routers) {
        for(RouterTo router: routers) {
            if(link.getSourceId().equals(router.getId())) {
                for(AbstractNodeTo node: router.getChildren()) {
                    if(link.getTargetId().equals(node.getId())) {
                        return true;
                    }
                }
                return false;
            }

            if(link.getTargetId().equals(router.getId())) {
                for(AbstractNodeTo node: router.getChildren()) {
                    if(link.getSourceId().equals(node.getId())) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    protected void assertRouterLinks(Set<LinkTo> linkTos, Set<RouterTo> networks) {
        for(final LinkTo link: linkTos) {
            Assert.assertTrue("RouterLinks source id is not an existing router id",
                    networks.stream().anyMatch(n -> n.getId().equals(link.getSourceId())));
            Assert.assertTrue("RouterLinks target id is not an existing router id",
                    networks.stream().anyMatch(n -> n.getId().equals(link.getTargetId())));
        }
    }

    protected Date toDate(long time) {
        Date date = new Date();
        date.setTime(time);
        return date;
    }
}

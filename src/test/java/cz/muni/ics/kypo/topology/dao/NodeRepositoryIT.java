package cz.muni.ics.kypo.topology.dao;

import cz.muni.ics.kypo.topology.TestEntityFactory;
import cz.muni.ics.kypo.topology.configuration.HibernateTestConfig;
import cz.muni.ics.kypo.topology.dao.interfaces.NodeDAO;
import cz.muni.ics.kypo.topology.model.Node;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Fabian Norbert
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class NodeRepositoryIT {

    @Autowired
    private NodeDAO nodeDAO;

    @Autowired
    private TestEntityFactory entityFactory;

    @Test
    public void createTest() {
        Node nodeToSave1 = entityFactory.node("TestNode1", true);
        Node nodeToSave2 = entityFactory.node("TestNode2", true);

        nodeDAO.create(nodeToSave1);
        nodeDAO.create(nodeToSave2);
        Node loadedNode1 = nodeDAO.get(nodeToSave1.getId());
        Node loadedNode2 = nodeDAO.get(nodeToSave2.getId());

        Assert.assertEquals("Saved node has wrong ID.", Long.valueOf(1), nodeToSave1.getId());
        Assert.assertEquals("Saved node has wrong ID.", Long.valueOf(2), nodeToSave2.getId());
        Assert.assertEquals("Loaded node has different name.", "TestNode1", loadedNode1.getName());
        Assert.assertEquals("Loaded node has different name.", "TestNode2", loadedNode2.getName());
    }
}

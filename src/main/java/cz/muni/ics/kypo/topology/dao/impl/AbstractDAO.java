package cz.muni.ics.kypo.topology.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Norbert Fabian
 */
@Transactional(transactionManager = "topologyTransactionManager")
public abstract class AbstractDAO {

    @Autowired
    @Qualifier(value="topologySessionFactory")
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}

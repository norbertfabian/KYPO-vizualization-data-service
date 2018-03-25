package cz.muni.ics.kypo.topology.configuration;

import cz.muni.ics.kypo.topology.loader.SampleDataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

/**
 * This configuration is to fire the test data loading during the startup.
 * Use only for testing purposes.
 *
 * Created by norbert on 17.7.17.
 */
@Configuration
public class DataLoaderConfiguration {

    final static Logger log = LoggerFactory.getLogger(DataLoaderConfiguration.class);

    @Autowired
    private SampleDataLoader loader;

    // Uncomment, when testing data loading needed.
    @PostConstruct
    public void dataLoading() {
        log.debug("dataLoading()");
//        loader.loadData(); // Remove this if you don't want testing data.
    }
}

package cz.muni.ics.kypo.topology.loader;

/**
 * This class is responsible for loading of the testing data during the service startup.
 * Created by norbert on 17.7.17.
 */
public interface SampleDataLoader {

    /**
     * This method is fired at the application startup.
     */
    void loadData();
}

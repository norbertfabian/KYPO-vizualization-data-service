package cz.muni.ics.kypo.topology.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Norbert Fabian
 */

@Configuration
@ComponentScan(basePackages = "cz.muni.ics.kypo.topology")
@EnableAsync
@EnableScheduling
@Import(cz.muni.ics.kypo.idm.configuration.IdmAppConfig.class)
public class TopologyAppConfig {
}

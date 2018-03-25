package cz.muni.ics.kypo.topology.multiTenant;

import cz.muni.ics.kypo.idm.service.interfaces.SandboxService;
import cz.muni.ics.kypo.topology.multiTenant.exception.SandboxNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by norbert on 2.10.17.
 */
@Service
public class SiteToAddressResolver {

    @Autowired
    private SandboxService sandboxService;

    public String toAddress(String site) {
        String sandboxUrl = sandboxService.getSandboxUrlBySite(site);
        if(sandboxUrl == null) {
            throw new SandboxNotFoundException("Sandbox for site '" + site + "' not found.");
        }
        return sandboxUrl;
    }
}

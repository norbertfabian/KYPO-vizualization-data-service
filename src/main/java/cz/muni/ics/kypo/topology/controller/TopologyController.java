package cz.muni.ics.kypo.topology.controller;

import cz.muni.ics.kypo.topology.multiTenant.tenant.TenantContext;
import cz.muni.ics.kypo.topology.service.interfaces.TopologyService;
import cz.muni.ics.kypo.topology.transfer.InterfaceRoleTo;
import cz.muni.ics.kypo.topology.transfer.TopologyTo;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiParam;
import org.jsondoc.core.pojo.ApiParamType;
import org.jsondoc.core.pojo.ApiVerb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Controller for handling REST HTTP requests about the topology.
 * Created by norbert on 10.7.17.
 */
@Api(name = "Visualization data service", description = "Methods for providing network topology information")
@RestController
@RequestMapping("/{site}/topology")
public class TopologyController {

    @Autowired
    private TopologyService topologyService;

    @ApiMethod(
            path="/{site}/topology",
            verb= ApiVerb.GET,
            description="Returns the network topology. Topology consists of routers, links between routers " +
                    "and nodes (or interfaces) connected to those routers. The site is specifying the site, " +
                    "where the user is and this information is used to choose the correct sandbox while getting data.",
            produces={MediaType.APPLICATION_JSON_VALUE}
    )
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public TopologyTo getTopology(
            @ApiParam(name="site", description="ID of the site, where the user is.", paramType = ApiParamType.PATH)
            @PathVariable String site) {
        TenantContext.setCurrentTenant(site);
        return topologyService.getTopology();
    }

    @ApiMethod(
            path="/{site}/topology/logicalRoles?experimentStart={experimentStart}&absoluteTimestamp={absoluteTimestamp}",
            verb= ApiVerb.GET,
            description="Gets the logical roles of all the interfaces in network at specified absolute time. " +
                    "Returns a list of Node Interface Roles called \"interfaceRoles\".",
            produces={MediaType.APPLICATION_JSON_VALUE}
    )
    @RequestMapping(value = "/logicalRoles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<InterfaceRoleTo> getLogicalRoles(
            @ApiParam(name="site", description="ID of the site, where the user is.", paramType = ApiParamType.PATH)
            @PathVariable String site,
            @ApiParam(name="absoluteTimestamp", description="Timestamp formatted as Unix time.", paramType = ApiParamType.QUERY)
            @RequestParam(value = "absoluteTimestamp", required = true) Long absoluteTimestamp,
            @ApiParam(name="experimentStart", description="The first timestamp of the experiment formatted as Unix time.", paramType = ApiParamType.QUERY)
            @RequestParam(value = "experimentStart", required = true) Long experimentStart) {
        TenantContext.setCurrentTenant(site);
        return topologyService.getInterfaceRoles(experimentStart, absoluteTimestamp);
    }
}

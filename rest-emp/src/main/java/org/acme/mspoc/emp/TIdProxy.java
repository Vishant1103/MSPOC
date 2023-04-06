package org.acme.mspoc.emp;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "TIdProxy")
@Path("/api/tid")
public interface TIdProxy {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    TId generate();
}

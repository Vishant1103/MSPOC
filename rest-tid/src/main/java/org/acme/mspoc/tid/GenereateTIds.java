package org.acme.mspoc.tid;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("/api/tid")
@Tag(name = "TId Rest Endpoint")
public class GenereateTIds {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Generating TId's",
            description = "Generate 8-digit long TId in form of string"
    )
    public tid generate(){
        tid id = new tid();
        id.setTid("T0" + new Random().nextInt(1000000));

        return id;
    }
}

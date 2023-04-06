package org.acme.mspoc.emp;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Instant;

@Path("/api")
public class createEmployee {

    @Inject
    @RestClient
    TIdProxy proxy;

    @Inject
    Logger logger;

    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Fallback(fallbackMethod = "fallbackOnCreateEmployee")
    public Response create(@FormParam("name") String name, @FormParam("title") String title, @FormParam("yoj") int yoj){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setTitle(title);
        employee.setYoj(yoj);
        employee.setTid(proxy.generate().getTid());
        logger.info("Created" + employee);

        return Response.status(201).entity(employee).build();
    }



    public Response fallbackOnCreateEmployee(String name, String title, int yoj) throws FileNotFoundException {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setTitle(title);
        employee.setYoj(yoj);
        employee.setTid("T0 - Will Generate Later");
        saveEmployeeOnDisk(employee);
        logger.warn("Employee saved on disk" + employee);

        return Response.status(206).entity(employee).build();
    }

    private void saveEmployeeOnDisk(Employee employee) throws FileNotFoundException {
        String empJson = JsonbBuilder.create().toJson(employee);

        try(PrintWriter out = new PrintWriter("employee + " + Instant.now().toEpochMilli() + ".json")){
            out.println(empJson);
        }
    }
}

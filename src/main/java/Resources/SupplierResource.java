package Resources;

import Domain.http.SupplierHttp;
import Services.SupplierService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/supplier")
public class SupplierResource {

    private final SupplierService service;

    public SupplierResource(SupplierService service) {
        this.service = service;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<Void> create(SupplierHttp supplierHttp, @Context UriInfo uriInfo) {
        this.service.create(supplierHttp);
        return RestResponse.created(uriInfo.getAbsolutePath());
    }

    @Path("{id}")
    @DELETE
    public RestResponse<Void> delete(Long id) {
        this.service.delete(id);
        return RestResponse.noContent();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<SupplierHttp> get(Long id) {
        return RestResponse.ok(this.service.get(id));
    }


}

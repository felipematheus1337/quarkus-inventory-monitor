package Resources;

import Domain.http.ItemHttp;
import Services.ItemService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/item")
public class ItemResource {

    private final ItemService itemService;

    @Inject
    public ItemResource(ItemService itemService) {
        this.itemService = itemService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<Void> createItem(ItemHttp itemHttp, @Context UriInfo uriInfo) {
        this.itemService.createItem(itemHttp);
        return RestResponse.created(uriInfo.getAbsolutePath());
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<ItemHttp> get(Long id) {
        return RestResponse.ok(this.itemService.getById(id));
    }

    @DELETE
    @Path("{id}")
    public RestResponse<Void> delete(Long id) {
        this.itemService.delete(id);
        return RestResponse.noContent();
    }

}

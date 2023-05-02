package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Customer;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.CustomersDAO;
import lt.vu.rest.contracts.CustomerDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@LoggedInvocation
@Path("/customers")
public class CustomersController {

    @Inject
    @Getter @Setter
    private CustomersDAO customersDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Customer customer = customersDAO.findOne(id);
        if (customer == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setAddress(customer.getAddress());

        return Response.ok(customerDto).build();
    }

    @Path("/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer id, CustomerDto c) {
        Customer existingCustomer = customersDAO.findOne(id);
        if (existingCustomer == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        existingCustomer.setEmail(c.getEmail());
        existingCustomer.setName(c.getName());
        existingCustomer.setAddress(c.getAddress());
        customersDAO.update(existingCustomer);
        return Response.ok().build();
    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(CustomerDto c) {
        Customer customer = new Customer();
        customer.setAddress(c.getAddress());
        customer.setName(c.getName());
        customer.setEmail(c.getEmail());
        customersDAO.persist(customer);
        return Response.ok(Response.Status.CREATED).build();
    }
}

package com.exercicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.util.List;



@Component
@Path("user")
public class UsuarioResource {

    @Autowired
    UsuarioService usuarioService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        List<Usuario> allUsers = usuarioService.getAllUsers();
        return Response.ok(allUsers).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getUser(@PathParam("id") int id) {
        Usuario user = usuarioService.getUserById(id);
        return Response.ok(user).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(Usuario user) {
        usuarioService.addUser(user);
        return Response.created(URI.create("/" + user.getId())).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateUser (@PathParam("id") int id, Usuario user) {
        usuarioService.updateUser(id, user);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int id) {
        usuarioService.removeUser(id);
        return Response.noContent().build();
    }


}

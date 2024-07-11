package com.app.resources;

import com.app.services.interfaces.IAuthService;
import com.app.viewModels.AuthViewModel;
import com.app.viewModels.LoginRequestViewModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Tag(name = "Auth")
@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {
    @Inject
    private IAuthService authService;

    @POST
    @Path("/login")
    public AuthViewModel login(LoginRequestViewModel loginRequestViewModel) {
        return authService.login(loginRequestViewModel);
    }

}

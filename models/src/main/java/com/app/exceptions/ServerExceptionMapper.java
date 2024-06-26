package com.app.exceptions;

import com.app.viewModels.ErrorResponse;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;


public class ServerExceptionMapper implements ExceptionMapper<WebApplicationException> {
    @Override
    public Response toResponse(WebApplicationException exception) {
        String message = exception.getMessage();
        Response response = exception.getResponse();
        Response.Status status = response.getStatusInfo().toEnum();
        ErrorResponse error = new ErrorResponse(status.getStatusCode(), message);
        return Response.status(status)
                .entity(error)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}


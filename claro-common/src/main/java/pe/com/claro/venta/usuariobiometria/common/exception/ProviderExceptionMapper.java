package pe.com.claro.venta.usuariobiometria.common.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonParseException;

import pe.com.claro.venta.usuariobiometria.common.exception.ApiException;
import pe.com.claro.venta.usuariobiometria.common.exception.BadRequestException;
import pe.com.claro.venta.usuariobiometria.common.exception.NotFoundException;
import pe.com.claro.venta.usuariobiometria.common.property.Constantes;
import pe.com.claro.venta.usuariobiometria.common.util.ApiResponse;

@Provider
public class ProviderExceptionMapper implements ExceptionMapper<Exception> {

    private static final Logger LOG = LoggerFactory.getLogger(ProviderExceptionMapper.class);

    public Response toResponse(Exception exception) {
		if (exception instanceof javax.ws.rs.WebApplicationException) {
		    javax.ws.rs.WebApplicationException e = (javax.ws.rs.WebApplicationException) exception;
		    LOG.error(Constantes.LOG_SEIS_LLAVES, Constantes.ERROR, WebApplicationException.class, Constantes.CORCHETES_EXCEPTION, e.getMessage(), Constantes.CORCHETE_CERRADO_EXCEPTION, e);
		    return Response.status(e.getResponse().getStatus()).entity(new ApiResponse(e.getResponse().getStatus(), exception.getMessage())).build();
		}
		else if (exception instanceof com.fasterxml.jackson.core.JsonParseException) {
		    LOG.error(Constantes.LOG_SEIS_LLAVES,  Constantes.ERROR, JsonParseException.class, Constantes.CORCHETES_EXCEPTION,exception.getMessage(), Constantes.CORCHETE_CERRADO_EXCEPTION, exception);
		    return Response.status(Status.BAD_REQUEST).entity(new ApiResponse(ApiResponse.ERROR, "Entrada incorrecta")).build();
		}
		else if (exception instanceof NotFoundException) {
		    LOG.error(Constantes.LOG_SEIS_LLAVES, Constantes.ERROR, WebApplicationException.class, Constantes.CORCHETES_EXCEPTION, exception.getMessage(), Constantes.CORCHETE_CERRADO_EXCEPTION, exception);
		    return Response.status(((NotFoundException) exception).getStatus()).entity(new ErrorMessage((NotFoundException) exception)).type(MediaType.APPLICATION_JSON).build();
		}
		else if (exception instanceof BadRequestException) {
		    LOG.error(Constantes.LOG_SEIS_LLAVES, Constantes.ERROR, BadRequestException.class, Constantes.CORCHETES_EXCEPTION, exception.getMessage(), Constantes.CORCHETE_CERRADO_EXCEPTION, exception);
		    return Response.status(((BadRequestException) exception).getStatus()).entity(new ErrorMessage((BadRequestException) exception)).type(MediaType.APPLICATION_JSON).build();
		}
		else if (exception instanceof ApiException) {
		    LOG.error(Constantes.LOG_SEIS_LLAVES, Constantes.ERROR, ApiException.class, Constantes.CORCHETES_EXCEPTION, exception.getMessage(), Constantes.CORCHETE_CERRADO_EXCEPTION, exception);
		    return Response.status(((ApiException) exception).getStatus()).entity(new ErrorMessage((ApiException) exception)).type(MediaType.APPLICATION_JSON).build();
		}
		else if (exception instanceof BadUsageException) {
		    LOG.error(Constantes.LOG_SEIS_LLAVES, Constantes.ERROR, BadUsageException.class, Constantes.CORCHETES_EXCEPTION, exception.getMessage(), Constantes.CORCHETE_CERRADO_EXCEPTION, exception);
		    return Response.status(((BadUsageException) exception).getStatus()).entity(new ErrorMessage((BadUsageException) exception)).type(MediaType.APPLICATION_JSON).build();
		}
		else {
		    LOG.error(Constantes.LOG_CUATRO_LLAVES, Constantes.ERROR, exception.getMessage(), Constantes.CORCHETE_CERRADO_EXCEPTION, exception);
		    return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ApiResponse(ApiResponse.ERROR, "Sucedió un error inesperado: " + exception)).build();
		}
    }
}

package pe.com.claro.venta.identidad.resource.http;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.claro.venta.identidad.resource.util.ValidSolicitudHttp;
import pe.com.claro.venta.usuariobiometria.canonical.registrapersona.request.RegistrarPersonaRequest;
import pe.com.claro.venta.usuariobiometria.canonical.registrarpersona.response.RegistrarPersonaResponse;
import pe.com.claro.venta.usuariobiometria.canonical.verificarbiometria.request.VerificarBiometriaRequest;
import pe.com.claro.venta.usuariobiometria.canonical.verificarbiometria.response.VerificarBiometriaResponse;
import pe.com.claro.venta.usuariobiometria.common.bean.BodyResponse;
import pe.com.claro.venta.usuariobiometria.common.bean.HeaderRequestBean;
import pe.com.claro.venta.usuariobiometria.common.exception.CastException;
import pe.com.claro.venta.usuariobiometria.common.exception.DBException;
import pe.com.claro.venta.usuariobiometria.common.exception.MappingResponseException;
import pe.com.claro.venta.usuariobiometria.common.exception.WSException;
import pe.com.claro.venta.usuariobiometria.common.property.Constantes;
import pe.com.claro.venta.usuariobiometria.common.util.ClaroUtil;
import pe.com.claro.venta.usuariobiometria.common.util.PropertiesExternos;
import pe.com.claro.venta.usuariobiometria.domain.service.IdentidadService;

@Stateless
@Path(Constantes.PATH_PRINCIPAL_URL)
@Produces({ MediaType.APPLICATION_JSON + Constantes.CHARSETUTF8 })
public class UsuarioBiometriaResource {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioBiometriaResource.class);
	private HeaderRequestBean headerRequestBean;
    
	private PropertiesExternos propertiesExternos;

	@Context
	private Configuration configuration;

	@PostConstruct
	public void initProperties() {
		propertiesExternos = new PropertiesExternos(configuration);
	}

	@EJB
	private IdentidadService identidadService;


	@POST
	@Path(Constantes.PATH_METODO_REGISTRARPERSONA)
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response registrarPersona(@Context HttpHeaders httpHeaders, RegistrarPersonaRequest registrarPersonaRequest) throws JsonProcessingException{

		String mensajeTransaccion = "";

		logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
		logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, "===== [INICIO] WS:" + Constantes.NOMBRESERVICIOREST + " - MET:" + Constantes.NOMBRE_METODO_REGISTRARPERSONA + " ====");
		logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);

		ObjectMapper mapper = new ObjectMapper();
		String dataJson ="";
		Response resJSON = Response.ok().entity(Constantes.VACIO).build();
		String responsePrint = Constantes.EMPTY;
		long tiempoInicio = System.currentTimeMillis();

		try {

			headerRequestBean = new HeaderRequestBean(httpHeaders);
		    String idTx = headerRequestBean.getIdTransaccion();
		    mensajeTransaccion = Constantes.INI_CORCHETE + Constantes.NOMBRE_METODO_REGISTRARPERSONA + " idTx=" + idTx + Constantes.FIN_CORCHETE;
		    
		    String headerRequestBeanJson = ClaroUtil.printPrettyJSONString(headerRequestBean);
		    
		    logger.info(Constantes.LOG_TRES_LLAVES, mensajeTransaccion, "Datos del Header: \n", headerRequestBeanJson );
		    String registrarPersonaRequestJson = ClaroUtil.printPrettyJSONString(registrarPersonaRequest);
			logger.info(Constantes.LOG_TRES_LLAVES, mensajeTransaccion, "Datos del Body: \n", registrarPersonaRequestJson);
			
		    ValidSolicitudHttp validSolicitudHttp = new ValidSolicitudHttp();
			RegistrarPersonaResponse registrarPersonaResponse = new RegistrarPersonaResponse();

//		    if(validSolicitudHttp.isValidaDataHeaderBean(headerRequestBean)){
//				registrarPersonaResponse =identidadService.registrarPersona(headerRequestBean,registrarPersonaRequest,propertiesExternos, mensajeTransaccion);
//		    }else{
//				logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, "No paso Validaciones obligatorias");
//		    }
			
			dataJson = mapper.writeValueAsString(registrarPersonaResponse);

		    Status httpCode = Status.INTERNAL_SERVER_ERROR;
		    
		    if (registrarPersonaResponse.getCodigoRespuesta().equals(Constantes.CERO_STRING))
		    	httpCode = Status.OK;

		    responsePrint = ClaroUtil.printPrettyJSONString(registrarPersonaResponse);
		    resJSON = Response.status(httpCode).entity(dataJson).build();
			
		} catch (Exception e) {
			logger.error(mensajeTransaccion + "Ocurrio un error interno: ", e);
		    MappingResponseException res = this.mappingResponseException(mensajeTransaccion, headerRequestBean, e);
			responsePrint = res.getResponsePrint();
		    resJSON = res.getResJSON();
		}finally {
			logger.info(Constantes.LOG_TRES_LLAVES, mensajeTransaccion, "Response General :\n", responsePrint);
			logger.info(Constantes.LOG_CUATRO_LLAVES, mensajeTransaccion, "Tiempo total de proceso(ms): ", System.currentTimeMillis() - tiempoInicio, "milisegundos.");
			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
			logger.info(Constantes.LOG_SEIS_LLAVES, mensajeTransaccion, "====== [FIN] WS:", Constantes.NOMBRESERVICIOREST, " - MET:", Constantes.NOMBRE_METODO_REGISTRARPERSONA, " ======");
		}

		return resJSON;
	}
	
	
	
//	@POST
//	@Path(Constantes.PATH_METODO_VERIFICARBIOMETRIA)
//	@Consumes({ MediaType.APPLICATION_JSON })
//	public Response verificarBiometria(@Context HttpHeaders httpHeaders, VerificarBiometriaRequest verificarBiometriaRequest) throws JsonProcessingException{
//
//		String mensajeTransaccion = "";
//
//		logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//		logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, "==== [INICIO] WS:" + Constantes.NOMBRESERVICIOREST + " - MET:" + Constantes.NOMBRE_METODO_VERIFICARBIOMETRIA + " ===");
//		logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//
//		ObjectMapper mapper = new ObjectMapper();
//		String dataJson ="";
//		Response resJSON = Response.ok().entity(Constantes.VACIO).build();
//		String responsePrint = Constantes.EMPTY;
//		long tiempoInicio = System.currentTimeMillis();
//
//		try {
//
//			headerRequestBean = new HeaderRequestBean(httpHeaders);
//		    String idTx = headerRequestBean.getIdTransaccion();
//		    mensajeTransaccion = Constantes.INI_CORCHETE + Constantes.NOMBRE_METODO_VERIFICARBIOMETRIA + " idTx=" + idTx + Constantes.FIN_CORCHETE;
//		    
//		    String headerRequestBeanJson = ClaroUtil.printPrettyJSONString(headerRequestBean);
//		    
//		    logger.info(Constantes.LOG_TRES_LLAVES, mensajeTransaccion, "Datos del Header: \n", headerRequestBeanJson );
//		    String registrarPersonaRequestJson = ClaroUtil.printPrettyJSONString(verificarBiometriaRequest);
//			logger.info(Constantes.LOG_TRES_LLAVES, mensajeTransaccion, "Datos del Body: \n", registrarPersonaRequestJson);
//			
//		    ValidSolicitudHttp validSolicitudHttp = new ValidSolicitudHttp();
//
//			VerificarBiometriaResponse verificarBiometriaResponse = new VerificarBiometriaResponse();
//
//		    if(validSolicitudHttp.isValidaDataHeaderBean(headerRequestBean)){
//
//				verificarBiometriaResponse = identidadService.verificarBiometria(headerRequestBean, verificarBiometriaRequest, propertiesExternos, mensajeTransaccion);
//		    }else{
//				logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, "No paso Validaciones obligatorias");
//		    }
//			
//			dataJson = mapper.writeValueAsString(verificarBiometriaResponse);
//
//		    Status httpCode = Status.INTERNAL_SERVER_ERROR;
//		    
//		    if (verificarBiometriaResponse.getCodigoRespuesta().equals(Constantes.CERO_STRING))
//		    	httpCode = Status.OK;
//
//		    responsePrint = ClaroUtil.printPrettyJSONString(verificarBiometriaResponse);
//		    resJSON = Response.status(httpCode).entity(dataJson).build();
//			
//		} catch (Exception e) {
//			logger.error(mensajeTransaccion + "Ocurrio un error interno: ", e);
//		    MappingResponseException res = this.mappingResponseException(mensajeTransaccion, headerRequestBean, e);
//			responsePrint = res.getResponsePrint();
//		    resJSON = res.getResJSON();
//		}finally {
//			logger.info(Constantes.LOG_TRES_LLAVES, mensajeTransaccion, "Response General :\n", responsePrint);
//			logger.info(Constantes.LOG_CUATRO_LLAVES, mensajeTransaccion, "Tiempo total de proceso(ms): ", System.currentTimeMillis() - tiempoInicio, "milisegundos.");
//			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//			logger.info(Constantes.LOG_SEIS_LLAVES, mensajeTransaccion, "===== [FIN] WS:", Constantes.NOMBRESERVICIOREST, " - MET:", Constantes.NOMBRE_METODO_REGISTRARPERSONA, " ====");
//		}
//
//		return resJSON;
//	}

    /**
     * * ********************************
     * Mapeo de Excepciones controladas ....
     * *********************************
     * Excepciones Controladas ....
     * Este metodo fue creado para manejar errores no controlados
     *
     * @param1 String trazabilidad
     * @param2 Excepcion excepcion generada en el flujo
     * @return MappingResponseException Bean utilitario que contendra los valores de RESULT: Valor String del mensaje, RESPONSEPRINT: String generado en formato JSON , RESPONSE JSON Response JSON generado.
     */
    private MappingResponseException mappingResponseException(String trazabilidad, HeaderRequestBean header, Exception e) throws JsonProcessingException {
	String result = Constantes.VACIO;
	String responsePrint = Constantes.VACIO;
	Response resJSON = null;
	int status = Constantes.STATUS_DISPONIBILIDAD;
	
	logger.error(Constantes.LOG_CINCO_LLAVES ,trazabilidad, "ERROR: [Exception] - [", e.getMessage(), "] ", e);
	
	if (e instanceof WSException) {
	    WSException x = (WSException) e;
	    status = x.getStatus();
	    result = ClaroUtil.printPrettyJSONString(new BodyResponse(header.getIdTransaccion(), x.getMessageDeveloper(), x.getCode(), x.getMessage()));
	    responsePrint = ClaroUtil.printPrettyJSONString(new BodyResponse(header.getIdTransaccion(), x.getMessageDeveloper(), (x.getCode()), x.getMessage()));
	}
	else if (e instanceof DBException) {
	    DBException x = (DBException) e;
	    status = x.getStatus();
	    result = ClaroUtil.printPrettyJSONString(new BodyResponse(header.getIdTransaccion(), x.getMessageDeveloper(), x.getCode(), x.getMessage()));
	    responsePrint = ClaroUtil.printPrettyJSONString(new BodyResponse(header.getIdTransaccion(), x.getMessageDeveloper(), (x.getCode()), x.getMessage()));
	}
	else if (e instanceof CastException) {
	    CastException x = (CastException) e;
	    result = ClaroUtil.printPrettyJSONString(new BodyResponse(header.getIdTransaccion(), x.getMessageDeveloper(), (x.getCode()), x.getMessage()));
	    responsePrint = ClaroUtil.printPrettyJSONString(new BodyResponse(header.getIdTransaccion(), x.getMessageDeveloper(), (x.getCode()), x.getMessage()));
	}

	resJSON = Response.status(status).entity(result).build();
	return new MappingResponseException(result, responsePrint, resJSON);
    }

}
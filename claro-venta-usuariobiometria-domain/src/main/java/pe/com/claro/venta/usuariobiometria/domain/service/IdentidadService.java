package pe.com.claro.venta.usuariobiometria.domain.service;

import java.io.Serializable;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.com.claro.venta.usuariobiometria.canonical.registrapersona.request.RegistrarPersonaRequest;
import pe.com.claro.venta.usuariobiometria.canonical.registrarpersona.response.RegistrarPersonaResponse;
import pe.com.claro.venta.usuariobiometria.canonical.verificarbiometria.request.VerificarBiometriaRequest;
import pe.com.claro.venta.usuariobiometria.canonical.verificarbiometria.response.VerificarBiometriaResponse;
import pe.com.claro.venta.usuariobiometria.common.bean.HeaderRequestBean;
import pe.com.claro.venta.usuariobiometria.common.exception.DBException;
import pe.com.claro.venta.usuariobiometria.common.exception.WSException;
import pe.com.claro.venta.usuariobiometria.common.property.Constantes;
import pe.com.claro.venta.usuariobiometria.common.util.JAXBUtilitarios;
import pe.com.claro.venta.usuariobiometria.common.util.PropertiesExternos;
import pe.com.claro.venta.usuariobiometria.domain.dao.PvuDao;
import pe.com.claro.venta.usuariobiometria.model.request.ConsultaUsuarioAutorRequest;
import pe.com.claro.venta.usuariobiometria.model.request.IdentificacionTransaccionRequest;
import pe.com.claro.venta.usuariobiometria.model.response.ConsultaUsuarioAutorResponse;
import pe.com.claro.venta.usuariobiometria.model.response.IdentificacionTransaccionResponse;

@Stateless
public class IdentidadService implements Serializable {
//
//	private static final long serialVersionUID = 4445586813136879751L;
//
//	@EJB
//	private PvuDao pvuDao;
//
//	private static final Logger logger = LoggerFactory.getLogger(IdentidadService.class);
//
//	public RegistrarPersonaResponse registrarPersona(HeaderRequestBean headerRequestBean,
//			RegistrarPersonaRequest request, PropertiesExternos propertiesExternos, String mensajeTransaccion) {
//
//		long tiempoInicio = System.currentTimeMillis();
//
//		ReniecAdquirienteWSSoa reniecAdquirienteWSSoa = new ReniecAdquirienteWSSoaImpl();
//		RegistrarPersonaResponse registrarPersonaResponse = new RegistrarPersonaResponse();
//
//		String codigoRespuesta = Constantes.VACIO;
//		String mensajeRespuesta = Constantes.VACIO;
//		String nomMetodo = Constantes.NOMBRE_METODO_REGISTRARPERSONA;
//		IdentificacionTransaccionResponse identificacionTransaccionResponse = null;
//		ConsultaUsuarioAutorResponse consultaUsuarioAutorResponse = null;
//		SignonResponseBean signonResponseBean = null;
//
//		try {
//
//			registrarPersonaResponse.setIdTransaccion(headerRequestBean.getIdTransaccion());
//
//			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_GUION);
//			logger.info(Constantes.LOG_CUATRO_LLAVES, mensajeTransaccion, "******************** [INICIO] - ", nomMetodo,
//					" ********************");
//			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_GUION);
//
//			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//					"============ [INICIO] 1. Obtener numetro de transaccion ===========");
//			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//
//			IdentificacionTransaccionRequest identificacionTransaccionRequest = setearCamposIdentificacionTransaccion(
//					mensajeTransaccion, propertiesExternos);
//			identificacionTransaccionResponse = pvuDao.obtenerNumeroTransaccion(propertiesExternos, headerRequestBean,
//					mensajeTransaccion, identificacionTransaccionRequest);
//
//			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//					"============= [FIN] 1. Obtener numetro de transaccion =============");
//
//			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//					"============ [INICIO] 2. Obtener identificador cliente ============");
//			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//
//			ConsultaUsuarioAutorRequest consultaUsuarioAutorRequest = setearCamposConsultaUsuarioAutor(request,
//					mensajeTransaccion);
//			consultaUsuarioAutorResponse = pvuDao.obtenerNumeroIdentificadorCliente(propertiesExternos,
//					headerRequestBean, mensajeTransaccion, consultaUsuarioAutorRequest);
//
//			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//					"============== [FIN] 2. Obtener identificador cliente =============");
//
//			if (consultaUsuarioAutorResponse.getkSalida() != null
//					&& !consultaUsuarioAutorResponse.getkSalida().isEmpty()) {
//
//				logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//				logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//						"==================== [INICIO] 3. Inicar sesion ====================");
//				logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//
//				SignonRequestBean signonRequestBean = setearCamposSignOn(request, identificacionTransaccionResponse,
//						consultaUsuarioAutorResponse, propertiesExternos);
//				signonResponseBean = reniecAdquirienteWSSoa.signon(mensajeTransaccion, signonRequestBean,
//						propertiesExternos);
//
//				logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//				logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//						"====================== [FIN] 3. Inicar sesion =====================");
//
//				if (signonResponseBean.getCodigoRespuesta().equals(Constantes.CODIGO_EXITO_SIGNON)) {
//
//					logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//					logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//							"================== [INICIO] 4. Registrar persona ==================");
//					logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//
//					RegistroRequestBean registroRequestBean = setearCamposRegistrarPersona(headerRequestBean, request,
//							signonResponseBean, identificacionTransaccionResponse, consultaUsuarioAutorResponse,
//							propertiesExternos);
//					RegistroResponseBean registroResponseBean = reniecAdquirienteWSSoa
//							.registrarPersona(mensajeTransaccion, registroRequestBean, propertiesExternos);
//
//					logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//					logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//							"==================== [FIN] 4. Registrar persona ===================");
//
//					if (registroResponseBean.getCodigoRespuesta().equals(Constantes.CODIGO_EXITO_REGISTRAR_PERSONA)) {
//						logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//								"Se realizo el registro de la persona satisfactoriamente");
//						registrarPersonaResponse.setCodigoRespuesta(propertiesExternos.claroVentaIdentidadCodigoIDF0);
//						registrarPersonaResponse.setMensajeRespuesta(propertiesExternos.claroVentaIdentidadMensajeIDF0);
//					} else {
//						logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//								"No se realizo el registro de la persona");
//						registrarPersonaResponse.setCodigoRespuesta(registroResponseBean.getCodigoRespuesta());
//						registrarPersonaResponse.setMensajeRespuesta(registroResponseBean.getMensajeRespuesta());
//					}
//
//				} else {
//					registrarPersonaResponse.setCodigoRespuesta(signonResponseBean.getCodigoRespuesta());
//					registrarPersonaResponse.setMensajeRespuesta(signonResponseBean.getMensajeRespuesta());
//				}
//
//			} else {
//				registrarPersonaResponse.setCodigoRespuesta(propertiesExternos.claroVentaIdentidadCodigoIDF1);
//				registrarPersonaResponse.setMensajeRespuesta(propertiesExternos.claroVentaIdentidadMensajeIDF1);
//			}
//
//		} catch (WSException e) {
//			String errorMsg = e + Constantes.VACIO;
//			logger.error(mensajeTransaccion + "Ocurrio un error de tipo WSException. " + errorMsg);
//			codigoRespuesta = e.getCode();
//			mensajeRespuesta = e.getMessage() + Constantes.ESPACIO + e.getMessageDeveloper();
//			registrarPersonaResponse.setCodigoRespuesta(codigoRespuesta);
//			registrarPersonaResponse.setMensajeRespuesta(mensajeRespuesta);
//		} catch (DBException e) {
//			String errorMsg = e + Constantes.VACIO;
//			logger.error(mensajeTransaccion + "Ocurrio un error de tipo DBException." + errorMsg);
//			codigoRespuesta = e.getCode();
//			mensajeRespuesta = e.getMessage() + Constantes.ESPACIO + e.getMessageDeveloper();
//			registrarPersonaResponse.setCodigoRespuesta(codigoRespuesta);
//			registrarPersonaResponse.setMensajeRespuesta(mensajeRespuesta);
//		} catch (Exception e) {
//			String errorMsg = e + Constantes.VACIO;
//			logger.error(mensajeTransaccion + "Ocurrio un Error Inesperado: " + e, e);
//			codigoRespuesta = propertiesExternos.codigoGenericoErrorIDT5;
//			mensajeRespuesta = propertiesExternos.mensajeGenericoErrorIDT5 + Constantes.ESPACIO + errorMsg;
//			registrarPersonaResponse.setCodigoRespuesta(codigoRespuesta);
//			registrarPersonaResponse.setMensajeRespuesta(mensajeRespuesta);
//		} finally {
//
//			if (signonResponseBean != null && !signonResponseBean.getIdSesion().isEmpty()) {
//
//				logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//				logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//						"==================== [INICIO] 5. Cerrar sesion ====================");
//				logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//
//				try {
//
//					SignoffRequestBean signoffRequestBean = setearCamposSignOff(request, signonResponseBean,
//							identificacionTransaccionResponse, consultaUsuarioAutorResponse, propertiesExternos);
//					SignoffResponseBean signoffResponseBean = reniecAdquirienteWSSoa.signoff(mensajeTransaccion,
//							signoffRequestBean, propertiesExternos);
//
//					if (signoffResponseBean.getCodigoRespuesta().equals(Constantes.CODIGO_EXITO_SIGNOFF)) {
//						logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//								"Se realizo la eliminacion del token satisfactoriamente");
//					} else {
//						logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//								"No se realizo la eliminacion del token");
//					}
//
//				} catch (WSException e) {
//					logger.error(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, "Ocurrio un error de tipo WSException");
//				} catch (Exception e) {
//					logger.error(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, "Ocurrio un Error Inesperado");
//				} finally {
//					logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_IGUAL);
//					logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//							"====================== [FIN] 5. Cerrar sesion =====================");
//				}
//
//			}
//			String registrarPersonaResponseXML = JAXBUtilitarios.anyObjectToXmlText(registrarPersonaResponse);
//			logger.info(Constantes.LOG_TRES_LLAVES, mensajeTransaccion, "DATOS DE SALIDA: \n",
//					registrarPersonaResponseXML);
//			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_GUION);
//			logger.info(Constantes.LOG_CUATRO_LLAVES, mensajeTransaccion, "********************** [FIN] - ", nomMetodo,
//					" *********************");
//			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, Constantes.LOG_GUION);
//			long tiempoFin = System.currentTimeMillis();
//			logger.info(Constantes.LOG_CUATRO_LLAVES, mensajeTransaccion, "Tiempo total de proceso(ms):",
//					(tiempoFin - tiempoInicio), " milisegundos");
//		}
//
//		return registrarPersonaResponse;
//
//	}
//
//	// public VerificarBiometriaResponse verificarBiometria(HeaderRequestBean
//	// headerRequestBean, VerificarBiometriaRequest request, PropertiesExternos
//	// propertiesExternos, String mensajeTransaccion) throws
//	// UnknownHostException {
//	//
//	//
//	//// conexionReniecClientWsRestClient conexionReniecClientWsRestClient = new
//	// ConexionReniecClientWsRestImpl();
//	// ReniecAdquirienteWSSoa reniecAdquirienteWSSoa = new
//	// ReniecAdquirienteWSSoaImpl();
//	////
//	// long tiempoInicio = System.currentTimeMillis();
//	// String nomMetodo = Constantes.NOMBRE_METODO_VERIFICARBIOMETRIA;
//	//
//	// String msgT = "[" + nomMetodo + "iD[" +
//	// headerRequestBean.getIdTransaccion() + "] ";
//	//
//	// VerificarBiometriaResponse verificarBiometriaResponse = new
//	// VerificarBiometriaResponse();
//	// verificarBiometriaResponse.setIdTransaccion(headerRequestBean.getIdTransaccion());
//	// verificarBiometriaResponse.setCodigoRespuesta("0");
//	// verificarBiometriaResponse.setCodigoRespuesta("Hola manito");
//	// String codigoRespuesta = Constantes.VACIO;
//	// String mensajeRespuesta = Constantes.VACIO;
//	// String idSesion = Constantes.VACIO;
//	// String numTransaccionFunc = Constantes.VACIO;
//	// String numeroIdentificadorCliente = Constantes.VACIO;
//	//
//	// try {
//	//
//	//
//	// logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//	// Constantes.LOG_GUION);
//	// logger.info(Constantes.LOG_CUATRO_LLAVES, mensajeTransaccion,
//	// "******************** [INICIO] - ", nomMetodo ," ********************");
//	// logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//	// Constantes.LOG_GUION);
//	//
//	// logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//	// Constantes.LOG_IGUAL);
//	// logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, "============
//	// [INICIO] 1. Obtener numetro de transaccion ===========");
//	// logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//	// Constantes.LOG_IGUAL);
//	//
//	// IdentificacionTransaccionRequest identificacionTransaccionRequest =
//	// setearCamposIdentificacionTransaccion(mensajeTransaccion,
//	// propertiesExternos);
//	// IdentificacionTransaccionResponse identificacionTransaccionResponse =
//	// pvuDao.obtenerNumeroTransaccion(propertiesExternos, headerRequestBean,
//	// msgT, identificacionTransaccionRequest);
//	// numTransaccionFunc = identificacionTransaccionResponse.getpIdTrxBio();
//	//
//	// logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//	// Constantes.LOG_IGUAL);
//	// logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, "=============
//	// [FIN] 1. Obtener numetro de transaccion =============");
//	//
//	// logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//	// Constantes.LOG_IGUAL);
//	// logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, "============
//	// [INICIO] 2. Obtener identificador cliente ============");
//	// logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,
//	// Constantes.LOG_IGUAL);
//	//
//	//
//	//
//	//// ConsultaUsuarioAutorRequest consultaUsuarioAutorRequest =
//	// setearCamposConsultaUsuarioAutor(request);
//	//// ConsultaUsuarioAutorResponse consultaUsuarioAutorResponse =
//	// pvuDao.obtenerNumeroIdentificadorCliente(propertiesExternos,
//	// headerRequestBean, msgT, consultaUsuarioAutorRequest);
//	////
//	//// logger.info(msgT +
//	// "===================================================================");
//	//// logger.info(msgT + "<*********** [FIN] 2. Obtener identificador cliente
//	// ***********>");
//	//// logger.info(msgT +
//	// "===================================================================");
//	////
//	//// if (consultaUsuarioAutorResponse.getK_SALIDA() != null &&
//	// !consultaUsuarioAutorResponse.getK_SALIDA().isEmpty()) {
//	////
//	//// numeroIdentificadorCliente =
//	// consultaUsuarioAutorResponse.getK_SALIDA().get(0).getUAV_DNI_AUTORIZADO();
//	////
//	//// logger.info(msgT +
//	// "===================================================================");
//	//// logger.info(msgT + "<*********** [INICIO] 3. Inicar sesion
//	// ***********>");
//	//// logger.info(msgT +
//	// "===================================================================");
//	////
//	//// GenerarTokenRequest generarTokenRequest =
//	// setearCamposGenerarToken(request, identificacionTransaccionResponse,
//	// consultaUsuarioAutorResponse, headerRequestBean.getIdTransaccion());
//	//// GenerarTokenResponse generarTokenResponse =
//	// conexionReniecClientWsRestClient.generarToken(generarTokenRequest,
//	// headerRequestBean, propertiesExternos, msgT);
//	////
//	//// logger.info(msgT +
//	// "===================================================================");
//	//// logger.info(msgT + "<*********** [FIN] 3. Inicar sesion ***********>");
//	//// logger.info(msgT +
//	// "===================================================================");
//	////
//	//// if
//	// (generarTokenResponse.getCodigoRespuesta().equals(Constantes.CERO_STRING))
//	// {
//	////
//	//// idSesion = generarTokenResponse.getIdSesion();
//	////
//	//// logger.info(msgT +
//	// "===================================================================");
//	//// logger.info(msgT + "<*********** [INICIO] 4. Verificacion Biometria
//	// ***********>");
//	//// logger.info(msgT +
//	// "===================================================================");
//	////
//	//// VerificacionRequestBean verificacionRequestBean =
//	// setearCamposVerificarBiometria(headerRequestBean, request,
//	// propertiesExternos, idSesion, msgT, numeroIdentificadorCliente,
//	// numTransaccionFunc);
//	//// VerificacionResponseBean verificacionResponseBean =
//	// reniecAdquirienteWSSoa.verificacionBiometrica(mensajeTransaccion,
//	// verificacionRequestBean, propertiesExternos);
//	////
//	//// logger.info(msgT +
//	// "===================================================================");
//	//// logger.info(msgT + "<*********** [FIN] 4. Verificacion Biometria
//	// ***********>");
//	//// logger.info(msgT +
//	// "===================================================================");
//	////
//	//// if (isCodigoValido(verificacionResponseBean.getCodigoRespuesta(),
//	// propertiesExternos.RENIECADQUIRIENTEWS_CODIGOS_EXITO)) {
//	//// verificarBiometriaResponse.setCodigoRespuesta(propertiesExternos.CLARO_VENTA_BIOMETRIA_CODIGO_IDF0);
//	//// verificarBiometriaResponse.setMensajeRespuesta(propertiesExternos.CLARO_VENTA_BIOMETRIA_MENSAJE_IDF0);
//	//// }
//	//// else {
//	//// verificarBiometriaResponse.setCodigoRespuesta(verificacionResponseBean.getCodigoRespuesta());
//	//// verificarBiometriaResponse.setMensajeRespuesta(verificacionResponseBean.getMensajeRespuesta());
//	//// }
//	//// }
//	//// else {
//	//// verificarBiometriaResponse.setCodigoRespuesta(generarTokenResponse.getCodigoRespuesta());
//	//// verificarBiometriaResponse.setMensajeRespuesta(generarTokenResponse.getMensajeRespuesta());
//	//// }
//	//// }
//	//// else {
//	//// // IDF 1 Usuario sin autorizacion
//	//// verificarBiometriaResponse.setCodigoRespuesta(propertiesExternos.CLARO_VENTA_BIOMETRIA_CODIGO_IDF1);
//	//// verificarBiometriaResponse.setMensajeRespuesta(propertiesExternos.CLARO_VENTA_BIOMETRIA_MENSAJE_IDF1);
//	//// }
//	////
//	// }
//	//// catch (WSException e) {
//	//// logger.error(msgT + "Ocurrio un error de tipo WSException.");
//	//// codigoRespuesta = e.getCode();
//	//// mensajeRespuesta = e.getMessage() + Constantes.PUNTO +
//	// Constantes.ESPACIO + e.getMessageDeveloper();
//	//// verificarBiometriaResponse.setCodigoRespuesta(codigoRespuesta);
//	//// verificarBiometriaResponse.setMensajeRespuesta(mensajeRespuesta);
//	//// }
//	//// catch (DBException e) {
//	//// logger.error(msgT + "Ocurrio un error de tipo DBException.");
//	//// codigoRespuesta = e.getCode();
//	//// mensajeRespuesta = e.getMessage() + Constantes.ESPACIO +
//	// e.getMessageDeveloper();
//	//// verificarBiometriaResponse.setCodigoRespuesta(codigoRespuesta);
//	//// verificarBiometriaResponse.setMensajeRespuesta(mensajeRespuesta);
//	//// }
//	// catch (Exception e) {
//	// String errorMsg = e + Constantes.VACIO;
//	// logger.error(msgT + "Ocurrio un Error Inesperado: " + e, e);
//	// codigoRespuesta = propertiesExternos.codigoGenericoErrorIDT5;
//	// mensajeRespuesta = propertiesExternos.mensajeGenericoErrorIDT5 +
//	// Constantes.ESPACIO + errorMsg;
//	// verificarBiometriaResponse.setCodigoRespuesta(codigoRespuesta);
//	// verificarBiometriaResponse.setMensajeRespuesta(mensajeRespuesta);
//	// }
//	// finally {
//	////
//	//// if (!idSesion.isEmpty()) {
//	////
//	//// logger.info(msgT +
//	// "===================================================================");
//	//// logger.info(msgT + "<*********** [INICIO] 5. Cerrar sesion
//	// ***********>");
//	//// logger.info(msgT +
//	// "===================================================================");
//	//// // Consumir claro_venta_conexionReniec (Metodo eliminarToken)
//	////
//	//// EliminarTokenRequest eliminarTokenRequest =
//	// setearCamposEliminarToken(request, idSesion, numTransaccionFunc,
//	// numeroIdentificadorCliente, msgT);
//	//// EliminarTokenResponse eliminarTokenResponse;
//	//// try {
//	//// eliminarTokenResponse =
//	// conexionReniecClientWsRestClient.eliminarToken(eliminarTokenRequest,
//	// headerRequestBean, propertiesExternos, msgT);
//	////
//	//// if
//	// (eliminarTokenResponse.getCodigoRespuesta().equals(Constantes.CERO_STRING))
//	// {
//	////
//	//// }
//	//// else {
//	//// verificarBiometriaResponse.setCodigoRespuesta(eliminarTokenResponse.getCodigoRespuesta());
//	//// verificarBiometriaResponse.setMensajeRespuesta(eliminarTokenResponse.getMensajeRespuesta());
//	//// }
//	//// }
//	//// catch (WSException e) {
//	//// logger.error(msgT + "Ocurrio un error de tipo WSException.");
//	//// codigoRespuesta = e.getCode();
//	//// mensajeRespuesta = e.getMessage() + Constantes.PUNTO +
//	// Constantes.ESPACIO + e.getMessageDeveloper();
//	//// verificarBiometriaResponse.setCodigoRespuesta(codigoRespuesta);
//	//// verificarBiometriaResponse.setMensajeRespuesta(mensajeRespuesta);
//	//// }
//	//// catch (Exception e) {
//	//// String errorMsg = e + Constantes.VACIO;
//	//// logger.error(msgT + "Ocurrio un Error Inesperado: " + e, e);
//	//// codigoRespuesta = propertiesExternos.CODIGO_GENERICO_ERROR_IDT5;
//	//// mensajeRespuesta = propertiesExternos.MENSAJE_GENERICO_ERROR_IDT5 +
//	// Constantes.ESPACIO + errorMsg;
//	//// verificarBiometriaResponse.setCodigoRespuesta(codigoRespuesta);
//	//// verificarBiometriaResponse.setMensajeRespuesta(mensajeRespuesta);
//	//// }
//	//// finally {
//	//// logger.info(msgT +
//	// "===================================================================");
//	//// logger.info(msgT + "<*********** [FIN] 5. Cerrar sesion ***********>");
//	//// logger.info(msgT +
//	// "===================================================================");
//	//// }
//	//// }
//	////
//	//// logger.info(msgT + "DATOS DE SALIDA:\n" +
//	// JAXBUtilitarios.anyObjtoJson(verificarBiometriaResponse));
//	//// logger.info(msgT +
//	// "-------------------------------------------------------------------");
//	//// logger.info(msgT + "<***************** [FIN] - " + nomMetodo + "
//	// ***************>");
//	//// logger.info(msgT +
//	// "-------------------------------------------------------------------");
//	//// long tiempoFin = System.currentTimeMillis();
//	//// logger.info(msgT + "Tiempo total de proceso(ms):" + (tiempoFin -
//	// tiempoInicio) + " milisegundos");
//	// }
//	// return verificarBiometriaResponse;
//	// }
//	//
//
//	private RegistroRequestBean setearCamposRegistrarPersona(HeaderRequestBean headerRequestBean,
//			RegistrarPersonaRequest request, SignonResponseBean signonResponseBean,
//			IdentificacionTransaccionResponse identificacionTransaccionResponse,
//			ConsultaUsuarioAutorResponse consultaUsuarioAutorResponse, PropertiesExternos propertiesExternos) {
//
//		RegistroRequestBean registroRequestBean = new RegistroRequestBean();
//
//		registroRequestBean.setAgenteSolicitanteServicio(
//				propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamAgenteSolicitanteServicio);
//		registroRequestBean.setAutenticacionMensaje(headerRequestBean.getIdTransaccion()); // *********************************************************
//		registroRequestBean
//				.setCodigoAdquirente(propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamCodigoAdquiriente);
//		registroRequestBean
//				.setCodigoAplicativo(propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamCodigoAplicativo);
//		registroRequestBean.setCodigoGrupo(propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamCodigoGrupo);
//		registroRequestBean.setCodigoIdentificacionDispositivo(
//				propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamCodigoIdentificacionDispositivo);
//		registroRequestBean.setCodigoIdentificacionEstacion(
//				propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamCodigoIdentificacionEstacion);
//		registroRequestBean.setCodigoProcesadorAdquirente(
//				propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamCodigoProcesadorAdquiriente);
//		registroRequestBean.setCodigoSistemaLocalizacion(
//				propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamCodigoSistemaLocalizacion);
//		registroRequestBean.setCodigoSubGrupo(propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamCodigoSubGrupo);
//		registroRequestBean
//				.setCodigoTransaccion(propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamCodigoTransaccion);
//		registroRequestBean.setFechaTransaccion(converDatetoString(new Date(), Constantes.FORMATO_FECHA));
//		registroRequestBean.setHoraTransaccion(converDatetoString(new Date(), Constantes.FORMATO_HORA));
//		registroRequestBean.setInstitucionCanalizaServicio(
//				propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamInstitucionCanalizaServicio);
//		registroRequestBean.setInstitucionProveedorServicio(
//				propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamInstitucionProveedorServicio);
//		registroRequestBean.setInstitucionSolicitanteServicio(
//				propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamInstitucionSolicitanteServicio);
//		registroRequestBean.setLatitudLocalizacion(request.getLatitudLocalizacion());
//		registroRequestBean.setLongitudLocalizacion(request.getLongitudLocalizacion());
//		registroRequestBean.setMarcaDispositivo(request.getMarcaDispositivo());
//		registroRequestBean.setModeloDispositivo(request.getModeloDispositivo());
//		registroRequestBean.setModeloEstacion(propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamModeloEstacion);
//		registroRequestBean
//				.setNumeroIdentificadorCliente(consultaUsuarioAutorResponse.getkSalida().get(0).getUavDniAutorizado());
//		registroRequestBean.setNumeroOrden(headerRequestBean.getIdTransaccion());
//		registroRequestBean.setNumeroTransaccion(identificacionTransaccionResponse.getpIdTrxBio());
//		registroRequestBean.setPuntoVentaSolicitanteServicio(
//				propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamPuntoVentaSolicitanteServicio);
//		registroRequestBean.setReservado(propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamReservado);
//		registroRequestBean.setSistemaOperativoEstacion(
//				propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamSistemaOperativoEstacion);
//		registroRequestBean
//				.setTipoDispositivo(propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamTipoDispositivo);
//		registroRequestBean.setTipoEstacion(propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamTipoEstacion);
//		registroRequestBean.setTipoFormato(propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamTipoFormato);
//		registroRequestBean.setTipoIdentificacionDispositivo(
//				propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamTipoIdentificacionDispositivo);
//		registroRequestBean.setTipoIdentificacionEstacion(
//				propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamTipoIdentificacionEstacion);
//		registroRequestBean.setTipoIdentificadorCliente(
//				propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamTipoIdentificadorCliente);
//		registroRequestBean.setTipoMensaje(propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamTipoMensaje);
//		registroRequestBean
//				.setVersionAplicativo(propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamVersionAplicativo);
//		registroRequestBean.setApellidoMaterno(request.getApellidoMaterno());
//		registroRequestBean.setApellidoPaterno(request.getApellidoPaterno());
//		registroRequestBean.setBanderaRegistro(request.getBanderaRegistro());
//		registroRequestBean.setFechaCaducidad(request.getFechaCaducidad());
//		registroRequestBean.setFechaNacimiento(request.getFechaNacimiento());
//		registroRequestBean.setFechaEmision(request.getFechaEmision());
//		registroRequestBean.setFirma(request.getFirma());
//
//		if (request.getHuellasBiometricas() != null && !request.getHuellasBiometricas().isEmpty()) {
//			for (pe.com.claro.venta.usuariobiometria.canonical.registrapersona.request.HuellasBiometricas obj : request
//					.getHuellasBiometricas()) {
//				HuellasBiometricas huellasBiometricas = new HuellasBiometricas();
//				huellasBiometricas.setCalidadImagen(obj.getCalidadImagen());
//				huellasBiometricas.setFormatoHuella(obj.getFormatoHuella());
//				huellasBiometricas.setHuellaImagen(obj.getHuellaImagen());
//				huellasBiometricas.setHuellaTemplate(obj.getHuellaTemplate());
//				huellasBiometricas.setIdHuellas(obj.getIdHuellas());
//				huellasBiometricas.setPorcentajeHuellaViva((obj.getPorcentajeHuellaViva() == null
//						|| obj.getPorcentajeHuellaViva().toString().equals(Constantes.VACIO)) ? Constantes.VACIO
//								: obj.getPorcentajeHuellaViva().toString());
//				registroRequestBean.getHuellasBiometricas().add(huellasBiometricas);
//			}
//		}
//
//		registroRequestBean.setIdSesion(signonResponseBean.getIdSesion());
//		registroRequestBean.setNombres(request.getNombres());
//		registroRequestBean.setNumeroDocumentoPersona(request.getNumeroDocumentoPersona());
//		registroRequestBean.setNumeroIdentificadorInstitucion(
//				propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamNumeroIdentificadorInstitucion);
//		registroRequestBean.setSexo(request.getSexo());
//		registroRequestBean.setTipoIdentificadorInstitucion(
//				propertiesExternos.reniecAdquirienteWsRegisrarPersonaParamTipoIdentificadorInstitucion);
//		registroRequestBean.setTipodeDocumentoPersona(request.getTipoDocumentoPersona());
//
//		return registroRequestBean;
//
//	}
//
//	private ConsultaUsuarioAutorRequest setearCamposConsultaUsuarioAutor(RegistrarPersonaRequest request,
//			String mensajeTransaccion) {
//
//		ConsultaUsuarioAutorRequest consultaUsuarioAutorRequest = new ConsultaUsuarioAutorRequest();
//
//		consultaUsuarioAutorRequest.setPiCodUser(request.getUsuarioSesion());
//		consultaUsuarioAutorRequest.setPiOficina(request.getCodigoOficina());
//		consultaUsuarioAutorRequest.setPiUserPlic(request.getUsuarioAplicacion());
//
//		logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, consultaUsuarioAutorRequest);
//
//		return consultaUsuarioAutorRequest;
//
//	}
//
//	private IdentificacionTransaccionRequest setearCamposIdentificacionTransaccion(String mensajeTransaccion,
//			PropertiesExternos propertiesExternos) {
//
//		IdentificacionTransaccionRequest identificacionTransaccionRequest = new IdentificacionTransaccionRequest();
//
//		identificacionTransaccionRequest.setP_TIPO_ID(propertiesExternos.bdPvuParamTipoId);
//
//		logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, identificacionTransaccionRequest);
//
//		return identificacionTransaccionRequest;
//
//	}
//
//	private String converDatetoString(Date date, String formato) {
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
//		return simpleDateFormat.format(date);
//	}
//
//	public SignonRequestBean setearCamposSignOn(RegistrarPersonaRequest registrarPersonaRequest,
//			IdentificacionTransaccionResponse identificacionTransaccionResponse,
//			ConsultaUsuarioAutorResponse consultaUsuarioAutorResponse, PropertiesExternos propertiesExternos)
//			throws Exception {
//
//		SignonRequestBean signonRequestBean = new SignonRequestBean();
//		signonRequestBean.setAgenteSolicitanteServicio(
//				propertiesExternos.reniecAdquirienteWsSignOnParamAgenteSolicitanteServicio);
//		signonRequestBean.setAutenticacionMensaje(registrarPersonaRequest.getAutenticacionMensaje());
//		signonRequestBean.setCodigoAdquirente(propertiesExternos.reniecAdquirienteWsSignOnParamCodigoAdquiriente);
//		signonRequestBean.setCodigoAplicativo(propertiesExternos.reniecAdquirienteWsSignOnParamCodigoAplicativo);
//		signonRequestBean.setCodigoGrupo(propertiesExternos.reniecAdquirienteWsSignOnParamCodigoGrupo);
//		signonRequestBean.setCodigoIdentificacionDispositivo(
//				propertiesExternos.reniecAdquirienteWsSignOnParamCodigoIdentificacionDispositivo);
//		signonRequestBean.setCodigoIdentificacionEstacion(
//				propertiesExternos.reniecAdquirienteWsSignOnParamCodigoIdentificacionEstacion);
//		signonRequestBean.setCodigoProcesadorAdquirente(
//				propertiesExternos.reniecAdquirienteWsSignOnParamCodigoProcesadorAdquiriente);
//		signonRequestBean.setCodigoSistemaLocalizacion(
//				propertiesExternos.reniecAdquirienteWsSignOnParamCodigoSistemaLocalizacion);
//		signonRequestBean.setCodigoSubGrupo(propertiesExternos.reniecAdquirienteWsSignOnParamCodigoSubGrupo);
//		signonRequestBean
//				.setCodigoTransaccion(propertiesExternos.reniecAdquirienteWsSignOnParamCodigoCodigoTransaccion);
//		signonRequestBean.setFechaTransaccion(converDatetoString(new Date(), Constantes.FORMATO_FECHA));
//		signonRequestBean.setHoraTransaccion(converDatetoString(new Date(), Constantes.FORMATO_HORA));
//		signonRequestBean.setInstitucionCanalizaServicio(
//				propertiesExternos.reniecAdquirienteWsSignOnParamInstitucionCanalizaServicio);
//		signonRequestBean.setInstitucionProveedorServicio(
//				propertiesExternos.reniecAdquirienteWsSignOnParamInstitucionProveedorServicio);
//		signonRequestBean.setInstitucionSolicitanteServicio(
//				propertiesExternos.reniecAdquirienteWsSignOnParamInstitucionSolicitanteServicio);
//		signonRequestBean.setLatitudLocalizacion(registrarPersonaRequest.getLatitudLocalizacion());
//		signonRequestBean.setLongitudLocalizacion(registrarPersonaRequest.getLongitudLocalizacion());
//		signonRequestBean.setMarcaDispositivo(registrarPersonaRequest.getMarcaDispositivo());
//		signonRequestBean.setModeloDispositivo(registrarPersonaRequest.getModeloDispositivo());
//		signonRequestBean.setModeloEstacion(propertiesExternos.reniecAdquirienteWsSignOnParamModeloEstacion);
//		signonRequestBean
//				.setNumeroIdentificadorCliente(consultaUsuarioAutorResponse.getkSalida().get(0).getUavDniAutorizado());
//		signonRequestBean.setNumeroOrden(registrarPersonaRequest.getNumeroOrden());
//		signonRequestBean.setNumeroTransaccion(identificacionTransaccionResponse.getpIdTrxBio());
//		signonRequestBean.setPuntoVentaSolicitanteServicio(
//				propertiesExternos.reniecAdquirienteWsSignOnParamPuntoVentaSolicitanteServicio);
//		signonRequestBean.setReservado(propertiesExternos.reniecAdquirienteWsSignOnParamReservado);
//		signonRequestBean
//				.setSistemaOperativoEstacion(propertiesExternos.reniecAdquirienteWsSignOnParamSistemaOperativoEstacion);
//		signonRequestBean.setTipoDispositivo(propertiesExternos.reniecAdquirienteWsSignOnParamTipoDispositivo);
//		signonRequestBean.setTipoEstacion(propertiesExternos.reniecAdquirienteWsSignOnParamTipoEstacion);
//		signonRequestBean.setTipoFormato(propertiesExternos.reniecAdquirienteWsSignOnParamTipoFormato);
//		signonRequestBean.setTipoIdentificacionDispositivo(
//				propertiesExternos.reniecAdquirienteWsSignOnParamTipoIdentificacionDispositivo);
//		signonRequestBean.setTipoIdentificacionEstacion(
//				propertiesExternos.reniecAdquirienteWsSignOnParamTipoIdentificacionEstacion);
//		signonRequestBean
//				.setTipoIdentificadorCliente(propertiesExternos.reniecAdquirienteWsSignOnParamTipoIdentificadorCliente);
//		signonRequestBean.setTipoMensaje(propertiesExternos.reniecAdquirienteWsSignOnParamTipoMensaje);
//		signonRequestBean.setVersionAplicativo(propertiesExternos.reniecAdquirienteWsSignOnParamVersionAplicativo);
//		signonRequestBean.setPassword(propertiesExternos.reniecAdquirienteWsSignOnParamPassword);
//		signonRequestBean.setUsuario(propertiesExternos.reniecAdquirienteWsSignOnParamUsuario);
//
//		return signonRequestBean;
//	}
//
//	public SignoffRequestBean setearCamposSignOff(RegistrarPersonaRequest registrarPersonaRequest,
//			SignonResponseBean signonResponseBean, IdentificacionTransaccionResponse identificacionTransaccionResponse,
//			ConsultaUsuarioAutorResponse consultaUsuarioAutorResponse, PropertiesExternos propertiesExternos)
//			throws Exception {
//
//		SignoffRequestBean signoffRequestBean = new SignoffRequestBean();
//
//		signoffRequestBean.setAgenteSolicitanteServicio(
//				propertiesExternos.reniecAdquirienteWsSignOnParamAgenteSolicitanteServicio);
//		signoffRequestBean.setAutenticacionMensaje(registrarPersonaRequest.getAutenticacionMensaje());
//		signoffRequestBean.setCodigoAdquirente(propertiesExternos.reniecAdquirienteWsSignOnParamCodigoAdquiriente);
//		signoffRequestBean.setCodigoAplicativo(propertiesExternos.reniecAdquirienteWsSignOnParamCodigoAplicativo);
//		signoffRequestBean.setCodigoGrupo(propertiesExternos.reniecAdquirienteWsSignOnParamCodigoGrupo);
//		signoffRequestBean.setCodigoIdentificacionDispositivo(
//				propertiesExternos.reniecAdquirienteWsSignOnParamCodigoIdentificacionDispositivo);
//		signoffRequestBean.setCodigoIdentificacionEstacion(
//				propertiesExternos.reniecAdquirienteWsSignOnParamCodigoIdentificacionEstacion);
//		signoffRequestBean.setCodigoProcesadorAdquirente(
//				propertiesExternos.reniecAdquirienteWsSignOnParamCodigoProcesadorAdquiriente);
//		signoffRequestBean.setCodigoSistemaLocalizacion(
//				propertiesExternos.reniecAdquirienteWsSignOnParamCodigoSistemaLocalizacion);
//		signoffRequestBean.setCodigoSubGrupo(propertiesExternos.reniecAdquirienteWsSignOnParamCodigoSubGrupo);
//		signoffRequestBean
//				.setCodigoTransaccion(propertiesExternos.reniecAdquirienteWsSignOffParamCodigoCodigoTransaccion);
//		signoffRequestBean.setFechaTransaccion(converDatetoString(new Date(), Constantes.FORMATO_FECHA));
//		signoffRequestBean.setHoraTransaccion(converDatetoString(new Date(), Constantes.FORMATO_HORA));
//		signoffRequestBean.setInstitucionCanalizaServicio(
//				propertiesExternos.reniecAdquirienteWsSignOnParamInstitucionCanalizaServicio);
//		signoffRequestBean.setInstitucionProveedorServicio(
//				propertiesExternos.reniecAdquirienteWsSignOnParamInstitucionProveedorServicio);
//		signoffRequestBean.setInstitucionSolicitanteServicio(
//				propertiesExternos.reniecAdquirienteWsSignOnParamInstitucionSolicitanteServicio); /****** aaaa ***************/
//		signoffRequestBean.setLatitudLocalizacion(registrarPersonaRequest.getLatitudLocalizacion());
//		signoffRequestBean.setLongitudLocalizacion(registrarPersonaRequest.getLongitudLocalizacion());
//		signoffRequestBean.setMarcaDispositivo(registrarPersonaRequest.getMarcaDispositivo());
//		signoffRequestBean.setModeloDispositivo(registrarPersonaRequest.getModeloDispositivo());
//		signoffRequestBean.setModeloEstacion(propertiesExternos.reniecAdquirienteWsSignOnParamModeloEstacion);
//		signoffRequestBean
//				.setNumeroIdentificadorCliente(consultaUsuarioAutorResponse.getkSalida().get(0).getUavDniAutorizado());
//		signoffRequestBean.setNumeroOrden(registrarPersonaRequest.getNumeroOrden());
//		signoffRequestBean.setNumeroTransaccion(identificacionTransaccionResponse.getpIdTrxBio());
//		signoffRequestBean.setPuntoVentaSolicitanteServicio(
//				propertiesExternos.reniecAdquirienteWsSignOnParamPuntoVentaSolicitanteServicio);
//		signoffRequestBean.setReservado(propertiesExternos.reniecAdquirienteWsSignOnParamReservado);
//		signoffRequestBean
//				.setSistemaOperativoEstacion(propertiesExternos.reniecAdquirienteWsSignOnParamSistemaOperativoEstacion);
//		signoffRequestBean.setTipoDispositivo(propertiesExternos.reniecAdquirienteWsSignOnParamTipoDispositivo);
//		signoffRequestBean.setTipoEstacion(propertiesExternos.reniecAdquirienteWsSignOnParamTipoEstacion);
//		signoffRequestBean.setTipoFormato(propertiesExternos.reniecAdquirienteWsSignOnParamTipoFormato);
//		signoffRequestBean.setTipoIdentificacionDispositivo(
//				propertiesExternos.reniecAdquirienteWsSignOnParamTipoIdentificacionDispositivo);
//		signoffRequestBean.setTipoIdentificacionEstacion(
//				propertiesExternos.reniecAdquirienteWsSignOnParamTipoIdentificacionEstacion);
//		signoffRequestBean
//				.setTipoIdentificadorCliente(propertiesExternos.reniecAdquirienteWsSignOnParamTipoIdentificadorCliente);
//		signoffRequestBean.setTipoMensaje(propertiesExternos.reniecAdquirienteWsSignOnParamTipoMensaje);
//		signoffRequestBean.setVersionAplicativo(propertiesExternos.reniecAdquirienteWsSignOnParamVersionAplicativo);
//		signoffRequestBean.setIdSesion(signonResponseBean.getIdSesion());
//		signoffRequestBean.setPassword(propertiesExternos.reniecAdquirienteWsSignOnParamPassword);
//		signoffRequestBean.setUsuario(propertiesExternos.reniecAdquirienteWsSignOnParamUsuario);
//
//		return signoffRequestBean;
//	}
}
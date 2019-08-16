package pe.com.claro.venta.identidad.domain.service.test;

import static org.mockito.Mockito.when;

import javax.ws.rs.core.Configuration;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pe.com.claro.venta.usuariobiometria.canonical.registrapersona.request.RegistrarPersonaRequest;
import pe.com.claro.venta.usuariobiometria.canonical.registrarpersona.response.RegistrarPersonaResponse;
import pe.com.claro.venta.usuariobiometria.common.bean.HeaderRequestBean;
import pe.com.claro.venta.usuariobiometria.common.util.PropertiesExternos;
import pe.com.claro.venta.usuariobiometria.domain.dao.PvuDao;
import pe.com.claro.venta.usuariobiometria.domain.service.IdentidadService;
import pe.com.claro.venta.usuariobiometria.model.response.IdentificacionTransaccionResponse;

public class IdentidadServiceTest {

	@Mock
	Configuration configuration;
	
	@InjectMocks
	IdentidadService identidadService;

	@Mock 
	PropertiesExternos propertiesExternos;
	

	@Mock 
	PvuDao pvuDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		// ########CODIGO Y MENSAJE DE ERROR############
		when(configuration.getProperty("codigo.generico.error.idt1")).thenReturn("-1");
		when(configuration.getProperty("mensaje.generico.error.idt1")).thenReturn("Error de timeout en el WS $ws y el metodo $metodo");
		when(configuration.getProperty("codigo.generico.error.idt2")).thenReturn("-2");
		when(configuration.getProperty("mensaje.generico.error.idt2")).thenReturn("Error de disponibilidad en el WS $ws y el metodo $metodo");
		when(configuration.getProperty("codigo.generico.error.idt3")).thenReturn("-3");
		when(configuration.getProperty("mensaje.generico.error.idt3")).thenReturn("Error de timeout en el SP $sp de la BD $bd");
		when(configuration.getProperty("codigo.generico.error.idt4")).thenReturn("-4");
		when(configuration.getProperty("mensaje.generico.error.idt4")).thenReturn("Error de disponibilidad el SP $sp de la BD $bd");
		when(configuration.getProperty("codigo.generico.error.idt5")).thenReturn("-5");
		when(configuration.getProperty("mensaje.generico.error.idt5")).thenReturn("Error en el Web Service");

		// ########CONEXIONRENIEC_GENERARTOKEN############
		when(configuration.getProperty("conexionReniec.generarToken.rest.client.url")).thenReturn("http://localhost:7001/claro-venta-conexionReniec-resource/api/venta/conexionReniec/v1.0.0/");
		when(configuration.getProperty("conexionReniec.generarToken.rest.client.method")).thenReturn("generarToken");
		when(configuration.getProperty("conexionReniec.generarToken.rest.client.timeout")).thenReturn("10000");

		// ########CONEXIONRENIEC_ELIMINARTOKEN############
		when(configuration.getProperty("conexionReniec.eliminarToken.rest.client.url")).thenReturn("http://localhost:7001/claro-venta-conexionReniec-resource/api/venta/conexionReniec/v1.0.0/");
		when(configuration.getProperty("conexionReniec.eliminarToken.rest.client.method")).thenReturn("eliminarToken");
		when(configuration.getProperty("conexionReniec.eliminarToken.rest.client.timeout")).thenReturn("1000");

		// ########SERVICIO RENIECADQUIRIENTEWS_REGISTRARPERSONA############
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.url")).thenReturn("http://localhost:8081/MockServicesAdquirienteWS?wsdl");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.nombre")).thenReturn("ReniecAdquirienteWS");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.method")).thenReturn("RegistrarPersona");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.nombre.impl")).thenReturn("ReniecAdquirienteWSSoa");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.timeout.connection")).thenReturn("1000");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.timeout.request")).thenReturn("1000");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.agente.solicitante.servicio")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.codigo.adquiriente")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.codigo.aplicativo")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.agente.codigo.grupo")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.identificacion.dispositivo")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.identificacion.estacion")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.codigo.procesador.adquiriente")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.codigo.sistema.localizacion")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.codigo.sub.grupo")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.codigo.transaccion")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.institucion.canaliza.servicio")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.institucion.proveedor.servicio")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.institucion.solicitante.servicio")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.modelo.estacion")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.punto.venta.solicitante.servicio")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.reservado")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.sistema.operativo.estacion")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.tipo.dispositivo")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.tipo.estacion")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.tipo.formato")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.tipo.identificaion.dispositivo")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.tipo.identificacion.estacion")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.identificador.cliente")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.tipo.mensaje")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.version.aplicacion")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.numero.identificador.institucion")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.tipo.identificador.insititucion")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.tipo.de.documento.persona")).thenReturn("");
		when(configuration.getProperty("reniecAdquirienteWS.registrarpersona.soa.client.param.tipo.id")).thenReturn("");
		
		//########CODIGO Y MENSAJE DE ERROR FUNCIONAL############
		when(configuration.getProperty("claro.venta.identidad.codigo.idf0")).thenReturn("0");
		when(configuration.getProperty("claro.venta.identidad.mensaje.idf0")).thenReturn("Proceso exitoso");
		when(configuration.getProperty("claro.venta.identidad.codigo.idf1")).thenReturn("1");
		when(configuration.getProperty("claro.venta.identidad.mensaje.idf1")).thenReturn("Usuario sin autorizacion");

		//########BASE DE DATOS############
		when(configuration.getProperty("bd.pvu.owner")).thenReturn("PVU");
		when(configuration.getProperty("bd.pvu.pkg.sisact.pkg.biometria")).thenReturn("SISACT_PKG_BIOMETRIA");
		when(configuration.getProperty("bd.pvu.sp.consulta_usuarioautor")).thenReturn("SP_CONSULTA_USUARIOAUTOR");
		when(configuration.getProperty("bd.pvu.fun.gen.id.tx.bio")).thenReturn("SISACTFUN_GEN_ID_TX_BIO");
		when(configuration.getProperty("bd.pvu.conexion.timeout.limite.consulta.usuario")).thenReturn("1000");
			
		propertiesExternos = new PropertiesExternos(configuration);
		
	}

	/************************************************** [INICIO] TEST **************************************************/
	
//	@Test
//	public void testCase01mostrarIDF1ConexionReniecGenerarTokenA() throws DBException {
//		HeaderRequestBean headerRequestBean =crearHeaderRequestBean();
//		RegistrarPersonaRequest registrarPersonaRequest =crearRegistrarPersonaRequest();
//		String mensajeTransaccion = "";
//		
//		IdentificacionTransaccionResponse identificacionTransaccionResponse = crearIdentificacionTransaccionResponse(); 
//		ConsultaUsuarioAutorResponse consultaUsuarioAutorResponse = crearConsultaUsuarioAutorResponseNulo();
//		
//		when(pvuDao.obtenerNumeroTransaccion(any(PropertiesExternos.class), any(HeaderRequestBean.class), any(String.class), any(IdentificacionTransaccionRequest.class))).thenReturn(identificacionTransaccionResponse);
//		when(pvuDao.obtenerNumeroIdentificadorCliente(any(PropertiesExternos.class), any(HeaderRequestBean.class), any(String.class), any(ConsultaUsuarioAutorRequest.class))).thenReturn(consultaUsuarioAutorResponse);
//		
//		RegistrarPersonaResponse responseObtenido = identidadService.registrarPersona(headerRequestBean, registrarPersonaRequest, propertiesExternos, mensajeTransaccion);
//	
//		RegistrarPersonaResponse responseEsperado = registrarPersonaResponseErrorIDF1PvuObtenerIdentificadorCliente();
//		assertThat(responseObtenido).isEqualToComparingFieldByFieldRecursively(responseEsperado);
//	}
//	
//    private RegistrarPersonaResponse registrarPersonaResponseErrorIDF1PvuObtenerIdentificadorCliente() {
//    	RegistrarPersonaResponse registrarPersonaResponse = new RegistrarPersonaResponse();
//    	registrarPersonaResponse.setCodigoRespuesta("1");
//    	registrarPersonaResponse.setMensajeRespuesta("Usuario sin autorizacion");
//    	
//    	return registrarPersonaResponse;
//	}
//
//	private ConsultaUsuarioAutorResponse crearConsultaUsuarioAutorResponse() {
//    	ConsultaUsuarioAutorResponse consultaUsuarioAutorResponse = new ConsultaUsuarioAutorResponse();
//    	
//    	List<DataResponse> listaDataResponse = new ArrayList<>();
//    	DataResponse dataResponse = new DataResponse();
//    	dataResponse.setUavDniAutorizado("05223454");
//    	listaDataResponse.add(dataResponse);
//    	consultaUsuarioAutorResponse.setkSalida(listaDataResponse);
//		return consultaUsuarioAutorResponse;
//	}
//    
//    private ConsultaUsuarioAutorResponse crearConsultaUsuarioAutorResponseNulo() {
//    	ConsultaUsuarioAutorResponse consultaUsuarioAutorResponse = new ConsultaUsuarioAutorResponse();
//    	consultaUsuarioAutorResponse.setkSalida(null);
//		return consultaUsuarioAutorResponse;
//	}
//
//	@Test
//	public void testCase01mostrarIDF1ConexionReniecGenerarToken() throws WSException {
//		HeaderRequestBean headerRequestBean =crearHeaderRequestBean();
//		RegistrarPersonaRequest registrarPersonaRequest =crearRegistrarPersonaRequest();
//		String mensajeTransaccion = "";
//		GenerarTokenResponse generarTokenResponse = crearGenerarTokenResponseIDF1();
//		when(conexionReniecClientWsRestClient.generarToken(any(GenerarTokenRequest.class),any(HeaderRequestBean.class), any(PropertiesExternos.class), any(String.class))).thenReturn(generarTokenResponse);
//	
//		RegistrarPersonaResponse responseObtenido = identidadService.registrarPersona(headerRequestBean, registrarPersonaRequest, propertiesExternos, mensajeTransaccion);
//	
//		RegistrarPersonaResponse responseEsperado = registrarPersonaResponseErrorIDF1ConexionReniecGenerarToken();
//		assertThat(responseObtenido).isEqualToComparingFieldByFieldRecursively(responseEsperado);
//	}
//
//	@Test
//	public void testCase02mostrarIDT1ConexionReniecGenerarToken(){
//		HeaderRequestBean headerRequestBean =crearHeaderRequestBean();
//		RegistrarPersonaRequest registrarPersonaRequest =crearRegistrarPersonaRequest();
//		String mensajeTransaccion = "";
//		IdentidadService objIdentidadService = new IdentidadService();
//		
////		propertiesExternos.conexionReniecGenerarTokenRestClientTimeOut="1";
//		RegistrarPersonaResponse responseObtenido = objIdentidadService.registrarPersona(headerRequestBean, registrarPersonaRequest, propertiesExternos, mensajeTransaccion);
//		RegistrarPersonaResponse responseEsperado = registrarPersonaResponseErrorIDT1ConexionReniecGenerarToken();
//		assertThat(responseObtenido).isEqualToComparingFieldByFieldRecursively(responseEsperado);
//	}
//	
//	@Test
//	public void testCase03mostrarIDT2ConexionReniecGenerarToken(){
////		propertiesExternos.conexionReniecGenerarTokenRestClientURL="http://localhost:7002/claro-venta-conexionReniec-resource/api/venta/conexionReniec/v1.0.0/";
//		HeaderRequestBean headerRequestBean =crearHeaderRequestBean();
//		RegistrarPersonaRequest registrarPersonaRequest =crearRegistrarPersonaRequest();
//		String mensajeTransaccion = "";
//		IdentidadService objIdentidadService = new IdentidadService();
//		RegistrarPersonaResponse responseObtenido = objIdentidadService.registrarPersona(headerRequestBean, registrarPersonaRequest, propertiesExternos, mensajeTransaccion);
//		RegistrarPersonaResponse responseEsperado = registrarPersonaResponseErrorIDT2ConexionReniecGenerarToken();
//		assertThat(responseObtenido).isEqualToComparingFieldByFieldRecursively(responseEsperado);
//	}
//	
//	@Test
//	public void testCase04mostrarIDT5ConexionReniecGenerarToken(){
////		propertiesExternos.conexionReniecGenerarTokenRestClientURL="http://localhost:7001/claro-venta-conexionReniec-resource/api/venta/conexionReniec/v1.0.0/";
//		HeaderRequestBean headerRequestBean =crearHeaderRequestBean();
//		RegistrarPersonaRequest registrarPersonaRequest =crearRegistrarPersonaRequest();
//		String mensajeTransaccion = "";
//		IdentidadService objIdentidadService = new IdentidadService();
//		RegistrarPersonaResponse responseObtenido = objIdentidadService.registrarPersona(headerRequestBean, registrarPersonaRequest, propertiesExternos, mensajeTransaccion);
//		RegistrarPersonaResponse responseEsperado = registrarPersonaResponseErrorIDT5ConexionReniecGenerarToken();
//		assertThat(responseObtenido).isEqualToComparingFieldByFieldRecursively(responseEsperado);
//	}
//	
//	
//	@Test
//	public void testCase05mostrarIDT5ConexionReniecGenerarToken() throws WSException {
//		HeaderRequestBean headerRequestBean =crearHeaderRequestBean();
//		RegistrarPersonaRequest registrarPersonaRequest =crearRegistrarPersonaRequest();
//		String mensajeTransaccion = "";
//		GenerarTokenResponse generarTokenResponse = crearGenerarTokenResponseIDF0();
//		when(conexionReniecClientWsRestClient.generarToken(any(GenerarTokenRequest.class),any(HeaderRequestBean.class), any(PropertiesExternos.class),any(String.class))).thenReturn(generarTokenResponse);
//		RegistrarPersonaResponse responseObtenido = identidadService.registrarPersona(headerRequestBean, registrarPersonaRequest, propertiesExternos, mensajeTransaccion);
//		RegistrarPersonaResponse responseEsperado = registrarPersonaResponseErrorIDF1ConexionReniecGenerarToken();
//		assertThat(responseObtenido).isEqualToComparingFieldByFieldRecursively(responseEsperado);
//	}
	
	
	
	
	private IdentificacionTransaccionResponse crearIdentificacionTransaccionResponse() {
		IdentificacionTransaccionResponse identificacionTransaccionResponse = new IdentificacionTransaccionResponse();
		identificacionTransaccionResponse.setpIdTrxBio("0000000000176478_CHRISTIAN");
		return identificacionTransaccionResponse;
	}

	/************************************************** [FIN] TEST **************************************************/
	

	private RegistrarPersonaRequest crearRegistrarPersonaRequest() {
		RegistrarPersonaRequest registrarPersonaRequest = new RegistrarPersonaRequest();
		registrarPersonaRequest.setApellidoMaterno("apellidoMaterno");
		return registrarPersonaRequest;
	}
	
	/************************************************** [INICIO] GENERICOS **************************************************/
	private HeaderRequestBean crearHeaderRequestBean() {
		HeaderRequestBean headerRequestBean = new HeaderRequestBean();
		headerRequestBean.setIdTransaccion("20190506001");
		headerRequestBean.setMsgid("msgid");
		headerRequestBean.setTimestamp("2013-09-29T18:46:19Z");
		headerRequestBean.setUserId("userId");
		headerRequestBean.setAccept("application/json");
		return headerRequestBean;
	}
	/************************************************** [FIN] GENERICOS **************************************************/
	

	/************************************************** [INICIO] REQUEST CONEXIONRENIEC - GENERARTOKEN **************************************************/
	
//	private GenerarTokenResponse crearGenerarTokenResponseIDF1() {
//		GenerarTokenResponse generarTokenResponse = new GenerarTokenResponse();
//		generarTokenResponse.setCodigoRespuesta("1");
//		generarTokenResponse.setMensajeRespuesta("");
//		return generarTokenResponse;
//	}
//	private GenerarTokenResponse crearGenerarTokenResponseIDF0() {
//		GenerarTokenResponse generarTokenResponse = new GenerarTokenResponse();
//		generarTokenResponse.setCodigoRespuesta("0");
//		generarTokenResponse.setMensajeRespuesta("");
//		return generarTokenResponse;
//	}

	/************************************************** [FIN] REQUEST CONEXIONRENIEC - GENERARTOKEN **************************************************/
	
	
	/************************************************** [INICIO] RESPONSE CONEXIONRENIEC - GENERARTOKEN **************************************************/
	private RegistrarPersonaResponse registrarPersonaResponseErrorIDF1ConexionReniecGenerarToken() {
		RegistrarPersonaResponse registrarPersonaResponse = new RegistrarPersonaResponse();
		registrarPersonaResponse.setCodigoRespuesta("1");
		registrarPersonaResponse.setMensajeRespuesta("No se inicio sesion");
		return registrarPersonaResponse;
	}
	
	private RegistrarPersonaResponse registrarPersonaResponseErrorIDT1ConexionReniecGenerarToken() {
		RegistrarPersonaResponse registrarPersonaResponse = new RegistrarPersonaResponse();
		registrarPersonaResponse.setCodigoRespuesta("-1");
		registrarPersonaResponse.setMensajeRespuesta("Error de timeout en el WS claro-venta-identidad y el metodo generarToken java.net.SocketTimeoutException: Read timed out");
		return registrarPersonaResponse;
	}
	
	private RegistrarPersonaResponse registrarPersonaResponseErrorIDT2ConexionReniecGenerarToken() {
		RegistrarPersonaResponse registrarPersonaResponse = new RegistrarPersonaResponse();
		registrarPersonaResponse.setCodigoRespuesta("-2");
		registrarPersonaResponse.setMensajeRespuesta("Error de disponibilidad en el WS claro-venta-identidad y el metodo generarToken java.net.ConnectException: Connection refused: connect");
		return registrarPersonaResponse;
	}
	
	private RegistrarPersonaResponse registrarPersonaResponseErrorIDT5ConexionReniecGenerarToken() {
		RegistrarPersonaResponse registrarPersonaResponse = new RegistrarPersonaResponse();
		registrarPersonaResponse.setCodigoRespuesta("-5");
		registrarPersonaResponse.setMensajeRespuesta("Error en el Web Service Unrecognized token 'Unauthorized': was expecting ('true', 'false' or 'null')\n at [Source: Unauthorized; line: 1, column: 25]");
		return registrarPersonaResponse;
	}
	/************************************************** [FIN] RESPONSE CONEXIONRENIEC - GENERARTOKEN **************************************************/
	

}
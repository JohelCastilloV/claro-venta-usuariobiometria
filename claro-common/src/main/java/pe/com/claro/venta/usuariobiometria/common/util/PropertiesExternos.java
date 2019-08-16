package pe.com.claro.venta.usuariobiometria.common.util;

import javax.ws.rs.core.Configuration;

public class PropertiesExternos {
	// CODIGO Y MENSAJE DE ERROR
	public final  String codigoGenericoErrorIDT1;
	public final  String mensajeGenericoErrorIDT1;
	public final  String codigoGenericoErrorIDT2;
	public final  String mensajeGenericoErrorIDT2;
	public final  String codigoGenericoErrorIDT3;
	public final  String mensajeGenericoErrorIDT3;
	public final  String codigoGenericoErrorIDT4;
	public final  String mensajeGenericoErrorIDT4;
	public final  String codigoGenericoErrorIDT5;
	public final  String mensajeGenericoErrorIDT5;

	// SERVICIO CONEXIONRENIEC_GENERARTOKEN
	public final  String conexionReniecRestClientURL;
	public final  String conexionReniecGenerarTokenRestClientMethod;
	public final  String conexionReniecGenerarTokenRestClientTimeOut;

	// SERVICIO CONEXIONRENIEC_ELIMINARTOKEN
	public final  String conexionReniecEliminarTokenRestClientMethod;
	public final  String conexionReniecEliminarTokenRestClientTimeOut;
		
	// CODIGO IDF
	public final  String claroVentaIdentidadCodigoIDF0;
	public final  String claroVentaIdentidadMensajeIDF0;
	public final  String claroVentaIdentidadCodigoIDF1;
	public final  String claroVentaIdentidadMensajeIDF1;
		


	//SERVICIO RENIECADQUIRIENTEWS
	public final  String reniecAdquirienteWsSoaClientURL;
	public final  String reniecAdquirienteWsSoaClientNombre;
	public final  String reniecAdquirienteWsSoaClientNombreImpl;
	
	// CODIGO RENIECADQUIRIENTEWS_SIGNON
	public final  String reniecAdquirienteWsSignOnSoaClientMethod;
	public final  int reniecAdquirienteWsSignOnSoaClientTimeOutConnection;
	public final  int reniecAdquirienteWsSignOnSoaClientTimeOutRequest;
	public final  String reniecAdquirienteWsSignOnParamAgenteSolicitanteServicio;
	public final  String reniecAdquirienteWsSignOnParamCodigoAdquiriente;
	public final  String reniecAdquirienteWsSignOnParamCodigoAplicativo;
	public final  String reniecAdquirienteWsSignOnParamCodigoGrupo;
	public final  String reniecAdquirienteWsSignOnParamCodigoIdentificacionDispositivo;
	public final  String reniecAdquirienteWsSignOnParamCodigoIdentificacionEstacion;
	public final  String reniecAdquirienteWsSignOnParamCodigoProcesadorAdquiriente;
	public final  String reniecAdquirienteWsSignOnParamCodigoSistemaLocalizacion;
	public final  String reniecAdquirienteWsSignOnParamCodigoSubGrupo;
	public final  String reniecAdquirienteWsSignOnParamCodigoCodigoTransaccion;
	public final  String reniecAdquirienteWsSignOnParamInstitucionCanalizaServicio;
	public final  String reniecAdquirienteWsSignOnParamInstitucionProveedorServicio;
	public final  String reniecAdquirienteWsSignOnParamInstitucionSolicitanteServicio;
	public final  String reniecAdquirienteWsSignOnParamModeloEstacion;
	public final  String reniecAdquirienteWsSignOnParamPuntoVentaSolicitanteServicio;
	public final  String reniecAdquirienteWsSignOnParamReservado;
	public final  String reniecAdquirienteWsSignOnParamSistemaOperativoEstacion;
	public final  String reniecAdquirienteWsSignOnParamTipoDispositivo;
	public final  String reniecAdquirienteWsSignOnParamTipoEstacion;
	public final  String reniecAdquirienteWsSignOnParamTipoFormato;
	public final  String reniecAdquirienteWsSignOnParamTipoIdentificacionDispositivo;
	public final  String reniecAdquirienteWsSignOnParamTipoIdentificacionEstacion;
	public final  String reniecAdquirienteWsSignOnParamTipoIdentificadorCliente;
	public final  String reniecAdquirienteWsSignOnParamTipoMensaje;
	public final  String reniecAdquirienteWsSignOnParamVersionAplicativo;
	public final  String reniecAdquirienteWsSignOnParamPassword;
	public final  String reniecAdquirienteWsSignOnParamUsuario;

	// CODIGO RENIECADQUIRIENTEWS_SIGNOFF
	public final  String reniecAdquirienteWsSignOffSoaClientMethod;
	public final  int reniecAdquirienteWsSignOffSoaClientTimeOutConnection;
	public final  int reniecAdquirienteWsSignOffSoaClientTimeOutRequest;

	public final  String reniecAdquirienteWsSignOffParamCodigoCodigoTransaccion;
	
	// CODIGO RENIECADQUIRIENTEWS_REGISTRARPERSONA
	public final  String reniecAdquirienteWsRegisrarPersonaSoaClientMethod;
	public final  int reniecAdquirienteWsRegisrarPersonaSoaClientTimeOutConnection;
	public final  int reniecAdquirienteWsRegisrarPersonaSoaClientTimeOutRequest;
	
	public final  String reniecAdquirienteWsRegisrarPersonaParamAgenteSolicitanteServicio;
	public final  String reniecAdquirienteWsRegisrarPersonaParamCodigoAdquiriente;
	public final  String reniecAdquirienteWsRegisrarPersonaParamCodigoAplicativo;
	public final  String reniecAdquirienteWsRegisrarPersonaParamCodigoGrupo;
	public final  String reniecAdquirienteWsRegisrarPersonaParamCodigoIdentificacionDispositivo;
	public final  String reniecAdquirienteWsRegisrarPersonaParamCodigoIdentificacionEstacion;
	public final  String reniecAdquirienteWsRegisrarPersonaParamCodigoProcesadorAdquiriente;
	public final  String reniecAdquirienteWsRegisrarPersonaParamCodigoSistemaLocalizacion;
	public final  String reniecAdquirienteWsRegisrarPersonaParamCodigoSubGrupo;
	public final  String reniecAdquirienteWsRegisrarPersonaParamCodigoTransaccion;
	public final  String reniecAdquirienteWsRegisrarPersonaParamInstitucionCanalizaServicio;
	public final  String reniecAdquirienteWsRegisrarPersonaParamInstitucionProveedorServicio;
	public final  String reniecAdquirienteWsRegisrarPersonaParamInstitucionSolicitanteServicio;
	public final  String reniecAdquirienteWsRegisrarPersonaParamModeloEstacion;
	public final  String reniecAdquirienteWsRegisrarPersonaParamPuntoVentaSolicitanteServicio;
	public final  String reniecAdquirienteWsRegisrarPersonaParamReservado;
	public final  String reniecAdquirienteWsRegisrarPersonaParamSistemaOperativoEstacion;
	public final  String reniecAdquirienteWsRegisrarPersonaParamTipoDispositivo;
	public final  String reniecAdquirienteWsRegisrarPersonaParamTipoEstacion;
	public final  String reniecAdquirienteWsRegisrarPersonaParamTipoFormato;
	public final  String reniecAdquirienteWsRegisrarPersonaParamTipoIdentificacionDispositivo;
	public final  String reniecAdquirienteWsRegisrarPersonaParamTipoIdentificacionEstacion;
	public final  String reniecAdquirienteWsRegisrarPersonaParamTipoIdentificadorCliente;
	public final  String reniecAdquirienteWsRegisrarPersonaParamTipoMensaje;
	public final  String reniecAdquirienteWsRegisrarPersonaParamVersionAplicativo;
	public final  String reniecAdquirienteWsRegisrarPersonaParamNumeroIdentificadorInstitucion;
	public final  String reniecAdquirienteWsRegisrarPersonaParamTipoIdentificadorInstitucion;
		
	//BASE DE DATOS
	public final  String bdPvuOwner;
	public final  String bdPvuPkgSisactPkgBiometria;
	public final  String bdPvuSpConsultaUsuarioAutor;
	public final  String bdPvuFunGenIdTxBio;
	public final  String bdPvuConexionTimeOutLimiteConsultaUsuario;
//	public final  String bdPvuFunGenIdTxBioInIdTransaccion;
	public final  String bdPvuParamTipoId;
		
	    
	public PropertiesExternos(Configuration configuration) {
		super();
			
			//CODIGO Y MENSAJE DE ERROR TECNICO
			this.codigoGenericoErrorIDT1 = cargarProperties(configuration, "codigo.generico.error.idt1");
			this.mensajeGenericoErrorIDT1 = cargarProperties(configuration, "mensaje.generico.error.idt1");
			this.codigoGenericoErrorIDT2 = cargarProperties(configuration, "codigo.generico.error.idt2");
			this.mensajeGenericoErrorIDT2 = cargarProperties(configuration, "mensaje.generico.error.idt2");
			this.codigoGenericoErrorIDT3 = cargarProperties(configuration, "codigo.generico.error.idt3");
			this.mensajeGenericoErrorIDT3 = cargarProperties(configuration, "mensaje.generico.error.idt3");
			this.codigoGenericoErrorIDT4 = cargarProperties(configuration, "codigo.generico.error.idt4");
			this.mensajeGenericoErrorIDT4 = cargarProperties(configuration, "mensaje.generico.error.idt4");
			this.codigoGenericoErrorIDT5 = cargarProperties(configuration, "codigo.generico.error.idt5");
			this.mensajeGenericoErrorIDT5 = cargarProperties(configuration, "mensaje.generico.error.idt5");

			//SERVICIO CONEXIONRENIEC_GENERARTOKEN
			this.conexionReniecRestClientURL=cargarProperties(configuration,"conexionReniec.rest.client.url");
			this.conexionReniecGenerarTokenRestClientMethod=cargarProperties(configuration,"conexionReniec.generarToken.rest.client.method");
			this.conexionReniecGenerarTokenRestClientTimeOut=cargarProperties(configuration,"conexionReniec.generarToken.rest.client.timeout");
			
			//SERVICIO CONEXIONRENIEC_ELIMINARTOKEN
			this.conexionReniecEliminarTokenRestClientMethod=cargarProperties(configuration,"conexionReniec.eliminarToken.rest.client.method");
			this.conexionReniecEliminarTokenRestClientTimeOut=cargarProperties(configuration,"conexionReniec.eliminarToken.rest.client.timeout");

			//SERVICIO RENIECADQUIRIENTEWS
			this.reniecAdquirienteWsSoaClientURL=cargarProperties(configuration,"reniecAdquirienteWS.soa.client.url");
			this.reniecAdquirienteWsSoaClientNombre=cargarProperties(configuration,"reniecAdquirienteWS.soa.client.nombre");
			this.reniecAdquirienteWsSoaClientNombreImpl=cargarProperties(configuration,"reniecAdquirienteWS.soa.client.nombre.impl");
			
			//SERVICIO RENIECADQUIRIENTEWS_SINGON
			this.reniecAdquirienteWsSignOnSoaClientMethod=cargarProperties(configuration,"reniecAdquirienteWS.signon.soa.client.method");
			this.reniecAdquirienteWsSignOnSoaClientTimeOutConnection = Integer.parseInt(cargarProperties(configuration, "reniecAdquirienteWS.signon.soa.client.timeout.connection"));
			this.reniecAdquirienteWsSignOnSoaClientTimeOutRequest = Integer.parseInt(cargarProperties(configuration, "reniecAdquirienteWS.signon.soa.client.timeout.request"));

			this.reniecAdquirienteWsSignOnParamAgenteSolicitanteServicio = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.agente.solicitante.servicio");
			this.reniecAdquirienteWsSignOnParamCodigoAdquiriente = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.codigo.adquiriente");
			this.reniecAdquirienteWsSignOnParamCodigoAplicativo = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.codigo.aplicativo");
			this.reniecAdquirienteWsSignOnParamCodigoGrupo = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.codigo.grupo");
			this.reniecAdquirienteWsSignOnParamCodigoIdentificacionDispositivo = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.codigo.identificacion.dispositivo");
			this.reniecAdquirienteWsSignOnParamCodigoIdentificacionEstacion = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.codigo.identificacion.estacion");
			this.reniecAdquirienteWsSignOnParamCodigoProcesadorAdquiriente = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.codigo.procesador.adquiriente");
			this.reniecAdquirienteWsSignOnParamCodigoSistemaLocalizacion = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.codigo.sistema.localizacion");
			this.reniecAdquirienteWsSignOnParamCodigoSubGrupo = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.codigo.sub.grupo");
			this.reniecAdquirienteWsSignOnParamCodigoCodigoTransaccion = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.codigo.transaccion");
			this.reniecAdquirienteWsSignOnParamInstitucionCanalizaServicio = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.institucion.canaliza.servicio");
			this.reniecAdquirienteWsSignOnParamInstitucionProveedorServicio = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.institucion.proveedor.servicio");
			this.reniecAdquirienteWsSignOnParamInstitucionSolicitanteServicio = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.institucion.solicitante.servicio");
			this.reniecAdquirienteWsSignOnParamModeloEstacion = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.modelo.estacion");
			this.reniecAdquirienteWsSignOnParamPuntoVentaSolicitanteServicio = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.punto.venta.solicitante.servicio");
			this.reniecAdquirienteWsSignOnParamReservado = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.reservado");
			this.reniecAdquirienteWsSignOnParamSistemaOperativoEstacion = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.sistema.operativo.estacion");
			this.reniecAdquirienteWsSignOnParamTipoDispositivo = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.tipo.dispositivo");
			this.reniecAdquirienteWsSignOnParamTipoEstacion = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.tipo.estacion");
			this.reniecAdquirienteWsSignOnParamTipoFormato = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.tipo.formato");
			this.reniecAdquirienteWsSignOnParamTipoIdentificacionDispositivo = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.tipo.identificacion.dispositivo");
			this.reniecAdquirienteWsSignOnParamTipoIdentificacionEstacion = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.tipo.identificacion.estacion");
			this.reniecAdquirienteWsSignOnParamTipoIdentificadorCliente = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.tipo.identificador.cliente");
			this.reniecAdquirienteWsSignOnParamTipoMensaje = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.tipo.mensaje");
			this.reniecAdquirienteWsSignOnParamVersionAplicativo = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.version.aplicativo");
			this.reniecAdquirienteWsSignOnParamPassword = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.password");
			this.reniecAdquirienteWsSignOnParamUsuario = cargarProperties(configuration, "reniecAdquirienteWS.signon.param.usuario");
			
			//SERVICIO RENIECADQUIRIENTEWS_SINGOFF
			this.reniecAdquirienteWsSignOffSoaClientMethod=cargarProperties(configuration,"reniecAdquirienteWS.signoff.soa.client.method");
			this.reniecAdquirienteWsSignOffSoaClientTimeOutConnection = Integer.parseInt(cargarProperties(configuration, "reniecAdquirienteWS.signoff.soa.client.timeout.connection"));
			this.reniecAdquirienteWsSignOffSoaClientTimeOutRequest = Integer.parseInt(cargarProperties(configuration, "reniecAdquirienteWS.signoff.soa.client.timeout.request"));

			this.reniecAdquirienteWsSignOffParamCodigoCodigoTransaccion = cargarProperties(configuration, "reniecAdquirienteWS.signoff.param.codigo.transaccion");
			
			
			//SERVICIO RENIECADQUIRIENTEWS_REGISTRARPERSONA
			this.reniecAdquirienteWsRegisrarPersonaSoaClientMethod=cargarProperties(configuration,"reniecAdquirienteWS.registrarpersona.soa.client.method");
			this.reniecAdquirienteWsRegisrarPersonaSoaClientTimeOutConnection = Integer.parseInt(cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.soa.client.timeout.connection"));
			this.reniecAdquirienteWsRegisrarPersonaSoaClientTimeOutRequest = Integer.parseInt(cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.soa.client.timeout.request"));
			
			this.reniecAdquirienteWsRegisrarPersonaParamAgenteSolicitanteServicio=cargarProperties(configuration,"reniecAdquirienteWS.registrarpersona.param.agente.solicitante.servicio");
			this.reniecAdquirienteWsRegisrarPersonaParamCodigoAdquiriente = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.codigo.adquiriente");
			this.reniecAdquirienteWsRegisrarPersonaParamCodigoAplicativo = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.codigo.aplicativo");
			this.reniecAdquirienteWsRegisrarPersonaParamCodigoGrupo = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.agente.codigo.grupo");
			this.reniecAdquirienteWsRegisrarPersonaParamCodigoIdentificacionDispositivo = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.codigo.identificacion.dispositivo");
			this.reniecAdquirienteWsRegisrarPersonaParamCodigoIdentificacionEstacion = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.codigo.identificacion.estacion");
			this.reniecAdquirienteWsRegisrarPersonaParamCodigoProcesadorAdquiriente = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.codigo.procesador.adquiriente");
			this.reniecAdquirienteWsRegisrarPersonaParamCodigoSistemaLocalizacion = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.codigo.sistema.localizacion");
			this.reniecAdquirienteWsRegisrarPersonaParamCodigoSubGrupo = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.codigo.sub.grupo");
			this.reniecAdquirienteWsRegisrarPersonaParamCodigoTransaccion = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.codigo.transaccion");
			this.reniecAdquirienteWsRegisrarPersonaParamInstitucionCanalizaServicio = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.institucion.canaliza.servicio");
			this.reniecAdquirienteWsRegisrarPersonaParamInstitucionProveedorServicio = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.institucion.proveedor.servicio");
			this.reniecAdquirienteWsRegisrarPersonaParamInstitucionSolicitanteServicio = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.institucion.solicitante.servicio");
			this.reniecAdquirienteWsRegisrarPersonaParamModeloEstacion = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.modelo.estacion");
			this.reniecAdquirienteWsRegisrarPersonaParamPuntoVentaSolicitanteServicio = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.punto.venta.solicitante.servicio");
			this.reniecAdquirienteWsRegisrarPersonaParamReservado = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.reservado");
			this.reniecAdquirienteWsRegisrarPersonaParamSistemaOperativoEstacion = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.sistema.operativo.estacion");
			this.reniecAdquirienteWsRegisrarPersonaParamTipoDispositivo = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.tipo.dispositivo");
			this.reniecAdquirienteWsRegisrarPersonaParamTipoEstacion = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.tipo.estacion");
			this.reniecAdquirienteWsRegisrarPersonaParamTipoFormato = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.tipo.formato");
			this.reniecAdquirienteWsRegisrarPersonaParamTipoIdentificacionDispositivo = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.tipo.identificaion.dispositivo");
			this.reniecAdquirienteWsRegisrarPersonaParamTipoIdentificacionEstacion = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.tipo.identificacion.estacion");
			this.reniecAdquirienteWsRegisrarPersonaParamTipoIdentificadorCliente = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.identificador.cliente");
			this.reniecAdquirienteWsRegisrarPersonaParamTipoMensaje = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.tipo.mensaje");
			this.reniecAdquirienteWsRegisrarPersonaParamVersionAplicativo = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.version.aplicacion");
			this.reniecAdquirienteWsRegisrarPersonaParamNumeroIdentificadorInstitucion = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.numero.identificador.institucion");
			this.reniecAdquirienteWsRegisrarPersonaParamTipoIdentificadorInstitucion = cargarProperties(configuration, "reniecAdquirienteWS.registrarpersona.param.tipo.identificador.insititucion");
			
			//BASE DE DATOS
			this.bdPvuOwner = cargarProperties(configuration, "bd.pvu.owner");
			this.bdPvuPkgSisactPkgBiometria = cargarProperties(configuration, "bd.pvu.pkg.sisact.pkg.biometria");
	    	this.bdPvuSpConsultaUsuarioAutor = cargarProperties(configuration, "bd.pvu.sp.consulta_usuarioautor");
	    	this.bdPvuFunGenIdTxBio = cargarProperties(configuration, "bd.pvu.fun.gen.id.tx.bio");
//	    	this.bdPvuFunGenIdTxBioInIdTransaccion = cargarProperties(configuration, "bd.pvu.fun.consulta_generaIdTransaccion_id");
	    	this.bdPvuConexionTimeOutLimiteConsultaUsuario = cargarProperties(configuration, "bd.pvu.conexion.timeout.limite.consulta.usuario");
	    	this.bdPvuParamTipoId= cargarProperties(configuration, "bd.pvu.param.tipo.id");
			
			//CODIGO Y MENSAJE DE ERROR FUNCIONAL
			this.claroVentaIdentidadCodigoIDF0 = cargarProperties(configuration, "claro.venta.identidad.codigo.idf0");
			this.claroVentaIdentidadMensajeIDF0 = cargarProperties(configuration, "claro.venta.identidad.mensaje.idf0");
			this.claroVentaIdentidadCodigoIDF1 = cargarProperties(configuration, "claro.venta.identidad.codigo.idf1");
			this.claroVentaIdentidadMensajeIDF1 = cargarProperties(configuration, "claro.venta.identidad.mensaje.idf1");
			
	    }

		private String cargarProperties(Configuration configuration, String propertie) {
			return ClaroUtil.convertProperties(configuration.getProperty(propertie));
		}
}

package pe.com.claro.venta.usuariobiometria.canonical.verificarbiometria.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class GenerarTokenResponse extends BodyResponse {
	private	String agenteSolicitanteServicio;
	private	String autenticacionMensaje;
	private	String codigoAdquirente;
	private	String codigoAplicativo;
	private	String codigoAutorizador;
	private	String codigoGrupo;
	private	String codigoIdentificacionDispositivo;
	private	String codigoIdentificacionEstacion;
	private	String codigoProcesadorAdquirente;
	private	String codigoRespuesta;
	private	String codigoSistemaLocalizacion;
	private	String codigoSubGrupo;
	private	String codigoTransaccion;
	private	String fechaProceso;
	private	String fechaTransaccion;
	private	String horaProceso;
	private	String horaTransaccion;
	private	String institucionCanalizaServicio;
	private	String institucionProveedorServicio;
	private	String institucionSolicitanteServicio;
	private	String latitudLocalizacion;
	private	String longitudLocalizacion;
	private	String marcaDispositivo;
	private	String mensajeRespuesta;
	private	String modeloDispositivo;
	private	String modeloEstacion;
	private	String numeroIdentificadorCliente;
	private	String numeroOrden;
	private	String numeroProceso;
	private	String numeroTransaccion;
	private	String origenRespuesta;
	private	String puntoVentaSolicitanteServicio;
	private	String reservado;
	private	String sistemaOperativoEstacion;
	private	String tipoDispositivo;
	private	String tipoEstacion;
	private	String tipoFormato;
	private	String tipoIdentificacionDispositivo;
	private	String tipoIdentificacionEstacion;
	private	String tipoIdentificadorCliente;
	private	String tipoMensaje;
	private	String tipoRespuesta;
	private	String versionAplicativo;
	private	String idSesion;
	public String idTransaccion;
	public String mensajeError;
	
	public GenerarTokenResponse() {
		super();
	}
	
	public GenerarTokenResponse(BodyResponse response) {
		super();
	}

	public GenerarTokenResponse(String agenteSolicitanteServicio, String autenticacionMensaje, String codigoAdquirente,
			String codigoAplicativo, String codigoAutorizador, String codigoGrupo,
			String codigoIdentificacionDispositivo, String codigoIdentificacionEstacion,
			String codigoProcesadorAdquirente, String codigoRespuesta, String codigoSistemaLocalizacion,
			String codigoSubGrupo, String codigoTransaccion, String fechaProceso, String fechaTransaccion,
			String horaProceso, String horaTransaccion, String institucionCanalizaServicio,
			String institucionProveedorServicio, String institucionSolicitanteServicio, String latitudLocalizacion,
			String longitudLocalizacion, String marcaDispositivo, String mensajeRespuesta, String modeloDispositivo,
			String modeloEstacion, String numeroIdentificadorCliente, String numeroOrden, String numeroProceso,
			String numeroTransaccion, String origenRespuesta, String puntoVentaSolicitanteServicio, String reservado,
			String sistemaOperativoEstacion, String tipoDispositivo, String tipoEstacion, String tipoFormato,
			String tipoIdentificacionDispositivo, String tipoIdentificacionEstacion, String tipoIdentificadorCliente,
			String tipoMensaje, String tipoRespuesta, String versionAplicativo, String idSesion) {
		super();
		this.agenteSolicitanteServicio = agenteSolicitanteServicio;
		this.autenticacionMensaje = autenticacionMensaje;
		this.codigoAdquirente = codigoAdquirente;
		this.codigoAplicativo = codigoAplicativo;
		this.codigoAutorizador = codigoAutorizador;
		this.codigoGrupo = codigoGrupo;
		this.codigoIdentificacionDispositivo = codigoIdentificacionDispositivo;
		this.codigoIdentificacionEstacion = codigoIdentificacionEstacion;
		this.codigoProcesadorAdquirente = codigoProcesadorAdquirente;
		this.codigoRespuesta = codigoRespuesta;
		this.codigoSistemaLocalizacion = codigoSistemaLocalizacion;
		this.codigoSubGrupo = codigoSubGrupo;
		this.codigoTransaccion = codigoTransaccion;
		this.fechaProceso = fechaProceso;
		this.fechaTransaccion = fechaTransaccion;
		this.horaProceso = horaProceso;
		this.horaTransaccion = horaTransaccion;
		this.institucionCanalizaServicio = institucionCanalizaServicio;
		this.institucionProveedorServicio = institucionProveedorServicio;
		this.institucionSolicitanteServicio = institucionSolicitanteServicio;
		this.latitudLocalizacion = latitudLocalizacion;
		this.longitudLocalizacion = longitudLocalizacion;
		this.marcaDispositivo = marcaDispositivo;
		this.mensajeRespuesta = mensajeRespuesta;
		this.modeloDispositivo = modeloDispositivo;
		this.modeloEstacion = modeloEstacion;
		this.numeroIdentificadorCliente = numeroIdentificadorCliente;
		this.numeroOrden = numeroOrden;
		this.numeroProceso = numeroProceso;
		this.numeroTransaccion = numeroTransaccion;
		this.origenRespuesta = origenRespuesta;
		this.puntoVentaSolicitanteServicio = puntoVentaSolicitanteServicio;
		this.reservado = reservado;
		this.sistemaOperativoEstacion = sistemaOperativoEstacion;
		this.tipoDispositivo = tipoDispositivo;
		this.tipoEstacion = tipoEstacion;
		this.tipoFormato = tipoFormato;
		this.tipoIdentificacionDispositivo = tipoIdentificacionDispositivo;
		this.tipoIdentificacionEstacion = tipoIdentificacionEstacion;
		this.tipoIdentificadorCliente = tipoIdentificadorCliente;
		this.tipoMensaje = tipoMensaje;
		this.tipoRespuesta = tipoRespuesta;
		this.versionAplicativo = versionAplicativo;
		this.idSesion = idSesion;
	}

	public String getAgenteSolicitanteServicio() {
		return agenteSolicitanteServicio;
	}

	public void setAgenteSolicitanteServicio(String agenteSolicitanteServicio) {
		this.agenteSolicitanteServicio = agenteSolicitanteServicio;
	}

	public String getAutenticacionMensaje() {
		return autenticacionMensaje;
	}

	public void setAutenticacionMensaje(String autenticacionMensaje) {
		this.autenticacionMensaje = autenticacionMensaje;
	}

	public String getCodigoAdquirente() {
		return codigoAdquirente;
	}

	public void setCodigoAdquirente(String codigoAdquirente) {
		this.codigoAdquirente = codigoAdquirente;
	}

	public String getCodigoAplicativo() {
		return codigoAplicativo;
	}

	public void setCodigoAplicativo(String codigoAplicativo) {
		this.codigoAplicativo = codigoAplicativo;
	}

	public String getCodigoAutorizador() {
		return codigoAutorizador;
	}

	public void setCodigoAutorizador(String codigoAutorizador) {
		this.codigoAutorizador = codigoAutorizador;
	}

	public String getCodigoGrupo() {
		return codigoGrupo;
	}

	public void setCodigoGrupo(String codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}

	public String getCodigoIdentificacionDispositivo() {
		return codigoIdentificacionDispositivo;
	}

	public void setCodigoIdentificacionDispositivo(String codigoIdentificacionDispositivo) {
		this.codigoIdentificacionDispositivo = codigoIdentificacionDispositivo;
	}

	public String getCodigoIdentificacionEstacion() {
		return codigoIdentificacionEstacion;
	}

	public void setCodigoIdentificacionEstacion(String codigoIdentificacionEstacion) {
		this.codigoIdentificacionEstacion = codigoIdentificacionEstacion;
	}

	public String getCodigoProcesadorAdquirente() {
		return codigoProcesadorAdquirente;
	}

	public void setCodigoProcesadorAdquirente(String codigoProcesadorAdquirente) {
		this.codigoProcesadorAdquirente = codigoProcesadorAdquirente;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getCodigoSistemaLocalizacion() {
		return codigoSistemaLocalizacion;
	}

	public void setCodigoSistemaLocalizacion(String codigoSistemaLocalizacion) {
		this.codigoSistemaLocalizacion = codigoSistemaLocalizacion;
	}

	public String getCodigoSubGrupo() {
		return codigoSubGrupo;
	}

	public void setCodigoSubGrupo(String codigoSubGrupo) {
		this.codigoSubGrupo = codigoSubGrupo;
	}

	public String getCodigoTransaccion() {
		return codigoTransaccion;
	}

	public void setCodigoTransaccion(String codigoTransaccion) {
		this.codigoTransaccion = codigoTransaccion;
	}

	public String getFechaProceso() {
		return fechaProceso;
	}

	public void setFechaProceso(String fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public String getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(String fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public String getHoraProceso() {
		return horaProceso;
	}

	public void setHoraProceso(String horaProceso) {
		this.horaProceso = horaProceso;
	}

	public String getHoraTransaccion() {
		return horaTransaccion;
	}

	public void setHoraTransaccion(String horaTransaccion) {
		this.horaTransaccion = horaTransaccion;
	}

	public String getInstitucionCanalizaServicio() {
		return institucionCanalizaServicio;
	}

	public void setInstitucionCanalizaServicio(String institucionCanalizaServicio) {
		this.institucionCanalizaServicio = institucionCanalizaServicio;
	}

	public String getInstitucionProveedorServicio() {
		return institucionProveedorServicio;
	}

	public void setInstitucionProveedorServicio(String institucionProveedorServicio) {
		this.institucionProveedorServicio = institucionProveedorServicio;
	}

	public String getInstitucionSolicitanteServicio() {
		return institucionSolicitanteServicio;
	}

	public void setInstitucionSolicitanteServicio(String institucionSolicitanteServicio) {
		this.institucionSolicitanteServicio = institucionSolicitanteServicio;
	}

	public String getLatitudLocalizacion() {
		return latitudLocalizacion;
	}

	public void setLatitudLocalizacion(String latitudLocalizacion) {
		this.latitudLocalizacion = latitudLocalizacion;
	}

	public String getLongitudLocalizacion() {
		return longitudLocalizacion;
	}

	public void setLongitudLocalizacion(String longitudLocalizacion) {
		this.longitudLocalizacion = longitudLocalizacion;
	}

	public String getMarcaDispositivo() {
		return marcaDispositivo;
	}

	public void setMarcaDispositivo(String marcaDispositivo) {
		this.marcaDispositivo = marcaDispositivo;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

	public String getModeloDispositivo() {
		return modeloDispositivo;
	}

	public void setModeloDispositivo(String modeloDispositivo) {
		this.modeloDispositivo = modeloDispositivo;
	}

	public String getModeloEstacion() {
		return modeloEstacion;
	}

	public void setModeloEstacion(String modeloEstacion) {
		this.modeloEstacion = modeloEstacion;
	}

	public String getNumeroIdentificadorCliente() {
		return numeroIdentificadorCliente;
	}

	public void setNumeroIdentificadorCliente(String numeroIdentificadorCliente) {
		this.numeroIdentificadorCliente = numeroIdentificadorCliente;
	}

	public String getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(String numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public String getNumeroProceso() {
		return numeroProceso;
	}

	public void setNumeroProceso(String numeroProceso) {
		this.numeroProceso = numeroProceso;
	}

	public String getNumeroTransaccion() {
		return numeroTransaccion;
	}

	public void setNumeroTransaccion(String numeroTransaccion) {
		this.numeroTransaccion = numeroTransaccion;
	}

	public String getOrigenRespuesta() {
		return origenRespuesta;
	}

	public void setOrigenRespuesta(String origenRespuesta) {
		this.origenRespuesta = origenRespuesta;
	}

	public String getPuntoVentaSolicitanteServicio() {
		return puntoVentaSolicitanteServicio;
	}

	public void setPuntoVentaSolicitanteServicio(String puntoVentaSolicitanteServicio) {
		this.puntoVentaSolicitanteServicio = puntoVentaSolicitanteServicio;
	}

	public String getReservado() {
		return reservado;
	}

	public void setReservado(String reservado) {
		this.reservado = reservado;
	}

	public String getSistemaOperativoEstacion() {
		return sistemaOperativoEstacion;
	}

	public void setSistemaOperativoEstacion(String sistemaOperativoEstacion) {
		this.sistemaOperativoEstacion = sistemaOperativoEstacion;
	}

	public String getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public String getTipoEstacion() {
		return tipoEstacion;
	}

	public void setTipoEstacion(String tipoEstacion) {
		this.tipoEstacion = tipoEstacion;
	}

	public String getTipoFormato() {
		return tipoFormato;
	}

	public void setTipoFormato(String tipoFormato) {
		this.tipoFormato = tipoFormato;
	}

	public String getTipoIdentificacionDispositivo() {
		return tipoIdentificacionDispositivo;
	}

	public void setTipoIdentificacionDispositivo(String tipoIdentificacionDispositivo) {
		this.tipoIdentificacionDispositivo = tipoIdentificacionDispositivo;
	}

	public String getTipoIdentificacionEstacion() {
		return tipoIdentificacionEstacion;
	}

	public void setTipoIdentificacionEstacion(String tipoIdentificacionEstacion) {
		this.tipoIdentificacionEstacion = tipoIdentificacionEstacion;
	}

	public String getTipoIdentificadorCliente() {
		return tipoIdentificadorCliente;
	}

	public void setTipoIdentificadorCliente(String tipoIdentificadorCliente) {
		this.tipoIdentificadorCliente = tipoIdentificadorCliente;
	}

	public String getTipoMensaje() {
		return tipoMensaje;
	}

	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

	public String getTipoRespuesta() {
		return tipoRespuesta;
	}

	public void setTipoRespuesta(String tipoRespuesta) {
		this.tipoRespuesta = tipoRespuesta;
	}

	public String getVersionAplicativo() {
		return versionAplicativo;
	}

	public void setVersionAplicativo(String versionAplicativo) {
		this.versionAplicativo = versionAplicativo;
	}

	public String getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(String idSesion) {
		this.idSesion = idSesion;
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	
}

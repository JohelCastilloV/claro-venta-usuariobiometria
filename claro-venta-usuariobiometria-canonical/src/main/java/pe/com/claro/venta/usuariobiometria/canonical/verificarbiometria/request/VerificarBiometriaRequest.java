package pe.com.claro.venta.usuariobiometria.canonical.verificarbiometria.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerificarBiometriaRequest {

	private String agenteSolicitanteServicio;
	private String autenticacionMensaje;
	private String codigoAdquirente;
	private String codigoAplicativo;
	private String codigoGrupo;
	private String codigoIdentificacionDispositivo;
	private String codigoIdentificacionEstacion;
	private String codigoProcesadorAdquirente;
	private String codigoSistemaLocalizacion;
	private String codigoSubGrupo;
	private String codigoTransaccion;
	private String fechaTransaccion;
	private String horaTransaccion;
	private String institucionCanalizaServicio;
	private String institucionProveedorServicio;
	private String institucionSolicitanteServicio;
	private String latitudLocalizacion;
	private String longitudLocalizacion;
	private String marcaDispositivo;
	private String modeloDispositivo;
	private String modeloEstacion;
	private String numeroIdentificadorCliente;
	private String numeroOrden;
	private String numeroTransaccion;
	private String puntoVentaSolicitanteServicio;
	private String reservado;
	private String sistemaOperativoEstacion;
	private String tipoDispositivo;
	private String tipoEstacion;
	private String tipoFormato;
	private String tipoIdentificacionDispositivo;
	private String tipoIdentificacionEstacion;
	private String tipoIdentificadorCliente;
	private String tipoMensaje;
	private String versionAplicativo;
	/*
	 * private String apellidoMaterno; private String apellidoPaterno; private
	 * String banderaRegistro; private String fechaCaducidad; private String
	 * fechaEmision; private String fechaNacimiento; private String firma;
	 * private String foto;
	 */
	// private HuellasBiometricas huellasBiometricas;
	private List<HuellasBiometricas> huellasBiometricas;
	private String idSesion;
	// private String nombres;
	private String numeroDocumentoPersona;
	private String numeroIdentificadorInstitucion;
	// private String sexo;
	private String tipoIdentificadorInstitucion;
	private String tipodeDocumentoPersona;
	private String porcentajeConfiabilidad;
	private String tipoVerificacion;
	private String codigoOficina;
	private String usuarioSesion;
	private String usuarioAplicacion;

	public VerificarBiometriaRequest() {
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

	public String getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(String fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
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

	public String getNumeroTransaccion() {
		return numeroTransaccion;
	}

	public void setNumeroTransaccion(String numeroTransaccion) {
		this.numeroTransaccion = numeroTransaccion;
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

	public String getVersionAplicativo() {
		return versionAplicativo;
	}

	public void setVersionAplicativo(String versionAplicativo) {
		this.versionAplicativo = versionAplicativo;
	}

	// public HuellasBiometricas getHuellasBiometricas() {
	// return huellasBiometricas;
	// }
	//
	// public void setHuellasBiometricas(HuellasBiometricas huellasBiometricas) {
	// this.huellasBiometricas = huellasBiometricas;
	// }
	public List<HuellasBiometricas> getHuellasBiometricas() {
		return huellasBiometricas;
	}

	public void setHuellasBiometricas(List<HuellasBiometricas> huellasBiometricas) {
		this.huellasBiometricas = huellasBiometricas;
	}

	public String getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(String idSesion) {
		this.idSesion = idSesion;
	}

	public String getNumeroDocumentoPersona() {
		return numeroDocumentoPersona;
	}

	public void setNumeroDocumentoPersona(String numeroDocumentoPersona) {
		this.numeroDocumentoPersona = numeroDocumentoPersona;
	}

	public String getNumeroIdentificadorInstitucion() {
		return numeroIdentificadorInstitucion;
	}

	public void setNumeroIdentificadorInstitucion(String numeroIdentificadorInstitucion) {
		this.numeroIdentificadorInstitucion = numeroIdentificadorInstitucion;
	}

	public String getTipoIdentificadorInstitucion() {
		return tipoIdentificadorInstitucion;
	}

	public void setTipoIdentificadorInstitucion(String tipoIdentificadorInstitucion) {
		this.tipoIdentificadorInstitucion = tipoIdentificadorInstitucion;
	}

	public String getTipodeDocumentoPersona() {
		return tipodeDocumentoPersona;
	}

	public void setTipodeDocumentoPersona(String tipodeDocumentoPersona) {
		this.tipodeDocumentoPersona = tipodeDocumentoPersona;
	}

	public String getPorcentajeConfiabilidad() {
		return porcentajeConfiabilidad;
	}

	public void setPorcentajeConfiabilidad(String porcentajeConfiabilidad) {
		this.porcentajeConfiabilidad = porcentajeConfiabilidad;
	}

	public String getCodigoOficina() {
		return codigoOficina;
	}

	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}

	public String getTipoVerificacion() {
		return tipoVerificacion;
	}

	public void setTipoVerificacion(String tipoVerificacion) {
		this.tipoVerificacion = tipoVerificacion;
	}

	public String getUsuarioSesion() {
		return usuarioSesion;
	}

	public void setUsuarioSesion(String usuarioSesion) {
		this.usuarioSesion = usuarioSesion;
	}

	public String getUsuarioAplicacion() {
		return usuarioAplicacion;
	}

	public void setUsuarioAplicacion(String usuarioAplicacion) {
		this.usuarioAplicacion = usuarioAplicacion;
	}

	@Override
	public String toString() {

		String huellas = "";
		if (huellasBiometricas != null && huellasBiometricas.size() > 0) {
			for (HuellasBiometricas huellaBiometrica : huellasBiometricas) {
				huellas += huellaBiometrica.toString() + "\n";
			}
		}

		return "RegistrarPersonaRequest [agenteSolicitanteServicio=" + agenteSolicitanteServicio + ", autenticacionMensaje=" + autenticacionMensaje + ", codigoAdquirente=" + codigoAdquirente + ", codigoAplicativo=" + codigoAplicativo + ", codigoGrupo=" + codigoGrupo + ", codigoIdentificacionDispositivo=" + codigoIdentificacionDispositivo + ", codigoIdentificacionEstacion=" + codigoIdentificacionEstacion + ", codigoProcesadorAdquirente=" + codigoProcesadorAdquirente + ", codigoSistemaLocalizacion=" + codigoSistemaLocalizacion + ", codigoSubGrupo=" + codigoSubGrupo + ", codigoTransaccion=" + codigoTransaccion + ", fechaTransaccion=" + fechaTransaccion + ", horaTransaccion=" + horaTransaccion + ", institucionCanalizaServicio=" + institucionCanalizaServicio + ", institucionProveedorServicio=" + institucionProveedorServicio + ", institucionSolicitanteServicio=" + institucionSolicitanteServicio + ", latitudLocalizacion=" + latitudLocalizacion + ", longitudLocalizacion=" + longitudLocalizacion + ", marcaDispositivo=" + marcaDispositivo + ", modeloDispositivo=" + modeloDispositivo + ", modeloEstacion=" + modeloEstacion + ", numeroIdentificadorCliente=" + numeroIdentificadorCliente + ", numeroOrden=" + numeroOrden + ", numeroTransaccion=" + numeroTransaccion + ", puntoVentaSolicitanteServicio=" + puntoVentaSolicitanteServicio + ", reservado=" + reservado + ", sistemaOperativoEstacion=" + sistemaOperativoEstacion + ", tipoDispositivo=" + tipoDispositivo + ", tipoEstacion=" + tipoEstacion + ", tipoFormato=" + tipoFormato + ", tipoIdentificacionDispositivo=" + tipoIdentificacionDispositivo + ", tipoIdentificacionEstacion=" + tipoIdentificacionEstacion + ", tipoIdentificadorCliente=" + tipoIdentificadorCliente + ", tipoMensaje=" + tipoMensaje + ", versionAplicativo=" + versionAplicativo + ", huellasBiometricas= " + huellas + ", idSesion=" + idSesion + ", numeroDocumentoPersona=" + numeroDocumentoPersona + ", numeroIdentificadorInstitucion=" + numeroIdentificadorInstitucion + ", tipoIdentificadorInstitucion=" + tipoIdentificadorInstitucion + ", tipodeDocumentoPersona=" + tipodeDocumentoPersona + ", porcentajeConfiabilidad=" + porcentajeConfiabilidad + ", codigoOficina=" + codigoOficina + ", usuarioSesion=" + usuarioSesion + ", usuarioAplicacion=" + usuarioAplicacion + "]";
	}

}

package pe.com.claro.venta.usuariobiometria.canonical.registrapersona.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrarPersonaRequest {

	private String autenticacionMensaje; /*Request del biometriaVendedor: idTransaccionNegocio */
	private String latitudLocalizacion; /*Request del biometriaVendedor*/
	private String longitudLocalizacion; /*Request del biometriaVendedor*/
	private String marcaDispositivo; /*Request del biometriaVendedor*/
	private String modeloDispositivo; /*Request del biometriaVendedor*/
	private String numeroOrden; /*Request del biometriaVendedor: idTransaccionNegocio*/
	private String apellidoMaterno;
	private String apellidoPaterno;
	private String banderaRegistro;
	private String fechaCaducidad;
	private String fechaEmision;
	private String fechaNacimiento;
	private String firma;
	private String foto;
	private List<HuellasBiometricas> huellasBiometricas;
	private String nombres;
	private String tipoDocumentoPersona;
	private String numeroDocumentoPersona;
	private String sexo;
	private String codigoOficina;
	private String usuarioSesion;
	private String usuarioAplicacion;
	
	public RegistrarPersonaRequest() {
	}
	

	public String getAutenticacionMensaje() {
		return autenticacionMensaje;
	}

	public void setAutenticacionMensaje(String autenticacionMensaje) {
		this.autenticacionMensaje = autenticacionMensaje;
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

	public String getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(String numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getBanderaRegistro() {
		return banderaRegistro;
	}

	public void setBanderaRegistro(String bangeraRegistro) {
		this.banderaRegistro = bangeraRegistro;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<HuellasBiometricas> getHuellasBiometricas() {
		return huellasBiometricas;
	}

	public void setHuellasBiometricas(List<HuellasBiometricas> huellasBiometricas) {
		this.huellasBiometricas = huellasBiometricas;
	}
	
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTipoDocumentoPersona() {
		return tipoDocumentoPersona;
	}


	public void setTipoDocumentoPersona(String tipoDocumentoPersona) {
		this.tipoDocumentoPersona = tipoDocumentoPersona;
	}


	public String getNumeroDocumentoPersona() {
		return numeroDocumentoPersona;
	}

	public void setNumeroDocumentoPersona(String numeroDocumentoPersona) {
		this.numeroDocumentoPersona = numeroDocumentoPersona;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCodigoOficina() {
		return codigoOficina;
	}

	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
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
		if(huellasBiometricas !=null && huellasBiometricas.size()>0) {
			for(HuellasBiometricas huellaBiometrica: huellasBiometricas){
				huellas+=huellaBiometrica.toString();
			}
		}
		
		return "RegistrarPersonaRequest [autenticacionMensaje=" + autenticacionMensaje + ", latitudLocalizacion="
				+ latitudLocalizacion + ", longitudLocalizacion=" + longitudLocalizacion + ", marcaDispositivo="
				+ marcaDispositivo + ", modeloDispositivo=" + modeloDispositivo + ", numeroOrden=" + numeroOrden
				+ ", apellidoMaterno=" + apellidoMaterno + ", apellidoPaterno=" + apellidoPaterno + ", banderaRegistro="
				+ banderaRegistro + ", fechaCaducidad=" + fechaCaducidad + ", fechaEmision=" + fechaEmision
				+ ", fechaNacimiento=" + fechaNacimiento + ", firma=" + firma + ", foto=" + foto
				+ ", huellasBiometricas=" + huellas + ", nombres=" + nombres + ", tipoDocumentoPersona=" + tipoDocumentoPersona +
				", numeroDocumentoPersona=" + numeroDocumentoPersona + ", sexo=" + sexo
				+ ", codigoOficina=" + codigoOficina + ", usuarioSesion=" + usuarioSesion + ", usuarioAplicacion="
				+ usuarioAplicacion + "]";
	}
	
}
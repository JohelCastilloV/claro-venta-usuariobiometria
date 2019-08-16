package pe.com.claro.venta.usuariobiometria.model.response;

public class DataResponse {

	private Integer uanId;
	private String uavCodigoUser;
	private String uavDniAutorizado;
	private String uavNombres;
	private String uavApellidos;
	private Integer uanEstado;
	private String uadTipoOFicina;
	private String uavUsuarioAplicacion;
	private String uavUserNova;

	public Integer getUanId() {
		return uanId;
	}

	public void setUanId(Integer uanId) {
		this.uanId = uanId;
	}

	public String getUavCodigoUser() {
		return uavCodigoUser;
	}

	public void setUavCodigoUser(String uavCodigoUser) {
		this.uavCodigoUser = uavCodigoUser;
	}

	public String getUavDniAutorizado() {
		return uavDniAutorizado;
	}

	public void setUavDniAutorizado(String uavDniAutorizado) {
		this.uavDniAutorizado = uavDniAutorizado;
	}

	public String getUavNombres() {
		return uavNombres;
	}

	public void setUavNombres(String uavNombres) {
		this.uavNombres = uavNombres;
	}

	public String getUavApellidos() {
		return uavApellidos;
	}

	public void setUavApellidos(String uavApellidos) {
		this.uavApellidos = uavApellidos;
	}

	public Integer getUanEstado() {
		return uanEstado;
	}

	public void setUanEstado(Integer uanEstado) {
		this.uanEstado = uanEstado;
	}

	public String getUadTipoOFicina() {
		return uadTipoOFicina;
	}

	public void setUadTipoOFicina(String uadTipoOFicina) {
		this.uadTipoOFicina = uadTipoOFicina;
	}

	public String getUavUsuarioAplicacion() {
		return uavUsuarioAplicacion;
	}

	public void setUavUsuarioAplicacion(String uavUsuarioAplicacion) {
		this.uavUsuarioAplicacion = uavUsuarioAplicacion;
	}

	public String getUavUserNova() {
		return uavUserNova;
	}

	public void setUavUserNova(String uavUserNova) {
		this.uavUserNova = uavUserNova;
	}

	@Override
	public String toString() {
		return "DataResponse [uanId=" + uanId + ", uavCodigoUser=" + uavCodigoUser + ", uavDniAutorizado="
				+ uavDniAutorizado + ", uavNombres=" + uavNombres + ", uavApellidos=" + uavApellidos + ", uanEstado="
				+ uanEstado + ", uadTipoOFicina=" + uadTipoOFicina + ", uavUsuarioAplicacion=" + uavUsuarioAplicacion
				+ ", uavUserNova=" + uavUserNova + "]";
	}

}
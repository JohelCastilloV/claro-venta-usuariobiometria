package pe.com.claro.venta.usuariobiometria.canonical.verificarbiometria.response;

public class EliminarTokenResponse {

	private String codigoRespuesta;
	private String mensajeRespuesta;
	private String codigoTransaccion;
	private String idSesion;

	public EliminarTokenResponse() {
	}

	public EliminarTokenResponse(String codigoRespuesta, String mensajeRespuesta, String codigoTransaccion, String idSesion) {
		super();
		this.codigoRespuesta = codigoRespuesta;
		this.mensajeRespuesta = mensajeRespuesta;
		this.codigoTransaccion = codigoTransaccion;
		this.idSesion = idSesion;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

	public String getCodigoTransaccion() {
		return codigoTransaccion;
	}

	public void setCodigoTransaccion(String codigoTransaccion) {
		this.codigoTransaccion = codigoTransaccion;
	}

	public String getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(String idSesion) {
		this.idSesion = idSesion;
	}

	@Override
	public String toString() {
		return "EliminarTokenResponse [codigoRespuesta=" + codigoRespuesta + ", mensajeRespuesta=" + mensajeRespuesta + ", codigoTransaccion=" + codigoTransaccion + "]";
	}

}

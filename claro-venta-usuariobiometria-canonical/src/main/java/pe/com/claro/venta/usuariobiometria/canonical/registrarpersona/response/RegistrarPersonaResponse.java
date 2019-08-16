package pe.com.claro.venta.usuariobiometria.canonical.registrarpersona.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrarPersonaResponse {

	private String idTransaccion;
	private String codigoRespuesta;
	private String mensajeRespuesta;

	public RegistrarPersonaResponse() {
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
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

	@Override
	public String toString() {
		return "RegistrarPersonaResponse [idTransaccion=" + idTransaccion + ", codigoRespuesta=" + codigoRespuesta
				+ ", mensajeRespuesta=" + mensajeRespuesta + "]";
	}

}
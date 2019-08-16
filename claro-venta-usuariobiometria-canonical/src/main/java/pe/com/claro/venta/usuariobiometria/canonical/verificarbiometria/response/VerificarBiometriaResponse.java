package pe.com.claro.venta.usuariobiometria.canonical.verificarbiometria.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerificarBiometriaResponse {

	private String idTransaccion;
	private String codigoRespuesta;
	private String mensajeRespuesta;

	public VerificarBiometriaResponse() {
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
	
	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	@Override
	public String toString() {
		return "\nVerificarBiometriaResponse {\nidTransacion: " + idTransaccion + ",\ncodigoRespuesta=" + codigoRespuesta + ",\nmensajeRespuesta=" + mensajeRespuesta
				+ "\n]";
	}

}
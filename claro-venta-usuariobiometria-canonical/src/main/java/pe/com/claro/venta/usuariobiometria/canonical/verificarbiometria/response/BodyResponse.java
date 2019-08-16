package pe.com.claro.venta.usuariobiometria.canonical.verificarbiometria.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BodyResponse {
	public String idTransaccion;
	public String mensajeError;
	public String codigoRespuesta;
	public String mensajeRespuesta;
	
	public BodyResponse() {
		super();
	}

	public BodyResponse(String idTransaccion, String mensajeError, String codigoRespuesta, String mensajeRespuesta) {
		super();
		this.idTransaccion = idTransaccion;
		this.mensajeError = mensajeError;
		this.codigoRespuesta = codigoRespuesta;
		this.mensajeRespuesta = mensajeRespuesta;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoRespuesta == null) ? 0 : codigoRespuesta.hashCode());
		result = prime * result + ((mensajeError == null) ? 0 : mensajeError.hashCode());
		result = prime * result + ((mensajeRespuesta == null) ? 0 : mensajeRespuesta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BodyResponse other = (BodyResponse) obj;
		if (codigoRespuesta == null) {
			if (other.codigoRespuesta != null)
				return false;
		} else if (!codigoRespuesta.equals(other.codigoRespuesta))
			return false;
		if (mensajeError == null) {
			if (other.mensajeError != null)
				return false;
		} else if (!mensajeError.equals(other.mensajeError))
			return false;
		if (mensajeRespuesta == null) {
			if (other.mensajeRespuesta != null)
				return false;
		} else if (!mensajeRespuesta.equals(other.mensajeRespuesta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BodyResponse [mensajeError=" + mensajeError + ", codigoRespuesta=" + codigoRespuesta
				+ ", mensajeRespuesta=" + mensajeRespuesta + "]";
	}
}

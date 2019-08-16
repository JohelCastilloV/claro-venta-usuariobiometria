package pe.com.claro.venta.usuariobiometria.common.bean;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.HttpHeaders;

import pe.com.claro.venta.usuariobiometria.common.property.Constantes;

@Entity
public class HeaderRequestBean {

	@NotNull
	private String idTransaccion;

	@NotNull
	private String msgid;

	@NotNull
	private String timestamp;

	@NotNull
	private String userId; // usuarioAplicacion

	@NotNull
	private String accept;

	public HeaderRequestBean() {
		super();
	}

	public HeaderRequestBean(HttpHeaders httpHeaders) {
		super();
		this.idTransaccion = httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) != null
				? httpHeaders.getRequestHeader(Constantes.IDTRANSACCION).get(Constantes.NCERO) : null;
		this.msgid = httpHeaders.getRequestHeader(Constantes.MSGID) != null
				? httpHeaders.getRequestHeader(Constantes.MSGID).get(Constantes.NCERO) : null;
		this.timestamp = httpHeaders.getRequestHeader(Constantes.TIMESTAMP) != null
				? httpHeaders.getRequestHeader(Constantes.TIMESTAMP).get(Constantes.NCERO) : null;
		this.userId = httpHeaders.getRequestHeader(Constantes.USERID) != null
				? httpHeaders.getRequestHeader(Constantes.USERID).get(Constantes.NCERO) : null;
		this.accept = httpHeaders.getRequestHeader(Constantes.ACCEPT) != null
				? httpHeaders.getRequestHeader(Constantes.ACCEPT).get(Constantes.NCERO) : null;
	}

	public HeaderRequestBean(String idTransaccion, String msgid, String timestamp, String userId, String accept,
			String nombreAplicacion, String ipAplicacion) {
		super();
		this.idTransaccion = idTransaccion;
		this.msgid = msgid;
		this.timestamp = timestamp;
		this.userId = userId;
		this.accept = accept;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "HeaderRequestBean [idTransaccion=" + idTransaccion + ", msgid=" + msgid + ", timestamp=" + timestamp
				+ ", userId=" + userId + ", accept=" + accept + "]";
	}

}
package pe.com.claro.venta.usuariobiometria.common.bean;

import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.HttpHeaders;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.com.claro.venta.usuariobiometria.common.property.Constantes;
import pe.com.claro.venta.usuariobiometria.common.util.ClaroUtil;

import java.util.Locale;

public class HeaderRequest {

    private static final Logger LOG = LoggerFactory.getLogger(HeaderRequest.class);

    @SuppressWarnings("unused") private Configuration conf;
    Locale locale = new Locale(Constantes.LOCALE_ES, Constantes.LOCALE_PE);
    private String idTransaccion;
    private String msgid;
    private Date timestamp;
    private String userId;
    private String accept;

    public HeaderRequest(HttpHeaders httpHeaders, Configuration config) {

	String[] headerBean = { Constantes.IDTRANSACCION, Constantes.MSGID, Constantes.TIMESTAMP, Constantes.USERID, Constantes.ACCEPT };
	String[] defaultHeaderBean = { ClaroUtil.generarIdTransaccion(), Constantes.BIOMOVIL, ClaroUtil.dateAString(GregorianCalendar.getInstance().getTime(), Constantes.FORMATOFECHAPARAMETROS_VEINTE), Constantes.USRBIOMOVIL, Constantes.TYPEREQUEST };
	String valorHeader = Constantes.EMPTY;
	boolean flagNuloVacio = Constantes.FALSE_BOOLEAN;
	String mensajeCampoNoValido = Constantes.EMPTY;
	String msg = Constantes.EMPTY;
	for (int i = 0; i < headerBean.length; i++) {
	    if (httpHeaders.getRequestHeader(headerBean[i]) != null) {
		if (!httpHeaders.getRequestHeader(headerBean[i]).isEmpty()) {
		    valorHeader = String.valueOf(httpHeaders.getRequestHeader(headerBean[i]).get(Constantes.CERO_INT));
		    if (i == Constantes.CUATRO_INT && !valorHeader.isEmpty()) {
			flagNuloVacio = Constantes.TRUE_BOOLEAN;
			mensajeCampoNoValido = "El parametro del header [" + headerBean[i] + "] esta VACIO. Autogenerando el parametro...";
		    }
		}
		else {
		    flagNuloVacio = Constantes.TRUE_BOOLEAN;
		    mensajeCampoNoValido = "El parametro del header [" + headerBean[i] + "] esta VACIO. Autogenerando el parametro...";
		}
	    }
	    else {
		flagNuloVacio = Constantes.TRUE_BOOLEAN;
		mensajeCampoNoValido = "El parametro del header [" + headerBean[i] + "] es NULO. Autogenerando el parametro...";
	    }
	    if (flagNuloVacio) {
		LOG.info(msg + mensajeCampoNoValido);
		valorHeader = defaultHeaderBean[i];
		LOG.info(msg + "Parametro por default [" + headerBean[i] + "] = " + valorHeader);
	    }

	    switch (headerBean[i]) {
	    case Constantes.IDTRANSACCION:
		this.idTransaccion = valorHeader;
		msg = "[id:" + this.idTransaccion + "] ";
		break;
	    case Constantes.MSGID:
		this.msgid = valorHeader;
		break;
	    case Constantes.TIMESTAMP:
		this.timestamp = ClaroUtil.toCalendar(valorHeader).getTime();
	    case Constantes.USERID:
		this.userId = valorHeader;
		break;
	    case Constantes.ACCEPT:
		this.accept = valorHeader;
	    default:
		break;
	    }
	}
	this.conf = config;
    }

    public HeaderRequest() {
	super();
    }

    public Date getTimestamp() {
	return timestamp;
    }

    public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
    }

    public String getIdTransaccion() {
	return idTransaccion;
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

    @Override
    public String toString() {
	return "HeaderRequest{" + "idTransaccion='" + idTransaccion + '\'' + ", msgid='" + msgid + '\'' + ", timestamp=" + timestamp + ", userId='" + userId + '\'' + ", accept='" + accept + '\'' + '}';
    }
}

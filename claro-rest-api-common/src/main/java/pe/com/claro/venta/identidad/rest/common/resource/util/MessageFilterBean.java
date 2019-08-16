package pe.com.claro.venta.identidad.rest.common.resource.util;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {

	 private @QueryParam("idCliente") String idCliente;
	 private @QueryParam("idTipDocCliente") String idTipDocCliente;
	 private @QueryParam("idTipDocCli") String idTipDocCli;
	 private @QueryParam("docCliente") String docCliente;
	
	public String getIdCliente(){
		return idCliente;
	}
	
	public void setIdCliente( String idCliente ){
		this.idCliente = idCliente;
	}
	
	public String getIdTipDocCliente(){
		return idTipDocCliente;
	}
	
	public void setIdTipDocCliente( String idTipDocCliente ){
		this.idTipDocCliente = idTipDocCliente;
	}
	
	public String getDocCliente(){
		return docCliente;
	}
	
	public void setDocCliente( String docCliente ){
		this.docCliente = docCliente;
	}
	
	public String getIdTipDocCli() {
		return idTipDocCli;
	}
	
	public void setIdTipDocCli(String idTipDocCli) {
		this.idTipDocCli = idTipDocCli;
	}
	
	@Override
	public String toString() {
		return "MessageFilterBean [idCliente=" + idCliente + ", idTipDocCliente=" + idTipDocCliente + ", idTipDocCli="
				+ idTipDocCli + ", docCliente=" + docCliente + "]";
	}
	

}

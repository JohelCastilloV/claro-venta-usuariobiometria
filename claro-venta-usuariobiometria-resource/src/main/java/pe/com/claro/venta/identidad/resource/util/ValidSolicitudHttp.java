package pe.com.claro.venta.identidad.resource.util;


import pe.com.claro.venta.usuariobiometria.common.bean.HeaderRequestBean;
import pe.com.claro.venta.usuariobiometria.common.property.Constantes;


public class ValidSolicitudHttp {

	public boolean isValidaDataHeaderBean(HeaderRequestBean headerRequestBean) {
		
		if (headerRequestBean.getIdTransaccion() == null)
			return false;
		
		if (headerRequestBean.getAccept() == null)
			return false;


		return headerRequestBean.getAccept().equals(Constantes.TYPEREQUEST);
	}

}

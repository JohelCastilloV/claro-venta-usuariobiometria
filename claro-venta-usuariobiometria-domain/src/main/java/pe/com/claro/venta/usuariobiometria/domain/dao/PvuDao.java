package pe.com.claro.venta.usuariobiometria.domain.dao;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import pe.com.claro.venta.usuariobiometria.common.bean.HeaderRequestBean;
import pe.com.claro.venta.usuariobiometria.common.exception.DBException;
import pe.com.claro.venta.usuariobiometria.common.util.PropertiesExternos;
import pe.com.claro.venta.usuariobiometria.domain.repository.PvuRepository;
import pe.com.claro.venta.usuariobiometria.model.request.ConsultaUsuarioAutorRequest;
import pe.com.claro.venta.usuariobiometria.model.request.IdentificacionTransaccionRequest;
import pe.com.claro.venta.usuariobiometria.model.response.ConsultaUsuarioAutorResponse;
import pe.com.claro.venta.usuariobiometria.model.response.IdentificacionTransaccionResponse;

@Stateless
public class PvuDao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
    private PvuRepository pvuRepository;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultaUsuarioAutorResponse obtenerNumeroIdentificadorCliente(PropertiesExternos propertiesExternos, HeaderRequestBean header,
			String mensajeTransaccion, ConsultaUsuarioAutorRequest consultaUsuarioAutorRequest) throws DBException{
		return pvuRepository.obtenerNumeroIdentificadorCliente(propertiesExternos, mensajeTransaccion, consultaUsuarioAutorRequest);
	}
	
	public IdentificacionTransaccionResponse obtenerNumeroTransaccion(PropertiesExternos propExt, HeaderRequestBean header,
			String msg, IdentificacionTransaccionRequest identificacionTransaccionRequest) throws DBException{
		return pvuRepository.obtenerNumeroTransaccion(propExt, msg, identificacionTransaccionRequest);
	}
	
}
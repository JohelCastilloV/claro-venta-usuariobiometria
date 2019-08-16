package pe.com.claro.venta.usuariobiometria.domain.repository;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.dialect.OracleTypesHelper;
import org.hibernate.jdbc.Work;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.com.claro.venta.usuariobiometria.common.domain.repository.AbstractRepository;
import pe.com.claro.venta.usuariobiometria.common.exception.DBException;
import pe.com.claro.venta.usuariobiometria.common.property.Constantes;
import pe.com.claro.venta.usuariobiometria.common.util.JAXBUtilitarios;
import pe.com.claro.venta.usuariobiometria.common.util.PropertiesExternos;
import pe.com.claro.venta.usuariobiometria.model.request.ConsultaUsuarioAutorRequest;
import pe.com.claro.venta.usuariobiometria.model.request.IdentificacionTransaccionRequest;
import pe.com.claro.venta.usuariobiometria.model.response.ConsultaUsuarioAutorResponse;
import pe.com.claro.venta.usuariobiometria.model.response.DataResponse;
import pe.com.claro.venta.usuariobiometria.model.response.IdentificacionTransaccionResponse;

@Stateless
public class PvuRepository extends AbstractRepository<Object> implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PvuRepository.class);
	
	@PersistenceContext(unitName = Constantes.PERSISTENCE_CONTEXT_PVU)
	public void setPersistenceUnit00(final EntityManager em) {
		this.entityManager = em;
	}
	
	@Override
	protected Predicate[] getSearchPredicates(Root<Object> root, Object example) {
		return new Predicate[0];
	}
	
	public ConsultaUsuarioAutorResponse obtenerNumeroIdentificadorCliente(PropertiesExternos propertiesExternos,String msg,ConsultaUsuarioAutorRequest request ) throws DBException {

		long tiempoInicio = System.currentTimeMillis();
		StringBuilder storedProcedure = new StringBuilder();
		ConsultaUsuarioAutorResponse consultaUsuarioAutorResponse = new ConsultaUsuarioAutorResponse();
		
		String nombreMetodo = "obtenerNumeroIdentificadorCliente";
		String mensajeTransaccion = msg + "[" + nombreMetodo + "] ";
		logger.info(Constantes.LOG_CUATRO_LLAVES, mensajeTransaccion, "[INICIO] - METODO: [", nombreMetodo, " - DAO] ");
		
		try {
			
			storedProcedure.append(propertiesExternos.bdPvuOwner + Constantes.PUNTO);
			storedProcedure.append(propertiesExternos.bdPvuPkgSisactPkgBiometria + Constantes.PUNTO);
			storedProcedure.append(propertiesExternos.bdPvuSpConsultaUsuarioAutor);
			logger.info(Constantes.LOG_TRES_LLAVES, mensajeTransaccion, "Consultando: ", storedProcedure);
			
			Session session = entityManager.unwrap( Session.class );
			session.doWork(new Work(){
				
				@Override
				public void execute(final Connection connection) throws SQLException {
					logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, "Ejecutando SP : ");
					logger.info(Constantes.LOG_TRES_LLAVES,mensajeTransaccion + "PARAMETROS [INPUT]: \n", JAXBUtilitarios.anyObjectToXmlText(request));
					
					ResultSet cursorUsuarioAutor = null;
					try {
						
						CallableStatement call = connection.prepareCall("call " + storedProcedure.toString() +" (?,?,?,?)" );
						call.setQueryTimeout(Integer.parseInt(propertiesExternos.bdPvuConexionTimeOutLimiteConsultaUsuario));
						
						cargarDataInputOutputPlsql(request, call);
						long tiempoInicioSP = System.currentTimeMillis();
						call.execute();
						
						logger.info(Constantes.LOG_CINCO_LLAVES, mensajeTransaccion, "Tiempo total de proceso del llamado del SP ", storedProcedure, "(ms):", System.currentTimeMillis() - tiempoInicioSP);
						logger.info(Constantes.LOG_TRES_LLAVES, mensajeTransaccion, "Se invoco con exito el SP: ", storedProcedure);
						
						cursorUsuarioAutor = cargarDataStoredProcedure(consultaUsuarioAutorResponse, call);
						
						logger.info(Constantes.LOG_TRES_LLAVES, mensajeTransaccion, "PARAMETROS [OUTPUT]: \n", JAXBUtilitarios.anyObjectToXmlText(consultaUsuarioAutorResponse));
						
					} catch (SQLException e) {
						String descripcionError = seterValorExceptionLog(e);
						logger.info(Constantes.LOG_TRES_LLAVES, mensajeTransaccion, "Error Catch Stored Procedure: \n", descripcionError);
						throw new SQLException(e);
					} finally {
						if(cursorUsuarioAutor != null){
							cursorUsuarioAutor.close();
						}
					} 		
				}
				
				private void cargarDataInputOutputPlsql(ConsultaUsuarioAutorRequest request, CallableStatement call)	throws SQLException {
					call.setString(Constantes.NUNO, request.getPiCodUser());
					call.setString(Constantes.NDOS, request.getPiOficina());
					call.setString(Constantes.NTRES, request.getPiUserPlic());						
					call.registerOutParameter(Constantes.NCUATRO, OracleTypesHelper.INSTANCE.getOracleCursorTypeSqlType());//CURSOR
				}
				
				private ResultSet cargarDataStoredProcedure(ConsultaUsuarioAutorResponse consultaUsuarioAutorResponse, CallableStatement call) throws SQLException {

					ResultSet cursorListaUsuarioAutor = (ResultSet) call.getObject(Constantes.NCUATRO);
					List<DataResponse> listaUsuarioAutor = new ArrayList<>();
					if (cursorListaUsuarioAutor != null) {
						while (cursorListaUsuarioAutor.next()) {
							DataResponse dataResponse = new DataResponse();
							dataResponse.setUanId(cursorListaUsuarioAutor.getInt(Constantes.NUNO)!= Constantes.NCERO?cursorListaUsuarioAutor.getInt(Constantes.NUNO):Constantes.NCERO);		
							dataResponse.setUavCodigoUser(cursorListaUsuarioAutor.getString(Constantes.NDOS)!= null?cursorListaUsuarioAutor.getString(Constantes.NDOS):Constantes.VACIO);		
							dataResponse.setUavDniAutorizado(cursorListaUsuarioAutor.getString(Constantes.NTRES)!= null?cursorListaUsuarioAutor.getString(Constantes.NTRES):Constantes.VACIO);
							dataResponse.setUavNombres(cursorListaUsuarioAutor.getString(Constantes.NCUATRO)!= null?cursorListaUsuarioAutor.getString(Constantes.NCUATRO):Constantes.VACIO);
							dataResponse.setUavApellidos(cursorListaUsuarioAutor.getString(Constantes.NCINCO)!= null?cursorListaUsuarioAutor.getString(Constantes.NCINCO):Constantes.VACIO);
							dataResponse.setUanEstado(cursorListaUsuarioAutor.getInt(Constantes.NSEIS)!= Constantes.NCERO?cursorListaUsuarioAutor.getInt(Constantes.NSEIS):Constantes.NCERO);
							dataResponse.setUadTipoOFicina(cursorListaUsuarioAutor.getString(Constantes.NSIETE)!= null?cursorListaUsuarioAutor.getString(Constantes.NSIETE):Constantes.VACIO);
							dataResponse.setUavUsuarioAplicacion(cursorListaUsuarioAutor.getString(Constantes.NOCHO)!= null?cursorListaUsuarioAutor.getString(Constantes.NOCHO):Constantes.VACIO);
							dataResponse.setUavUserNova(cursorListaUsuarioAutor.getString(Constantes.NNUEVE)!= null?cursorListaUsuarioAutor.getString(Constantes.NNUEVE):Constantes.VACIO);
							listaUsuarioAutor.add(dataResponse);
						}
					}
					
					ResultSet cursorUsuarioAutor;
					cursorUsuarioAutor = (ResultSet) call.getObject(Constantes.NCUATRO);
					consultaUsuarioAutorResponse.setkSalida(listaUsuarioAutor);
					return cursorUsuarioAutor;
					
				}
			});
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));

			String descripcionError=String.valueOf(errors.toString());
						
			if (descripcionError.toUpperCase(Locale.getDefault()).contains(Constantes.SQL_TIMEOUTEXCEPTION)) {
				logger.error(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, "Error de Time Out Exception");
				throw new DBException(propertiesExternos.codigoGenericoErrorIDT3, propertiesExternos.mensajeGenericoErrorIDT3.replace("$sp", storedProcedure).replace("$bd", propertiesExternos.bdPvuOwner), e.getMessage() , e, Constantes.STATUS_TIME_OUT);
			}else {
				logger.error(Constantes.LOG_DOS_LLAVES, mensajeTransaccion,"Error Exception");
				throw new DBException(propertiesExternos.codigoGenericoErrorIDT3, propertiesExternos.mensajeGenericoErrorIDT3.replace("$sp", storedProcedure).replace("$bd", propertiesExternos.bdPvuOwner), e.getMessage() , e, Constantes.STATUS_DISPONIBILIDAD);
			}
			
		} finally {
			logger.info(Constantes.LOG_TRES_LLAVES, mensajeTransaccion, "Tiempo total de proceso(ms):",System.currentTimeMillis() - tiempoInicio);
			logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion, "[Fin de metodo]");
		}
		
		return consultaUsuarioAutorResponse;
	}
	
	public IdentificacionTransaccionResponse obtenerNumeroTransaccion(PropertiesExternos propExt,
			String msg, IdentificacionTransaccionRequest request ) throws DBException {

		long tiempoInicio = System.currentTimeMillis();
		StringBuilder storedProcedure = new StringBuilder();
		IdentificacionTransaccionResponse identificacionTransaccionResponse = new IdentificacionTransaccionResponse();

		String nombreMetodo = "obtenerNumeroTransaccion";
		String mensajeTransaccion = msg + "[" + nombreMetodo + "] ";
		logger.info(Constantes.LOG_CUATRO_LLAVES, mensajeTransaccion, "[INICIO] - METODO: [", nombreMetodo, " - DAO] ");
	
		try {
			storedProcedure.append(propExt.bdPvuOwner + Constantes.PUNTO);
			storedProcedure.append(propExt.bdPvuPkgSisactPkgBiometria + Constantes.PUNTO);
			storedProcedure.append(propExt.bdPvuFunGenIdTxBio);

			logger.info(Constantes.LOG_TRES_LLAVES, mensajeTransaccion, "Consultando: ", storedProcedure);
			
			Session session = entityManager.unwrap( Session.class );
			session.doWork(new Work() {	
				CallableStatement call = null;
				@Override
				public void execute(final Connection connection) throws SQLException {
					logger.info(Constantes.LOG_DOS_LLAVES, mensajeTransaccion + "Ejecutando SP : ");
					logger.info(Constantes.LOG_TRES_LLAVES, mensajeTransaccion + "PARAMETROS [INPUT]: \n", JAXBUtilitarios.anyObjectToXmlText(request));
					try {
						call = connection.prepareCall("{ ? = call " + storedProcedure.toString() +" (?) } " );
						
						call.setQueryTimeout(Integer.parseInt(propExt.bdPvuConexionTimeOutLimiteConsultaUsuario));
						
						cargarDataInputOutputPlsql(request, call);
						long tiempoInicioSP = System.currentTimeMillis();
						call.execute();
						
						logger.info(Constantes.LOG_CINCO_LLAVES, mensajeTransaccion, "Tiempo total de proceso del llamado del SP ", storedProcedure, "(ms):", System.currentTimeMillis() - tiempoInicioSP);
						logger.info(Constantes.LOG_TRES_LLAVES, mensajeTransaccion, "Se invoco con exito el SP: ", storedProcedure);
						
						identificacionTransaccionResponse.setpIdTrxBio(call.getString(Constantes.NUNO)!= null ? call.getString(Constantes.NUNO) : Constantes.VACIO); 

						String identificacionTransaccionResponseXML = JAXBUtilitarios.anyObjectToXmlText(identificacionTransaccionResponse);
						logger.info(Constantes.LOG_TRES_LLAVES, mensajeTransaccion, "PARAMETROS [OUTPUT]: \n", identificacionTransaccionResponseXML);
						
					} catch (SQLException e) {
						String descripcionError = seterValorExceptionLog(e);
						logger.info(Constantes.LOG_TRES_LLAVES,mensajeTransaccion,"Error Catch Stored Procedure: ", descripcionError);
						
						throw new SQLException(e);
					} finally {
						if(call != null){
							call.close();
						}
					} 		
				}
				
				private void cargarDataInputOutputPlsql(IdentificacionTransaccionRequest request, CallableStatement call)	throws SQLException {
					call.setInt(Constantes.NDOS, Integer.parseInt(request.getP_TIPO_ID())); 
					call.registerOutParameter(Constantes.NUNO, java.sql.Types.VARCHAR);
				}
				
			});
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));

			String descripcionError=String.valueOf(errors.toString());
						
			if (descripcionError.toUpperCase(Locale.getDefault()).contains(Constantes.SQL_TIMEOUTEXCEPTION)) {
				logger.info(Constantes.LOG_DOS_LLAVES,mensajeTransaccion, "Error de Time Out Exception");
				throw new DBException(propExt.codigoGenericoErrorIDT3, propExt.mensajeGenericoErrorIDT3.replace("$sp", storedProcedure).replace("$bd", propExt.bdPvuOwner), e.getMessage() , e, Constantes.STATUS_TIME_OUT);
			}else {
				logger.info(Constantes.LOG_DOS_LLAVES,mensajeTransaccion, "Error Exception");
				throw new DBException(propExt.codigoGenericoErrorIDT3, propExt.mensajeGenericoErrorIDT3.replace("$sp", storedProcedure).replace("$bd", propExt.bdPvuOwner), e.getMessage() , e, Constantes.STATUS_DISPONIBILIDAD);
			}
			
		} finally {
			logger.info(Constantes.LOG_TRES_LLAVES,mensajeTransaccion, "Tiempo total de proceso(ms):",System.currentTimeMillis() - tiempoInicio);
			logger.info(Constantes.LOG_CUATRO_LLAVES,mensajeTransaccion, "[Fin de metodo: ", storedProcedure, Constantes.CORCHETE);
		}
		
		return identificacionTransaccionResponse;
	}

	private String seterValorExceptionLog(Exception e) {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		
		return String.valueOf(errors.toString());
	}
}

package pe.com.claro.venta.usuariobiometria.common.property;

public class Constantes {

	private Constantes(){}
	
    public static final String NOMBRESERVICIOREST = "claro-venta-identidad";
    public static final String URLPATTERNS = "/api/*";
    public static final String BASEPATH = "/claro-venta-identidad-resource/api";
    public static final String PATH_PRINCIPAL_URL = "venta/identidad/v1.0.0";
    public static final String NOMBRE_METODO_REGISTRARPERSONA = "registrarPersona";
    public static final String SLASH ="/"; 
    public static final String PATH_METODO_REGISTRARPERSONA = SLASH + NOMBRE_METODO_REGISTRARPERSONA;
    public static final String NOMBRE_METODO_VERIFICARBIOMETRIA = "verificarBiometria";
    public static final String PATH_METODO_VERIFICARBIOMETRIA = SLASH + NOMBRE_METODO_VERIFICARBIOMETRIA;

    public static final String VERSION = "1.0.0";

    public static final String CLASSTIMEOUTCONNECTION = "com.sun.xml.ws.connect.timeout";
    public static final String CLASSTIMEOUTREQUEST = "com.sun.xml.ws.request.timeout";
    public static final String TIMEOUTEXCEPTION = "Timeout";
    public static final String TIMEOUTEXCEPTION2 = "Timed out";

	public static final String EXCEPTION_WS_NO_DISPONIBLE_01	= "RemoteAccessException";
	public static final String EXCEPTION_WS_NO_DISPONIBLE_02	= "404";
	public static final String EXCEPTION_WS_NO_DISPONIBLE_03	= "WebServiceException";
	public static final String EXCEPTION_WS_NO_DISPONIBLE_04	= "ConnectException";
	
    public static final String TIPOCLIENTEREST = "REST";
    public static final String TIPOCLIENTESOA = "SOA";

    // INI PROPERTIES CONFIG
    public static final String VAR_PROPERTIES_SERVER_CLARO = "claro.properties";
    public static final String NOMBRE_FOLDER_PROPERTIES = NOMBRESERVICIOREST;
    public static final String NOMBRE_ARCHIVO_PROPERTIES = ".properties";
    // FIN PROPERTIES CONFIG

    public static final String LOCALE_ES = "es";
    public static final String LOCALE_PE = "pe";

    public static final String PUNTO = ".";

    public static final String TRUE = "TRUE";
    public static final String FALSE = "FALSE";

    public static final boolean TRUE_BOOLEAN = true;
    public static final boolean FALSE_BOOLEAN = false;

    public static final String VALOPECLARO = "VALOPECLARO";
    public static final String VALEXISTESIAPDV = "VALEXISTESIAPDV";
    public static final String VALPERTENENCIA = "VALPERTENENCIA";
    public static final String MENOPETECLARO = "MENOPETECLARO";
    public static final String MENOPETEVENDE = "MENOPETEVENDE";
    public static final String MENOREGISTRADO = "MENOREGISTRADO";

    // INICIO CAMPOS DEL HEADER
    public static final String USERID = "userId";
    public static final String USRBIOMOVIL = "USRBIOMOVIL";
    public static final String BIOMOVIL = "BIOMOVIL";
    // FIN CAMPOS DEL HEADER

    public static final String FLAGVALIDACIONLINEA = "flagValidacionLinea";
    public static final String FLAGACTUALIZACIONLINEA = "flagActualizacionLinea";

    public static final String ID = "id";
    public static final String EMPTY = "";
    public static final String ACCEPTNOVALIDO = "*/*";

    public static final String FORMATOFECHAPARAMETROS_VEINTE = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String FORMATOFECHAPARAMETROS_VEINTICUATRO = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String FORMATOFECHAPARAMETROS_VEINTICINCO = "yyyy-MM-dd'T'HH:mm:ssXXX";

    public static final String NOMBREWS_BIOMETRIAVENDEDOR = "BiometriaVendedorWS";
    public static final String NOMBREREST_PARAMETRO = "claro-venta-parametro";
    public static final String NOMBREWS_VALIDARLINEASCLIENTE = "ValidarLineasClienteWS";
    public static final String NOMBREWS_VALIDALINEACLAROV2 = "ValidaLineaClaroV2WS";

    public static final String TIPO_OPERACION_METODO = "Método";
    public static final String TIPO_OPERACION_SP = "SP";

    public static final String FORMATOFECHADEFAULT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

    public static final String CODIGO200 = "200";
    public static final String CODIGO400 = "400";
    public static final String CODIGO404 = "404";
    public static final String MENSAJEOK = "OK";

    public static final String EXCEPTION_PEDIDO = "Error en el servicio registrar Operacion ";

    public static final String IDTRANSACCION = "idTransaccion";
    public static final String MSGID = "msgid";
    public static final String USRID = "userId";
    public static final String TIMESTAMP = "timestamp";
    public static final String ACCEPT = "accept";
    public static final String API = "api";
    public static final String CORCHETE = "]";

    public static final String CHARSETUTF8 = ";charset=UTF-8";
    public static final String SWAGGERJAXRSCONFIG = "SwaggerJaxrsConfig";
    public static final String URLSWAGGERJAXRSCONFIG = "/SwaggerJaxrsConfig";
    public static final String HTML5CORSFILTER = "HTML5CorsFilter";

    public static final String ACCESSCONTROLALLOWORIGIN = "Access-Control-Allow-Origin";
    public static final String ACCESSCONTROLALLOWMETHODS = "Access-Control-Allow-Methods";
    public static final String ACCESSCONTROLALLOWHEADERS = "Access-Control-Allow-Headers";
    public static final String ASTERISCO = "*";
    public static final String METODOSPERMITIDOS = "GET, POST, DELETE, PUT";
    public static final String CONTENTTYPE = "Content-Type";

    public static final String PROPERTIESEXTERNOS = ".properties";
    public static final String PROPERTIESKEY = "claro.properties";
    public static final String CONSTANTENOJNDI = "javax.persistence.PersistenceException";
    public static final String CONSTANTENOJNDIWS = "MessageBodyProviderNotFoundException";
    public static final String CONSTANTETIMEOUTWS = "java.net.SocketTimeoutException";
    public static final String MENOS_UNO = "-1";
    public static final String UNO_STR = "1";
    public static final String DOS_STR = "2";
    public static final String TRES_STR = "3";
    public static final String CUATRO_STR = "4";
    public static final String CINCO_STR = "5";
    public static final String SEIS_STR = "6";

    public static final String COD_RPTA_EXCEPTION_CONTROLADO = "99";

    public static final String SESENTACINCO = "65";
    public static final String ZERO = "0";
    public static final Long ZERO_LONG = 0L;
    public static final int UNO_INT = 1;
    public static final int DOS_INT = 2;
    public static final int TRES_INT = 3;
    public static final int CUATRO_INT = 4;
    public static final int CINCO_INT = 5;

    public static final int OCHO = 8;
    public static final String FORMATO_FECHA_SP = "yyyy-MM-dd HH:mm:ss";
    public static final Object NULO = null;

    // -----------------
    public static final String QUERYMEDIOSCOMUNICACION = "SELECT m FROM MedioComunicacion m";

    // -----------------
    public static final String QUERYREPRESENTANTELEGALBASE = "SELECT r FROM RepresentanteLegal r";
    public static final String IDREPRESENTANTE = "idRepresentante";
    public static final String QUERYREPRESENTANTEBYID = " WHERE r.releId = :idRepresentante";

    // -----------------
    public static final String QUERYCLIENTESOLCAMBIO = "SELECT c FROM ClienteSolCambio c";
    public static final String IDSOLCAMBIO = "solId";
    public static final String QUERYSOLCAMBIOBYID = " WHERE c.solId = :solId";

    // -----------------
    public static final String QUERYCLIENTESOLCAMBIODET = "SELECT c FROM ClienteSolCambioDet c";
    public static final String IDSOLCAMBIODET = "soldetId";
    public static final String QUERYSOLCAMBIOBYIDDET = " WHERE c.soldetId = :soldetId";

    // -----------------
    public static final String PERSISTENCEPACKAGEUNIT = "pe.com.claro.vent.clientes";
    public static final String LINEA = "linea";

    // *** Parametros de Auditoria - Header Request Transport
    public static final String DD_MM_YYYY = "dd/MM/yyyy";
    public static final String DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";
    public static final String BOLSA_ID6 = "6";
    public static final int CERO_INT = 0;
    public static final String CERO_STRING = "0";

    /// **** ENCODING
    public static final String DEFAULT_ENCODING_PROPERTIES = "ISO-8859-1";
    public static final String DEFAULT_ENCODING_API = "UTF-8";

    public static final String FORMATO_FECHA_DEFAULT = "dd/MM/yyyy HH:mm:ss";
    public static final int VEINTE = 20;
    public static final int VEINTICUATRO = 24;
    public static final int VEINTICINCO = 25;
    public static final String TEXTO_NULL = "null";

    // **** Caracteres
    public static final String CHAR_PARENTESIS_IZQUIERDO = "(";
    public static final String CHAR_PARENTESIS_DERECHO = ")";
    public static final String CHAR_INTERROGACION = "?";
    public static final String CHAR_COMA = ",";
    public static final String OK = "OK";
    public static final String ERROR = "ERROR";
    public static final String VACIO = "";
    public static final String ERROR_EXCEPTION = "ERROR: [";
    public static final String CORCHETES_EXCEPTION = "] - [";
    public static final String CORCHETE_CERRADO_EXCEPTION = "] ";
    

    // ******PEDIDOS
    public static final int DIAS_DATA_PEDIDOS = 1;

    // REQUEST
    public static final String TYPEREQUEST = "application/json";

    /******************************/
    // CONTEXT BASE DE DATOS
    public static final String PERSISTENCE_CONTEXT_PVU = "pe.com.claro.jdbc.datasources.noXA.portaprepago.pvuDS";

    public static final String PERSISTENCE_CONTEXT_BSCS = "pe.com.claro.venta.data.source.bscs";

    public static final String PERSISTENCE_CONTEXT_MCL = "pe.com.claro.venta.data.source.mcl";

    // NOMBRE DE METODOS
    public static final String METHODO_OBTENEREMAILCLIENTE = "obtenerEmailCliente -> ";

    public static final String METHODO_UPDATE_EMAILCLIENTE = "updateEmailCliente -> ";

    // ERRORES DE DB
    public static final int STATUS_TIME_OUT = 504;
    public static final String SQL_TIMEOUTEXCEPTION = "SQLTIMEOUTEXCEPTION";
    
    public static final int STATUS_DISPONIBILIDAD = 404;

    //
    public static final String TIPO_DOCUMENTO_GENERAL = "01";
    public static final String TIPO_DOCUMENTO_PVU = "01";
    public static final int TIPO_DOCUMENTO_BSCS = 2;

    public static final String PALOTE = "|";

    /* RESTBUtilitarios */
    public static final String RAWTYPES = "rawtypes";
    public static final String UNCHECKED = "unchecked";
    public static final String ERROR_JAXB_CONTEXT = "Error creando JAXBContext: ";
    public static final String ERROR_PARSE_XML = "Error parseando object to xml: ";
    public static final String HEADER_PARAM_ID_TRANSACCION = "idTransaccion";
    public static final String HEADER_PARAM_MSG_ID = "msgid";
    public static final String HEADER_PARAM_TIMESTAMP = "timestamp";
    public static final String HEADER_PARAM_USER_ID = "userId";
    public static final String HEADER_PARAM_ACCEPT = "Accept";
    public static final String ID_TXT = " idTx=";
    public static final String MSG_ID = " msgid=";
    public static final String USER_ID = " userId=";
    public static final String INI_CORCHETE = "[";
    public static final String FIN_CORCHETE = "] ";
    public static final String GUION = "-";
    public static final String INICIO_METODO = "[ INICIO de m�todo ";
    public static final String DATOS_ENTRADA = " Datos REQUEST: \n ";
    public static final String INI_CORCHETE1 = " 1. [";
    public static final String RESPONSE_RETORNAR = " RESPONSE a retornar: \n ";
    public static final String FIN_METODO = "[ FIN de m�todo ";
    public static final String TIEMPO_TOTAL = " ] Tiempo total de proceso (ms):";
    public static final String MILISEG = " milisegundos.";
    public static final String VERSION_HTTP = "Version-HTTP";
    public static final String EJECUTANDO = " Ejecutando: ";
    public static final int VALOR_CERO = 0;
    public static final String ERROR_EXCEPCION = "ERROR: [Exception] ";
    public static final String CONSULTANDO_BD = "Consultando BD ";
    public static final String CON_JNDI = ", con JNDI=";
    public static final String EJECUTANDO_SP = "Ejecutando SP : ";
    public static final String INVOCACION_CON_EXITO = "Se consult� con éxito las tablas: ";
    public static final String PARAMETROS_OUTPUT = "PARAMETROS [OUPUT]: ";
    public static final String CANTIDAD_REGISTROS = "cantidad de registros: ";
    public static final String PUNTO_ESPACIO = ". ";
    public static final String ESPACIO = " ";
    public static final String PUNTO_PROPERTIES = ".properties";

	// PARAMETROS PROCEDURE
	public static final int NCERO = 0;
	public static final int NUNO = 1;
	public static final int NDOS = 2;
	public static final int NTRES = 3;
	public static final int NCUATRO = 4;
	public static final int NCINCO = 5;
	public static final int NSEIS = 6;
	public static final int NSIETE = 7;
	public static final int NOCHO = 8;
	public static final int NNUEVE = 9;
    
	
	// PARAMETROS CONEXION RENIEC
	public static final String CODIGO_EXITO_SIGNON ="00000";
	public static final String CODIGO_EXITO_SIGNOFF ="00000";
	public static final String CODIGO_EXITO_REGISTRAR_PERSONA ="00000";
//	public static final String CODIGO_EXITO ="0";
	public static final String FORMATO_FECHA ="yyyyMMdd";
	public static final String FORMATO_HORA ="HHmmssSSS";

	public static final String LOG_DOS_LLAVES    = "{}{}";
	public static final String LOG_TRES_LLAVES   = "{}{}{}";
	public static final String LOG_CUATRO_LLAVES = "{}{}{}{}";
	public static final String LOG_CINCO_LLAVES  = "{}{}{}{}{}";
	public static final String LOG_SEIS_LLAVES   = "{}{}{}{}{}{}";
	public static final String LOG_GUION = "-------------------------------------------------------------------";
	public static final String LOG_IGUAL = "===================================================================";
	public static final String INDICADOR_WS= "$ws";
	public static final String INDICADOR_METODO= "$metodo";
	
	
}

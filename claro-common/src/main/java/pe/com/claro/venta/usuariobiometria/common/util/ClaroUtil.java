package pe.com.claro.venta.usuariobiometria.common.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import pe.com.claro.venta.usuariobiometria.common.property.Constantes;

public class ClaroUtil {

	private ClaroUtil(){}
	
    private static final Logger LOG = LoggerFactory.getLogger(ClaroUtil.class);

    /**
     * Genera un String a partir de un Date, si fecha es NULL retorna ""
     * (vacio).
     *
     * @param fecha tipo Date
     * @return String de la forma dd/MM/yyyy
     */
    public static String dateAString(Date fecha) {
		if (fecha == null) {
		    return Constantes.EMPTY;
		}
		return dateAString(fecha, Constantes.DD_MM_YYYY_HH_MM_SS);
    }

    public static String convertProperties(Object object) {
		String a = null;
		if (object != null) {
		    a = object.toString();
		    try {
		    	a = new String(a.getBytes(Constantes.DEFAULT_ENCODING_PROPERTIES), Constantes.DEFAULT_ENCODING_API);
		    }
		    catch (Exception e) {
		    	LOG.error("Error getProperties Encoding Failed, trayendo Encoding por defecto", e);
		    }
		}
		return a;
    }

    /**
     * Genera un String a partir de un Date de acuerdo al fomrato enviado, si
     * fecha es NULL toma la fecha actual.
     *
     * @param fecha
     * @param formato
     * @return
     */
    public static String dateAString(Date fecha, String formato) {
		SimpleDateFormat formatoDF = new SimpleDateFormat(formato, Locale.getDefault());
		return formatoDF.format(fecha);
    }

    public static Calendar toCalendar(String iso8601string) {
		Calendar calendar = GregorianCalendar.getInstance();
		try {
		    boolean exito = Constantes.FALSE_BOOLEAN;
		    if (iso8601string.isEmpty()) {
				exito = Constantes.TRUE_BOOLEAN;
				return calendar;
		    }
		    else {
				LOG.info("Dimension de Fecha de Header: " + iso8601string.length());
		
				Date date = new Date();
				String formatoFecha = Constantes.EMPTY;
		
				switch (iso8601string.length()) {
					case Constantes.VEINTE:
					    formatoFecha = Constantes.FORMATOFECHAPARAMETROS_VEINTE;
					    exito = Constantes.TRUE_BOOLEAN;
					    break;
					case Constantes.VEINTICUATRO:
					    formatoFecha = Constantes.FORMATOFECHAPARAMETROS_VEINTICUATRO;
					    exito = Constantes.TRUE_BOOLEAN;
					    break;
					case Constantes.VEINTICINCO:
					    formatoFecha = Constantes.FORMATOFECHAPARAMETROS_VEINTICINCO;
					    exito = Constantes.TRUE_BOOLEAN;
					    break;
					default:
					    break;
				}
		
				date = fechaADate(formatoFecha, iso8601string);
				calendar.setTime(date);
		    }
		    if (!exito) {
				LOG.info("Parseo no fue exitoso Calendar es ahora null");
				calendar = null;
		    }
		    else {
		    	LOG.info("Parseo exitoso de la fecha");
		    }
		}
		catch (IndexOutOfBoundsException e) {
		    LOG.error("Ocurrio un error al recorrer la cadena de Fecha", e);
		    calendar = null;
		}
		catch (ParseException e) {
		    LOG.error("Ocurrio un error al convertir a Date la cadena de la fecha", e);
		    calendar = null;
		}
		return calendar;
    }

    public static Date fechaADate(String formatoFecha, String fechaCadena) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha, Locale.getDefault());
		sdf.setTimeZone(TimeZone.getTimeZone("GMT-5"));
		Date date = sdf.parse(fechaCadena);
		return date;
    }

    public static boolean isValidFormat(String format, String value) {
		Date date = null;
		try {
		    SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
		    date = sdf.parse(value);
		    if (!value.equals(sdf.format(date))) {
		    	date = null;
		    }
		}
		catch (ParseException ex) {
		    date = null;
		}
		return date != null;
    }

    public static String getStoredProcedureByParameters(Object owner, Object packg, Object name) {
		StringBuffer storedProcedure = new StringBuffer();
		if (owner != null && !owner.toString().isEmpty()) {
		    storedProcedure.append(owner.toString());
		    storedProcedure.append(Constantes.PUNTO);
		}
		if (packg != null && !packg.toString().isEmpty()) {
		    storedProcedure.append(packg.toString());
		    storedProcedure.append(Constantes.PUNTO);
		}
		if (name != null && !name.toString().isEmpty()) {
		    storedProcedure.append(name.toString());
		}
		return storedProcedure.toString();
    }

    public static String getExceptionToMensaje(Exception e) {
		String msg = Constantes.VACIO;
		if (e.getCause() != null) {
		    msg = e.getCause().toString();
		}
		else {
		    msg = e.toString();
		}
		return msg;
    }

    public static Float floatParse(String object) {
	if (object != null && !object.isEmpty()) {
	    return Float.parseFloat(object);
	}
	return null;
    }

    public static String getStoredProcedureJDBC(String sp, int parameters) {
	StringBuilder call = new StringBuilder();
	call.append("call ");
	call.append(sp);
	call.append(Constantes.CHAR_PARENTESIS_IZQUIERDO);
	for (int i = 0; i < parameters; i++) {
	    call.append(Constantes.CHAR_INTERROGACION);
	    if (i + 1 < parameters)
		call.append(Constantes.CHAR_COMA);
	}
	call.append(Constantes.CHAR_PARENTESIS_DERECHO);
	return call.toString();
    }

    public static DateFormat getLocalFormat() {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
	dateFormat.setTimeZone(TimeZone.getDefault());
	return dateFormat;
    }

    public static String printPrettyJSONString(Object o) throws JsonProcessingException {
	return new ObjectMapper().setDateFormat(ClaroUtil.getLocalFormat()).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }

    public static String printJSONString(Object o) {
	try {
	    return new ObjectMapper().setDateFormat(ClaroUtil.getLocalFormat()).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writeValueAsString(o);
	}
	catch (JsonProcessingException e) {
	    return Constantes.EMPTY;
	}
    }

    public static boolean validarFechaExpiracion(String fecha) {
	try {
	    String fechaActual = new SimpleDateFormat(Constantes.DD_MM_YYYY, Locale.getDefault()).format(new Date());
	    Date dateExp = new SimpleDateFormat(Constantes.DD_MM_YYYY, Locale.getDefault()).parse(fecha);
	    Date dateAct = new SimpleDateFormat(Constantes.DD_MM_YYYY, Locale.getDefault()).parse(fechaActual);

	    if (dateExp.after(dateAct) || dateExp.compareTo(dateAct) == 0)
	    	return true;

	    return false;
	}
	catch (Exception e) {
	    return false;
	}
    }

    public static Double getDouble(Object valor) {
	try {
	    return Double.valueOf(valor.toString());
	}
	catch (Exception e) {
	    return new Double(0);
	}
    }

    public static Date convertirStringADate(String fecha, String formato) {

	try {
	    SimpleDateFormat formatoFecha = new SimpleDateFormat(formato);

	    return formatoFecha.parse(fecha);
	}
	catch (Exception e) {

	    return null;
	}
    }

    public static double redondear(Object valor) {
	double dblValor = Double.parseDouble(valor.toString());
	return (double) Math.round(dblValor * 10) / 10;
    }

    public static String decimalesCadenasRound(Double valor) {
	valor = (double) Math.round(valor * 100) / 100.0;
	DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.US);
	DecimalFormat decimalFormat = new DecimalFormat("###0.00", simbolos);
	return decimalFormat.format(valor);
    }

    public static Date modificarFecha(Date fecha, int campo, int cantidad) {
	try {
	    Calendar fechaFinal = Calendar.getInstance();
	    fechaFinal.setTime(fecha);
	    fechaFinal.add(campo, cantidad);
	    return fechaFinal.getTime();
	}
	catch (Exception e) {
	    return fecha;
	}
    }

    public static String dateToString(Date fecha, String formato) {
	try {
	    SimpleDateFormat sdf = new SimpleDateFormat(formato, Locale.getDefault());
	    sdf.setTimeZone(TimeZone.getTimeZone("GMT-5"));
	    return sdf.format(fecha);
	}
	catch (Exception e) {
	    return Constantes.EMPTY;
	}
    }

    public static boolean existStringSplitValue(String[] array, String value) {
	boolean existe = false;
	if (array != null) {
	    for (String val : array) {
		if (val.equals(value)) {
		    existe = true;
		    break;
		}
	    }
	}
	return existe;
    }

    public static Date stringToJavaDateLegado(String sDate) {
	Date date = null;
	try {
	    date = new SimpleDateFormat(Constantes.DD_MM_YYYY_HH_MM_SS, new Locale("es", "ES")).parse(sDate);
	}
	catch (ParseException e) {
	    date = null;
	}
	return date;
    }

    public static String generarIdTransaccion() {
	Calendar fecha = Calendar.getInstance();
	return String.valueOf(fecha.get(Calendar.YEAR)) + String.valueOf((fecha.get(Calendar.MONTH) + 1)) + String.valueOf(fecha.get(Calendar.DAY_OF_MONTH)) + String.valueOf(fecha.get(Calendar.HOUR_OF_DAY)) + String.valueOf(fecha.get(Calendar.MINUTE)) + String.valueOf(fecha.get(Calendar.SECOND)) + String.valueOf(fecha.get(Calendar.MILLISECOND));
    }
}

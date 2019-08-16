package pe.com.claro.venta.usuariobiometria.canonical.verificarbiometria.request;

public class EliminarTokenRequest {

	private String autenticacionMensaje;
	private String fechaTransaccion;
	private String horaTransaccion;
	private String latitudLocalizacion;
	private String longitudLocalizacion;
	private String marcaDispositivo;
	private String modeloDispositivo;
	private String numeroIdentificadorCliente;
	private String numeroOrden;
	private String numeroTransaccion;
	private String idSesion;

	public EliminarTokenRequest() {
	}

	public EliminarTokenRequest(String autenticacionMensaje, String fechaTransaccion, String horaTransaccion,
			String latitudLocalizacion, String longitudLocalizacion, String marcaDispositivo, String modeloDispositivo,
			String numeroIdentificadorCliente, String numeroOrden, String numeroTransaccion, String idSesion) {
		super();
		this.autenticacionMensaje = autenticacionMensaje;
		this.fechaTransaccion = fechaTransaccion;
		this.horaTransaccion = horaTransaccion;
		this.latitudLocalizacion = latitudLocalizacion;
		this.longitudLocalizacion = longitudLocalizacion;
		this.marcaDispositivo = marcaDispositivo;
		this.modeloDispositivo = modeloDispositivo;
		this.numeroIdentificadorCliente = numeroIdentificadorCliente;
		this.numeroOrden = numeroOrden;
		this.numeroTransaccion = numeroTransaccion;
		this.idSesion = idSesion;
	}

	public String getAutenticacionMensaje() {
		return autenticacionMensaje;
	}

	public void setAutenticacionMensaje(String autenticacionMensaje) {
		this.autenticacionMensaje = autenticacionMensaje;
	}

	public String getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(String fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public String getHoraTransaccion() {
		return horaTransaccion;
	}

	public void setHoraTransaccion(String horaTransaccion) {
		this.horaTransaccion = horaTransaccion;
	}

	public String getLatitudLocalizacion() {
		return latitudLocalizacion;
	}

	public void setLatitudLocalizacion(String latitudLocalizacion) {
		this.latitudLocalizacion = latitudLocalizacion;
	}

	public String getLongitudLocalizacion() {
		return longitudLocalizacion;
	}

	public void setLongitudLocalizacion(String longitudLocalizacion) {
		this.longitudLocalizacion = longitudLocalizacion;
	}

	public String getMarcaDispositivo() {
		return marcaDispositivo;
	}

	public void setMarcaDispositivo(String marcaDispositivo) {
		this.marcaDispositivo = marcaDispositivo;
	}

	public String getModeloDispositivo() {
		return modeloDispositivo;
	}

	public void setModeloDispositivo(String modeloDispositivo) {
		this.modeloDispositivo = modeloDispositivo;
	}

	public String getNumeroIdentificadorCliente() {
		return numeroIdentificadorCliente;
	}

	public void setNumeroIdentificadorCliente(String numeroIdentificadorCliente) {
		this.numeroIdentificadorCliente = numeroIdentificadorCliente;
	}

	public String getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(String numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public String getNumeroTransaccion() {
		return numeroTransaccion;
	}

	public void setNumeroTransaccion(String numeroTransaccion) {
		this.numeroTransaccion = numeroTransaccion;
	}

	public String getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(String idSesion) {
		this.idSesion = idSesion;
	}

}
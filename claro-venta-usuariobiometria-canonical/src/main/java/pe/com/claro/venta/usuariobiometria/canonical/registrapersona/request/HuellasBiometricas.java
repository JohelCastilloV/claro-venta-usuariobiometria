package pe.com.claro.venta.usuariobiometria.canonical.registrapersona.request;

import java.math.BigDecimal;

public class HuellasBiometricas {

	private String idHuellas;
	private String calidadImagen;
	private String formatoHuella;
	private String huellaImagen;
	private String huellaTemplate;
	private BigDecimal porcentajeHuellaViva;

	public HuellasBiometricas() {
	}

	public String getIdHuellas() {
		return idHuellas;
	}

	public void setIdHuellas(String idHuellas) {
		this.idHuellas = idHuellas;
	}

	public String getCalidadImagen() {
		return calidadImagen;
	}

	public void setCalidadImagen(String calidadImagen) {
		this.calidadImagen = calidadImagen;
	}

	public String getFormatoHuella() {
		return formatoHuella;
	}

	public void setFormatoHuella(String formatoHuella) {
		this.formatoHuella = formatoHuella;
	}

	public String getHuellaImagen() {
		return huellaImagen;
	}

	public void setHuellaImagen(String huellaImagen) {
		this.huellaImagen = huellaImagen;
	}

	public String getHuellaTemplate() {
		return huellaTemplate;
	}

	public void setHuellaTemplate(String huellaTemplate) {
		this.huellaTemplate = huellaTemplate;
	}

	public BigDecimal getPorcentajeHuellaViva() {
		return porcentajeHuellaViva;
	}

	public void setPorcentajeHuellaViva(BigDecimal porcentajeHuellaViva) {
		this.porcentajeHuellaViva = porcentajeHuellaViva;
	}

	@Override
	public String toString() {
		return "HuellaBiometrica [idHuellas=" + idHuellas + ", calidadImagen=" + calidadImagen + ", formatoHuella="
				+ formatoHuella + ", huellaImagen=" + huellaImagen + ", huellaTemplate=" + huellaTemplate
				+ ", porcentajeHuellaViva=" + porcentajeHuellaViva + "]";
	}

}
package pe.com.claro.venta.usuariobiometria.model.response;

public class IdentificacionTransaccionResponse {

	private String pIdTrxBio;

	public String getpIdTrxBio() {
		return pIdTrxBio;
	}

	public void setpIdTrxBio(String pIdTrxBio) {
		this.pIdTrxBio = pIdTrxBio;
	}

	@Override
	public String toString() {
		return "IdentificacionTransaccionResponse [pIdTrxBio=" + pIdTrxBio + "]";
	}

}
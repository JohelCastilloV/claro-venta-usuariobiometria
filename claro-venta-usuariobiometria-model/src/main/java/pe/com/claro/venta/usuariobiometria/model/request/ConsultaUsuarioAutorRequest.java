package pe.com.claro.venta.usuariobiometria.model.request;

public class ConsultaUsuarioAutorRequest {

	private String piCodUser;
	private String piOficina;
	private String piUserPlic;

	public String getPiCodUser() {
		return piCodUser;
	}

	public void setPiCodUser(String piCodUser) {
		this.piCodUser = piCodUser;
	}

	public String getPiOficina() {
		return piOficina;
	}

	public void setPiOficina(String piOficina) {
		this.piOficina = piOficina;
	}

	public String getPiUserPlic() {
		return piUserPlic;
	}

	public void setPiUserPlic(String piUserPlic) {
		this.piUserPlic = piUserPlic;
	}

	@Override
	public String toString() {
		return "ConsultaUsuarioAutorRequest [piCodUser=" + piCodUser + ", piOficina=" + piOficina + ", piUserPlic="
				+ piUserPlic + "]";
	}

}
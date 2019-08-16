package pe.com.claro.venta.usuariobiometria.model.request;

public class IdentificacionTransaccionRequest {

	private String P_TIPO_ID;
	
	public IdentificacionTransaccionRequest(){}

	public IdentificacionTransaccionRequest(String p_TIPO_ID) {
		super();
		P_TIPO_ID = p_TIPO_ID;
	}

	public String getP_TIPO_ID() {
		return P_TIPO_ID;
	}

	public void setP_TIPO_ID(String p_TIPO_ID) {
		P_TIPO_ID = p_TIPO_ID;
	}

	@Override
	public String toString() {
		return "IdentificacionTransaccionRequest [P_TIPO_ID=" + P_TIPO_ID + "]";
	}

}
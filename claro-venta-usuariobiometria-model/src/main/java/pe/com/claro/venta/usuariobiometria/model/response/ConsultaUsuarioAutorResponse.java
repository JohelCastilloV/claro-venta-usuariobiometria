package pe.com.claro.venta.usuariobiometria.model.response;

import java.util.List;

public class ConsultaUsuarioAutorResponse {

	private List<DataResponse> kSalida;

	public List<DataResponse> getkSalida() {
		return kSalida;
	}

	public void setkSalida(List<DataResponse> kSalida) {
		this.kSalida = kSalida;
	}

	@Override
	public String toString() {
		return "ConsultaUsuarioAutorResponse [kSalida=" + kSalida + "]";
	}

}
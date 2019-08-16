package pe.com.claro.venta.usuariobiometria.common.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ObjetoRequestOpcional {
	private String clave;
	private String valor;

	public String getClave() {
		return clave;
	}

	public void setClave(String value) {
		this.clave = value;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String value) {
		this.valor = value;
	}

	@Override
	public String toString() {
		return "ObjetoRequestOpcional [clave=" + clave + ", valor=" + valor + "]";
	}
}
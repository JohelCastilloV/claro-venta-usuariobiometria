package pe.com.claro.venta.usuariobiometria.common.bean;

public class BolsaCompartidaType {
	
	private boolean isBolsaCompartida;
	private boolean isHaveRPCIlimitado;
	private boolean isHaveRedSocialIlimitado;
	
	public BolsaCompartidaType() {
		super();
		this.isBolsaCompartida = false;
		this.isHaveRPCIlimitado = false;
		this.isHaveRedSocialIlimitado = false;
	}
	
	public boolean isBolsaCompartida() {
		return isBolsaCompartida;
	}
	public void setBolsaCompartida(boolean isBolsaCompartida) {
		this.isBolsaCompartida = isBolsaCompartida;
	}
	public boolean isHaveRPCIlimitado() {
		return isHaveRPCIlimitado;
	}
	public void setHaveRPCIlimitado(boolean isHaveRPCIlimitado) {
		this.isHaveRPCIlimitado = isHaveRPCIlimitado;
	}
	public boolean isHaveRedSocialIlimitado() {
		return isHaveRedSocialIlimitado;
	}
	public void setHaveRedSocialIlimitado(boolean isHaveRedSocialIlimitado) {
		this.isHaveRedSocialIlimitado = isHaveRedSocialIlimitado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isBolsaCompartida ? 1231 : 1237);
		result = prime * result + (isHaveRPCIlimitado ? 1231 : 1237);
		result = prime * result + (isHaveRedSocialIlimitado ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BolsaCompartidaType other = (BolsaCompartidaType) obj;
		if (isBolsaCompartida != other.isBolsaCompartida)
			return false;
		if (isHaveRPCIlimitado != other.isHaveRPCIlimitado)
			return false;
		if (isHaveRedSocialIlimitado != other.isHaveRedSocialIlimitado)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BolsaCompartidaType [isBolsaCompartida=" + isBolsaCompartida + ", isHaveRPCIlimitado="
				+ isHaveRPCIlimitado + ", isHaveRedSocialIlimitado=" + isHaveRedSocialIlimitado + "]";
	}
}

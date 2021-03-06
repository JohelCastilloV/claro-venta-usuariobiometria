
package pe.com.claro.venta.usuariobiometria.common.exception;

public class ApiException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4463545099205456203L;
	private int code;
	private Integer status;
	String developerMessage;

	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
	}

	public ApiException(int status, int code, String msg, String developerMessage) {
		super(msg);
		this.status = status;
		this.code = code;
		this.developerMessage = developerMessage;
	}

	public ApiException(int code, String msg, String developerMessage) {
		super(msg);
		this.code = code;
		this.developerMessage = developerMessage;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

}

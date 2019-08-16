
package pe.com.claro.venta.usuariobiometria.common.exception;

public class BadRequestException extends ApiException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7482288873992395827L;
	private int code;
	private Integer status;
	String developerMessage;

	public BadRequestException(int code, String msg) {
		super(code, msg);
		this.code = code;
	}

	public BadRequestException(int status, int code, String msg, String developerMessage) {
		super(status, code, msg, developerMessage);
		this.status = status;
		this.code = code;
		this.developerMessage = developerMessage;
	}

	public BadRequestException(int code, String msg, String developerMessage) {
		super(code, msg, developerMessage);
		this.code = code;
		this.developerMessage = developerMessage;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public Integer getStatus() {
		return status;
	}

	@Override
	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String getDeveloperMessage() {
		return developerMessage;
	}

	@Override
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

}

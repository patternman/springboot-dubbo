/**
 * 
 */
package io.springcat.dto;

/**
 * @author adampeng
 *
 */
public class ExecuteStatusDTO extends BaseDTO{
	
	private static final long serialVersionUID = 1L;

	/*
	 * 任务执行状态
	 */
	private Integer status;
	
	/*
	 * 任务执行信息
	 */
	private String message;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}

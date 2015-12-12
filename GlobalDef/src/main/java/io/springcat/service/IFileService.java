/**
 * 
 */
package io.springcat.service;

import io.springcat.dto.ExecuteStatusDTO;
import io.springcat.exception.FileNotExistsException;
import io.springcat.exception.ServerTooBusyException;

/**
 * @author adampeng
 *
 */
public interface IFileService {

	/**
	 * 通知文件服务器进行业务计算
	 * @return 任务执行结果
	 * @throws FileNotExistsException   目标文件不存在
	 * @throws ServerTooBusyException   服务器节点正忙，稍后再试
	 */
	ExecuteStatusDTO calData(Object sourceData) throws FileNotExistsException, ServerTooBusyException; 
	
}

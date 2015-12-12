/**
 * 
 */
package io.springcat.service.stub;

import io.springcat.dto.ExecuteStatusDTO;
import io.springcat.exception.FileNotExistsException;
import io.springcat.exception.ServerTooBusyException;
import io.springcat.service.IFileService;

/**
 * @author adampeng
 *
 */
public class FileServiceStub implements IFileService {
	
	private final IFileService fileService;

	public FileServiceStub(IFileService fileService) {
		this.fileService = fileService;
	}
	
	/**
	 * AOP，做容错处理
	 */
	@Override
	public ExecuteStatusDTO calData(Object object) {
		try{
			return fileService.calData(object);
		}catch(FileNotExistsException fne){
			//文件不存在，错误信息写库或写mq等待处理
			return null;
		}catch(ServerTooBusyException stbe){
			//服务器繁忙，等待后重试
			//可通过ThreadLocal 记录 重试次数，限定重试次数
			return null;
		}
	}

}

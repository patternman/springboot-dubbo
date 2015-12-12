/**
 * 
 */
package io.springcat.internal.service.impl;

import io.springcat.dto.ExecuteStatusDTO;
import io.springcat.exception.FileNotExistsException;
import io.springcat.exception.ServerTooBusyException;
import io.springcat.service.IFileService;

/**
 * @author adampeng
 *
 */
public class FileService implements IFileService {

	/* (non-Javadoc)
	 * @see io.springcat.service.IFileService#calData()
	 */
	@Override
	public ExecuteStatusDTO calData(Object sourceData) throws FileNotExistsException,
			ServerTooBusyException {
		return new ExecuteStatusDTO();
	}

}

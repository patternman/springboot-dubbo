/**
 * 
 */
package io.springcat.external.controller;

import io.springcat.dto.ExecuteStatusDTO;
import io.springcat.dto.UserDTO;
import io.springcat.exception.FileNotExistsException;
import io.springcat.exception.ServerTooBusyException;
import io.springcat.service.IFileService;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author adampeng
 *
 */
@RestController
@RequestMapping("/file")
public class FileController {
	
	@Autowired @Qualifier("fileServiceDubbo")
	IFileService fileServiceDubbo;
	@Autowired @Qualifier("fileServiceRMI")
	IFileService fileServiceRMI;
	
	static final String _1kbString;
	
	static final String _1mbString;
	
	static final String transString;
	
	static{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 1024 ; i++){
			sb.append("1");
		}
		_1kbString = new String(sb);
		
		StringBuilder mb = new StringBuilder();
		for(int i = 0 ; i < 1024 ; i++){
			mb.append(_1kbString);
		}
		_1mbString = new String(mb);
		
		StringBuilder sourceData = new StringBuilder();
		for(int i = 0; i < 10; i++){
			sourceData.append(_1mbString);
		} 
		
		transString = new String(sourceData);
		
		System.out.println("transString size = " + transString.length() + "bytes");
	}
	
	@RequestMapping(value="/bigdata", method=RequestMethod.GET)
	public ExecuteStatusDTO bigdata(@PathParam("protocol") String protocol){
		switch(protocol){
		case "dubbo":
			return fileServiceDubbo.calData(transString);
		case "rmi":
			return fileServiceRMI.calData(transString);
		default:
			throw new IllegalAccessError("不支持该版本调用！");
		}
	}
	
	@RequestMapping(value="/smalldata", method=RequestMethod.GET)
	public ExecuteStatusDTO smalldata(@PathParam("protocol") String protocol){
		switch(protocol){
		case "dubbo":
			return fileServiceDubbo.calData("");
		case "rmi":
			return fileServiceRMI.calData("");
		default:
			throw new IllegalAccessError("不支持该版本调用！");
		}
	}
}

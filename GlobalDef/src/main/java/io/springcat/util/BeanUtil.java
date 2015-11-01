/**  
 * @Title: BeanUtil.java
 * @Prject: GlobalDef
 * @Package: io.springcat.util
 * @Description: TODO
 * @author: adampeng  
 * @date: 2015年4月1日 下午5:51:53
 * @version: V1.0  
 */
package io.springcat.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: BeanUtil
 * @Description: TODO
 * @author: adampeng
 * @date: 2015年4月1日 下午5:51:53
 */
public class BeanUtil {
	
	/**
	 * 拷贝字段时候过滤的字段，如serialVersionUID
	 */
	private static final String[] ftilerFieldNames = {"serialVersionUID","ID","id"};

	private BeanUtil(){
	}
	
	/**
	* @Title: convertBean 
	* @Description: 返回一个targetClass的实例，这个返回结果复制了oriBean里同名同类型的字段的值
	* @param @param oriBean
	* @param @param targetClass
	* @param @return    设定文件 
	* @return T    返回类型 
	* @throws
	 */
	public static <T> T convertBean(Object oriBean, Class<T> targetClass){
		
		if(oriBean == null){
			return null;
		}
		
		Field[] oriFields = oriBean.getClass().getDeclaredFields();
		Field[] targetFields = targetClass.getDeclaredFields();
		
		Map<String,Field> oriNameFieldMap = makeNameMapping(oriFields);
		
		T targetBean = null;
		try {
			targetBean = targetClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		for(Field targetField : targetFields){
			
			if(filterNames(targetField.getName())){
				continue;
			}
			
			targetField.setAccessible(true);
			
			if(oriNameFieldMap.containsKey(targetField.getName())){
				Field oriField = oriNameFieldMap.get(targetField.getName());
				if(oriField.getType().getName().equals(targetField.getType().getName())){
					oriField.setAccessible(true);
					
					try {
						targetField.set(targetBean, oriField.get(oriBean));
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return targetBean;
	}
	
	/**
	* @Title: filterNames 
	* @Description: 判断是否过滤字段
	* @param @param fieldName
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	private static boolean filterNames(String fieldName){
		for(String ftilerFieldName : ftilerFieldNames){
			if(fieldName.equals(ftilerFieldName)){
				return true;
			}
		}
		return false;
	}
	
	/**
	* @Title: makeNameMapping 
	* @Description: 创建名字-field的map
	* @param @param fields
	* @param @return    设定文件 
	* @return Map<String,Field>    返回类型 
	* @throws
	 */
	private static Map<String,Field> makeNameMapping(Field[] fields){
		Map<String,Field> map = new HashMap<String,Field>();
		for(Field field : fields){
			map.put(field.getName(), field);
		}
		return map;
	}
	
	
}

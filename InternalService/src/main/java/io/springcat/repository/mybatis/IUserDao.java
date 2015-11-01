/**
 * 
 */
package io.springcat.repository.mybatis;

import io.springcat.po.User;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author adampeng
 *
 */
public interface IUserDao {

	@Select("SELECT * FROM t_user WHERE id = #{id}")
	User get(@Param("id") Long id);
	
}

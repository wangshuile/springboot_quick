/**
 * 
 */
package xyz.nesting.quick.util;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * @Description: 实现toJson和ToString方法
 * @Author qizai
 * @Version: 0.0.1
 * @CreateAt 2016年5月21日-上午10:13:34
 *
 */
public class ZcApiBase {

	public String toJson() {
		return ZcJsonKit.nonNullMapper().toJson(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

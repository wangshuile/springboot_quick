package xyz.nesting.quick.protocol.req;

import org.hibernate.validator.constraints.NotEmpty;

import xyz.nesting.quick.util.ZcAbstractToString;

public class UserReq extends ZcAbstractToString{

	@NotEmpty(message = "mobile is empty")
	private String mobile;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}

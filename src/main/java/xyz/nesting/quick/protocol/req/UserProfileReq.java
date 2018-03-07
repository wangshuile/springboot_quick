package xyz.nesting.quick.protocol.req;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import xyz.nesting.quick.util.ZcAbstractToString;

public class UserProfileReq extends ZcAbstractToString{

	@Size(min=0,max=32,message="名称限制12个字符")
	@NotEmpty(message = "name is empty")
	private String name;

	@Size(min=0,max=32,message="签名限制32个字符")
	private String description = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

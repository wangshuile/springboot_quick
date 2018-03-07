/**
 * 
 */
package xyz.nesting.quick.util;

import java.util.Date;

/**
 * 
 * 
 * @Description: 统一模型定义
 * @Author qizai
 * @Version: 0.0.1
 * @CreateAt 2016年5月22日-上午10:26:55
 *
 */
public abstract class ZcAbstractBaseModel extends ZcAbstractToString{

    /**
     * 主键
     */
    protected String id;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 更新时间
     */
    protected Date updateTime;

    /**
     * 状态
     */
    protected int status;


    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

package xyz.nesting.quick.controller.api;

import xyz.nesting.quick.constant.ErrorCode;
import xyz.nesting.quick.controller.BaseController;
import xyz.nesting.quick.domain.MgUser;
import xyz.nesting.quick.exception.BusinessException;

public abstract class BaseApiController extends BaseController {

	public static final String ROUTER_API_V1 = "/api";

	/**
	 * 获取登录用户uuid
	 * @return
	 */
	protected String getUserUuid() {
		return (String) request.getAttribute("user_uuid");
	}

	/**
	 * 获取登录用户信息
	 * @return
	 */
	protected MgUser getUser() {
		String userUuid = getUserUuid();
		MgUser mgUser = redisUserDao.getByUserUuid(userUuid);
		if (mgUser == null) {
			mgUser = userService.getUserByUserUuid(userUuid);
			if (null == mgUser) {
				// 若无此用户,新建用户信息
				BusinessException.error(ErrorCode.FAILED, "用户未注册");
			}
			// 缓存用户信息半小时
			redisUserDao.setUser(userUuid, mgUser, 1800L);
		}
		return mgUser;
	}

	/**
	 * 获取登录用户id
	 * @return
	 */
	protected String getUserId() {
		return getUser().getId();
	}

	/**
	 * 获取真实客户端ip
	 * @param request
	 * @return
	 */
	protected String getIpAddr() {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip != null && 4 != ip.split(".").length) {
			return "127.0.0.1";
		}
		return ip;
	}
}

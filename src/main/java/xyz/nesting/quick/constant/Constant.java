package xyz.nesting.quick.constant;

public interface Constant {

	/*
	 * 是否评论:未评论
	 */
	int IS_COMMENT_FALSE = 0;
	
	/*
	 * 是否评论:已评论
	 */
	int IS_COMMENT_TRUE = 1;
	
	/*
	 * 交易类型:当面交易
	 */
	int TRADE_TYPE_FACE = 0;
	
	/*
	 * 是否接受竞价:未接受
	 */
	int COMPETE_NOT_ACCEPTED = 0;
	
	/*
	 * 是否接受竞价:已接受
	 */
	int COMPETE_ACCEPTED = 1;
	
	/*
	 * 支付方式:微信app
	 */
	int PAYTYPE_WX = 0;
	
	/*
	 * 支付方式:支付宝app
	 */
	int PAYTYPE_ALI = 1;
	
	/*
	 * 退款状态:退款中
	 */
	int REFUND_WAITING = 0;
	
	/*
	 * 退款状态:已退还
	 */
	int REFUND_SUCCESS = 1;
	
	/*
	 * 个人状态
	 */
	int USERSTATUS_TRUE = 1;
	
	/*
	 * 个人状态
	 */
	int USERSTATUS_FALSE = 0;
	
	/*
	 * 是否到账:已到账
	 */
	int WITHWITHDRAWAL_COMPLETED = 1;
	
	/*
	 * 是否到账:未到账
	 */
	int WITHWITHDRAWAL_WAITING = 0;
	
	/*
	 * 提现到账途径:银联
	 */
	int WITHWITHDRAWAL_TYPE_UNION_PAY = 0;
	
	/*
	 * 关注
	 */
	int FOLLOW_TRUE = 1;
	
	/*
	 * 未关注
	 */
	int FOLLOW_FALSE = 0;
}

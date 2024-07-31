/**
* 后台程序自动生成，请勿手工修改
*
* Copyright (c) 2010 by ust.hundsuncom.
*/
package com.example.microsoftrewards.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.NumberFormat;

public class F27207Export {
	/**
	 * 营业部号
	 */
	@ExcelProperty(value = "营业部号", order = 1)
	private Integer branchNo;
	/**
	 * 客户编号
	 */
	@ExcelProperty(value = "客户编号", order = 2)
	private String clientId;
	/**
	 * 客户姓名
	 */
	@ExcelProperty(value = "客户姓名", order = 3)
	private String clientName;
	/**
	 * 资产账户
	 */
	@ExcelProperty(value = "资产账号", order = 4)
	private String fundAccount;
	/**
	 * 资产账号所属公司,0-恒生 1-非恒生
	 */
	@ExcelProperty(value = "所属公司", order = 5)
	private Integer fundAccountComp;
	/**
	 * 机构标志
	 */
	@ExcelProperty(value = "机构标志", order = 6)
	@NumberFormat("1048")
	private String organFlag;
	/**
	 * 资产属性
	 */
	@ExcelProperty(value = "资产属性", order = 7)
	@NumberFormat("3002")
	private String assetProp;
	/**
	 * 密码
	 */
	@ExcelIgnore
	private String password;
	/**
	 * 证件类别
	 */
	@ExcelProperty(value = "证件类别", order = 8)
	@NumberFormat("1041")
	private String idKind;
	/**
	 * 证件号码
	 */
	@ExcelProperty(value = "证件号码", order = 9)
	private String idNo;
	/**
	 * 资产账号状态
	 */
	@ExcelProperty(value = "资产账号状态", order = 10)
	@NumberFormat("1000")
	private String fundacctStatus;
	/**
	 * 允许委托方式
	 */
	@ExcelProperty(value = "允许委托方式", order = 11)
	private String enEntrustWay;
	/**
	 * 客户权限
	 */
	@ExcelProperty(value = "客户权限", order = 12)
	private String clientRights;
	/**
	 * 独立线程标志
	 */
	@ExcelProperty(value = "独立线程标志", order = 13)
	private String singleThreadFlag;
	/**
	 * 后台费用属性
	 */
	@ExcelProperty(value = "后台费用属性", order = 14)
	private String bfareKind;

	/**
	 * 证券资产账户
	 */
	@ExcelProperty(value = "证券资产账户", order = 15)
	private String fundAccountSecu;
	/**
	 * 委托来源
	 */
	@ExcelProperty(value = "委托来源", order = 16)
	@NumberFormat("36017")
	private String entrustSrc;

	/**
	 * 系统节点编号
	 */
	@ExcelProperty(value = "系统节点编号", order = 17)
	private Integer ustSysnodeID;
	/**
	 * 登入失败次数
	 */
	@ExcelProperty(value = "登入失败次数", order = 18)
	private Integer failLoginTimes;
	/**
	 * 盈亏计算方式
	 */
	@ExcelProperty(value = "盈亏计算方式")
	@NumberFormat("3004")
	@ExcelIgnore
	private String profitFlag;

	/**
	 * 产品序号
	 */
	@ExcelProperty("产品序号")
	@ExcelIgnore
	private Integer productID;

	/**
	 * 账号支持的市场
	 */
	@ExcelProperty(value = "账号支持的市场")
	@ExcelIgnore
	private Integer acctExch;
	/**
	 * 账号类型
	 */
	@ExcelProperty(value = "账号类型")
	@ExcelIgnore
	private String acctType;

	/**
	 * 账户是否锁定
	 */
	@ExcelProperty(value = "账户是否被锁定")
	@ExcelIgnore
	private String loginFailLock;

}
package me.zhyd.springboot.poi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class WordParam {
	private String name;// 名字
	private String company;// 公司
	private String depart;// 部门
	private String position;// 职位
	private String jobContent;// 工作职责
	private String performance;// 个人业绩
	private String power;// 个人能力
	private String learnSituation;// 学习情况
	private String suggestion;// 对公司建议
	private String year;
	private String month;
	private String day;
	private String quarter;// 季度

}

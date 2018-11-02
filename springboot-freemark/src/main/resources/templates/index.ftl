<!DOCTYPE html> 
<html lang="en">
<head>
    <title>Freemarker 语法大全</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <style>
        html {
            font-size: 14px;
            font-weight: 400;
        }
        .exp {
            font-size: 12px;
            color: lightgray;
        }
    </style>
</head>
<body>
<p>当前时间：${.now?string("yyyy-MM-dd HH:mm:ss.sss")}</p>
<dl>
    <dt>list长度：<span class="exp">${list?size}</span></dt>
    <dt>列表</dt>
        <#list list as item>
        	<dd>${item }, 索引：${item_index }，hasNext：${item_has_next}</dd>
        </#list>

    <dt>数字遍历</dt>
        <#list 1..3 as item>
            <dd>数字${item}</dd>
        </#list>

    <dt>map</dt>
        <#list map?keys as key>
            <dd>${map[key]}, 索引：${key_index }，hasNext：${key_has_next}</dd>
        </#list>
</dl>
<dl>
    <dt>字符串</dt>
    <dd>普通字符串：<span class="exp">${name}</span></dd>
    <dd>非html编码：<span class="exp">${htmlText}</span></dd>
    <dd>html编码：<span class="exp">${htmlText?html}</span></dd>
    <dd>首字母大写：<span class="exp">${name?cap_first}</span></dd>
    <dd>首字母小写：<span class="exp">${name?uncap_first}</span></dd>
    <dd>全小写：<span class="exp">${name?lower_case}</span></dd>
    <dd>全大写：<span class="exp">${name?upper_case}</span></dd>
    <dd>去除首位空格：<span class="exp">${name?trim}</span></dd>
    <dd>空字符串：<span class="exp">${null?if_exists}</span></dd>
    <dd>是否包含某个字符串：<span class="exp">${name?contains("wWw")?string}</span></dd>
    <dd>默认值：<span class="exp">${null?default("空值默认")}</span></dd>
    <dd>“${name}”字符串长度：<span class="exp">${name?length}</span></dd>
    <dd>定义字符串：<span class="exp">str=码一码<#assign str="码一码"/></span></dd>
    <dd>字符串拼接(1)：<span class="exp">${"字符串拼接 + " + str}</span></dd>
    <dd>字符串拼接(2)：<span class="exp">${"字符串拼接 + ${str}"}</span></dd>
    <dd>字符串截取单个字符(1)：<span class="exp">${str[1]}</span></dd>
    <dd>字符串截取(2)：<span class="exp">${str?substring(1)}</span></dd>
    <dd>字符串截取(3)：<span class="exp">${str?substring(1,2)}</span></dd>
    <dd>indexOf：<span class="exp">${str?index_of("一")}</span></dd>
    <dd>split分割字符串：<span class="exp">
    <#list "a|b|c"?split("|") as item>
        ${item}
    </#list>
    </span></dd>
    <dd>if...elseif...else：<span class="exp">
			<#if null == ''>
				匹配if显示
            <#elseif null == '1'>
				匹配elseif显示
            <#else>
				匹配else显示
            </#if></span>
    </dd>
</dl>

<dl>
    <dt>switch</dt>
    <dd>
        <#switch str>
            <#case "你好">
                匹配“你好”
                <#break >
            <#case "码一码">
                匹配“码一码”
                <#break >
            <#default>
                默认匹配
        </#switch>
    </dd>
</dl>

<dl>
    <dt>数字</dt>
    <dd>普通数字：<span class="exp">${num}</span></dd>
    <dd>数字类型：<span class="exp">${num?string.number}</span></dd>
    <dd>货币类型：<span class="exp">${num?string.currency}</span></dd>
    <dd>百分比类型：<span class="exp">${num?string.percent}</span></dd>
    <dd>格式化数字：<span class="exp">${num?string("#.###")}</span></dd>
    <dd>取数字的整数部分：<span class="exp">${num?int}</span></dd>
</dl>

<dl>
    <dt>运算符</dt>
    <dd>不等于：!= <span class="exp">例如：${(1 != 2)?string('1 != 2', '1 == 2')}</span></dd>
    <dd>等于：== <span class="exp">例如：${(1 == 1)?string('1 == 1', '1 != 1')}</span></dd>
    <dd>大于(1)：> <span
            class="exp">例如：${(2 > 1)?string('2 > 1', '2 < 1')}。<strong>注：使用> 时必须加括号，否则可能会被当成普通的标签闭合符号而引起报错</strong></span>
    </dd>
    <dd>大于(2)：gt <span class="exp">例如：${(2 gt 1)?string('2 gt 1', '2 lte 1')}</span></dd>
    <dd>大于等于：gte <span class="exp">例如：${(2 gte 2)?string('2 gte 2', '2 lt 2')}</span></dd>
    <dd>小于(1)：< <span
            class="exp">例如：${(1 < 2)?string('1 < 2', '1 > 2')}。<strong>注：使用< 时必须加括号，否则可能会被当成普通的标签闭合符号而引起报错</strong></span>
    </dd>
    <dd>小于(2)：lt <span class="exp">例如：${(1 lt 2)?string('1 lt 2', '1 gte 2')}</span></dd>
    <dd>小于等于：lte <span class="exp">例如：${(2 lte 2)?string('2 lte 2', '2 gt 2')}</span></dd>
</dl>

<dl>
    <dt>boolean</dt>
    <dd>普通boolean输出：<span class="exp">${bol}</span></dd>
    <dd>boolean判断输出：<span class="exp">${bol?string('true的时候显示','false的时候显示')}</span></dd>
</dl>

<dl>
    <dt>日期</dt>
    <dd>${dateObj?date}</dd>
    <dd>${dateObj?time}</dd>
    <dd>${dateObj?string("yyyy-MM-dd HH:mm:ss.SSS")}</dd>
</dl>

<dl>
    <dt>import</dt>
    <dd>
        <#import "import.ftl" as importObj>
        <p>${importObj.importStr}</p>
        <p>${importObj.importStr1}</p>
    </dd>
</dl>

<dl>
    <dt>macro宏模板</dt>
    <dd>
        <#macro listMacro title items>
            <p>${title?cap_first}:
            <ul>
               <#list items as item>
                   <li>${item?cap_first}</li>
               </#list>
            </ul>
            <#nested >
        </#macro>
    </dd>
    <dd>
        <@listMacro items=["item1", "item2", "item3"] title="Items">
            nested标签表示可以插入自定义的内容
        </@listMacro>
    </dd>
</dl>


👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇 include 👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇
<#include "eclipse.ftl">
</body>
</html>

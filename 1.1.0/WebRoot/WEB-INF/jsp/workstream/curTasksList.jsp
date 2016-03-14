<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
    <title>待我审批</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body> 

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 待我审批
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<form>
	<input type="hidden" name="pageNum" value="1" />
</form>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
				<td width="250">标题</td>
				<td width="115">申请人</td>
				<td width="115">申请日期</td>
				<td>相关操作</td>
			</tr>
		</thead>		
		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="formList">
       		<s:iterator value="#tvList">
			<tr class="TableDetail1 template">
				<td><s:property value="form.title"/></td>
				<td><s:property value="form.applicant"/></td>
				<td><s:property value="form.approveTime"/></td>
				<td><s:a action="formAction_approveWeb?fid=%{form.fid}&&taskId=%{task.id}">审批处理</s:a>
					<a href="#">查看流转记录</a>
				</td>
			</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail"><div id="TableTail_inside"></div></div>
</div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<HTML>
<HEAD>
    <META http-equiv=Content-Type CONTENT="text/html; charset=utf8" />
	<TITLE>OA Test</TITLE>
	<LINK HREF="css/blue/login.css" type=text/css rel=stylesheet />
</HEAD>

<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 CLASS=PageBody >
<s:form action="userAction_login.action">
    <DIV ID="CenterAreaBg">
        <DIV ID="CenterArea">
            <DIV ID="LogoImg"><IMG BORDER="0" SRC="css/blue/images/logo.png" /></DIV>
            <DIV ID="LoginInfo">
                <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
                <tr>
                	<td colspan="3"><font color="red"><s:property value="#session.errorMsg"></s:property></font> </td>
                </tr>
                    <TR>
                        <TD width=45 CLASS="Subject"><IMG BORDER="0" SRC="css/blue/images/login/userId.gif" /></TD>
                        
                        <TD><s:textfield name="username" cssClass="TextField"></s:textfield></TD>
                        <TD ROWSPAN="2" STYLE="padding-left:10px;"><INPUT TYPE="image" SRC="css/blue/images/login/userLogin_button.gif"/></TD>
                    </TR>
                    <TR>
                        <TD CLASS="Subject"><IMG BORDER="0" SRC="css/blue/images/login/password.gif" /></TD>
                        <TD><s:password name="password" cssClass="TextField"></s:password></TD>
                    </TR>
                </TABLE>
            </DIV>
            <DIV ID="CopyRight"><A HREF="javascript:void(0)">&copy; 2016 All Copyrights by Leibniz.hu</A></DIV>
        </DIV>
    </DIV>
</s:form>
</BODY>

</HTML>
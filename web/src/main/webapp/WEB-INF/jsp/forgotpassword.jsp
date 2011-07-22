<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="<c:url value="/resources/static/styles/forgotpassword.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/static/styles/error.css"/>"
	rel="stylesheet" type="text/css" />	
	
<div id="content">
<h1 class="notopmargin">Password Retrieval</h1>
<p class="paragraph_style_1">Forgot your password. Please enter your
email addres below and your password will be emailed to you.</p>


<c:if test="${not empty errorMessages}">
	<div id="errormessage">
	<table width="95%">
		<c:forEach items="${errorMessages}" var="errorMessage">
			<tr>
				<td><img
					src="<c:url value="/resources/static/images/error_icon.png"/>" width="15"
					height="15" /></td>
				<td><c:out value="${errorMessage}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</c:if> 


<form:form  modelAttribute="forgotPasswordVO" action="forgotPasswordProcess" method="post" class="contentmargin">
<fieldset>
<table width="90%">
	<tr>
		<td width="30%"><label>Username</label></td>
		<td width="15%"></td>
		<td width="30%"><label>Email Address</label></td>
		<td width="45%"></td>
	</tr>
	<tr>
		<td><form:input path="username" type="text" /></td>
		<td>
		<div style="text-align: center">OR</div>
		</td>
		<td><form:input path="emailAddress" type="text" /></td>
		<td><input name="submit" type="submit" class="button"
			value="Submit" /></td>
	</tr>
</table>
</fieldset>
</form:form>
</div>

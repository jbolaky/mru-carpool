<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="<c:url value="/resources/styles/login.css"/>"
	rel="stylesheet" type="text/css" />
<div id="content">
<h1 class="notopmargin">Login</h1>
<p class="paragraph_style_1">Please log in using your Username and
Password.</p>
<form action="loginProcess" method="post"
	class="contentmargin">
<fieldset>
<table width="90%">
	<tr>
		<td width="45%"><label>Username</label></td>
		<td width="45%"><label>Password</label></td>
		<td width="45%"></td>
	</tr>
	<tr>
		<td><input name="j_username" type="text" /></td>
		<td><input name="j_password" type="password" /></td>
		<td><input name="submit" type="submit" class="button"
			value="Log In" /></td>
	</tr>
</table>
</fieldset>
<fieldset>
<div style="float: left; margin-bottom: 3px; width: 40%;"></div>
<div><a class="common_link_style" href="<c:url value="forgotpassword"/>"/>Forgotton
your password?</a></div>
</fieldset>
</form>
<p style="font-size: 95%">Not a member? <a class="common_link_style"
	href="<c:url value="registeruser"/>">Register Here FREE</a></p>
</div>

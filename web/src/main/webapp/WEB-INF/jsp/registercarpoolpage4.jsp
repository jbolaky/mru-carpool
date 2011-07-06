<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="<c:url value="/resources/styles/registercarpoolpage4.css"/>"
	rel="stylesheet" type="text/css" />
<div id="content">
<h1 class="notopmargin">Confirmation Message</h1>
<p>Thank you. Your pool has been added.</p>
<form:form action="${flowExecutionUrl}" method="post">
	<table align="center" width="30%">
		<tr>
			<td width="10%"><label>Name:</label></td>
			<td>Loremsum</td>
			<td width="10%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><label>From:</label></td>
			<td>Adeline</td>
			<td><label>To:</label></td>
			<td>Berrimah</td>
		</tr>
		<tr>
			<td><label>Dept.Time:</label></td>
			<td>0045</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div class="topspace buttons"><input class="button"
		name="_eventId_previousstep" type="submit"
		value="Click Here To Go Back" /><input class="button" name="_eventId_confirm"
		type="submit" value="Click Here To Register Carpool" /></div></div>
</form:form>

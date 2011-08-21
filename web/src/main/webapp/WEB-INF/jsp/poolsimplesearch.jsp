<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="content">
<h1 class="notopmargin">Search Car Pools - Simple Search</h1>
<p class="paragraph_style_1" align="right"><a
	class="common_link_style" href="<c:url value="pooladvancesearch"/>">Advanced
Search Options</a></p>
<form:form modelAttribute="poolSearchVO" action="searchpool"
	method="post" class="contentmargin">
	<fieldset>
	<table width="95%">
		<tr>
			<td width="45%" colspan="2">
			<h2 class="item" style="margin-top: 0%;">Travelling From</h2>
			</td>
			<td width="45%" colspan="2">
			<h2 class="item" style="margin-top: 0%;">Travelling To</h2>
			</td>
		</tr>
		<tr>
			<td width="25%"><label>District</label></td>
			<td width="25%"><label>Region</label></td>
			<td width="25%"><label>District</label></td>
			<td width="25%"><label>Region</label></td>
		</tr>
		<tr>
			<td><form:select path="fromDistictCode">
				<form:option value="">--SELECT--</form:option>
				<form:option value="MU">Mauritius</form:option>
			</form:select></td>
			<td><form:select path="fromAreaCode">
				<form:option value="">--SELECT--</form:option>
				<form:option value="MU">Mauritius</form:option>
			</form:select></td>
			<td><form:select path="toDistrictCode">
				<form:option value="">--SELECT--</form:option>
				<form:option value="MU">Mauritius</form:option>
			</form:select></td>
			<td><form:select path="toAreaCode">
				<form:option value="">--SELECT--</form:option>
				<form:option value="MU">Mauritius</form:option>
			</form:select></td>
		</tr>
	</table>
	<div class="topspace buttons"><input class="button"
		name="register" type="submit" value="Find Available Car Pool" /></div>
	</fieldset>
</form:form></div>

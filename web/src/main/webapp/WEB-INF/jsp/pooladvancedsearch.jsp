<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link
	href="<c:url value="/resources/static/jQuery/css/ui-lightness/jquery-ui.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/resources/static/jQuery/css/jquery-ui-timepicker.css"/>"
	rel="stylesheet" type="text/css" />
<script
	src="<c:url value="/resources/static/jQuery/js/jquery-ui-1.8.14.custom.min.js"/>"
	type="text/javascript"></script>
<script
	src="<c:url value="/resources/static/jQuery/js/jquery.ui.timepicker.js"/>"
	type="text/javascript"></script>

<script>
	$(function() {

		$('#earliestDepartureTime').timepicker();
		$('#latestDepartureTime').timepicker();
	});
</script>

<div id="content">
<h1 class="notopmargin">Search Car Pools - Advanced Search</h1>
<p class="paragraph_style_1" align="right"><a
	class="common_link_style" href="<c:url value="poolsimplesearch"/>">Simple
Search Options</a></p>
<form:form modelAttribute="poolSearchVO" action="searchpool" method="post"
	class="contentmargin">
	<fieldset>
	<table width="95%">
		<tr>
			<td><label>Travel Days:</label></td>
		</tr>
		<tr>
			<td><form:checkbox path="mondaySelected" />Monday</td>
			<td><form:checkbox path="tuesdaySelected" />Tuesday</td>
			<td><form:checkbox path="wednesdaySelected" />Wednesday</td>
			<td><form:checkbox path="thursdaySelected" />Thursday</td>
		</tr>
		<tr>
			<td><form:checkbox path="fridaySelected" />Friday</td>
			<td><form:checkbox path="saturdaySelected" />Saturday</td>
			<td><form:checkbox path="sundaySelected" />Sunday</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<table class="topspace" width="95%">
		<tr>
			<td><label>Earliest Departure Time:</label></td>
			<td><form:input path="earliestDepartureTime"
				id="earliestDepartureTime" type="text" /></td>
			<td><label>Latest Departure Time:</label></td>
			<td><form:input path="latestDepartureTime"
				id="latestDepartureTime" type="text" /></td>
		</tr>
	</table>
	<p>Note: if you don't specify a "to" time, the search will return
	only those matching the "from" time. If you specify a time range, the
	search will return those matching the range searched for.</p>
	<table width="95%">
		<tr>
			<td><label>One Way Travel:</label></td>
			<span id="spryradio1">
			<td><form:radiobutton type="radio" path="oneWayTravel"
				value="true" id="Journey_0" /> <label>Yes</label></td>
			<td><form:radiobutton type="radio" path="oneWayTravel"
				value="false" id="Journey_1" /> <label>No</label></td>
			</span>
		</tr>
	</table>

	<table class="topspace" width="95%">
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

	<table class="topspace" width="95%">
		<tr>
			<td width="20%"><label>Age Group:</label></td>
			<td width="50%"><form:select path="ageGroup">
				<form:option value="">--SELECT-</form:option>
				<form:option value="25">18-25</form:option>
				<form:option value="32">26-32</form:option>
				<form:option value="40">33-40</form:option>
				<form:option value="1000">40+</form:option>
			</form:select></td>
			<td width="30%"><label>Number of interested passengers:</label></td>
			<td width="5%"><form:input path="numberOfPassengers" type="text" /></td>
		</tr>
		<tr>
			<td><label>Driver Gender:</label></td>
			<span id="spryradio2">
			<td><form:radiobutton type="radio" path="driverGender" value="M"
				id="driverGender_0" /> Male Only</td>
			<td><form:radiobutton type="radio" path="driverGender" value="F"
				id="driverGender_1" /> Female Only</td>
			<td><form:radiobutton type="radio" path="driverGender" value="B"
				id="driverGender_2" /> Both</td>
			</span>
		</tr>
		<tr>
			<td><label>Share Costs:</label></td>
			<span id="spryradio3">
			<td><form:radiobutton type="radio" path="shareCost" value="true"
				id="shareCost_0" /> Yes</td>
			<td><form:radiobutton type="radio" path="shareCost" value="false"
				id="shareCost_1" /> No</td>
			</span>
		</tr>
	</table>

	<div class="topspace buttons"><input class="button"
		name="register" type="submit" value="Find Available Car Pool" /></div>
	</fieldset>
</form:form></div>
<script type="text/javascript">
	var spryradio1 = new Spry.Widget.ValidationRadio("spryradio1");
	var spryradio2 = new Spry.Widget.ValidationRadio("spryradio2");
	var spryradio3 = new Spry.Widget.ValidationRadio("spryradio3");
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link href="<c:url value="/resources/styles/registercarpoolpage2.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/styles/error.css"/>"
	rel="stylesheet" type="text/css" />
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

		$("#startingPoolDate").datepicker({
			dateFormat : 'dd/mm/yy'
		}).datepicker({
			showAnim : 'slideDown'
		});
		;
		
		$("#endOfPoolDate").datepicker({
			dateFormat : 'dd/mm/yy'
		}).datepicker({
			showAnim : 'slideDown'
		});
		;
		
		$('#departureTime').timepicker();
	});
</script>

<div id="content">
<h1 class="notopmargin">Car Pool Details</h1>

<spring:hasBindErrors name="carPoolRegistrationVO">
	<div id="errormessage">
	<table width="95%">
		<spring:bind path="carPoolRegistrationVO.*">
			<c:forEach items="${status.errorMessages}" var="error">
				<tr>
					<td><img
						src="<c:url value="/resources/images/error_icon.png"/>" width="15"
						height="15" /></td>
					<td><c:out value="${error}" /></td>
				</tr>
			</c:forEach>
		</spring:bind>
	</table>
	</div>
</spring:hasBindErrors> <form:form modelAttribute="carPoolRegistrationVO"
	action="${flowExecutionUrl}" method="post" class="contentmargin">
	<fieldset>

	<table width="95%">
		<tr>
			<td><label>Pool Name:</label></td>
			<td><label>Starting Pool Date:</label></td>
			<td><label>End Of Pool Date:</label></td>
			<td><label>Departure Time:</label></td>
			<td><label>No. Current Passengers:</label></td>
		</tr>
		<tr>
			<td><form:input path="poolName" type="text" /></td>
			<td><form:input path="startingPoolDate" id="startingPoolDate"
				type="text" /></td>
			<td><form:input path="endOfPoolDate" id="endOfPoolDate" type="text" /></td>
			<td><form:input path="departureTime" id="departureTime" type="text" /></td>
			<td><form:input path="numberOfCurrentPassengers" type="text" /></td>
		</tr>
	</table>

	<h2 class="item">From</h2>
	<p>To list all suburbs in your State, select State, change Region
	to Search All and then select the Suburb.</p>
	<table width="95%">
		<tr>
			<td width="25%"><label>District:</label></td>
			<td width="25%"><label>Region:</label></td>
		</tr>
		<tr>
			<td><form:select path="fromAreaCode">
				<form:option value="">--SELECT--</form:option>
				<form:option value="MU">Mauritius</form:option>
			</form:select></td>
			<td><form:select path="fromDistrictCode">
				<form:option value="">--SELECT--</form:option>
				<form:option value="MU">Mauritius</form:option>
			</form:select></td>
		</tr>
	</table>

	<table width="95%" class="topspace">
		<tr>
			<td><label>One Way or Return?</label></td>
			<span id="spryradio1">
			<td><form:radiobutton type="radio" path="oneWayTravel"
				value="true" id="journey_0" /> <label>Yes</label></td>
			<td><form:radiobutton type="radio" path="oneWayTravel"
				value="false" id="journey_1" /> <label>No</label></td>
			</span>
		</tr>
		<tr>
			<td><label>Preferred Gender To Travel With:</label></td>
			<span id="spryradio2">
			<td><form:radiobutton type="radio" path="genderToTravelWith"
				value="M" id="genderToTravelWith_0" /> <label>Male Only</label></td>
			<td><form:radiobutton type="radio" path="genderToTravelWith"
				value="F" id="genderToTravelWith_1" /> <label>Female Only</label></td>
			<td><form:radiobutton type="radio" path="genderToTravelWith"
				value="M" id="genderToTravelWith_2" /> <label>Both</label></td>
			</span>
		</tr>
		<tr>
			<td><label>Share Costs:</label></td>
			<span id="spryradio3">
			<td><form:radiobutton type="radio" path="shareCost" value="true"
				id="shareCost_0" /> <label>Yes</label></td>
			<td><form:radiobutton type="radio" path="shareCost"
				value="false" id="shareCost_1" /> <label>No</label></td>
			</span>
		</tr>
	</table>
	<div class="topspace buttons"><input class="button"
		name="_eventId_previousstep" type="submit"
		value="Previous Step - Personal Details" /> <input class="button"
		name="_eventId_nextstep" type="submit"
		value="Next Step - Travel Details" /></div>
	</fieldset>
</form:form></div>
<script type="text/javascript">
	var spryradio1 = new Spry.Widget.ValidationRadio("spryradio1");
	var spryradio1 = new Spry.Widget.ValidationRadio("spryradio2");
	var spryradio1 = new Spry.Widget.ValidationRadio("spryradio3");
</script>

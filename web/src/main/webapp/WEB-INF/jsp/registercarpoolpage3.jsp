<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link href="<c:url value="/resources/static/styles/registercarpoolpage3.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/static/styles/error.css"/>"
	rel="stylesheet" type="text/css" />

<div id="content">
<h1 class="notopmargin">Travel Details</h1>

<spring:hasBindErrors name="carPoolRegistrationVO">
	<div id="errormessage">
	<table width="95%">
		<spring:bind path="carPoolRegistrationVO.*">
			<c:forEach items="${status.errorMessages}" var="error">
				<tr>
					<td><img
						src="<c:url value="/resources/static/images/error_icon.png"/>" width="15"
						height="15" /></td>
					<td><c:out value="${error}" /></td>
				</tr>
			</c:forEach>
		</spring:bind>
	</table>
	</div>
</spring:hasBindErrors>

<form:form modelAttribute="carPoolRegistrationVO" action="${flowExecutionUrl}" method="post"
	class="contentmargin">
	<fieldset><label>Select the travel Days and the
	amount of seats available for that day</label>
	<table>
		<tr>
			<td width="20%"><form:checkbox path="travelOnMonday" type="checkbox" value="true" />Monday</td>
			<td><form:input path="numberOfAvailableSeatsOnMonday" type="text"
				value="0" class="seatsAvailable" /></td>
			<td width="20%"><form:checkbox path="travelOnTuesday" type="checkbox" value="true" />Tuesday</td>
			<td><form:input path="numberOfAvailableSeatsOnTuesday" type="text"
				value="0" class="seatsAvailable" /></td>
			<td width="20%"><form:checkbox path="travelOnWednesday" type="checkbox" value="true" />Wednesday</td>
			<td><form:input path="numberOfAvailableSeatsOnWednesday" type="text"
				value="0" class="seatsAvailable" /></td>
		</tr>
		<tr>
			<td><form:checkbox path="travelOnThursday" type="checkbox" value="true" />Thursday</td>
			<td><form:input path="numberOfAvailableSeatsOnThursday" type="text"
				value="0" class="seatsAvailable" /></td>
			<td><form:checkbox path="travelOnFriday" type="checkbox" value="true" />Friday</td>
			<td><form:input path="numberOfAvailableSeatsOnFriday" type="text"
				value="0" class="seatsAvailable" /></td>
		</tr>
		<tr>
			<td><form:checkbox path="travelOnSaturday" type="checkbox" value="true" />Saturday</td>
			<td><form:input path="numberOfAvailableSeatsOnSaturday" type="text"
				value="0" class="seatsAvailable" /></td>
			<td><form:checkbox path="travelOnSunday" type="checkbox" value="true" />Sunday</td>
			<td><form:input path="numberOfAvailableSeatsOnSunday" type="text"
				value="0" class="seatsAvailable" /></td>
		</tr>
	</table>
	<p>Note: You must specify how many seats are available in the field
	after the day you selected</p>
	<h2 class="item">To</h2>
	<table width="95%">
		<tr>
			<td width="25%"><label>District:</label></td>
			<td width="25%"><label>Region:</label></td>
		</tr>
		<tr>
			<td><form:select path="toAreaCode">
				<form:option value="">--SELECT--</form:option>
				<form:option value="MU">Mauritius</form:option>
			</form:select></td>
			<td><form:select path="toDistrictCode">
				<form:option value="">--SELECT--</form:option>
				<form:option value="MU">Mauritius</form:option>
			</form:select></td>
		</tr>
	</table>
	<p>To list all suburbs in your State, select State, change Region
	to Search All and then select the Suburb.</p>
	<table width="95%">
		<tr>
			<td><label>Additional Details:</label></td>
		</tr>
		<tr>
			<td><form:textarea path="additionalDetails" cols="50%" rows="5%"/>
			</td>
		</tr>
	</table>

	<div class="topspace buttons"><input class="button"
		name="_eventId_previousstep" type="submit"
		value="Previous Step - Car Pool Details" /> <input class="button"
		name="_eventId_nextstep" type="submit"
		value="Next Step -  Complete Registration" /></div>
	</fieldset>
</form:form></div>

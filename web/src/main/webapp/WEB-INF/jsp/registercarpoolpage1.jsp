<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link href="<c:url value="/resources/styles/registercarpoolpage1.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/styles/error.css"/>"
	rel="stylesheet" type="text/css" />

<div id="content">
<h1 class="notopmargin">Password Information</h1>

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
</spring:hasBindErrors> 
<form:form modelAttribute="carPoolRegistrationVO"
	action="${flowExecutionUrl}" method="post" class="contentmargin">
	<fieldset>
	<table width="95%">
		<tr>
			<td><label>Pool type:</label></td>
			<td colspan="2"><form:select path="poolCode">
				<option>--SELECT--</option>
				<form:option value="1">Car Pool</form:option>
				<form:option value="2">Van Pool</form:option>
			</form:select></td>
		</tr>
		<tr>
			<td width="40%" height="30%"><label>Car Owner:</label></td>
			<span id="spryradio1">
			<td><form:radiobutton type="radio" path="carOwner" value="true"
				id="carOwner_0" /> <label>Yes</label></td>
			<td><form:radiobutton type="radio" path="carOwner" value="false"
				id="carOwner_1" /> <label>No</label></td>
			</span>
		</tr>
		<tr>
			<td><label>Valid Licence:</label></td>
			<span id="spryradio2">
			<td><form:radiobutton type="radio" path="validLicense"
				value="true" id="validLincense_0" /> <label>Yes</label></td>
			<td><form:radiobutton type="radio" path="validLicense"
				value="false" id="validLincense_1" /> <label>No</label></td>
			</span>
		</tr>
		<tr>
			<td><label>Are you a smoker?</label></td>
			<span id="spryradio4">
			<td><form:radiobutton type="radio" path="smoker" value="true"
				id="smoker_0" /> <label>Yes</label></td>
			<td><form:radiobutton type="radio" path="smoker" value="false"
				id="smoker_1" /> <label>No</label></td>
			</span>
		</tr>
		<tr>
			<td><label>Vehicle make:</label></td>
			<td colspan="2"><form:select path="vehicleMake">
				<option>--SELECT--</option>
				<form:option value="ALPRM">Alpha Romeo</form:option>
				<form:option value="2">Toyota</form:option>
			</form:select></td>
		</tr>
		<tr>
			<td><label>Vehicle Model:</label></td>
			<td colspan="2"><form:select path="vehicleModel">
				<option>--SELECT--</option>
				<form:option value="1">Spider</form:option>
				<form:option value="2">GT</form:option>
				<form:option value="3">Mito</form:option>
			</form:select></td>
		</tr>
		<tr>
			<td><label>Vehicle Type:</label></td>
			<td colspan="2"><form:select path="vehicleType">
				<option>--SELECT--</option>
				<form:option value="1">Sedan</form:option>
				<form:option value="2">Couper</form:option>
			</form:select></td>
		</tr>
		<tr>
			<td><label>Maximun number of seats available:</label></td>
			<td><form:input path="maxNumberOfSeats" type="text" /></td>
		</tr>
	</table>
	<div class="topspace buttons"><input class="button"
		name="_eventId_nextstep" type="submit"
		value="Next Step - Travel Details" /></div>
	</fieldset>
</form:form></div>

<script type="text/javascript">
	var spryradio1 = new Spry.Widget.ValidationRadio("spryradio1");
	var spryradio2 = new Spry.Widget.ValidationRadio("spryradio2");
	var spryradio3 = new Spry.Widget.ValidationRadio("spryradio3");
	var spryradio4 = new Spry.Widget.ValidationRadio("spryradio4");
</script>

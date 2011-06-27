<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script
	src="<c:url value="/resources/SpryAssets/SpryValidationRadio.js"/>"
	type="text/javascript"></script>
<link href="<c:url value="/resources/styles/register.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/resources/SpryAssets/SpryValidationRadio.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/styles/error.css"/>"
	rel="stylesheet" type="text/css" />

<div id="content">
<h1 class="contentmargin notopmargin">Your Information</h1>

<c:if test="${not empty errorMessages}">
	<div id="errormessage">
	<table width="95%">
		<c:forEach items="${errorMessages}" var="errorMessage">
			<tr>
				<td><img
					src="<c:url value="/resources/images/error_icon.png"/>" width="15"
					height="15" /></td>
				<td><c:out value="${errorMessage}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</c:if> 

<form:form modelAttribute="userVO" action="saveuser" method="post"
	class="contentmargin">
	<fieldset>
	<h2 class="item" style="margin-top: 0%;">Account Details</h2>
	<table id="account_details" width="100%">
		<tr>
			<td><label>Username:</label></td>
			<td><form:input path="username" type="text" /></td>
			<td><label>Age Group:</label></td>
			<td><form:select path="ageGroup">
				<form:option value="">--SELECT-</form:option>
				<form:option value="25">18-25</form:option>
				<form:option value="32">26-32</form:option>
				<form:option value="40">33-40</form:option>
				<form:option value="1000">40+</form:option>
			</form:select></td>
		</tr>
		<tr>
			<td><label>First Name:</label></td>
			<td><form:input path="firstname" type="text" /></td>
			<td><label>Last Name:</label></td>
			<td><form:input path="lastname" type="text" /></td>
		</tr>
		<tr>
			<td><label>Password:</label></td>
			<td><form:input path="password" type="text" /></td>
			<td><label>Confirm Password:</label></td>
			<td><form:input path="confirmPassword" type="text" /></td>
		</tr>
		<tr>
			<td><label>Email:</label></td>
			<td><form:input path="emailAddress" type="text" /></td>
			<td><label>Confirm Email:</label></td>
			<td><form:input path="confirmEmailAddress" type="text" /></td>
		</tr>
	</table>

	<h2 class="item">Other Details</h2>
	<table width="60%">
		<tr>
			<td width="35%"><label>Car Owner:</label></td>
			<span id="spryradio1">
			<td>
			<div align="center" class="radio_button"><form:radiobutton
				path="carOwner" type="radio" name="RadioGroup1" value="true"
				id="RadioGroup1_0" /> <label>Yes</label></div>
			</td>
			<td>
			<div align="center" class="radio_button"><form:radiobutton
				path="carOwner" type="radio" name="RadioGroup1" value="false"
				id="RadioGroup1_1" /> <label>No</label></div>
			</td>
			</span>
		</tr>
		<tr>
			<td><label>Valid Licence:</label></td>
			<span id="spryradio2">
			<td>
			<div align="center" class="radio_button"><form:radiobutton
				path="validLicense" type="radio" name="RadioGroup2" value="true"
				id="RadioGroup2_0" /> <label>Yes</label></div>
			</td>
			<td>
			<div align="center" class="radio_button"><form:radiobutton
				path="validLicense" type="radio" name="RadioGroup2" value="false"
				id="RadioGroup2_1" /> <label>No</label></div>
			</td>
			</span>
		</tr>
		<tr>
			<td><label>Gender:</label></td>
			<span id="spryradio3">
			<td>
			<div align="center" class="radio_button"><form:radiobutton
				path="gender" type="radio" name="RadioGroup3" value="M"
				id="RadioGroup3_0" /> <label>Male</label></div>
			</td>
			<td>
			<div align="center" class="radio_button"><form:radiobutton
				path="gender" type="radio" name="RadioGroup3" value="F"
				id="RadioGroup3_1" /> <label>Female</label></div>
			</td>
			</span>
		</tr>
	</table>

	<h2 class="item">Your Contact Details</h2>
	<p>To list all suburbs in your State, select State, change Region
	to Search All and then select the Suburb.</p>
	<table class="ur_contact_details" width="90%">
		<tr>
			<td><label>Country:</label></td>
			<td><label>State:</label></td>
			<td><label>Region:</label></td>
		</tr>
		<tr>
			<td><form:select path="countryCode">
				<form:option selected="selected" value="">--SELECT COUNTRY--</form:option>
				<c:forEach items="${countries}" var="countryVO">
					<form:option value="${countryVO.countryId}">
						<c:out value="${countryVO.countryName}" />
					</form:option>
				</c:forEach>
			</form:select></td>
			<td><form:select path="areaCode">
				<form:option selected="selected" value="">--SELECT A COUNTRY--</form:option>
			</form:select></td>
			<td><form:select path="districtCode">
				<form:option selected="selected" value="">--SELECT STATE--</form:option>
			</form:select></td>
		</tr>
	</table>
	<table class="ur_contact_details" width="80%">
		<tr>
			<td><label>Address (street):</label></td>
			<td><label>Phone:</label></td>
		</tr>
		<tr>
			<td><form:input size="40%" type="text" path="addressLine1"
				id="address" /></td>
			<td><form:input size="17%" type="text" path="phoneNumber"
				id="phone" /></td>
		</tr>
	</table>

	<h2 class="item">Your Preferences</h2>
	<form:checkbox path="allowToReceiveUpdates" /> <label>I would
	like to recieve updates on new Car Pools for my area</label>
	<table width="60%" class="topspace">
		<tr>
			<td width="35%"><label>Share Costs:</label></td>
			<span id="spryradio3">
			<td>
			<div align="center" class="radio_button"><form:radiobutton
				path="shareCost" type="radio" name="RadioGroup3" value="true"
				id="RadioGroup3_0" /> <label>Yes</label></div>
			</td>
			<td>
			<div align="center" class="radio_button"><form:radiobutton
				path="shareCost" type="radio" name="RadioGroup3" value="false"
				id="RadioGroup3_1" /> <label>No</label></div>
			</td>
			</span>
		</tr>
		<tr>
			<td><label>Share Driving:</label></td>
			<span id="spryradio4">
			<td>
			<div align="center" class="radio_button"><form:radiobutton
				path="shareDriving" type="radio" name="RadioGroup4" value="true"
				id="RadioGroup4_0" /> <label>Yes</label></div>
			</td>
			<td>
			<div align="center" class="radio_button"><form:radiobutton
				path="shareDriving" type="radio" name="RadioGroup4" value="false"
				id="RadioGroup4_1" /> <label>No</label></div>
			</td>
			</span>
		</tr>
	</table>
	<div class="topspace buttons"><input class="button"
		name="clearform" type="reset" value="Clear Form" /> <input
		class="button" name="register" type="submit" value="Register Now" /></div>
	</fieldset>
</form:form></div>

<script type="text/javascript">
	var spryradio1 = new Spry.Widget.ValidationRadio("spryradio1");
	var spryradio2 = new Spry.Widget.ValidationRadio("spryradio2");
	var spryradio3 = new Spry.Widget.ValidationRadio("spryradio3");
	var spryradio4 = new Spry.Widget.ValidationRadio("spryradio4");
	/* Above are for radio spry buttons */

	$(document).ready(function() {
		// check name availability on focus lost
		$('#countryCode').change(function() {
			if ($('#countryCode').val()) {
				populateAreaDropDown($('#countryCode').val());
			}
		});

		$('#areaCode').change(function() {
			if ($('#areaCode').val()) {
				populateDistrictDropDown($('#areaCode').val());
			}
		});

	});

	function populateAreaDropDown(countryId) {

		$.getJSON("getareas", {
			countryId : countryId
		}, function(areas) {
			$("#areaCode").get(0).options.length = 0;
			$.each(areas, function(index, a) {
				$("#areaCode").get(0).options[index] = new Option(a.areaName,
						a.areaId);
			});
		});
	}

	function populateDistrictDropDown(areaId) {

		$.getJSON("getdistricts", {
			areaId : areaId
		}, function(districts) {
			$("#districtCode").get(0).options.length = 0;
			$.each(districts, function(index, d) {
				$("#districtCode").get(0).options[index] = new Option(
						d.districtName, d.districtId);
			});
		});
	}
</script>
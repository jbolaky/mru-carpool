<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="<c:url value="/resources/styles/registercarpoolpage2.css"/>"
	rel="stylesheet" type="text/css" />
<div id="content">
<h1 class="notopmargin">Car Pool Details</h1>

<form:form action="${flowExecutionUrl}" method="post"
	class="contentmargin">
	<fieldset>

	<table width="95%">
		<tr>
			<td><label>CarPool Name:</label></td>
			<td><label>CarPool Date:</label></td>
			<td><label>No. Current Passengers:</label></td>
		</tr>
		<tr>
			<td><input name="carPoolName" type="text" /></td>
			<td><input name="carPoolDate" type="text" /></td>
			<td><input name="numberPassengers" type="text" /></td>
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
			<td><select name="fromDistrict">
				<option>Mauritius</option>
			</select></td>
			<td><select name="fromRegion">
				<option>Mauritius</option>
			</select></td>
		</tr>
	</table>

	<table width="95%" class="topspace">
		<tr>
			<td><label>One Way or Return?</label></td>
			<span id="spryradio1">
			<td><input type="radio" name="journey" value="radio"
				id="journey_0" /> <label>Yes</label></td>
			<td><input type="radio" name="journey" value="radio"
				id="journey_1" /> <label>No</label></td>
			</span>
		</tr>
		<tr>
			<td><label>Preferred Gender To Travel With:</label></td>
			<span id="spryradio2">
			<td><input type="radio" name="genderToTravelWith" value="radio"
				id="genderToTravelWith_0" /> <label>Male Only</label></td>
			<td><input type="radio" name="genderToTravelWith" value="radio"
				id="genderToTravelWith_1" /> <label>Female Only</label></td>
			<td><input type="radio" name="genderToTravelWith" value="radio"
				id="genderToTravelWith_2" /> <label>Both</label></td>
			</span>
		</tr>
		<tr>
			<td><label>Share Costs:</label></td>
			<span id="spryradio3">
			<td><input type="radio" name="shareCost" value="radio"
				id="shareCost_0" /> <label>Yes</label></td>
			<td><input type="radio" name="shareCost" value="radio"
				id="shareCost_1" /> <label>No</label></td>
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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="<c:url value="/resources/static/styles/registercarpoolpage4.css"/>"
	rel="stylesheet" type="text/css" />
<div id="content">
<h1 class="notopmargin">Confirmation Message</h1>
<p>Thank you. Your pool is nearly added.</p>
<form:form action="${flowExecutionUrl}" method="post">
	<table align="center" width="30%">

		<tr>
			<td width="10%"><label>Pool Name:</label></td>
			<td><c:out value="${carPoolRegistrationVO.poolName}" /></td>
			<td width="10%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td width="10%"><label>Pool Type:</label></td>
			<td><c:out value="${carPoolRegistrationVO.poolType}" /></td>
			<td width="10%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td width="10%"><label>Starting Pool Date and Time:</label></td>
			<td><c:out value="${carPoolRegistrationVO.startingPoolDate}" /></td>
			<td width="10%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td width="10%"><label>End Pool Date:</label></td>
			<td><c:out value="${carPoolRegistrationVO.endOfPoolDate}" /></td>
			<td width="10%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td width="10%"><label>One way travel:</label></td>
			<td><c:out value="${carPoolRegistrationVO.oneWayTravel}" /></td>
			<td width="10%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td width="10%"><label>Preferred gender to travel with:</label></td>
			<td><c:out value="${carPoolRegistrationVO.genderToTravelWith}" /></td>
			<td width="10%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td width="10%"><label>Share Cost:</label></td>
			<td><c:out value="${carPoolRegistrationVO.shareCost}" /></td>
			<td width="10%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td width="10%"><label>From District:</label></td>
			<td><c:out value="${carPoolRegistrationVO.fromAreaCode}" /></td>
			<td width="10%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td width="10%"><label>From Region:</label></td>
			<td><c:out value="${carPoolRegistrationVO.fromDistrictCode}" /></td>
			<td width="10%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td width="10%"><label>To District:</label></td>
			<td><c:out value="${carPoolRegistrationVO.toAreaCode}" /></td>
			<td width="10%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td width="10%"><label>To Region:</label></td>
			<td><c:out value="${carPoolRegistrationVO.toDistrictCode}" /></td>
			<td width="10%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td width="10%"><label>To Travel on each:</label></td>
			<c:if test="${carPoolRegistrationVO.travelOnMonday == 'true'}">
				<td>monday</td>
				<td width="10%">with currently</td>
				<td width="10%"><c:out
					value="${carPoolRegistrationVO.numberOfAvailableSeatsOnMonday}" /></td>
			</c:if>

			<c:if test="${carPoolRegistrationVO.travelOnTuesday == 'true'}">
				<td>tuesday</td>
				<td width="10%">with currently</td>
				<td width="10%"><c:out
					value="${carPoolRegistrationVO.numberOfAvailableSeatsOnTuesday}" /></td>
			</c:if>

			<c:if test="${carPoolRegistrationVO.travelOnWednesday == 'true'}">
				<td>wednesday</td>
				<td width="10%">with currently</td>
				<td width="10%"><c:out
					value="${carPoolRegistrationVO.numberOfAvailableSeatsOnWednesday}" /></td>
			</c:if>

			<c:if test="${carPoolRegistrationVO.travelOnThursday == 'true'}">
				<td>thursday</td>
				<td width="10%">with currently</td>
				<td width="10%"><c:out
					value="${carPoolRegistrationVO.numberOfAvailableSeatsOnThursday}" /></td>
			</c:if>

			<c:if test="${carPoolRegistrationVO.travelOnFriday == 'true'}">
				<td>friday</td>
				<td width="10%">with currently</td>
				<td width="10%"><c:out
					value="${carPoolRegistrationVO.numberOfAvailableSeatsOnFriday}" /></td>
			</c:if>

			<c:if test="${carPoolRegistrationVO.travelOnSaturday == 'true'}">
				<td>saturday</td>
				<td width="10%">with currently</td>
				<td width="10%"><c:out
					value="${carPoolRegistrationVO.numberOfAvailableSeatsOnSaturday}" /></td>
			</c:if>

			<c:if test="${carPoolRegistrationVO.travelOnSunday == 'true'}">
				<td>sunday</td>
				<td width="10%">with currently</td>
				<td width="10%"><c:out
					value="${carPoolRegistrationVO.numberOfAvailableSeatsOnSunday}" /></td>
			</c:if>
			<td width="10%">place available</td>
			<td>&nbsp;</td>
		</tr>

	</table>
	<div class="topspace buttons"><input class="button"
		name="_eventId_previousstep" type="submit"
		value="Click Here To Go Back" /><input class="button"
		name="_eventId_confirm" type="submit"
		value="Click Here To Register Carpool" /></div></div>
</form:form>

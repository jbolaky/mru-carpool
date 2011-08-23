<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="content"><c:if test="${not empty poolSearchResultVOs}">
	<table width="95%" class="contentmargin">
		<c:forEach items="${poolSearchResultVOs}" var="poolSearchResultVO">
			<tr>
				<td><a href="<c:url value="viewspecificpool?id=${poolSearchResultVO.poolId}"/>">View Details</a></td>
				<td><c:out
					value="${poolSearchResultVO.driverAdditionalDetails}"></c:out></td>
				<td><c:out value="${poolSearchResultVO.fromRegionName}"></c:out></td>
				<td><c:out value="${poolSearchResultVO.fromAreaName}"></c:out></td>
				<td><c:out value="${poolSearchResultVO.toRegionName}"></c:out></td>
				<td><c:out value="${poolSearchResultVO.toAreaName}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</c:if></div>
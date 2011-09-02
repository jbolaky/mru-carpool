<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link
	href="<c:url value="/resources/static/jQuery/css/ui-lightness/jquery-ui.css"/>"
	rel="stylesheet" type="text/css" />
<script
	src="<c:url value="/resources/static/jQuery/js/jquery-ui-1.8.14.custom.min.js"/>"
	type="text/javascript"></script>

<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>

<div id="content"><c:if test="${not empty poolVOs}">

	<div class="demo">

	<div id="tabs">
	<ul>
		<li><a href="#tabs-1">Pools</a></li>
		<li><a href="#tabs-2">Edit Account</a></li>
	</ul>
	<div id="tabs-1">
	<table width="95%" class="contentmargin">
		<c:forEach items="${poolVOs}" var="poolVO">
			<tr>
				<td><a
					href="<c:url value="viewspecificpool?id=${poolVO.poolId}"/>"><c:out
					value="${poolVO.poolName}" /></a></td>
				<td><c:out value="${poolVO.poolType}"></c:out></td>
				<td><c:out value="${poolVO.completed}"></c:out></td>
				<td><a
					href="<c:url value="/flows/pool-editing?id=${poolVO.poolId}"/>">Edit
				Pool</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div id="tabs-2"><tiles:insertAttribute name="registerPage" /></div>
	</div>

	</div>
	<!-- End demo -->



	<div style="display: none;" class="demo-description">
	<p>Click tabs to swap between content that is broken into logical
	sections.</p>
	</div>
	<!-- End demo-description -->
</c:if></div>
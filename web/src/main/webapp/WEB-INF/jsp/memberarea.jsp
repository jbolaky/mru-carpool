<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="content"><c:if test="${not empty poolVOs}">
	<table width="95%" class="contentmargin">
		<c:forEach items="${poolVOs}" var="poolVO">
			<tr>
				<td><a href="<c:url value="viewspecificpool?id=${poolVO.poolId}"/>"><c:out value="${poolVO.poolName}"/></a></td>
				<td><c:out
					value="${poolVO.poolType}"></c:out></td>
				<td><c:out value="${poolVO.completed}"></c:out></td>
				<td><a href="<c:url value="/flows/pool-editing?id=${poolVO.poolId}"/>">Edit Pool</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if></div>
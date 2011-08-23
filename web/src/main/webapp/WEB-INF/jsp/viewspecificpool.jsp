<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="content">
<a href="<c:url value="contactdriver?id=${poolVO.poolId}"/>">contact driver</a>
<c:out value="${poolVO.addtionalDetails}" />
</div>
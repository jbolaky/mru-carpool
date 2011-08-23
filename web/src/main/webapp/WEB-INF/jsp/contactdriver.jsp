<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="content"><form:form modelAttribute="contactDriverVO"
	action="requestcontactdriver" method="post" class="contentmargin">
	firstname : <form:input path="firstname" />
	<form:hidden value="${contactDriverVO.poolId}"
		path="poolId"/>
	<div class="topspace buttons"><input class="button"
		name="Send Request" type="submit" value="Send Request" /></div>
</form:form></div>
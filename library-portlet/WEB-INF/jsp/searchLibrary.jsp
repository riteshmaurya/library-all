<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<fmt:setLocale value="<%=request.getLocale()%>" />
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"> -->
<%@ page contentType="text/html" isELIgnored="false" %>	
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script> -->
<fmt:setBundle basename="content.CommonLang-ext"/>

<portlet:renderURL var="showAddLibraryUrl">
	<portlet:param name="myaction" value="addLibraryForm" />
</portlet:renderURL>

<form:form modelAttribute="library" action="${searchLibraryActionUrl}" method="POST">

<div><span><fmt:message key="library.zipcode"/></span></div>
<div><span><input type="text" name="zipcode" id="zipcode"></span></div>
<div><span><input type="submit"></span></div>
</form:form>

<br>
<br>

<form:form action="${showAllLibraryActionUrl}" method="POST">
<div><span><input type="submit" name="Show All" value="Show All"></span></div>
</form:form>

<br>
<form:form action="${showAddLibraryUrl}" method="POST">
<div><span><input type="submit" name="Add Library" value="Add Library"></span></div>
</form:form>
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

<portlet:actionURL var="addLibraryActionUrl">
	<portlet:param name="myaction" value="addLibrary" />
</portlet:actionURL>

<portlet:renderURL var="homeUrl">
	<portlet:param name="myaction" value="library" />
</portlet:renderURL>

<form name="addLibraryForm" action="${addLibraryActionUrl}" method="POST">

<div><span><fmt:message key="library.libraryName"/></span></div>
<div><span><input type="text" name="libraryName" id="libraryName" value='<c:out value="${requestScope.library.libraryName }"></c:out>'></span></div>
<div><span><fmt:message key="library.zipcode"/></span></div>
<div><span><input type="text" name="zipcode" id="zipcode" value='<c:out value="${requestScope.library.zipcode }"></c:out>'></span></div>
<div><span><fmt:message key="library.street"/></span></div>
<div><span><input type="text" name="street" id="street" value='<c:out value="${requestScope.library.street }"></c:out>'></span></div>
<div><span><input type="submit" value="Add Library" ></span></div>
</form>
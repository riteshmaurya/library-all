<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<portlet:actionURL var="homeUrl">
	<portlet:param name="myaction" value=""/>
</portlet:actionURL>
<portlet:actionURL var="editLibraryActionUrl">
	<portlet:param name="myaction" value="editLibrary"/>
</portlet:actionURL>
<portlet:actionURL var="removeLibraryActionUrl">
	<portlet:param name="myaction" value="removeLibrary"/>
</portlet:actionURL>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script> -->
<fmt:setBundle basename="content.CommonLang-ext"/>
<div class="container">

<table class="table table-striped">
<tr>
<th>Library Name</th>
<th>Zip Code</th>
<th>Street Name</th>
</tr>
<c:out value="Hi i processed showAllLibraryJsp"/>
<c:forEach var="library" items="${showAllLibrary }"> 
<tr>
<td><c:out value="${library.libraryName }"/></td>
<td><c:out value="${library.zip }"/></td>
<td><c:out value="${library.street }"/></td>
<td>
<a href="<c:out value="${editLibraryActionUrl }"/>">Edit</a>
<c:out value=" / "/>
<a href="<c:out value="${removeLibraryActionUrl }"/>">Remove</a>
</td>
</tr>
</c:forEach>
</table>
<div>
<a href='<c:out value="${homeUrl }"></c:out>'>Home Page</a>
</div>
</div>
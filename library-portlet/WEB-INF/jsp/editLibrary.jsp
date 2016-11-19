<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<portlet:actionURL var="editLibraryActionUrl">
	<portlet:param name="myaction" value="editLibrary" />
</portlet:actionURL>
<portlet:renderURL var="homeUrl">
	<portlet:param name="myaction" value="library" />
</portlet:renderURL>
<form:form name="editLibraryForm" modelAttribute="libraryToEdit" method="post"
	action="${editLibraryActionUrl}">
	<table>
		<tr align="left">
			<a href="${homeUrl}">Home</a>
		</tr>
	</table>
	<table>
		<tr>
			<td>NAME:<font style="color: #C11B17;">*</font></td>
			<td><form:input path="libraryName" /></td>
			<td><font style="color: #C11B17;"></font></td>
		</tr>
		<tr>
			<td>STREET<font style="color: #C11B17;">*</font></td>
			<td><form:input path="street" /></td>
			<td><font style="color: #C11B17;"></font></td>
		</tr>
		<tr>
			<td>ZIPCODE:<font style="color: #C11B17;">*</font></td>
			<td><form:input path="zipcode" readonly="true"/></td>
			<td><font style="color: #C11B17;"></font></td>
		</tr>
	</table>
	<table align="right">
		<tr>
			<td><input type="submit" value="Update Library" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
</form:form>
<br></br>
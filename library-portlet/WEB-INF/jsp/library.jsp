<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>
function confirmRemove(){
	return confirm("Do you want to delete the selected library?");
}
</script>
<portlet:renderURL var="showAddLibraryUrl">
	<portlet:param name="myaction" value="addLibraryForm" />
</portlet:renderURL>


<form:form name="catalogForm" method="post" action="${showAddLibraryUrl}">
	<c:if test="${not empty library}">
		<table border="1">
			<tr bgcolor="#99CCFF">
				<td valign="top"><b>Library Name</b></td>
				<td valign="top"><b>zipcode</b></td>
				<td valign="top"><b>Steet No</b></td>
				<td valign="top"><b>ACTION</b></td>
			</tr>
			<c:forEach var="library" items="${library}">
				<tr>
					<td valign="top"><c:out value="${library.libraryName}" /></td>
					<td valign="top"><c:out value="${library.zipcode}" /></td>
					<td valign="top"><c:out value="${library.street}" /></td>
					<td align="center" valign="top" width="100px"><a
						href="
						<portlet:renderURL>
							<portlet:param name="myaction" value="editLibraryForm" />
							<portlet:param name="libraryZipCodeEdit" value="${library.zipcode}" />
						</portlet:renderURL>					
					"><b>Edit</b></a>
					/
					<a href="
						<portlet:actionURL>
							<portlet:param name="myaction" value="removeLibrary" />
							<portlet:param name="libraryZipCodeRemove" value="${library.zipcode}" />
						</portlet:actionURL>					
					" onclick="javascript: return confirmRemove()"><b>Remove</b></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br></br>
	<table align="right">
		<tr>
			<td><input type="submit" value="Add Library" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
</form:form>
<br></br>
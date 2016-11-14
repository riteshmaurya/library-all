<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="content.CommonLang-ext"/>
<portlet:renderURL var="homeUrl">
<portlet:param name="myaction" value="" />
</portlet:renderURL>
<fmt:message key="common.searchNotFound"/>

<a href="<c:out value="${requestScope.homeUrl }"/>">Search again</a>
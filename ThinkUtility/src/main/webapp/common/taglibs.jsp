<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="datePattern"><fmt:message key="date.format"/></c:set>

<% 
response.setHeader("Cache-Control","no-cache"); 
 response.setHeader("Pragma","no-cache");
 response.setDateHeader ("Expires", 0); 
%>
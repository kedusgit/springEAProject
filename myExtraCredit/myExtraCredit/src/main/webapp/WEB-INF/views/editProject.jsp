<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Project</title>
</head>
<body>

<table>
        <tr>
            <c:forEach var = "listValue" items = "${project}">
            <td>
                <c:out value="${listValue.Name}"/>
            </td>
            <td>
                <c:out value="${listValue.Description}"/>
            </td>
            </c:forEach>
        </tr>
</table>
<form:form action= "/editProject" method="post" modelAttributes ="project" enctype="multipart/form-data">

        <div> <form:input path="pId" id="pId"  value="${project.pId}" /></div>

            <div >
                <label for="name">Name</label>
                <form:errors path="name" cssStyle="color:#ff0000;" />
                <form:input path="name" id="name"  value="${project.name}"/>
            </div>
</form:form>

</body>
</html>
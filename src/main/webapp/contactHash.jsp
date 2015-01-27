<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
    Document   : contactHash
    Created on : Jun 13, 2014, 12:28:39 PM
    Author     : faisal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HashMap Form</title>
    </head>
    <body>
        <h1>HashMap Form</h1>
        <form:form method="post" modelAttribute="chMapjpt" action="contactHash/add">
            <table>
                <tr>
                    <th>Key</th>
                    <th>Value</th>
                </tr>
                <c:forEach items="${chMap.contactMap}" var="contactMap" varStatus="status">
                    <tr>
                        <td>${contactMap.key}</td>
                        <td><input name="contactMap['${contactMap.key}']" value="${contactMap.value}"/></td>
                    </tr>
                </c:forEach>
            </table>  
            <br/>

            <input type="submit" value="Save" />
        </form:form>
    </body>
</html>

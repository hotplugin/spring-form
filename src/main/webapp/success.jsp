<%-- 
    Document   : success
    Created on : May 13, 2014, 3:01:02 PM
    Author     : faisal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Message</title>
    </head>
    <body>
        
        <h3>Contact Entered Values</h3>
        <c:out value="${contactinfo.name}"/>
        
        <h2>SendSms Mobile:  ${contactinfo.email}</h2>
        <h3>${message}</h3>
<!--        <h1>Spring Multiple File Upload example</h1>
        <p>Following files are uploaded successfully.</p>
        <ol>
            <c:forEach items="${files}" var="file">
                <li><c:out value="${file}"/></li>
            </c:forEach>
        </ol>-->
        
<!--        <h2>Show Contact</h2>
    <table>
        <tr>
            <th>Key</th>
            <th>Value</th>
        </tr>
        <c:forEach items="${chMapjpt.contactMap}" var="contactMap"
            varStatus="status">
            <tr>
                <td>${contactMap.key}</td>
                <td>${contactMap.value}</td>
            </tr>
        </c:forEach>
    </table>-->
    <br />
    <input type="button" value="Back" onclick="javascript:history.back()" />
    </body>
</html>

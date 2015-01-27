<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Us</title>
    </head>
    <body>
        <h2>Contact Us</h2>
        <form:form method="POST" modelAttribute="contact" >
            <table>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                    <td><form:errors path="name" /></td>
                <tr>   
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><form:label path="message">Message</form:label></td>
                    <td><form:textarea path="message"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Send"/>

                    </td>
                </tr>
            </tr>
        </table>
    </form:form>
    <h3>Send SMS</h3>

    <form:form method="POST" action="contact/sendSms" modelAttribute="contact">
        <form:radiobuttons path="mobile" items="${previousNumbers}"  /> 
        <form:select path="mobile">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${countryList}" />
        </form:select>
        <form:input path="mobile"/>
        <input type="submit" value="send"/>
    </form:form>
    <a href="test">Click here to test Exception handling</a>

</body>
</html>

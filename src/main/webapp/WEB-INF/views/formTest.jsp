<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>
<section class="steps">
    <div class="steps--container" style="font-size: large">
        <form:form method="post" modelAttribute="donation">

            <table style="padding: 10px">

                <tr><td>kategorie </td><td><form:checkboxes path="categories" items="${categories}" itemLabel="name" itemValue="id"/></td></tr>
                <tr><td>instytucje </td><td><form:select path="institution" items="${institutions}" itemLabel="name" itemValue="id"/></td></tr>
                <tr><td>ile worków </td><td><form:input path="quantity"/></td></tr>
                <tr><td>miasto </td><td><form:input path="city"/></td></tr>
                <tr><td>kod pocztowy </td><td><form:input path="zipCode" /></td></tr>
                <tr><td>ulica </td><td><form:input path="street" /></td></tr>
                <tr><td>data </td><td><form:input type="date" path="pickUpDate"/></td></tr>
                <tr><td>godzina </td><td><form:input type="time" path="pickUpTime" /></td></tr>
                <tr><td>uwagi </td><td><form:textarea path="pickUpComment"/></td></tr>
                <tr><td><input type="submit" value="ZAPISZ"></td><td></td></tr>

            </table>





        </form:form>
    </div>
</section>
<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
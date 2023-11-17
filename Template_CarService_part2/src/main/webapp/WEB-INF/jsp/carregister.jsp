<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<h1>This is the signup page</h1>
<form:form action="done" modelAttribute="car">
    Car Name:
    <form:select path="carName">
        <form:option value="Seltos"></form:option>
        <form:option value="Maruti"></form:option>
    </form:select>
</form:form>

<h1>${message}</h1>

</html>
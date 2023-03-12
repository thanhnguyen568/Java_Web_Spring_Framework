<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
<h2>Settings:</h2>
<form:form action="" method="post" modelAttribute="email">
    <table>
        <tr>
            <th>Language: </th>
            <td>
                <form:select path="language">
                    <form:options items="${languages}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Pages: </th>
            <td><form:select path="pageSize" items="${pages}"/></td>
        </tr>
        <tr>
            <th>Spam Filter: </th>
            <td>
                <form:select path="spamFilter">
                    <form:option value="true">Enable</form:option>
                    <form:option value="false">Disable</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Signature: </th>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <th></th>
            <td>
                <input type="submit" role="button" class="btn btn-outline-primary" value="Update">
                <input type="reset" role="button" class="btn btn-outline-secondary" value="Cancel">
            </td>
        </tr>
    </table>
</form:form>
<c:if test="${message != null}">
    <div style="color: red">
        <c:out value="${message}"/>
    </div>
</c:if>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Management Customer</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.3/css/jquery.dataTables.min.css">
    <style>
        body {
            background: #f5f5f5;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="text-info">Management Customer</h1>
    <h3 class="text-warning">Update Information</h3>

    <form:form method="post" action="updated" modelAttribute="customer">
        <table>
            <tr>
                <td><form:label path="customerNo">Customer No:</form:label></td>
                <td><form:input path="customerNo" value="${customer.customerNo}"/></td>
            </tr>
            <tr>
                <td><form:label path="customerName">Customer Name:</form:label></td>
                <td><form:input path="customerName" value="${customer.customerName}"/></td>
            </tr>
            <tr>
                <td><form:label path="customerEmail">Customer Email:</form:label></td>
                <td><form:input path="customerEmail" value="${customer.customerEmail}"/></td>
            </tr>
            <tr>
                <td><form:label path="customerAddress">Customer Address:</form:label></td>
                <td><form:input path="customerAddress" value="${customer.customerAddress}"/></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button class="btn btn-secondary" role="button">
                        <a class="text-light" href="/customers">Cancel</a>
                    </button>
                    <input type="submit" value="Submit" class="btn btn-success"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.13.3/js/jquery.dataTables.min.js"></script>
</body>
</html>

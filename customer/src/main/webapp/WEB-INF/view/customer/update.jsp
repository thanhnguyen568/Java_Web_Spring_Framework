<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container-fluid">
    <h1>
        <a href="/customers" class="text-info">Management Customer</a>
    </h1>

    <div class="col-4 fla">
        <table class="table">
            <thead>
            <tr>
                <th>
                    <h2 class="text-warning">Update Information</h2>
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <form action="updated" method="post" style="width: 500px">
                        <div class="form-group">
                            <label for="customerNo">Customer No</label>
                            <input type="text" name="customerNo" id="customerNo" class="form-control"
                                   value="${customer.customerNo}">

                            <label for="customerName">Customer Name</label>
                            <input type="text" name="customerName" id="customerName" class="form-control"
                                   value="${customer.customerName}">

                            <label for="customerEmail">Customer Email</label>
                            <input type="text" name="customerEmail" id="customerEmail" class="form-control"
                                   value="${customer.customerEmail}">

                            <label for="customerAddress">Customer Address</label>
                            <input type="text" name="customerAddress" id="customerAddress" class="form-control"
                                   value="${customer.customerAddress}">

                            <hr>
                            <button class="btn btn-secondary" role="button">
                                <a class="text-light" href="/customers">
                                    Cancel
                                </a>
                            </button>

                            <button class="btn btn-success" role="button" type="submit">
                                Save
                            </button>
                        </div>
                    </form>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.13.3/js/jquery.dataTables.min.js"></script>
</body>
</html>

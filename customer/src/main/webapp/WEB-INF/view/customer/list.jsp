<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.css">
</head>
<body>
<h1>List customers</h1>
<div class="container-fluid">
    <div>
        <button type="button" class="btn-success">
            <a class="text-light"
               href="/customer/create">Create new</a>
        </button>
        <button type="button" class="btn-danger">
            <a class="text-light"
               href="#">Delete</a>
        </button>
    </div>

    <table class="table table-striped table-hover " id="tableList">
        <tr>
            <th></th>
            <th>Customer No</th>
            <th>Customer Name</th>
            <th>Customer Email</th>
            <th>Customer Address</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td><input type="checkbox" name="checkbox" value="${customer.customerNo}"></td>
                <td>${customer.customerNo}</td>
                <td>${customer.customerName}</td>
                <td>${customer.customerEmail}</td>
                <td>${customer.customerAddress}</td>
                <td>
                    <button type="button" class="btn-warning">
                        <a class="text-light"
                           href="/customer/update?customerNo=${customer.customerNo}">Update</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<script src="/static/js/jquery-3.5.1.min.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/datatables/js/jquery.dataTables.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.js"></script>
<script>
    $(document).ready(function () {
        $('#tableList').dataTable({
            // 'searching': false,
            'pageLength': 100
        })
    })

    function deleteAlert(id) {
        document.getElementById("delLink").href = '/accounts?action=delete&accountId=' + id;
    }
</script>
</body>
</html>

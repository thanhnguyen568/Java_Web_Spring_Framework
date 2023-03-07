<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.3/css/jquery.dataTables.min.css">
</head>
<body>
<div class="container-fluid">
    <h1>Customer List</h1>

    <button type="button" class="btn btn-success">
        <a href=/customer/create class="text-light">Create</a>
    </button>
    <!-- Button trigger modal -->
    <%--        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modelId">Delete</button>--%>

    <hr>

    <!-- Table -->
    <table id="tableList" class="table table-striped table-hover ">
        <thead class="bg-info">
        <tr>
            <th>#</th>
            <th>Customer No</th>
            <th>Customer Name</th>
            <th>Customer Email</th>
            <th>Customer Address</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td><input type="checkbox" name="checkbox" value="${customer.customerNo}"></td>
                <td>${customer.customerNo}</td>
                <td>${customer.customerName}</td>
                <td>${customer.customerEmail}</td>
                <td>${customer.customerAddress}</td>
                <td>
                    <button type="button" class="btn btn-warning">
                        <a class="text-light"
                           href="/customer/update?customerNo=${customer.customerNo}">Update</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>

        <!-- Modal -->
        <div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Confirm delete</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Confirm delete?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary" onclick="deleteAlert(${customer.customerNo})">
                            Confirm
                        </button>
                    </div>
                </div>
            </div>
        </div>

    </table>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.13.3/js/jquery.dataTables.min.js"></script>

<script>
    $(document).ready(function () {
        $('#tableList').dataTable({
            // 'searching': false,
            'pageLength': 100
        })
    })

</script>
</body>
</html>

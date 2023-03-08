<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Management</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.3/css/jquery.dataTables.min.css">
</head>
<body>
<div class="container-fluid">

    <h1>
        <a href="/customers" class="text-info">Management Customer</a>
    </h1>

    <div class="row">
        <div class="col">
            <button type="button" class="btn btn-success">
                <a href="/customers/create" class="text-light">Create</a>
            </button>
        </div>

        <form action="/customers/search" class="col form-inline">
            <input type="text" name="search" class="form-control">
            <button type="submit" class="btn btn-dark">Search</button>
        </form>
    </div>
    <hr>

    <form action="/customers/delete" method="post">

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
                            <a href="/customers/update?&customerNo=${customer.customerNo}" class="text-light">Update</a>
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <!-- Button trigger modal -->
        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modelId">
            Delete
        </button>

        <!-- Modal -->
        <div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title"></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Confirm delete ?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Confirm</button>
                    </div>
                </div>
            </div>
        </div>

    </form>

</div>

<!-- JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.13.3/js/jquery.dataTables.min.js"></script>

<script>
    $(document).ready(function () {
        $('#tableList').dataTable({
            'searching': false,
            'pageLength': 100
        })
    })
</script>
</body>
</html>

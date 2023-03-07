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
    <div class="col-4 bg-light ">
        <form action="result" method="post">
            <fieldset class="form-group">
                <legend>Create new</legend>

                <div class="form-group">
                    <label for="customerNo">Customer No</label>
                    <input type="text" name="customerNo" id="customerNo" class="form-control" placeholder="Customer No">

                    <label for="customerName">Customer Name</label>
                    <input type="text" name="customerName" id="customerName" class="form-control" placeholder="Customer Name">

                    <label for="customerEmail">Customer Email</label>
                    <input type="text" name="customerEmail" id="customerEmail" class="form-control"
                           placeholder="Customer Email">

                    <label for="customerAddress">Customer Address</label>
                    <input type="text" name="customerAddress" id="customerAddress" class="form-control"
                           placeholder="Customer Address">

                    <button class="btn btn-warning" role="button">
                        <a class="text-light" href="/customer/list">Cancel</a>
                    </button>
                    &nbsp;
                    &nbsp;
                    &nbsp;
                    &nbsp;
                    <button class="btn btn-success" role="button" type="submit">Save</button>

                </div>
            </fieldset>
        </form>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.13.3/js/jquery.dataTables.min.js"></script>
</body>
</html>

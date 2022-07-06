<!DOCTYPE html>
<%@ page import="com.entity.Employee" %>
<%@ page import="java.util.Optional" %>
<html lang="en">

<head>
    <title>Submit Reimbursement</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="icons8-money-box-48.png">
    <link rel="stylesheet" href="submitReimbursement.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

    <div class="container rounded bg-white mt-5 mb-5">
        <div class="row">
            <div class="col-md-5 border-right">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="250px" src="reimbursement.png" />
                    <%Optional<Employee> employee = (Optional<Employee>) request.getAttribute("employee-info");
                    %>
                    <span><%=employee.get().getName()%></span>
                    <span><%=employee.get().getEmail()%></span>
                </div>
            </div>
            <div class="col-md-5 border-right">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h2 class="text-right">Submit A Reimbursement</h2>
                    </div>
                    <div class="row mt-3">
                        <form action="submit-reimbursement-button" method="post">
                            <div class="col-md-12"><span class="information">Title</span>
                                <input type="text" class="form-control" placeholder="Title" name="title" value="">
                            </div>
                            <div class="form-group">
                               <label for="exampleFormControlTextarea1">Description</label>
                               <textarea class="form-control" placeholder="Description" name="description" rows="3" value=""></textarea>
                            </div>
                            <div class="col-md-12"><span class="information">Total</span>
                               <input type="text" class="form-control" placeholder="Total" name="total" value="">
                            </div>
                            <div class="mt-3 text-center">
                                <input class="btn btn-primary profile-button" type="submit" value="Submit Reimbursement" id="submit-button">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
<!DOCTYPE html>
<%@ page import="com.entity.Reimbursement" %>
<%@ page import="com.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%@ page import= "com.repository.EmployeeRepository" %>
<%@ page import= "com.repository.JdbcEmployeeRepository" %>
<html lang="en">

<head>
  <title>Manager Homepage</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link rel="icon" type="image/x-icon" href="icons8-money-box-48.png">
  <link rel="stylesheet" href="employeeHome.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
  <nav class="navbar sticky-top navbar-light bg-dark navbar-right">
    <button class="btn" id="sidebar-toggle"><i class="fa fa-bars"></i> Menu</button>

    <li class="nav-item dropdown dropdown-menu-end">
      <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-hashpopup="true" aria-expanded="false"><img src="boss.png" alt="Avatar" class="avatar">
        Settings
      </a>
      <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
        <a class="dropdown-item" href="view-information-manager">My Information</a>
        <a class="dropdown-item" href="logout">Logout</a>
      </div>
    </li>


  </nav>

  <div id="sidebar-container">
    <div id="sidebar">
        <%
           EmployeeRepository employeeRepository = new JdbcEmployeeRepository();
           String currentUser = (String) session.getAttribute("current-user");
           Optional<Employee> employee = employeeRepository.findByEmpUsername(currentUser);
        %>
      <h3 id="name">Hello, <%=employee.get().getName()%></h3>
      <ul class="sidebar-items">
        <li><a href="manager-pending-reimbursements" class="sidebar-item">Pending Reimbursements</a></li>
        <li><a href="manager-resolved-reimbursements" class="sidebar-item">Resolved Reimbursements</a></li>
        <li><a href="view-all-employees" class="sidebar-item">View All Employees</a></li>
      </ul>
    </div>
  </div>

  <div id="website-content m-0">
    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-12">
          <form action="pending-sort" method="post">
            <div class="form-group d-flex flex-row-reverse">
                <div class="justify-content-end">
                <label class="mt-1">Search by Employee ID</label>
                <input name="search" class="form-control" placeholder="Enter Employee ID">
                <input class="btn btn-primary profile-button mt-2 mb-2" type="submit" value="Search" id="submit-button">
                </div>
            </div>
          </form>
          <%
             List<Reimbursement> reimbursements = (List<Reimbursement>) request.getAttribute("all-pending-reimbursement-list");
             for (Reimbursement reimbursement : reimbursements) {
          %>
             <div class="card" style="background : linear-gradient(315deg, #000000 0%, #7f8c8d 90%);" id="my-card">
                 <img src="businessan.png" class="card-img-top" alt="...">
                 <div class="card-body">
                    <h5 class="card-title " style="color : white">Title: <%=reimbursement.getTitle()%></h5>
                    <hr>
                    <p class="card-text" style="color : white">Description: <%=reimbursement.getDescription()%></p>
                    <p class="card-text" style="color : white">Total: $<%=reimbursement.getTotal()%></p>
                    <hr>
                    <p class="card-text" style="color : white">Created by: <%=employeeRepository.findByEmpId(reimbursement.getEmpId()).get().getName()%> (Employee Id: <%=reimbursement.getEmpId()%>)</p>
                    <p class="card-text" style="color : white">Status: <%=reimbursement.getState()%></p>
                    <div>
                        <a href="approve-reimbursement?id=<%=reimbursement.getReimbursement_id()%>"><input class="btn btn-primary profile-button mt-2 mb-2 btn btn-success" type="submit" value="APPROVE" id="approve-button"></a>
                        <a href="deny-reimbursement?id=<%=reimbursement.getReimbursement_id()%>"><input class="btn btn-primary profile-button mt-2 mb-2 btn btn-danger" type="submit" value="DENY" id="deny-button"></a>
                    </div>
                 </div>
             </div>
          <%
             }
          %>
        </div>
      </div>
    </div>
  </div>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.6/dist/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
  <script src="managerHome.js"></script>
</body>
</html>
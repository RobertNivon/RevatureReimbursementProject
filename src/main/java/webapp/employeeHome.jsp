<!DOCTYPE html>
<%@ page import="java.util.Optional" %>
<%@ page import= "com.repository.EmployeeRepository" %>
<%@ page import= "com.repository.JdbcEmployeeRepository" %>
<%@ page import="com.entity.Employee" %>
<html lang="en">

<head>
  <title>Employee Homepage</title>
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
    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-hashpopup="true" aria-expanded="false"><img src="businessman.png" alt="Avatar" class="avatar">
      Settings
    </a>
    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
      <a class="dropdown-item" href="view-information-employee">My Information</a>
      <a class="dropdown-item" href="logout">Logout</a>
    </div>
  </li>


</nav>

<div id="sidebar-container">
  <div id="sidebar">
        <%
            EmployeeRepository employeeRepository = new JdbcEmployeeRepository();
            String currentUser = (String) session.getAttribute("current-user");
            Optional<Employee> employeeName = employeeRepository.findByEmpUsername(currentUser);
        %>
    <h3 id="name">Hello, <%=employeeName.get().getName()%></h3>
    <ul class="sidebar-items">
      <li><a href="pending-reimbursements" class="sidebar-item">My Pending Reimbursements</a></li>
      <li><a href="resolved-reimbursements" class="sidebar-item">My Resolved Reimbursements</a></li>
      <li><a href="submit-reimbursement" class="sidebar-item">Submit a Reimbursement</a></li>
    </ul>
  </div>
</div>

<div id="website-content">
  <div class="container-fluid">
    <div class="row">
      <div class="col-lg-12">
        <h1>hahaha</h1>
      </div>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.6/dist/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="employeeHome.js"></script>
</body>
</html>
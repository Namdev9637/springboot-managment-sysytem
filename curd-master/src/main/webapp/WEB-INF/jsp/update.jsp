<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <title>CURD || UPDATE</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">
  <c:if test="${null!=msg }">
  <h2 style="color: red;">${msg }</h2>
  </c:if>
  <h2>Update Employee Form</h2>
  <form:form action="updateEmployee" method="POST" modelAttribute="employee" id="employee" name="employee">
    <div class="mb-3 mt-3">
      <label >Employee name:</label>
      <input type="hidden" name="empId" id="empId" value="${employee.empId }">
      <input type="text" value="${employee.empName }" class="form-control" id="empName" placeholder="Enter name" name="empName" required="required">
    </div>
    <div class="mb-3">
      <label >Role</label>
      <input type="text"   value="${employee.role }" class="form-control" id="role"  name="role" placeholder="Enter role" required="required">
    </div>
   
    <button style="border-radius:0px;" type="submit" class="btn btn-primary">Update Employee Details</button>
  </form:form>
</div>

<div class="container mt-3">
  
  <h2>Saved Employee data</h2>
          
  <table class="table table-bordered">
    <thead>
      <tr style="background-color: #8ddcfe;">
        <th>ID</th>
        <th>Employee Name</th>
        <th>Role</th>
         <th>Update</th>
          <th>Delete</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${empList }" var="emp">
      <tr>
        <td>${emp.empId }</td>
        <td>${emp.empName }</td>
        <td>${emp.role }</td>
          <th ><a class="btn btn-info" style="border-radius:0px;" href="update?id=${emp.empId }">Update</a></th>
     	 <th ><a class="btn btn-danger" style="border-radius:0px;"  href="delete?id=${emp.empId }">Delete</a></th>
   
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>



</body>
</html>

<%-- 
    Document   : dashboard.jsp
    Created on : May 14, 2023, 5:50:42 AM
    Author     : AnataArisa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>G1 Dashboard</title>
        <link rel="stylesheet" href="view/css/dashboard.css"/>
        <!-- bootstrap-link-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <body>
        <div class="main-container container-fluid">
            <header>
                <div class="header-container container-fluid">
                    <div class="header-username col-md-4">
                        <h5>WELCOME BACK ${username}</h5>
                    </div>
                    <div class="col-md-4 header-nav">
                        <nav>
                            <button>Home</button>
                            <button>Account</button>
                            <button style="display: ${admin}">Account Manager</button><!-- comment -->
                            <button>Home</button>
                        </nav>
                    </div>
                    <div class="col-md-4 logout-btn">
                        <form action="logout" method="POST">
                            <button type="submit">Logout</button>
                        </form>
                    </div>
                </div>
            </header>
        </div>
        <div class="container am-container">
            <table class="admin-table">
                <tr>
                    <th>UID</th>
                    <th>UserName</th>
                    <th>Role</th>
                    <th>Create Date</th>
                    <th>Status</th>
                </tr>
                <c:forEach items="${accList}" var="o">
                    <tr>
                        <td>${o.UID}</td>
                        <td>${o.username}</td>
                        <td>${o.roles}</td>
                        <td>${o.registerDate}</td>
                        <td>${o.status}</td>
                            
                    </tr>
                </c:forEach>
            </table>
        </div> 
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </body>
</html>

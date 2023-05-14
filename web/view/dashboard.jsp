<%-- 
    Document   : dashboard.jsp
    Created on : May 14, 2023, 5:50:42 AM
    Author     : AnataArisa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>G1 Dashboard</title>
        <link rel="stylesheet" href="view/css/dashboard.css"/>
    </head>
    <body>
        <div class="main-container">
            <header>
                <div class="header-container">
                    <div class="header-username">
                        <h5>${username}</h5>
                    </div>
                    <div>
                        <nav>
                            <form action="logout" method="POST">
                                <button type="submit">Logout</button>
                            </form>
                        </nav>
                    </div>
                </div>
            </header>
            
        </div>
    </body>
</html>

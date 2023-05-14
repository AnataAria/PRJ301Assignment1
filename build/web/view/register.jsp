<%-- Document : index Created on : May 12, 2023, 3:12:40 PM Author : AnataArisa
--%> <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>LOGIN FORM</title>
    <link href="view/css/loginstyle.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <div class="main-container">
      <div class="login-container">
        <div class="welcome">
          <h2>WELCOME</h2>
          <p>Please login to use the application</p>
        </div>

        <form action="register" method="POST">
          <div class="loginform-container">
            <h5>USERNAME</h5>
            <input
              type="text"
              name="username"
              class="input"
              value="${username}"
              placeholder="Username doesn't contain special word"
            />
            <h5>PASSWORD</h5>
            <input
              type="password"
              name="password"
              class="input"
              value="${password}"
              placeholder="Password doesn't contain special word"
            />
            <h5>REPASS</h5>
            <input
              type="password"
              name="repass"
              class="input"
              placeholder="Please
            enter like the password"
            />
          </div>
          <div class="login">
            <p>${note}</p>
            <button type="submit" id="login-btn">REGISTER</button>
          </div>
        </form>
      </div>
      <div class="background">
        <img src="assets/background.jpg" alt="alt" />
      </div>
    </div>
  </body>
</html>

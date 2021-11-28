<%-- 
    Document   : forgot
    Created on : Nov 28, 2021, 1:14:41 AM
    Author     : Tyler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
    </head>
    <body>
        <h1>Forgot Password</h1>
        
        <p>Please enter your email address to retrieve your password</p>
        <form method ="post" action="">
            <input type="text" name="email" value="">
            <input type="submit" value="Submit">           
        </form>
        ${message}
    </body>
</html>

<%-- 
    Document   : login.jsp
    Created on : 7-Oct-2021, 9:19:54 PM
    Author     : mikep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <div>
            <form action="login" method="post">
                <table>
                    <tr>
                        <td><label for="username"> Username: </label></td>
                        <td><input type="text" name="username" value=""/></td>
                    </tr>
                    <tr>
                        <td><label for="password"> Password: </label></td>
                        <td><input type="password" name="password" value=""/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Log in" /></td>
                    </tr>
                    <tr>
                    <td colspan="2">${message}</td>
                    </tr>
                </table>
        </div>
    </body>
</html>

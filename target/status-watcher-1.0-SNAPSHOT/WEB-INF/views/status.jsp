<%-- 
    Document   : status
    Created on : 3 déc. 2012, 08:20:21
    Author     : alexis
--%>

<%@ page import="java.util.Map" %>
<%@ page import="chatapp.components.Statuses" %>
<%@ page import="chatapp.components.StatusChangeReceiver" %>
<%@ page import="java.util.HashMap" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="refresh" content="10" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       <link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    </head>
    <body>
        

        <form method="GET" action="status">
            <table align ="center"><tr valign="center" heigth="100%"><td>
                <table>
                    <tr>
                        <td align="center"> 
                            <h3>Participant Status</h3> 
                        </td>
                    </tr>
                    <tr>
                        <td align="center">

<textarea class="input-xxlarge" name="board" rows="20" readonly="true">
    <% Map<String, String> statusMap = (HashMap)request.getAttribute("statusMap"); %>
    <% for (String mapKey : statusMap.keySet()) { %> 
    <% String name = mapKey;%>
    <% String status = statusMap.get(mapKey);%>
<%= name %> is <%= status %><%}%>
</textarea>

                        </td>
                    </tr>

                </table>
            </td></tr></table>
        </form>
            


    </body>
</html>

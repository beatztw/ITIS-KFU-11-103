<%@ page import="java.util.List" %>
<%@ page import="com.itis.forms_servlet_example.model.User" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/15/21
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <th>ID</th>
    <th>FIRST NAME</th>
    <th>LAST NAME</th>
    <th>COURSE NAME</th>
    <th>AGE</th>

    <%
        List<User> users = (List<User>) request.getAttribute("usersForJsp");
        for (User user : users) {
    %>

    <tr>
        <td><%=user.getId()%>
        </td>
        <td><%=user.getFirstName()%>
        </td>
        <td><%=user.getLastName()%>
        </td>
        <td><%=user.getCourseName()%>
        </td>
        <td><%=user.getAge()%>
        </td>
    </tr>

    <% } %>
</table>
<a href="/user/add">ADD USER</a>

</body>
</html>

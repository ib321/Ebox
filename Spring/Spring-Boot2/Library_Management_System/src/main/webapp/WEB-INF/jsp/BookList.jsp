<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lib.model.Book" %>
<% ArrayList<Book> lists = (ArrayList<Book>) request.getAttribute("listBooks");%>
<!DOCTYPE html>  
<html lang="en">  
<head>  
    <meta charset="UTF-8">
    <title>Hello ${name}!</title>
    <link href="/css/main.css" rel="stylesheet">
</head>  
<body>
    <a href="/">Home</a>
<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of All Books On server</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Author</th>
                <th>Category</th>
                <th>Return Date</th>
                <th>Availability</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
           
            <%
                for(Book book : lists) 
                {
            %>
                <tr>
                    <td><%=book.getId()%></td>
                    <td><%=book.getName()%></td>
                    <td><%=book.getAuthor()%></td>
                    <td><%=book.getCategory()%></td>
                    <td><%=book.getReturnDate()%></td>
                    <td>Availability</td>
                    <td><a href="/editOneBook/<%=book.getId()%>">Edit</a></td>
                    <td><a href="/editOneBook/<%=book.getId()%>">Edit</a></td>
                </tr>
            <% 
                } 
            %>
        </table>
    </div>
    <script src="/js/main.js"></script>
</body>  
</html>
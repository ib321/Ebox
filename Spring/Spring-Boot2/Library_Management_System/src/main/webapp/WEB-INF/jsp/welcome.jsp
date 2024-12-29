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
    <h2 class="hello-title">Hello ${name}!</h2>
    <h1></h1>
    <a href="/listBooks">Click Here to view All Book On server</a>
    <h1></h1>
    <a href="/addNewBook">Click Here to Add Book On server</a>
    <c:choose>
        <c:when test="${AddStatus=='true'}"><h3>Book Added Successfully</h3></c:when>
        <c:when test="${AddStatus=='false'}"><h3>Failed to Add Book! Duplicate value of Book id.</h3></c:when>
        <c:otherwise></c:otherwise>
    </c:choose>
    <script src="/js/main.js"></script>
</body>  
</html>
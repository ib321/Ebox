<%@ page import="com.lib.model.Book" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <script>
    function formatDate(date)
    {
      console.log(date);
      let fdate=date.value.replace(/-/g,"/");
      date.value=fdate;
      console.log(fdate);
    }
  </script>
</head>

<body>
  <h4 align="justify" style="color: white">
    <br />
    <input class="button5" type="button" value="Back" onCLick="history.back()" />
  </h4>
  <div align="center">
    <h1>Add Book</h1>
    <div class="container">

      <form action = "/addOneBook" method = "POST" >
        Id : <input type = "text" name = "id">
        <br />
        Name: <input type = "text" name = "name" />
        <br />
        Author: <input type = "text" name = "author">
        <br />
        Category: <input type = "text" name = "category">
        <br />
       Return Date: <input type="text" placeholder="yyyy/MM/dd" name="returnDate" ">
        <br />
        <input type = "submit" value = "Submit" />
     </form>

    </div>
  </div>
</body>

</html>
<%@ page import="com.uniyaz.db.DbOperations" %><%--
  Created by IntelliJ IDEA.
  User: fb_cn
  Date: 3.03.2021
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Silme</title>
    <link rel="stylesheet" href="style.css"/>


</head>
<br>
<h3>Silmek istediğinizden emin misiniz?</h3>

<form action="listele.jsp" method="get">




               <div style="width: 300px;">
                   <div class="sil"  style="float: left;">
                <input class="silbutonu" type="submit" value="evet">

               </div>

    </div>
</form>


<%
    String id = request.getParameter("id");

    if (id == null) return;

    DbOperations dbOperations = new DbOperations();
    dbOperations.kisiSil(id);

%>


</body>
</html>

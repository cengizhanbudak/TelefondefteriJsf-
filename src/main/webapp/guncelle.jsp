<%@ page import="com.uniyaz.db.DbOperations" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Güncelle </title>
    <link rel="stylesheet" href="style.css"/>

</head>
<body>
<h1> güncelle   </h1>
<form class="elele" action="listele.jsp" method="get">



    <%
        String id1 = request.getParameter("id");
        String isim = request.getParameter("isim");
        String telefon = request.getParameter("telefon");
        int id =Integer.parseInt(id1);


        DbOperations dbOperations = new DbOperations();
        dbOperations.kisiGuncelle(id,isim,telefon);

    %>



    <div>
        <div style="width: 300px;">
            <div style="float: left;">
                <label for="isim">İsim</label>
                <input type="text" name="isim">
            </div>

            <div style="clear: both">
                Telefon<input type="text" name="telefon">
            </div>
            <input type="submit" value="Kaydet">
        </div>
    </div>

</form>



</body>
</html>

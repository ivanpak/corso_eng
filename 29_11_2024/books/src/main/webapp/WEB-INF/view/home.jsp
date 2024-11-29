pagina home.jsp
inizio libri
fine libri

<html>
    <head>
        <title>Il mio sito di libri</title>
        <%
        String nome = "pippo";
        %>
    </head>
    <body>
        <h1>elenco libri</h1>
        ${books}
        <p><%=nome%></p>
        <c:forEach items="${books}" var="item">
        $item.nome
        </c:forEach>
    </body>
</html>
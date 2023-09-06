<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KOPO Site</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </head>
    <body>
        <header class="py-3 mb-3 border-bottom">
            <div class="container-fluid d-grid gap-3align-items-center" style="grid-template-columns: 1fr 2fr; text-align:center; background-color:burlywood;">
                <h3><font style="color: cornflowerblue;">KOPO API Page</font></h3>
            </div>
        </header>
        <div class="container-fluid pb-3">
            <div class="card">
                <div class="card-header">
                    Page List
                </div>
                <div class="card-body">
                    <table class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">제목</th>
                                <th scope="col">날짜</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="i" items="${getPageList}">
                                <th scope="row">
                                    <a href="getpage?idx=${i.idx}">${i.idx}</a>
                                </th>
                                <td>
                                    <a href="getpage?idx=${i.idx}">${i.title}</a>
                                </td>
                                <td>
                                    <a href="getpage?idx=${i.idx}">
                                        <fmt:formatDate value="${i.makedate}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate>
                                    </a>
                                </td>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br><br>
                    <div class="text-xs-center">
                        <ul class="pagination justify-content-center">
                            <c:forEach begin="0" end="${totalpage}" var="numz">
                                <li class="page-item">
                                    <a class="page-link" href="/?pagenumber=${numz+1}">${numz+1}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
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
                    Page Detail Information
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">IDX : ${getpages.idx}</li>
                    <li class="list-group-item">제목 : ${getpages.title}</li>
                    <li class="list-group-item" style="word-break: break-all;">내용 : ${getpages.content}</li>
                    <li class="list-group-item">UUID값 : ${getpages.uuid}</li>
                    <li class="list-group-item">
                        만든날짜 : <fmt:formatDate value="${getpages.makedate}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate>
                    </li>
                    <li class="list-group-item">
                        API 데이터 받기 : IP주소:포트번호/api/getdata/UUID값
                    </li>
                    <li class="list-group-item">
                        <table class="table table-striped table-bordered">
                            <tr>
                                <td>파라미터</td>
                                <td>간략 설명</td>
                                <td>필수/선택</td>
                                <td>입력값</td>
                            </tr>
                            <tr>
                                <td>pageno</td>
                                <td>페이징 처리</td>
                                <td>필수</td>
                                <td>숫자(0부터 입력)</td>
                            </tr>
                            <tr>
                                <td>time</td>
                                <td>날짜 기준</td>
                                <td>선택</td>
                                <td>XXXX-XX-XX</td>
                            </tr>
                            <tr>
                                <td>name</td>
                                <td>이름만</td>
                                <td>선택</td>
                                <td>임일균/김희철/강찬밥/수련 중선택</td>
                            </tr>
                            <tr>
                                <td>date</td>
                                <td>만들어진 날짜</td>
                                <td>선택</td>
                                <td>XXXX-XX-XX</td>
                            </tr>
                            <tr>
                                <td>device</td>
                                <td>사용한 기기</td>
                                <td>선택</td>
                                <td>HEM-7142T2/Galaxy Watch/BP170B</td>
                            </tr>
                        </table>
                    </li>
                </ul>
            </div>
            <form action="/">
                <button type="submit" class="btn btn-info">GO TO BACK</button>
            </form>
        </div>
    </body>
</html>
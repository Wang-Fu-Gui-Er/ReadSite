<%@ page import="com.yx.po.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html><!--书的简介-->
<html>
<head>
<meta charset="utf-8">
<title>檀香小筑</title>
<link rel="shortcut icon" href="images/favicon.png">
<link rel="icon" href="images/favicon.png" type="image/x-icon">
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="list_content fn-clear">

  <div class="list_right">
<%
    Book book = (Book) request.getAttribute("rbook");
    if (book == null){
%>
    <span><font size="5px">图书信息丢失，您可以和管理员联系，反映情况</font></span>
<%
    } else {
        String bookName = book.getBookName();
        String bigCate = book.getSmallCategory().getBigCategory().getBigCateName();
        long bigCateId = book.getSmallCategory().getBigCategory().getBigCateId();
        String smallCate = book.getSmallCategory().getSmallCateName();
        long smallCateId = book.getSmallCategory().getSmallCateId();
        String authorName = book.getAuthor().getAuthorName();
        String bookDesc = book.getBookDescribe();
        String bookPic = book.getBookPic();
        long bookId = book.getBookId();
%>
    <div class="position fn-clear">
      <span><a href="index.jsp">首页</a> >
        <a href="/book?type=manyBook&&bigCateId=<%=bigCateId%>"><%=bigCate%></a> >
          <a href="/book?type=manyBook&&bigCateId=<%=bigCateId%>&&smallCateId=<%=smallCateId%>&&page=1"><%=smallCate%></a>
      </span>
      <em><%=smallCate%></em>
    </div>

    <div class="chapterbox">
      <div class="bookpic"><a href="/chapter?chapType=chapBookId&&bookId=<%=bookId%>">
        <img src="<%=bookPic%>" width="134"
                                height="200"  alt="暂无封面"/></a></div>
      <div class="bookname"><a href="/chapter?chapType=chapBookId&&bookId=<%=bookId%>">《<%=bookName%>》</a></div>
      <div class="bookauthor">作者：<a href="/author.jsp"><%=authorName%></a></div>
      <div class="explain">
        <p><%=bookDesc%></p>
      </div>
    </div>
<%
    }
%>
  </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>

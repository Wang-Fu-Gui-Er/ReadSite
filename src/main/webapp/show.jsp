<%@ page import="com.yx.po.Chapter" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.io.FileOutputStream" %>
<%@ page import="java.io.ByteArrayInputStream" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html><!--在线阅读界面-->
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
<%
  List<Chapter> list = (List<Chapter>)request.getSession().getAttribute("listChapter");
  if (list == null){
%>
  <div class="list_right">
    <div class="showbox">
      <p><span><font size="5px">图书信息丢失，您可以和管理员联系，反映情况</font></span></p>
    </div>
  </div>
  <%
  } else {
      Iterator<Chapter> iterator = list.iterator();
      Chapter chap= iterator.next();
      String bookName = chap.getBook().getBookName();
      long chapTId_f = chap.getChapTitleId();
      String chapTName_f = chap.getChapTitleName();
      long chapId = chap.getChapId();
%>
  <div class="list_left">
    <div class="show_bookname">《<%=bookName%>》</div>
    <div class="show_category">
      <dl>
        <dt>第<%=chapTId_f%>章</dt>
        <dd><a href="/chapter?chapType=onlyChapId&&chapId=<%=chapId%>" class="selected"><%=chapTName_f%></a></dd>
      </dl>
<%
        while (iterator.hasNext()){
          Chapter chapter = iterator.next();
          long chapTId = chapter.getChapTitleId();
          String chapTName = chapter.getChapTitleName();
          chapId = chapter.getChapId();
%>
      <dl>
        <dt>第<%=chapTId%>章</dt>
        <dd><a href="/chapter?chapType=onlyChapId&&chapId=<%=chapId%>"><%=chapTName%></a></dd>
      </dl>
<%
      }
%>
      <%
        }
      %>
    </div>
  </div>
<%
    List<Chapter> tmpList = (List<Chapter>)request.getSession().getAttribute("listChapter");
    if (tmpList != null){
      Chapter chapter = tmpList.iterator().next();
      String smallCateName = chapter.getBook().getSmallCategory().getSmallCateName();
      String bigCateName = chapter.getBook().getSmallCategory().getBigCategory().getBigCateName();
      long bigCateId = chapter.getBook().getSmallCategory().getBigCategory().getBigCateId();
      long smallCateId = chapter.getBook().getSmallCategory().getSmallCateId();
%>

  <div class="list_right">
    <div class="position fn-clear">
      <span><a href="index.jsp">首页</a> >
        <a href="/book?type=manyBook&&bigCateId=<%=bigCateId%>&&page=1"><%=bigCateName%></a> >
        <a href="/book?type=manyBook&&bigCateId=<%=bigCateId%>&&smallCateId=<%=smallCateId%>&&page=1"><%=smallCateName%></a></span>
    </div>
<%
  }
%>
<%
    String flag = request.getParameter("msgFlag");
    Chapter chapterAll = (Chapter) request.getAttribute("chapterAll");
    if (chapterAll == null && flag!=null && flag.equals("right")){
%>
    <div class="showbox">
      <p><span><font size="5px">该章节丢失，您可以和管理员联系，反映情况</font></span></p>
    </div>
<%
    } else if (chapterAll != null){ //这章已经回到前端了，要获得它的前一章，和后一章
        String  con = chapterAll.getChapContent();
        Chapter preChap = (Chapter) request.getAttribute("preChap");
        Chapter nextChap = (Chapter) request.getAttribute("nextChap");
%>
    <div class="showbox">
      <p><%=con%></p>
    </div>

     <div class="prevnext">
      <div class="prev">上一章：<a href="/chapter?chapType=onlyChapId&&chapId=<%=preChap==null?"":preChap.getChapId()%>">
          <%=preChap==null?"无":preChap.getChapTitleName()%></a></div>
      <div class="next">下一章：<a href="/chapter?chapType=onlyChapId&&chapId=<%=nextChap==null?"":nextChap.getChapId()%>">
          <%=nextChap==null?"无":nextChap.getChapTitleName()%></a></div>
    </div>
<%
  }
%>

  </div>

</div>
<jsp:include page="footer.jsp"/>
</body>
</html>

<%@ page import="com.yx.po.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>檀香小筑</title>
    <link rel="shortcut icon" href="images/favicon.png">
    <link rel="icon" href="images/favicon.png" type="image/x-icon">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <script type="text/javascript">
        $(function () {
            var big_cate_id = $("#big_cate_id").val();
            if (big_cate_id == 1) {
                $("#big_cate").text("网络文学");
                $("#big_cate_a").text("网络文学");
            } else if (big_cate_id == 2) {
                $("#big_cate").text("小说");
                $("#big_cate_a").text("小说");
            } else if (big_cate_id == 3) {
                $("#big_cate").text("文艺");
                $("#big_cate_a").text("文艺");
            } else if (big_cate_id == 4) {
                $("#big_cate").text("人文社科");
                $("#big_cate_a").text("人文社科");
            } else if (big_cate_id == 5) {
                $("#big_cate").text("童书");
                $("#big_cate_a").text("童书");
            } else if (big_cate_id == 6) {
                $("#big_cate").text("生活");
                $("#big_cate_a").text("生活");
            } else if (big_cate_id == 7) {
                $("#big_cate").text("教育");
                $("#big_cate_a").text("教育");
            } else if (big_cate_id == 8) {
                $("#big_cate").text("经管");
                $("#big_cate_a").text("经管");
            } else if (big_cate_id == 9) {
                $("#big_cate").text("科技");
                $("#big_cate_a").text("科技");
            }
        });
    </script>
</head>

<body>
<jsp:include page="header.jsp"/>
<%
    String bigCate = request.getParameter("bigCateId");
%>
<input type="hidden" id="big_cate_id" name="big_cate_id"
       value="<%=request.getParameter("bigCateId")%>">

<div class="list_content fn-clear"><!--页面中部，内容部分-->

    <div class="list_left"><!--左部分类-->
        <div class="list_category">
            <dl id="d1_1">
                <dt><a href="/book?type=manyBook&&bigCateId=1&&page=1" target="_self">网络文学 </a></dt>
                <dd>
                    <a href="/book?type=manyBook&&bigCateId=1&&smallCateId=1&&page=1" target="_self">古代作品</a>
                    <a href="/book?type=manyBook&&bigCateId=1&&smallCateId=2&&page=1" target="_self">现代都市</a>
                    <a href="/book?type=manyBook&&bigCateId=1&&smallCateId=3&&page=1" target="_self">言情</a>
                    <a href="/book?type=manyBook&&bigCateId=1&&smallCateId=4&&page=1" target="_self">耽美作品</a>
                    <a href="/book?type=manyBook&&bigCateId=1&&smallCateId=5&&page=1" target="_self">同志文学</a>
                    <a href="/book?type=manyBook&&bigCateId=1&&smallCateId=6&&page=1" target="_self" class="last">玄幻</a>
                </dd>
            </dl>
            <dl>
                <dt><a href="/book?type=manyBook&&bigCateId=2&&page=1" target="_self">小说 </a></dt>
                <dd>
                    <a href="/book?type=manyBook&&bigCateId=2&&smallCateId=7&&page=1" target="_self">中国当代小说</a>
                    <a href="/book?type=manyBook&&bigCateId=2&&smallCateId=8&&page=1" target="_self">中国近代小说</a>
                    <a href="/book?type=manyBook&&bigCateId=2&&smallCateId=9&&page=1" target="_self">中国古典小说</a>
                    <a href="/book?type=manyBook&&bigCateId=2&&smallCateId=10&&page=1" target="_self"
                       class="last">外国小说</a>
                </dd>
            </dl>
            <dl>
                <dt><a href="/book?type=manyBook&&bigCateId=3&&page=1" target="_self">文艺 </a></dt>
                <dd>
                    <a href="/book?type=manyBook&&bigCateId=3&&smallCateId=11&&page=1" target="_self">文学</a>
                    <a href="/book?type=manyBook&&bigCateId=3&&smallCateId=12&&page=1" target="_self">艺术</a>
                    <a href="/book?type=manyBook&&bigCateId=3&&smallCateId=13&&page=1" target="_self">传记</a>
                    <a href="/book?type=manyBook&&bigCateId=3&&smallCateId=14&&page=1" target="_self"
                       class="last">摄影</a>
                </dd>
            </dl>
            <dl>
                <dt><a href="/book?type=manyBook&&bigCateId=4&&page=1" target="_self">人文社科 </a></dt>
                <dd>
                    <a href="/book?type=manyBook&&bigCateId=4&&smallCateId=15&&page=1" target="_self">哲学/宗教</a>
                    <a href="/book?type=manyBook&&bigCateId=4&&smallCateId=16&&page=1" target="_self">历史</a>
                    <a href="/book?type=manyBook&&bigCateId=4&&smallCateId=17&&page=1" target="_self">政治/军事</a>
                    <a href="/book?type=manyBook&&bigCateId=4&&smallCateId=18&&page=1" target="_self">文化</a>
                    <a href="/book?type=manyBook&&bigCateId=4&&smallCateId=19&&page=1" target="_self">社会科学</a>
                    <a href="/book?type=manyBook&&bigCateId=4&&smallCateId=20&&page=1" target="_self">心理学</a>
                    <a href="/book?type=manyBook&&bigCateId=4&&smallCateId=21&&page=1" target="_self">古籍</a>
                    <a href="/book?type=manyBook&&bigCateId=4&&smallCateId=22&&page=1" target="_self"
                       class="last">法律</a>
                </dd>
            </dl>
            <dl>
                <dt><a href="/book?type=manyBook&&bigCateId=5&&page=1" target="_self">童书 </a></dt>
                <dd>
                    <a href="/book?type=manyBook&&bigCateId=5&&smallCateId=28&&page=1" target="_self">科普/百科</a>
                    <a href="/book?type=manyBook&&bigCateId=5&&smallCateId=27&&page=1" target="_self">绘本</a>
                    <a href="/book?type=manyBook&&bigCateId=5&&smallCateId=26&&page=1" target="_self">文学</a>
                    <a href="/book?type=manyBook&&bigCateId=5&&smallCateId=25&&page=1" target="_self"
                       class="last">外语</a>
                </dd>
            </dl>
            <dl>
                <dt><a href="/book?type=manyBook&&bigCateId=6&&page=1" target="_self">生活 </a></dt>
                <dd>
                    <a href="/book?type=manyBook&&bigCateId=6&&smallCateId=31&&page=1" target="_self">保健</a>
                    <a href="/book?type=manyBook&&bigCateId=6&&smallCateId=30&&page=1" target="_self">亲子家教</a>
                    <a href="/book?type=manyBook&&bigCateId=6&&smallCateId=29&&page=1" target="_self">旅游</a>
                    <a href="/book?type=manyBook&&bigCateId=6&&smallCateId=24&&page=1" target="_self">美食</a>
                    <a href="/book?type=manyBook&&bigCateId=6&&smallCateId=23&&page=1" target="_self">育儿</a>
                    <a href="/book?type=manyBook&&bigCateId=6&&smallCateId=34&&page=1" target="_self">美妆</a>
                    <a href="/book?type=manyBook&&bigCateId=6&&smallCateId=33&&page=1" target="_self">手工DIY</a>
                    <a href="/book?type=manyBook&&bigCateId=6&&smallCateId=32&&page=1" target="_self">孕产/胎教</a>
                    <a href="/book?type=manyBook&&bigCateId=6&&smallCateId=35&&page=1" target="_self">休闲/爱好</a>
                    <a href="/book?type=manyBook&&bigCateId=6&&smallCateId=36&&page=1" target="_self"
                       class="last">休闲家居</a>
                </dd>
            </dl>
            <dl>
                <dt><a href="/book?type=manyBook&&bigCateId=7&&page=1" target="_self">教育 </a></dt>
                <dd>
                    <a href="/book?type=manyBook&&bigCateId=7&&smallCateId=37&&page=1" target="_self">教材</a>
                    <a href="/book?type=manyBook&&bigCateId=7&&smallCateId=38&&page=1" target="_self">外语</a>
                    <a href="/book?type=manyBook&&bigCateId=7&&smallCateId=39&&page=1" target="_self">考试</a>
                    <a href="/book?type=manyBook&&bigCateId=7&&smallCateId=40&&page=1" target="_self"
                       class="last">工具书</a>
                </dd>
            </dl>
            <dl>
                <dt><a href="/book?type=manyBook&&bigCateId=8&&page=1" target="_self">经管 </a></dt>
                <dd>
                    <a href="/book?type=manyBook&&bigCateId=8&&smallCateId=41&&page=1" target="_self">经济</a>
                    <a href="/book?type=manyBook&&bigCateId=8&&smallCateId=42&&page=1" target="_self">管理</a>
                    <a href="/book?type=manyBook&&bigCateId=8&&smallCateId=43&&page=1" target="_self"
                       class="last">投资理财</a>
                </dd>
            </dl>
            <dl>
                <dt><a href="/book?type=manyBook&&bigCateId=9&&page=1" target="_self">科技 </a></dt>
                <dd>
                    <a href="/book?type=manyBook&&bigCateId=9&&smallCateId=44&&page=1" target="_self">科普</a>
                    <a href="/book?type=manyBook&&bigCateId=9&&smallCateId=45&&page=1" target="_self">建筑</a>
                    <a href="/book?type=manyBook&&bigCateId=9&&smallCateId=46&&page=1" target="_self">医学</a>
                    <a href="/book?type=manyBook&&bigCateId=9&&smallCateId=47&&page=1" target="_self">计算机/网络</a>
                    <a href="/book?type=manyBook&&bigCateId=9&&smallCateId=48&&page=1" target="_self">自然科学</a>
                    <a href="/book?type=manyBook&&bigCateId=9&&smallCateId=49&&page=1" target="_self">农业/林业</a>
                    <a href="/book?type=manyBook&&bigCateId=9&&smallCateId=50&&page=1" target="_self"
                       class="last">工业技术</a>
                </dd>
            </dl>
        </div>
    </div>
    <%
        String small_cate_name = (String) request.getAttribute("small_cate_name");
    %>
    <div class="list_right"><!--右部具体展示-->
        <div class="position fn-clear">
      <span>
        <a href="index.jsp">首页</a> > <a href="/book?type=manyBook&&bigCateId=<%=bigCate%>&&page=1" id="big_cate_a"></a>
        <span id="small_cate"><%=small_cate_name != null ? " >" + small_cate_name : ""%></span>
      </span>
            <em id="big_cate"></em>
        </div>

        <div class="intwobox fn-clear">

            <%
                List<Book> list = (List<Book>) request.getAttribute("bookResult");
                if (list == null) {  //没有书
            %>
            <span><font size="5px">没有相关书籍，您可以和管理员联系，提交需求</font></span>
            <%
            } else { //有书，遍历展示
                Iterator<Book> iterable = list.iterator();
                while (iterable.hasNext()) {
                    Book book = iterable.next();
                    String bookName = book.getBookName();
                    long bookId = book.getBookId();
                    String bookPic = book.getBookPic();
            %>
            <dl>
                <dt>
                    <a href="/book?type=oneBook&&bookId=<%=bookId%>"><img src="<%=bookPic%>" width="110" height="150"
                                                                          alt="暂无封面"/></a>
                </dt>
                <dd><a href="/book?type=oneBook&&bookId=<%=bookId%>"><%=bookName%>
                </a></dd>
            </dl>
            <%
                    }
                }
            %>
        </div>

<%
        if (list == null) {
 %>
            <div class="pages"></div>
<%
        } else {
            int currentPageNo =(int) request.getAttribute("currentPage");
            int tmpPageNo = currentPageNo;
            int bookCount = (int) request.getAttribute("bookCount");
            int pageSum = bookCount%24==0?bookCount/24:bookCount/24+1;
            if (small_cate_name != null) {  //小分类分页查询
                long small_cate_id = (long) request.getAttribute("small_cate_id");

%>
                <div class="pages"><!--分页-->
                    <span>共<%=bookCount%>本</span>
                    <a class="first" href="/book?type=manyBook&&bigCateId=<%=bigCate%>&&smallCateId=<%=small_cate_id%>&&page=1">首页</a>
                    <a class="prev" href="/book?type=manyBook&&bigCateId=<%=bigCate%>&&smallCateId=<%=small_cate_id%>&&page=<%=(tmpPageNo>1?--tmpPageNo:tmpPageNo)%>"><<</a>
                    <a style="background:#31D6C5; color:#FFF; font-weight:700; border-color:#31D6C5;" href="#">
                        <%=currentPageNo%>
                    </a>
                    <a class="next" href="/book?type=manyBook&&bigCateId=<%=bigCate%>&&smallCateId=<%=small_cate_id%>&&page=<%=(tmpPageNo<pageSum?++tmpPageNo:tmpPageNo)%>">>></a>
                    <a class="end" href="/book?type=manyBook&&bigCateId=<%=bigCate%>&&smallCateId=<%=small_cate_id%>&&page=<%=pageSum%>">尾页</a>
                </div>
<%
        } else {    //大分类分页查询
%>
                <div class="pages"><!--分页-->
                    <span>共<%=bookCount%>本</span>
                    <a class="first" href="/book?type=manyBook&&bigCateId=<%=bigCate%>&&page=1">首页</a>
                    <a class="prev" href="/book?type=manyBook&&bigCateId=<%=bigCate%>&&page=<%=(tmpPageNo>1?--tmpPageNo:tmpPageNo)%>"><<</a>
                    <a style="background:#31D6C5; color:#FFF; font-weight:700; border-color:#31D6C5;" href="#">
                        <%=currentPageNo%>
                    </a>
                    <a class="next" href="/book?type=manyBook&&bigCateId=<%=bigCate%>&&page=<%=(tmpPageNo<pageSum?++tmpPageNo:tmpPageNo)%>">>></a>
                    <a class="end" href="/book?type=manyBook&&bigCateId=<%=bigCate%>&&page=<%=pageSum%>">尾页</a>
                </div>
<%
                }
            }
%>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>

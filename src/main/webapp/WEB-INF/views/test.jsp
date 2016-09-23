<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--
  Created by IntelliJ IDEA.
  User: Sooyoung
  Date: 2016-07-29
  Time: 오후 3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>다국어 테스으 </title>
    
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    
    <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script type="text/javascript" language="JavaScript"
            src="/resources/js/jquery.i18n.properties.js"></script>
    <script type="text/javascript" language="JavaScript"
            src="/resources/js/i18n.js"></script>
</head>
<body>
<h1>${hello}!!!</h1>
Language : <a href="?lang=en">English</a>|<a href="?lang=ko">Korean</a>|<a href="?lang=cn">China</a>
</br>
<spring:message code="message.test"/>
</br>
<spring:message code="message.test2"/>
</br>
<spring:message code="message.test3"/>

<div class="row">
    <div class="btn btn-primary" id="btn">
        <spring:message code="test.button"/>
    </div>
</div>
    
<input type="hidden" id="locale" value="${sessionScope.locale}"/>
<script type="text/javascript">
    $(document).ready(function () {

        $("#btn").click(function () {
            alert(loadBundle('test.button'));
        })
    })
    
    
</script>

</body>
</html>

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%><% 
    String path=request.getContextPath();
 %>


<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/style3.css"/>
<script type="text/javascript" src="<%=path %>/javascript/validation.js"></script>
</head>

<body>
<tiles:insert page="/template/baseLayout.jsp" flush="true">
<tiles:put name="header" value="/template/header.jsp"></tiles:put>
<tiles:put name="left" value="/template/leftMenu.jsp"></tiles:put>
<tiles:put name="footer" value="/template/footer.jsp"></tiles:put>
<tiles:put name="body" value="/template/body.jsp"></tiles:put>

</tiles:insert>    

  </body>
</html>
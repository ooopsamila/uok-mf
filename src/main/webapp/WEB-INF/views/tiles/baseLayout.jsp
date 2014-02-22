<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="max-age=0, no-cache, no-store, must-revalidate"/>

    <title><%out.print("uok-mf");%></title>

    <jsp:include page="library.jsp"/>


</head>
<body>
<div class="maincontent" id="custom-doc" align="center">
    <div id="hd" align="center">
        <%--<tiles:insertAttribute name="header" />--%>
    </div>
    <div id="bd" align="center">
        <div id="wrapper">
            <div>
                <tiles:insertAttribute name="menu" />
            </div>
            <div class="bumperpack">
                <div class="bw1">
                    <div class="bw2">
                        <div class="bw3">
                            <div class="bw4">
                                <div class="bw5">
                                    <div class="bw6">
                                        <div id="mask" >

                                        </div>
                                        <tiles:insertAttribute name="container" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="footer">
        <tiles:insertAttribute name="footer" />
    </div>
</div>

</body>
</html>
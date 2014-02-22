<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>

<fmt:bundle basename="messages">
    <script type="text/javascript" src="<c:url value="/resources/js/sdmenu.js" />">
        //
    </script>

    <div id="my_menu" class="sdmenu">

        <sec:authorize
                ifAnyGranted="ROLE_CAMPAIGN_CREATION_NORMAL,ROLE_CAMPAIGN_CREATION_FAST_FLOW,ROLE_CAMPAIGN_CREATION_BULK_REWARDS,ROLE_CAMPAIGN_SEARCH,ROLE_CAMPAIGN_CREATION_INSTANT_REWARDS">
            <div>
                <span><fmt:message key="uok.mf.menu.bar.results"/></span>
                <a tabindex="-1" href="<c:url value="/add_results.html"/>"> &nbsp;&nbsp;<fmt:message
                        key="uok.mf.menu.bar.add.result"/></a>
                <a tabindex="-1" href="<c:url value="/manage_results.html"/>"> &nbsp;&nbsp;<fmt:message
                        key="uok.mf.menu.bar.manage.results"/></a>
            </div>
            <div>
                <span><fmt:message key="uok.mf.menu.bar.students"/></span>
                <a tabindex="-1" href="<c:url value="/add_students.html"/>"> &nbsp;&nbsp;<fmt:message
                        key="uok.mf.menu.bar.add.students"/></a>
                <a tabindex="-1" href="<c:url value="/manage_students.html"/>"> &nbsp;&nbsp;<fmt:message
                        key="uok.mf.menu.bar.manage.students"/></a>
            </div>
            <div>
                <span><fmt:message key="uok.mf.menu.bar.subjects"/></span>
                <a tabindex="-1" href="<c:url value="/add_subjects.html"/>"> &nbsp;&nbsp;<fmt:message
                        key="uok.mf.menu.bar.add.subjects"/></a>
                <a tabindex="-1" href="<c:url value="/manage_subjects.html"/>"> &nbsp;&nbsp;<fmt:message
                        key="uok.mf.menu.bar.manage.subjects"/></a>
            </div>

    </div>
</fmt:bundle>

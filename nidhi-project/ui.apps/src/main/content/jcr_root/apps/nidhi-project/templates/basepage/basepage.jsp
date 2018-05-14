<%--

  Base Page Nidhi component.

  

--%><%
%><%@include file="/libs/foundation/global.jsp"%><%
%><%@page session="false" %><%
%><%
	// TODO add you code here
%>

<%@include file="/libs/wcm/core/components/init/init.jsp"%>

<!DOCTYPE html>
    <head>
        <cq:includeClientLib css="nidhi.main" />

    </head>
    <body>

        <header>
header
        </header>
        <div class="main">
            <cq:include path="parsys" resourceType = "/libs/foundation/components/parsys"/>

nidhi

        </div>
        <footer>
            footer

            <cq:includeClientLib js="nidhi.main"/>

        </footer>
    </body>
</html>
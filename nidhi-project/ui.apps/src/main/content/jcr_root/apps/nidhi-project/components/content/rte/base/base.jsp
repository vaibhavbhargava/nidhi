<%--
   base.jsp

  Author: Mohit Bansal
  Date Created:  28-Aug-2014

  Copyright 2014 BT adviser Rating
  All Rights Reserved.

  This software is the confidential and proprietary information of
  BT Financial, ("Confidential Information"). You shall not
  disclose such Confidential Information and shall use it only in
  accordance with the terms of the license agreement you entered into
  with BT Financial.
  ==============================================================================

  Rich Text Editor Component

  This script is the default script that is executed for the  Rich Text Editor Component
  that allows editors to add and modify text on page .
  ==============================================================================
--%><%
%><%@include file="/apps/btfoundation/global/global.jsp"%>
<c:set var='divid' value="${properties['divid']}" />
<c:choose>
    <c:when test="${isAuthorMode}">
		<div class="clearfix">
			<cq:text property="text" placeholder="<div class='auth--info'>Edit to place rich text content in this section. This control enables you to add styles and additional formatting to your text to make it neat and presentable.</div>"></cq:text>
		</div>
    </c:when>
    <c:otherwise>
		<div class="rte" id="${divid}">
			<btf:linkUpdate>
				<cq:text property="text" placeholder="<div class='auth--info'>Edit to place rich text content in this section. This control enables you to add styles and additional formatting to your text to make it neat and presentable.</div>"></cq:text>
			</btf:linkUpdate>
		</div>
    </c:otherwise>
</c:choose>
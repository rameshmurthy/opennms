<%--
/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2007-2012 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2012 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

--%>

<%@page language="java"
	contentType="text/html"
	session="true"
	import="org.opennms.netmgt.config.UserFactory,
	org.opennms.netmgt.config.UserManager,
	org.opennms.netmgt.config.users.User,
    org.springframework.web.context.WebApplicationContext,
    org.springframework.web.context.support.WebApplicationContextUtils,
    org.opennms.web.api.Authentication"
%>

<%
	boolean canEdit = false;
    String userid = request.getRemoteUser();
    if (request.isUserInRole(Authentication.ROLE_ADMIN)) {
        canEdit = true;
    } else {
	    try {
            final WebApplicationContext webAppContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
            final UserManager userFactory = webAppContext.getBean("userManager", org.opennms.netmgt.config.UserManager.class);
       		User user = userFactory.getUser(userid);
       		if (!user.isReadOnly()) {
       		    canEdit = true;
       		}
	    } catch (Throwable e) {
	    	throw new ServletException("Couldn't initialize UserFactory", e);
	    }
	}
%>

<jsp:include page="/includes/header.jsp" flush="false" >
  <jsp:param name="title" value="User Account Self-Service" />
  <jsp:param name="headTitle" value="User Account Self-Service" />
  <jsp:param name="breadcrumb" value="User Account Self-Service" />
</jsp:include>

<script type="text/javascript">
  function changePassword() {
	  <% if (canEdit) { %>
    document.selfServiceForm.action = "account/selfService/newPasswordEntry";
    document.selfServiceForm.submit();
<% } else { %>
	alert("The <%= userid %> user is read-only!  Please have an administrator change your password.");
<% } %>
  }
</script>

<div class="TwoColLeft">
    <h3>User Account Self-Service</h3>
        <div class="boxWrapper">
        <ul class="plain">
        <li><a href="javascript:changePassword()">Change Password</a></li>
        </ul>
        </div>
</div>

<div class="TwoColRight">
    <h3>Account Self-Service Options</h3>
    <div class="boxWrapper">
    <p>
    Currently, account self-service is limited to password changes. Note that in environments using a
    reduced sign-on system such as LDAP, changing your password here may have no effect and may not even be
    possible.
    </p>
    <p>
    If you require further changes to your account, please contact the person within your organization responsible for
    maintaining OpenNMS.
    </p>
    </div>
</div>

<form name="selfServiceForm" method="post"></form>

<jsp:include page="/includes/footer.jsp" flush="false" />
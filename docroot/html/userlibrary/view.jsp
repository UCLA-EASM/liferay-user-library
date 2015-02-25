<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>

<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.sample.service.DocumentLocalServiceUtil" %>

<portlet:defineObjects />

<h1>My Library</h1>

<%


/* List documents = DocumentLocalServiceUtil.getDocuments(0, 10); */

%>

<table>
	<thead>
		<tr>
			<th>URL</th>
			<th>Downloaded at</th>
		</tr>
	</thead>
	<tbody>
		
	</tbody>
</table>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>

<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.sample.service.DocumentLocalServiceUtil" %>

<portlet:defineObjects />

<h1>My Library</h1>


<!-- Document list -->
<%

String originalURL = renderRequest.getParameter("originalURL");

if (originalURL != null) {
	%>
	You entered <%=originalURL %>!
	<%
}

/* DocumentLocalServiceUtil.addDocument(, 0, "http://example.com/", "asdfj;kasjdfasdf"); */

List documents = DocumentLocalServiceUtil.getDocuments(0, 10);

%>
<%-- 
<%=documents.size() %> --%>
<portlet:renderURL var="viewDocumentURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<aui:form action="<%= viewDocumentURL %>" method="POST">
	<aui:input id="originalURL" name="originalURL"></aui:input>
	<aui:button type="submit" value="Save your URL"></aui:button>
</aui:form>

<liferay-ui:search-container delta="10" emptyResultsMessage="No documents found">
	<liferay-ui:search-container-results
		results="<%=DocumentLocalServiceUtil.getDocuments(searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=DocumentLocalServiceUtil.getDocumentsCount()%>"
		/>
		
	<liferay-ui:search-container-row
		className="com.liferay.sample.model.Document"
		keyProperty="documentId"
		modelVar="document"
	>
		<liferay-ui:search-container-column-text
			name="originalURL"
			value="<%= document.getOriginalURL() %>"
		/>
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
		
</liferay-ui:search-container>


<%-- <table>
	<thead>
		<tr>
			<th>URL</th>
			<th>Downloaded at</th>
		</tr>
	</thead>
	<tbody>
		<liferay-ui:search-container delta="20" emptyResultsMessage="No documents found" searchContainer="${documents}">
			<liferay-ui:search-container-results results="${documents}" />
			<liferay-ui:search-container-row 
				className="com.liferay.sample.model.Document" 
				keyProperty="originalURL"
				modelVar="originalURL"
			>
				<%= originalURL %>
			</liferay-ui:search-container-row>
			
		</liferay-ui:search-container>
	</tbody>
</table> --%>
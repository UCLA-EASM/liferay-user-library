package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.sample.model.Document;
import com.liferay.sample.service.DocumentLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class UserLibraryPortlet
 */
public class UserLibraryPortlet extends MVCPortlet {
	public void addDocument(ActionRequest request, ActionResponse response) throws Exception {
		_updateDocument(request);
		
		sendRedirect(request, response);
	}
	
	public void deleteDocument(ActionRequest request, ActionResponse response) throws Exception {
		
		long documentId = ParamUtil.getLong(request, "documentId");
		
		DocumentLocalServiceUtil.deleteDocument(documentId);
		
		sendRedirect(request, response);
	}
	
	public void updateDocument(ActionRequest request, ActionResponse response) throws Exception {
		
		_updateDocument(request);
		
		sendRedirect(request, response);
	}
	
	private Document _updateDocument(ActionRequest request) 
			throws PortalException, SystemException, MalformedURLException, UnsupportedEncodingException, IOException {
		
		long documentId = ParamUtil.getLong(request, "documentId");
		
		String originalURL = ParamUtil.getString(request, "originalURL");
		String content = ""; // = ParamUtil.getString(request, "content");
		
		
		URL url = new URL(originalURL);
		
		try {
			InputStream inputStream = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			
			String line;
			StringBuilder contentReader = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				contentReader.append(line);
			}
			content = contentReader.toString();
		} catch (UnsupportedEncodingException ex) {
			_log.error(ex);
			throw ex;
		} catch (IOException ex) {
			_log.error(ex);
			throw ex;
		}
		
		
		Document document = null;
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Document.class.getName(), request);
		
		if (documentId <= 0) {
			document = DocumentLocalServiceUtil.addDocument(
					serviceContext.getUserId(), serviceContext.getScopeGroupId(),
					originalURL, content
			);
		} else {
			document = DocumentLocalServiceUtil.getDocument(documentId);
			
			document = DocumentLocalServiceUtil.updateDocument(
					serviceContext.getUserId(), serviceContext.getScopeGroupId(),
					originalURL, content, serviceContext
			);
		}
		
		return document;
		
	}
	
	private static Log _log = LogFactoryUtil.getLog(UserLibraryPortlet.class);


}

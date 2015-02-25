/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sample.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Document service. Represents a row in the &quot;Library_Document&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.sample.model.impl.DocumentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.sample.model.impl.DocumentImpl}.
 * </p>
 *
 * @author Dave Shepard
 * @see Document
 * @see com.liferay.sample.model.impl.DocumentImpl
 * @see com.liferay.sample.model.impl.DocumentModelImpl
 * @generated
 */
public interface DocumentModel extends BaseModel<Document> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a document model instance should use the {@link Document} interface instead.
	 */

	/**
	 * Returns the primary key of this document.
	 *
	 * @return the primary key of this document
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this document.
	 *
	 * @param primaryKey the primary key of this document
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the document ID of this document.
	 *
	 * @return the document ID of this document
	 */
	public long getDocumentId();

	/**
	 * Sets the document ID of this document.
	 *
	 * @param documentId the document ID of this document
	 */
	public void setDocumentId(long documentId);

	/**
	 * Returns the original u r l of this document.
	 *
	 * @return the original u r l of this document
	 */
	@AutoEscape
	public String getOriginalURL();

	/**
	 * Sets the original u r l of this document.
	 *
	 * @param originalURL the original u r l of this document
	 */
	public void setOriginalURL(String originalURL);

	/**
	 * Returns the content of this document.
	 *
	 * @return the content of this document
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this document.
	 *
	 * @param content the content of this document
	 */
	public void setContent(String content);

	/**
	 * Returns the group ID of this document.
	 *
	 * @return the group ID of this document
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this document.
	 *
	 * @param groupId the group ID of this document
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this document.
	 *
	 * @return the company ID of this document
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this document.
	 *
	 * @param companyId the company ID of this document
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this document.
	 *
	 * @return the user ID of this document
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this document.
	 *
	 * @param userId the user ID of this document
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this document.
	 *
	 * @return the user uuid of this document
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this document.
	 *
	 * @param userUuid the user uuid of this document
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this document.
	 *
	 * @return the create date of this document
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this document.
	 *
	 * @param createDate the create date of this document
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this document.
	 *
	 * @return the modified date of this document
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this document.
	 *
	 * @param modifiedDate the modified date of this document
	 */
	public void setModifiedDate(Date modifiedDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Document document);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Document> toCacheModel();

	@Override
	public Document toEscapedModel();

	@Override
	public Document toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
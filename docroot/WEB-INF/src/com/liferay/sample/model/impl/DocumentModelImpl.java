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

package com.liferay.sample.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.sample.model.Document;
import com.liferay.sample.model.DocumentModel;
import com.liferay.sample.model.DocumentSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Document service. Represents a row in the &quot;Library_Document&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.sample.model.DocumentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DocumentImpl}.
 * </p>
 *
 * @author Dave Shepard
 * @see DocumentImpl
 * @see com.liferay.sample.model.Document
 * @see com.liferay.sample.model.DocumentModel
 * @generated
 */
@JSON(strict = true)
public class DocumentModelImpl extends BaseModelImpl<Document>
	implements DocumentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a document model instance should use the {@link com.liferay.sample.model.Document} interface instead.
	 */
	public static final String TABLE_NAME = "Library_Document";
	public static final Object[][] TABLE_COLUMNS = {
			{ "documentId", Types.BIGINT },
			{ "originalURL", Types.VARCHAR },
			{ "content", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table Library_Document (documentId LONG not null primary key,originalURL VARCHAR(75) null,content VARCHAR(75) null,groupId LONG,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table Library_Document";
	public static final String ORDER_BY_JPQL = " ORDER BY document.documentId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Library_Document.documentId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.sample.model.Document"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.sample.model.Document"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.sample.model.Document"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long CREATEDATE_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long MODIFIEDDATE_COLUMN_BITMASK = 8L;
	public static long USERID_COLUMN_BITMASK = 16L;
	public static long DOCUMENTID_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Document toModel(DocumentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Document model = new DocumentImpl();

		model.setDocumentId(soapModel.getDocumentId());
		model.setOriginalURL(soapModel.getOriginalURL());
		model.setContent(soapModel.getContent());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Document> toModels(DocumentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Document> models = new ArrayList<Document>(soapModels.length);

		for (DocumentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.sample.model.Document"));

	public DocumentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _documentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDocumentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _documentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Document.class;
	}

	@Override
	public String getModelClassName() {
		return Document.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("documentId", getDocumentId());
		attributes.put("originalURL", getOriginalURL());
		attributes.put("content", getContent());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		String originalURL = (String)attributes.get("originalURL");

		if (originalURL != null) {
			setOriginalURL(originalURL);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@JSON
	@Override
	public long getDocumentId() {
		return _documentId;
	}

	@Override
	public void setDocumentId(long documentId) {
		_documentId = documentId;
	}

	@JSON
	@Override
	public String getOriginalURL() {
		if (_originalURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _originalURL;
		}
	}

	@Override
	public void setOriginalURL(String originalURL) {
		_originalURL = originalURL;
	}

	@JSON
	@Override
	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask |= CREATEDATE_COLUMN_BITMASK;

		if (_originalCreateDate == null) {
			_originalCreateDate = _createDate;
		}

		_createDate = createDate;
	}

	public Date getOriginalCreateDate() {
		return _originalCreateDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_columnBitmask |= MODIFIEDDATE_COLUMN_BITMASK;

		if (_originalModifiedDate == null) {
			_originalModifiedDate = _modifiedDate;
		}

		_modifiedDate = modifiedDate;
	}

	public Date getOriginalModifiedDate() {
		return _originalModifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Document.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Document toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Document)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DocumentImpl documentImpl = new DocumentImpl();

		documentImpl.setDocumentId(getDocumentId());
		documentImpl.setOriginalURL(getOriginalURL());
		documentImpl.setContent(getContent());
		documentImpl.setGroupId(getGroupId());
		documentImpl.setCompanyId(getCompanyId());
		documentImpl.setUserId(getUserId());
		documentImpl.setCreateDate(getCreateDate());
		documentImpl.setModifiedDate(getModifiedDate());

		documentImpl.resetOriginalValues();

		return documentImpl;
	}

	@Override
	public int compareTo(Document document) {
		long primaryKey = document.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Document)) {
			return false;
		}

		Document document = (Document)obj;

		long primaryKey = document.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		DocumentModelImpl documentModelImpl = this;

		documentModelImpl._originalGroupId = documentModelImpl._groupId;

		documentModelImpl._setOriginalGroupId = false;

		documentModelImpl._originalCompanyId = documentModelImpl._companyId;

		documentModelImpl._setOriginalCompanyId = false;

		documentModelImpl._originalUserId = documentModelImpl._userId;

		documentModelImpl._setOriginalUserId = false;

		documentModelImpl._originalCreateDate = documentModelImpl._createDate;

		documentModelImpl._originalModifiedDate = documentModelImpl._modifiedDate;

		documentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Document> toCacheModel() {
		DocumentCacheModel documentCacheModel = new DocumentCacheModel();

		documentCacheModel.documentId = getDocumentId();

		documentCacheModel.originalURL = getOriginalURL();

		String originalURL = documentCacheModel.originalURL;

		if ((originalURL != null) && (originalURL.length() == 0)) {
			documentCacheModel.originalURL = null;
		}

		documentCacheModel.content = getContent();

		String content = documentCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			documentCacheModel.content = null;
		}

		documentCacheModel.groupId = getGroupId();

		documentCacheModel.companyId = getCompanyId();

		documentCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			documentCacheModel.createDate = createDate.getTime();
		}
		else {
			documentCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			documentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			documentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return documentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{documentId=");
		sb.append(getDocumentId());
		sb.append(", originalURL=");
		sb.append(getOriginalURL());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sample.model.Document");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>documentId</column-name><column-value><![CDATA[");
		sb.append(getDocumentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>originalURL</column-name><column-value><![CDATA[");
		sb.append(getOriginalURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Document.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Document.class
		};
	private long _documentId;
	private String _originalURL;
	private String _content;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private Date _createDate;
	private Date _originalCreateDate;
	private Date _modifiedDate;
	private Date _originalModifiedDate;
	private long _columnBitmask;
	private Document _escapedModel;
}
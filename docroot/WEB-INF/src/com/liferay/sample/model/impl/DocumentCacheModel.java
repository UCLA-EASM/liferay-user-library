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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.sample.model.Document;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Document in entity cache.
 *
 * @author Dave Shepard
 * @see Document
 * @generated
 */
public class DocumentCacheModel implements CacheModel<Document>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{documentId=");
		sb.append(documentId);
		sb.append(", originalURL=");
		sb.append(originalURL);
		sb.append(", content=");
		sb.append(content);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Document toEntityModel() {
		DocumentImpl documentImpl = new DocumentImpl();

		documentImpl.setDocumentId(documentId);

		if (originalURL == null) {
			documentImpl.setOriginalURL(StringPool.BLANK);
		}
		else {
			documentImpl.setOriginalURL(originalURL);
		}

		if (content == null) {
			documentImpl.setContent(StringPool.BLANK);
		}
		else {
			documentImpl.setContent(content);
		}

		documentImpl.setGroupId(groupId);
		documentImpl.setCompanyId(companyId);
		documentImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			documentImpl.setCreateDate(null);
		}
		else {
			documentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			documentImpl.setModifiedDate(null);
		}
		else {
			documentImpl.setModifiedDate(new Date(modifiedDate));
		}

		documentImpl.resetOriginalValues();

		return documentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		documentId = objectInput.readLong();
		originalURL = objectInput.readUTF();
		content = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(documentId);

		if (originalURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(originalURL);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long documentId;
	public String originalURL;
	public String content;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
}
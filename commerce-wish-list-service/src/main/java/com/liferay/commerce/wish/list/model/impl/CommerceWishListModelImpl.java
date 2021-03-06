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

package com.liferay.commerce.wish.list.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.wish.list.model.CommerceWishList;
import com.liferay.commerce.wish.list.model.CommerceWishListModel;
import com.liferay.commerce.wish.list.model.CommerceWishListSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CommerceWishList service. Represents a row in the &quot;CommerceWishList&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CommerceWishListModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceWishListImpl}.
 * </p>
 *
 * @author Andrea Di Giorgi
 * @see CommerceWishListImpl
 * @see CommerceWishList
 * @see CommerceWishListModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CommerceWishListModelImpl extends BaseModelImpl<CommerceWishList>
	implements CommerceWishListModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce wish list model instance should use the {@link CommerceWishList} interface instead.
	 */
	public static final String TABLE_NAME = "CommerceWishList";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "commerceWishListId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "defaultWishList", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("commerceWishListId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("defaultWishList", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table CommerceWishList (uuid_ VARCHAR(75) null,commerceWishListId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,defaultWishList BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table CommerceWishList";
	public static final String ORDER_BY_JPQL = " ORDER BY commerceWishList.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CommerceWishList.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.wish.list.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.commerce.wish.list.model.CommerceWishList"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.wish.list.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.commerce.wish.list.model.CommerceWishList"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.wish.list.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.commerce.wish.list.model.CommerceWishList"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long CREATEDATE_COLUMN_BITMASK = 2L;
	public static final long DEFAULTWISHLIST_COLUMN_BITMASK = 4L;
	public static final long GROUPID_COLUMN_BITMASK = 8L;
	public static final long USERID_COLUMN_BITMASK = 16L;
	public static final long UUID_COLUMN_BITMASK = 32L;
	public static final long NAME_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommerceWishList toModel(CommerceWishListSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CommerceWishList model = new CommerceWishListImpl();

		model.setUuid(soapModel.getUuid());
		model.setCommerceWishListId(soapModel.getCommerceWishListId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setDefaultWishList(soapModel.isDefaultWishList());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommerceWishList> toModels(
		CommerceWishListSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CommerceWishList> models = new ArrayList<CommerceWishList>(soapModels.length);

		for (CommerceWishListSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.commerce.wish.list.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.commerce.wish.list.model.CommerceWishList"));

	public CommerceWishListModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceWishListId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceWishListId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceWishListId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceWishList.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceWishList.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("commerceWishListId", getCommerceWishListId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("defaultWishList", isDefaultWishList());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long commerceWishListId = (Long)attributes.get("commerceWishListId");

		if (commerceWishListId != null) {
			setCommerceWishListId(commerceWishListId);
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

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean defaultWishList = (Boolean)attributes.get("defaultWishList");

		if (defaultWishList != null) {
			setDefaultWishList(defaultWishList);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getCommerceWishListId() {
		return _commerceWishListId;
	}

	@Override
	public void setCommerceWishListId(long commerceWishListId) {
		_commerceWishListId = commerceWishListId;
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
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
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

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		_name = name;
	}

	@JSON
	@Override
	public boolean getDefaultWishList() {
		return _defaultWishList;
	}

	@JSON
	@Override
	public boolean isDefaultWishList() {
		return _defaultWishList;
	}

	@Override
	public void setDefaultWishList(boolean defaultWishList) {
		_columnBitmask |= DEFAULTWISHLIST_COLUMN_BITMASK;

		if (!_setOriginalDefaultWishList) {
			_setOriginalDefaultWishList = true;

			_originalDefaultWishList = _defaultWishList;
		}

		_defaultWishList = defaultWishList;
	}

	public boolean getOriginalDefaultWishList() {
		return _originalDefaultWishList;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				CommerceWishList.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CommerceWishList.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceWishList toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CommerceWishList)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommerceWishListImpl commerceWishListImpl = new CommerceWishListImpl();

		commerceWishListImpl.setUuid(getUuid());
		commerceWishListImpl.setCommerceWishListId(getCommerceWishListId());
		commerceWishListImpl.setGroupId(getGroupId());
		commerceWishListImpl.setCompanyId(getCompanyId());
		commerceWishListImpl.setUserId(getUserId());
		commerceWishListImpl.setUserName(getUserName());
		commerceWishListImpl.setCreateDate(getCreateDate());
		commerceWishListImpl.setModifiedDate(getModifiedDate());
		commerceWishListImpl.setName(getName());
		commerceWishListImpl.setDefaultWishList(isDefaultWishList());

		commerceWishListImpl.resetOriginalValues();

		return commerceWishListImpl;
	}

	@Override
	public int compareTo(CommerceWishList commerceWishList) {
		int value = 0;

		value = getName().compareTo(commerceWishList.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommerceWishList)) {
			return false;
		}

		CommerceWishList commerceWishList = (CommerceWishList)obj;

		long primaryKey = commerceWishList.getPrimaryKey();

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
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CommerceWishListModelImpl commerceWishListModelImpl = this;

		commerceWishListModelImpl._originalUuid = commerceWishListModelImpl._uuid;

		commerceWishListModelImpl._originalGroupId = commerceWishListModelImpl._groupId;

		commerceWishListModelImpl._setOriginalGroupId = false;

		commerceWishListModelImpl._originalCompanyId = commerceWishListModelImpl._companyId;

		commerceWishListModelImpl._setOriginalCompanyId = false;

		commerceWishListModelImpl._originalUserId = commerceWishListModelImpl._userId;

		commerceWishListModelImpl._setOriginalUserId = false;

		commerceWishListModelImpl._originalCreateDate = commerceWishListModelImpl._createDate;

		commerceWishListModelImpl._setModifiedDate = false;

		commerceWishListModelImpl._originalDefaultWishList = commerceWishListModelImpl._defaultWishList;

		commerceWishListModelImpl._setOriginalDefaultWishList = false;

		commerceWishListModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceWishList> toCacheModel() {
		CommerceWishListCacheModel commerceWishListCacheModel = new CommerceWishListCacheModel();

		commerceWishListCacheModel.uuid = getUuid();

		String uuid = commerceWishListCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			commerceWishListCacheModel.uuid = null;
		}

		commerceWishListCacheModel.commerceWishListId = getCommerceWishListId();

		commerceWishListCacheModel.groupId = getGroupId();

		commerceWishListCacheModel.companyId = getCompanyId();

		commerceWishListCacheModel.userId = getUserId();

		commerceWishListCacheModel.userName = getUserName();

		String userName = commerceWishListCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceWishListCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceWishListCacheModel.createDate = createDate.getTime();
		}
		else {
			commerceWishListCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceWishListCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commerceWishListCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceWishListCacheModel.name = getName();

		String name = commerceWishListCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			commerceWishListCacheModel.name = null;
		}

		commerceWishListCacheModel.defaultWishList = isDefaultWishList();

		return commerceWishListCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", commerceWishListId=");
		sb.append(getCommerceWishListId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", defaultWishList=");
		sb.append(isDefaultWishList());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.commerce.wish.list.model.CommerceWishList");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commerceWishListId</column-name><column-value><![CDATA[");
		sb.append(getCommerceWishListId());
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
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>defaultWishList</column-name><column-value><![CDATA[");
		sb.append(isDefaultWishList());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CommerceWishList.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CommerceWishList.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _commerceWishListId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _originalCreateDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private boolean _defaultWishList;
	private boolean _originalDefaultWishList;
	private boolean _setOriginalDefaultWishList;
	private long _columnBitmask;
	private CommerceWishList _escapedModel;
}
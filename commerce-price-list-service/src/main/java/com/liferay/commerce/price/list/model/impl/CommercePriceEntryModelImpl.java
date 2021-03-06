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

package com.liferay.commerce.price.list.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.price.list.model.CommercePriceEntry;
import com.liferay.commerce.price.list.model.CommercePriceEntryModel;
import com.liferay.commerce.price.list.model.CommercePriceEntrySoap;

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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CommercePriceEntry service. Represents a row in the &quot;CommercePriceEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CommercePriceEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommercePriceEntryImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceEntryImpl
 * @see CommercePriceEntry
 * @see CommercePriceEntryModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CommercePriceEntryModelImpl extends BaseModelImpl<CommercePriceEntry>
	implements CommercePriceEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce price entry model instance should use the {@link CommercePriceEntry} interface instead.
	 */
	public static final String TABLE_NAME = "CommercePriceEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "externalReferenceCode", Types.VARCHAR },
			{ "commercePriceEntryId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "commercePriceListId", Types.BIGINT },
			{ "CPInstanceUuid", Types.VARCHAR },
			{ "CProductId", Types.BIGINT },
			{ "price", Types.DECIMAL },
			{ "promoPrice", Types.DECIMAL },
			{ "hasTierPrice", Types.BOOLEAN },
			{ "lastPublishDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("commercePriceEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commercePriceListId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CPInstanceUuid", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CProductId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("price", Types.DECIMAL);
		TABLE_COLUMNS_MAP.put("promoPrice", Types.DECIMAL);
		TABLE_COLUMNS_MAP.put("hasTierPrice", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table CommercePriceEntry (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,commercePriceEntryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commercePriceListId LONG,CPInstanceUuid VARCHAR(75) null,CProductId LONG,price DECIMAL(30, 16) null,promoPrice DECIMAL(30, 16) null,hasTierPrice BOOLEAN,lastPublishDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table CommercePriceEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY commercePriceEntry.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CommercePriceEntry.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.price.list.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.commerce.price.list.model.CommercePriceEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.price.list.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.commerce.price.list.model.CommercePriceEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.price.list.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.commerce.price.list.model.CommercePriceEntry"),
			true);
	public static final long CPINSTANCEUUID_COLUMN_BITMASK = 1L;
	public static final long COMMERCEPRICELISTID_COLUMN_BITMASK = 2L;
	public static final long COMPANYID_COLUMN_BITMASK = 4L;
	public static final long EXTERNALREFERENCECODE_COLUMN_BITMASK = 8L;
	public static final long GROUPID_COLUMN_BITMASK = 16L;
	public static final long UUID_COLUMN_BITMASK = 32L;
	public static final long CREATEDATE_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommercePriceEntry toModel(CommercePriceEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CommercePriceEntry model = new CommercePriceEntryImpl();

		model.setUuid(soapModel.getUuid());
		model.setExternalReferenceCode(soapModel.getExternalReferenceCode());
		model.setCommercePriceEntryId(soapModel.getCommercePriceEntryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommercePriceListId(soapModel.getCommercePriceListId());
		model.setCPInstanceUuid(soapModel.getCPInstanceUuid());
		model.setCProductId(soapModel.getCProductId());
		model.setPrice(soapModel.getPrice());
		model.setPromoPrice(soapModel.getPromoPrice());
		model.setHasTierPrice(soapModel.isHasTierPrice());
		model.setLastPublishDate(soapModel.getLastPublishDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommercePriceEntry> toModels(
		CommercePriceEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CommercePriceEntry> models = new ArrayList<CommercePriceEntry>(soapModels.length);

		for (CommercePriceEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.commerce.price.list.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.commerce.price.list.model.CommercePriceEntry"));

	public CommercePriceEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commercePriceEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommercePriceEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commercePriceEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommercePriceEntry.class;
	}

	@Override
	public String getModelClassName() {
		return CommercePriceEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("commercePriceEntryId", getCommercePriceEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("commercePriceListId", getCommercePriceListId());
		attributes.put("CPInstanceUuid", getCPInstanceUuid());
		attributes.put("CProductId", getCProductId());
		attributes.put("price", getPrice());
		attributes.put("promoPrice", getPromoPrice());
		attributes.put("hasTierPrice", isHasTierPrice());
		attributes.put("lastPublishDate", getLastPublishDate());

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

		String externalReferenceCode = (String)attributes.get(
				"externalReferenceCode");

		if (externalReferenceCode != null) {
			setExternalReferenceCode(externalReferenceCode);
		}

		Long commercePriceEntryId = (Long)attributes.get("commercePriceEntryId");

		if (commercePriceEntryId != null) {
			setCommercePriceEntryId(commercePriceEntryId);
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

		Long commercePriceListId = (Long)attributes.get("commercePriceListId");

		if (commercePriceListId != null) {
			setCommercePriceListId(commercePriceListId);
		}

		String CPInstanceUuid = (String)attributes.get("CPInstanceUuid");

		if (CPInstanceUuid != null) {
			setCPInstanceUuid(CPInstanceUuid);
		}

		Long CProductId = (Long)attributes.get("CProductId");

		if (CProductId != null) {
			setCProductId(CProductId);
		}

		BigDecimal price = (BigDecimal)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		BigDecimal promoPrice = (BigDecimal)attributes.get("promoPrice");

		if (promoPrice != null) {
			setPromoPrice(promoPrice);
		}

		Boolean hasTierPrice = (Boolean)attributes.get("hasTierPrice");

		if (hasTierPrice != null) {
			setHasTierPrice(hasTierPrice);
		}

		Date lastPublishDate = (Date)attributes.get("lastPublishDate");

		if (lastPublishDate != null) {
			setLastPublishDate(lastPublishDate);
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
	public String getExternalReferenceCode() {
		if (_externalReferenceCode == null) {
			return "";
		}
		else {
			return _externalReferenceCode;
		}
	}

	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		_columnBitmask |= EXTERNALREFERENCECODE_COLUMN_BITMASK;

		if (_originalExternalReferenceCode == null) {
			_originalExternalReferenceCode = _externalReferenceCode;
		}

		_externalReferenceCode = externalReferenceCode;
	}

	public String getOriginalExternalReferenceCode() {
		return GetterUtil.getString(_originalExternalReferenceCode);
	}

	@JSON
	@Override
	public long getCommercePriceEntryId() {
		return _commercePriceEntryId;
	}

	@Override
	public void setCommercePriceEntryId(long commercePriceEntryId) {
		_commercePriceEntryId = commercePriceEntryId;
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
		_columnBitmask = -1L;

		_createDate = createDate;
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
	public long getCommercePriceListId() {
		return _commercePriceListId;
	}

	@Override
	public void setCommercePriceListId(long commercePriceListId) {
		_columnBitmask |= COMMERCEPRICELISTID_COLUMN_BITMASK;

		if (!_setOriginalCommercePriceListId) {
			_setOriginalCommercePriceListId = true;

			_originalCommercePriceListId = _commercePriceListId;
		}

		_commercePriceListId = commercePriceListId;
	}

	public long getOriginalCommercePriceListId() {
		return _originalCommercePriceListId;
	}

	@JSON
	@Override
	public String getCPInstanceUuid() {
		if (_CPInstanceUuid == null) {
			return "";
		}
		else {
			return _CPInstanceUuid;
		}
	}

	@Override
	public void setCPInstanceUuid(String CPInstanceUuid) {
		_columnBitmask |= CPINSTANCEUUID_COLUMN_BITMASK;

		if (_originalCPInstanceUuid == null) {
			_originalCPInstanceUuid = _CPInstanceUuid;
		}

		_CPInstanceUuid = CPInstanceUuid;
	}

	public String getOriginalCPInstanceUuid() {
		return GetterUtil.getString(_originalCPInstanceUuid);
	}

	@JSON
	@Override
	public long getCProductId() {
		return _CProductId;
	}

	@Override
	public void setCProductId(long CProductId) {
		_CProductId = CProductId;
	}

	@JSON
	@Override
	public BigDecimal getPrice() {
		return _price;
	}

	@Override
	public void setPrice(BigDecimal price) {
		_price = price;
	}

	@JSON
	@Override
	public BigDecimal getPromoPrice() {
		return _promoPrice;
	}

	@Override
	public void setPromoPrice(BigDecimal promoPrice) {
		_promoPrice = promoPrice;
	}

	@JSON
	@Override
	public boolean getHasTierPrice() {
		return _hasTierPrice;
	}

	@JSON
	@Override
	public boolean isHasTierPrice() {
		return _hasTierPrice;
	}

	@Override
	public void setHasTierPrice(boolean hasTierPrice) {
		_hasTierPrice = hasTierPrice;
	}

	@JSON
	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				CommercePriceEntry.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CommercePriceEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommercePriceEntry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CommercePriceEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommercePriceEntryImpl commercePriceEntryImpl = new CommercePriceEntryImpl();

		commercePriceEntryImpl.setUuid(getUuid());
		commercePriceEntryImpl.setExternalReferenceCode(getExternalReferenceCode());
		commercePriceEntryImpl.setCommercePriceEntryId(getCommercePriceEntryId());
		commercePriceEntryImpl.setGroupId(getGroupId());
		commercePriceEntryImpl.setCompanyId(getCompanyId());
		commercePriceEntryImpl.setUserId(getUserId());
		commercePriceEntryImpl.setUserName(getUserName());
		commercePriceEntryImpl.setCreateDate(getCreateDate());
		commercePriceEntryImpl.setModifiedDate(getModifiedDate());
		commercePriceEntryImpl.setCommercePriceListId(getCommercePriceListId());
		commercePriceEntryImpl.setCPInstanceUuid(getCPInstanceUuid());
		commercePriceEntryImpl.setCProductId(getCProductId());
		commercePriceEntryImpl.setPrice(getPrice());
		commercePriceEntryImpl.setPromoPrice(getPromoPrice());
		commercePriceEntryImpl.setHasTierPrice(isHasTierPrice());
		commercePriceEntryImpl.setLastPublishDate(getLastPublishDate());

		commercePriceEntryImpl.resetOriginalValues();

		return commercePriceEntryImpl;
	}

	@Override
	public int compareTo(CommercePriceEntry commercePriceEntry) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				commercePriceEntry.getCreateDate());

		value = value * -1;

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

		if (!(obj instanceof CommercePriceEntry)) {
			return false;
		}

		CommercePriceEntry commercePriceEntry = (CommercePriceEntry)obj;

		long primaryKey = commercePriceEntry.getPrimaryKey();

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
		CommercePriceEntryModelImpl commercePriceEntryModelImpl = this;

		commercePriceEntryModelImpl._originalUuid = commercePriceEntryModelImpl._uuid;

		commercePriceEntryModelImpl._originalExternalReferenceCode = commercePriceEntryModelImpl._externalReferenceCode;

		commercePriceEntryModelImpl._originalGroupId = commercePriceEntryModelImpl._groupId;

		commercePriceEntryModelImpl._setOriginalGroupId = false;

		commercePriceEntryModelImpl._originalCompanyId = commercePriceEntryModelImpl._companyId;

		commercePriceEntryModelImpl._setOriginalCompanyId = false;

		commercePriceEntryModelImpl._setModifiedDate = false;

		commercePriceEntryModelImpl._originalCommercePriceListId = commercePriceEntryModelImpl._commercePriceListId;

		commercePriceEntryModelImpl._setOriginalCommercePriceListId = false;

		commercePriceEntryModelImpl._originalCPInstanceUuid = commercePriceEntryModelImpl._CPInstanceUuid;

		commercePriceEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CommercePriceEntry> toCacheModel() {
		CommercePriceEntryCacheModel commercePriceEntryCacheModel = new CommercePriceEntryCacheModel();

		commercePriceEntryCacheModel.uuid = getUuid();

		String uuid = commercePriceEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			commercePriceEntryCacheModel.uuid = null;
		}

		commercePriceEntryCacheModel.externalReferenceCode = getExternalReferenceCode();

		String externalReferenceCode = commercePriceEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
				(externalReferenceCode.length() == 0)) {
			commercePriceEntryCacheModel.externalReferenceCode = null;
		}

		commercePriceEntryCacheModel.commercePriceEntryId = getCommercePriceEntryId();

		commercePriceEntryCacheModel.groupId = getGroupId();

		commercePriceEntryCacheModel.companyId = getCompanyId();

		commercePriceEntryCacheModel.userId = getUserId();

		commercePriceEntryCacheModel.userName = getUserName();

		String userName = commercePriceEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commercePriceEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commercePriceEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			commercePriceEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commercePriceEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commercePriceEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commercePriceEntryCacheModel.commercePriceListId = getCommercePriceListId();

		commercePriceEntryCacheModel.CPInstanceUuid = getCPInstanceUuid();

		String CPInstanceUuid = commercePriceEntryCacheModel.CPInstanceUuid;

		if ((CPInstanceUuid != null) && (CPInstanceUuid.length() == 0)) {
			commercePriceEntryCacheModel.CPInstanceUuid = null;
		}

		commercePriceEntryCacheModel.CProductId = getCProductId();

		commercePriceEntryCacheModel.price = getPrice();

		commercePriceEntryCacheModel.promoPrice = getPromoPrice();

		commercePriceEntryCacheModel.hasTierPrice = isHasTierPrice();

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			commercePriceEntryCacheModel.lastPublishDate = lastPublishDate.getTime();
		}
		else {
			commercePriceEntryCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		return commercePriceEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", externalReferenceCode=");
		sb.append(getExternalReferenceCode());
		sb.append(", commercePriceEntryId=");
		sb.append(getCommercePriceEntryId());
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
		sb.append(", commercePriceListId=");
		sb.append(getCommercePriceListId());
		sb.append(", CPInstanceUuid=");
		sb.append(getCPInstanceUuid());
		sb.append(", CProductId=");
		sb.append(getCProductId());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", promoPrice=");
		sb.append(getPromoPrice());
		sb.append(", hasTierPrice=");
		sb.append(isHasTierPrice());
		sb.append(", lastPublishDate=");
		sb.append(getLastPublishDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.liferay.commerce.price.list.model.CommercePriceEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>externalReferenceCode</column-name><column-value><![CDATA[");
		sb.append(getExternalReferenceCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commercePriceEntryId</column-name><column-value><![CDATA[");
		sb.append(getCommercePriceEntryId());
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
			"<column><column-name>commercePriceListId</column-name><column-value><![CDATA[");
		sb.append(getCommercePriceListId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CPInstanceUuid</column-name><column-value><![CDATA[");
		sb.append(getCPInstanceUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CProductId</column-name><column-value><![CDATA[");
		sb.append(getCProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>promoPrice</column-name><column-value><![CDATA[");
		sb.append(getPromoPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasTierPrice</column-name><column-value><![CDATA[");
		sb.append(isHasTierPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPublishDate</column-name><column-value><![CDATA[");
		sb.append(getLastPublishDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CommercePriceEntry.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CommercePriceEntry.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private String _externalReferenceCode;
	private String _originalExternalReferenceCode;
	private long _commercePriceEntryId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commercePriceListId;
	private long _originalCommercePriceListId;
	private boolean _setOriginalCommercePriceListId;
	private String _CPInstanceUuid;
	private String _originalCPInstanceUuid;
	private long _CProductId;
	private BigDecimal _price;
	private BigDecimal _promoPrice;
	private boolean _hasTierPrice;
	private Date _lastPublishDate;
	private long _columnBitmask;
	private CommercePriceEntry _escapedModel;
}
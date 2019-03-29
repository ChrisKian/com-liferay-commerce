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

package com.liferay.headless.commerce.admin.catalog.model.v1_0;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import com.liferay.commerce.openapi.core.annotation.Nullable;

import java.util.Map;

import javax.annotation.Generated;

/**
 * @author Alessio Antonio Rendina
 */
@Generated(value = "OSGiRESTModuleGenerator")
@JacksonXmlRootElement(localName = "ProductOption")
public class ProductOptionDTO {

	@Nullable
	public String getDescription() {
		return _description;
	}

	public String getExternalReferenceCode() {
		return _externalReferenceCode;
	}

	public String getFieldType() {
		return _fieldType;
	}

	@Nullable
	public Long getGroupId() {
		return _groupId;
	}

	@Nullable
	public Long getId() {
		return _id;
	}

	public String getKey() {
		return _key;
	}

	public Map<String, String> getName() {
		return _name;
	}

	@Nullable
	public Double getPriority() {
		return _priority;
	}

	@Nullable
	public ProductOptionValueDTO[] getValues() {
		return _values;
	}

	@Nullable
	public Boolean isFacetable() {
		return _facetable;
	}

	@Nullable
	public Boolean isRequired() {
		return _required;
	}

	@Nullable
	public Boolean isSkuContributor() {
		return _skuContributor;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		_externalReferenceCode = externalReferenceCode;
	}

	public void setFacetable(Boolean facetable) {
		_facetable = facetable;
	}

	public void setFieldType(String fieldType) {
		_fieldType = fieldType;
	}

	public void setGroupId(Long groupId) {
		_groupId = groupId;
	}

	public void setId(Long id) {
		_id = id;
	}

	public void setKey(String key) {
		_key = key;
	}

	public void setName(Map<String, String> name) {
		_name = name;
	}

	public void setPriority(Double priority) {
		_priority = priority;
	}

	public void setRequired(Boolean required) {
		_required = required;
	}

	public void setSkuContributor(Boolean skuContributor) {
		_skuContributor = skuContributor;
	}

	public void setValues(ProductOptionValueDTO[] values) {
		_values = values;
	}

	@Nullable
	private String _description;

	private String _externalReferenceCode;

	@Nullable
	private Boolean _facetable;

	private String _fieldType;

	@Nullable
	private Long _groupId;

	@Nullable
	private Long _id;

	private String _key;
	private Map<String, String> _name;

	@Nullable
	private Double _priority;

	@Nullable
	private Boolean _required;

	@Nullable
	private Boolean _skuContributor;

	@Nullable
	private ProductOptionValueDTO[] _values;

}
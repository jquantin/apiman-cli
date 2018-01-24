/*
 * Copyright 2017 Jean-Charles Quantin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.apiman.cli.core.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author Jean-Charles Quantin {@literal <jeancharles.quantin@gmail.com>}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Contract {

	@JsonProperty
	private String planId;

	@JsonProperty
	private String apiOrgId;

	@JsonProperty
	private String apiId;

	@JsonProperty
	private String apiVersion;

	@JsonProperty
	private String createdOn;

	@JsonProperty
	private String clientVersion;

	@JsonProperty
	private String planVersion;

	@JsonProperty
	private String clientOrganizationId;

	@JsonProperty
	private String clientOrganizationName;

	@JsonProperty
	private String apiOrgName;

	@JsonProperty
	private String apiDescription;

	@JsonProperty
	private String clientId;
	
	@JsonProperty
	private String planName;
	
	@JsonProperty
	private Long contractId;
	
	@JsonProperty
	private String apiName;
	
	@JsonProperty
	private String clientName;
	

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getApiOrgId() {
		return apiOrgId;
	}

	public void setApiOrgId(String apiOrgId) {
		this.apiOrgId = apiOrgId;
	}

	public String getApiId() {
		return apiId;
	}

	public void setApiId(String apiId) {
		this.apiId = apiId;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getCreatedOn() {
	    return createdOn;
	}

	public void setCreatedOn(String createdOn) {
	    this.createdOn = createdOn;
	}

	public String getClientVersion() {
	    return clientVersion;
	}

	public void setClientVersion(String clientVersion) {
	    this.clientVersion = clientVersion;
	}

	public String getPlanVersion() {
	    return planVersion;
	}

	public void setPlanVersion(String planVersion) {
	    this.planVersion = planVersion;
	}

	public String getClientOrganizationId() {
	    return clientOrganizationId;
	}

	public void setClientOrganizationId(String clientOrganizationId) {
	    this.clientOrganizationId = clientOrganizationId;
	}

	public String getClientOrganizationName() {
	    return clientOrganizationName;
	}

	public void setClientOrganizationName(String clientOrganizationName) {
	    this.clientOrganizationName = clientOrganizationName;
	}

	public String getApiOrgName() {
	    return apiOrgName;
	}

	public void setApiOrgName(String apiOrgName) {
	    this.apiOrgName = apiOrgName;
	}

	public String getApiDescription() {
	    return apiDescription;
	}

	public void setApiDescription(String apiDescription) {
	    this.apiDescription = apiDescription;
	}

	public String getClientId() {
	    return clientId;
	}

	public void setClientId(String clientId) {
	    this.clientId = clientId;
	}

	public String getPlanName() {
	    return planName;
	}

	public void setPlanName(String planName) {
	    this.planName = planName;
	}

	public Long getContractId() {
	    return contractId;
	}

	public void setContractId(Long contractId) {
	    this.contractId = contractId;
	}

	public String getApiName() {
	    return apiName;
	}

	public void setApiName(String apiName) {
	    this.apiName = apiName;
	}

	public String getClientName() {
	    return clientName;
	}

	public void setClientName(String clientName) {
	    this.clientName = clientName;
	}
	
}

/*
 * Copyright 2016 Pete Cornish
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

package io.apiman.cli.core.api.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.apiman.cli.ManagerApi;
import io.apiman.cli.core.declarative.model.DeclarativeApi;
import io.apiman.cli.core.declarative.model.DeclarativePolicy;
import io.apiman.cli.util.MappingUtil;

/**
 * Models an API.
 *
 * @author Pete Cornish {@literal <outofcoffee@gmail.com>}
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Api {

	@JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private String organizationName;

    /**
     * Note: use {@link #version} instead for declarative API configuration.
     */
    @JsonProperty
    private String initialVersion;

    @JsonProperty
    private String version;

    @JsonProperty
    private String status;
    
    @JsonIgnore
    public ManagerApi managerApi;

    public Api() {
    }

    public Api(String name, String description, String initialVersion) {
        this.name = name;
        this.description = description;
        this.initialVersion = initialVersion;
    }

    public String getName() {
        return name;
    }

    public void setInitialVersion(String initialVersion) {
        this.initialVersion = initialVersion;
    }

    public String getInitialVersion() {
        return initialVersion;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public String getStatus() {
        return status;
    }

    public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

    
    public List<Api> listVersions() throws Exception {
    	return managerApi.api().fetchVersions(organizationName, name);
    }
    

    public List<ApiPolicy> listPolicies() throws Exception {
    	return managerApi.api().fetchPolicies(organizationName, name, version);
    }
}

package io.apiman.cli;

import java.util.List;

import io.apiman.cli.core.api.GatewayApi;
import io.apiman.cli.core.api.VersionAgnosticApi;
import io.apiman.cli.core.api.model.Api;
import io.apiman.cli.core.common.model.ManagementApiVersion;
import io.apiman.cli.core.org.OrgApi;
import io.apiman.cli.core.org.model.Org;
import io.apiman.cli.core.plan.PlanApi;
import io.apiman.cli.core.plugin.PluginApi;
import io.apiman.cli.management.ManagementApiUtil;
import io.apiman.cli.management.factory.PostConverter;
import io.apiman.cli.util.MappingUtil;

public class ManagerApi {
	private String endpoint;
	private String username;
	private String password;
	private boolean debugLogging;
	private ManagementApiVersion serverVersion;
	

	public ManagerApi(String endpoint,
			String username,
			String password,
			boolean debugLogging,
			ManagementApiVersion serverVersion) {
        	this.endpoint = endpoint;
        	this.username = username;
        	this.password = password;
        	this.debugLogging = debugLogging;
        	this.serverVersion = serverVersion;
        }
	
	public OrgApi org() {
		return ManagementApiUtil.buildServerApiClient(OrgApi.class, endpoint, username, password, debugLogging, ManagementApiVersion.UNSPECIFIED, getPostConverter());
	}
	
	public PlanApi plan() {
		return ManagementApiUtil.buildServerApiClient(PlanApi.class, endpoint, username, password, debugLogging, ManagementApiVersion.UNSPECIFIED, getPostConverter());
	}
	
	public GatewayApi gateway() {
		return ManagementApiUtil.buildServerApiClient(GatewayApi.class, endpoint, username, password, debugLogging, ManagementApiVersion.UNSPECIFIED, getPostConverter());
	}
	
	public PluginApi plugin() {
		return ManagementApiUtil.buildServerApiClient(PluginApi.class, endpoint, username, password, debugLogging, ManagementApiVersion.UNSPECIFIED, getPostConverter());
	}
	
	public VersionAgnosticApi api() {
		return ManagementApiUtil.buildServerApiClient(VersionAgnosticApi.class, endpoint, username, password, debugLogging, serverVersion, getPostConverter());
	}
	
	public PostConverter getPostConverter() {
		
		final ManagerApi managerApi = ManagerApi.this;
		
		return new PostConverter() {
			@Override
			public void postConvert(Object o) {
				// TODO : working with reflexion to know if there is a ManagerApi to set.
				if (o instanceof Org) {
					Org org = (Org) o;
					org.managerApi = managerApi;
				} else if (o instanceof Api) {
					Api api = (Api) o;
					api.managerApi = managerApi;
				} else if (o instanceof List) {
					List l = (List) o;
					l.forEach(listItem -> {
						postConvert(listItem);
					});
				}
				
			}};
	}
	
	
	public static void main(String... args) {
		try {
			ManagerApi managerApi = new ManagerApi("http://127.0.0.1:8080/apiman", "admin", "admin123!", false, ManagementApiVersion.v12x);
			Org org = managerApi.org().fetch("test");
			System.out.println("orga test : "+org.getName());
			List<Api> apis = org.listApis();
			System.out.println("list Apis : ");
			System.out.println(MappingUtil.safeWriteValueAsJson(apis));
			apis.forEach(api -> {
				try {
					List<Api> versions = api.listVersions();
					System.out.println("list Versions of api "+api.getName()+" :");
					System.out.println(MappingUtil.safeWriteValueAsJson(versions));
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
			});
			// Other way to acces an api by .api() access.
			System.out.println("an Api : ");
			Api api = managerApi.api().fetchVersion("test", "yo", "1.0");
			
			System.out.println(MappingUtil.safeWriteValueAsJson(api));

			System.out.println("policies : ");
			System.out.println(MappingUtil.safeWriteValueAsJson(api.listPolicies()));
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
	}
	
}

package io.enco;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import io.enco.model.SeaasDeviceRepresentation;
import io.enco.model.UserInfo;

import java.util.Collections;
import java.util.List;

public class AuthenticationsampleApplicationSpring {

	public static void main(String[] args) {
        System.out.println("Retrieving token");
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(getClientCredentials());
        System.err.print("Got Bearer access_token: ");
        System.err.println(restTemplate.getAccessToken());
        System.err.println();

        showGetUserInfo(restTemplate);

        showGetUserInfoAsObject(restTemplate);

        showGetSeaasDevicesAsObjects(restTemplate);
    }

    private static OAuth2ProtectedResourceDetails getClientCredentials() {
        // Get the client_id and client_secret from https://www.enco.io/dashboard/settings/authentication
        String clientId = "<< YOUR INFO HERE >>";
        String clientSecret = "<< YOUR INFO HERE >>";
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri("https://api.enco.io/token");
        details.setScope(Collections.singletonList("openid")); // optional, but usually added
        return details;
    }

	protected static void showGetUserInfo(OAuth2RestTemplate theRestTemplate) {
		System.out.println("Use token to exercise the OpenID Connect endpoint URL");
        String responseBody = theRestTemplate.getForObject("https://api.enco.io/userinfo?schema=openid", String.class,
                                                        Collections.emptyMap());
        System.err.print("Got responseBody: ");
        System.err.println(responseBody);
        System.err.println();
	}

	protected static void showGetUserInfoAsObject(OAuth2RestTemplate theRestTemplate) {
        // Now coerce this String into something we can actually work with.
        // This works because the Jackson JSON library is on our classpath.
        // Also show how to interpolate variables.
		System.out.println("Use token to exercise the OpenID Connect endpoint URL for info object");
		UserInfo response = theRestTemplate.getForObject("https://api.enco.io/userinfo?schema={schema}", UserInfo.class,
												Collections.singletonMap("schema", "openid"));
        System.err.print("Hello User: ");
        System.err.println(response.getName());
        System.err.printf("\t%s, %s%sYour email: %s%s",
        		response.getGivenName(), response.getFamilyName(), System.lineSeparator(), 
        		response.getEmail(), System.lineSeparator());
        System.err.println();
	}

	protected static void showGetSeaasDevicesAsObjects(OAuth2RestTemplate restTemplate) {
        // Now coerce this String into something we can actually work with.
        // This works because the Jackson JSON library is on our classpath.
        // Also show how to interpolate variables.
		System.out.println("Get the list of SEaaS devices as object instances");
        List<SeaasDeviceRepresentation> devices =
                restTemplate.exchange("https://api.enco.io/seaas/0.0.1/device/list?public={public}",
                                      HttpMethod.GET,
                                      HttpEntity.EMPTY,
                                      new ParameterizedTypeReference<List<SeaasDeviceRepresentation>>() {},
                                      Collections.singletonMap("public", false)).getBody();
        for (SeaasDeviceRepresentation device : devices) {
            System.err.printf("Device \t%s has owner \t%s and tags \t%s%s",
                              device.getDeviceId(), device.getOwner(), device.getTags(), System.lineSeparator());
        }
        System.err.println();
	}
}

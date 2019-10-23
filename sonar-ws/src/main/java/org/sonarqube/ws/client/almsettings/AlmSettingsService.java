/*
 * SonarQube
 * Copyright (C) 2009-2019 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonarqube.ws.client.almsettings;

import javax.annotation.Generated;
import org.sonarqube.ws.AlmSettings;
import org.sonarqube.ws.MediaTypes;
import org.sonarqube.ws.client.BaseService;
import org.sonarqube.ws.client.GetRequest;
import org.sonarqube.ws.client.PostRequest;
import org.sonarqube.ws.client.WsConnector;

/**
 * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/alm_settings">Further information about this web service online</a>
 */
@Generated("sonar-ws-generator")
public class AlmSettingsService extends BaseService {

  public AlmSettingsService(WsConnector wsConnector) {
    super(wsConnector, "api/alm_settings");
  }

  /**
   * This is a GET request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/alm_settings/count_binding">Further information about this action online (including a response example)</a>
   * @since 8.1
   */
  public AlmSettings.CountBindingWsResponse countBinding(CountBindingRequest request) {
    return call(
      new GetRequest(path("count_binding"))
        .setParam("almSetting", request.getAlmSetting())
        .setMediaType(MediaTypes.JSON),
      AlmSettings.CountBindingWsResponse.parser());
  }

  /**
   *
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/alm_settings/create_azure">Further information about this action online (including a response example)</a>
   * @since 8.1
   */
  public void createAzure(CreateAzureRequest request) {
    call(
      new PostRequest(path("create_azure"))
        .setParam("key", request.getKey())
        .setParam("personalAccessToken", request.getPersonalAccessToken())
        .setMediaType(MediaTypes.JSON)).content();
  }

  /**
   *
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/alm_settings/create_bitbucket">Further information about this action online (including a response example)</a>
   * @since 8.1
   */
  public void createBitbucket(CreateBitbucketRequest request) {
    call(
      new PostRequest(path("create_bitbucket"))
        .setParam("key", request.getKey())
        .setParam("url", request.getUrl())
        .setParam("personalAccessToken", request.getPersonalAccessToken())
        .setMediaType(MediaTypes.JSON)).content();
  }

  /**
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/alm_settings/create_github">Further information about this action online (including a response example)</a>
   * @since 8.1
   */
  public void createGithub(CreateGithubRequest request) {
    call(
      new PostRequest(path("create_github"))
        .setParam("appId", request.getAppId())
        .setParam("key", request.getKey())
        .setParam("privateKey", request.getPrivateKey())
        .setParam("url", request.getUrl())
        .setMediaType(MediaTypes.JSON)).content();
  }

  /**
   *
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/alm_settings/delete">Further information about this action online (including a response example)</a>
   * @since 8.1
   */
  public void delete(DeleteRequest request) {
    call(
      new PostRequest(path("delete"))
        .setParam("key", request.getKey())
        .setMediaType(MediaTypes.JSON)).content();
  }

  /**
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/alm_settings/delete_binding">Further information about this action online (including a response example)</a>
   * @since 8.1
   */
  public void deleteBinding(DeleteBindingRequest request) {
    call(
      new PostRequest(path("delete_binding"))
        .setParam("project", request.getProject())
        .setMediaType(MediaTypes.JSON)).content();
  }

  /**
   * This is a GET request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/alm_settings/get_binding">Further information about this action online (including a response example)</a>
   * @since 8.1
   */
  public AlmSettings.GetBindingWsResponse getBinding(GetBindingRequest request) {
    return call(
      new GetRequest(path("get_binding"))
        .setParam("project", request.getProject())
        .setMediaType(MediaTypes.JSON),
      AlmSettings.GetBindingWsResponse.parser());
  }

  /**
   * This is a GET request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/alm_settings/list">Further information about this action online (including a response example)</a>
   * @since 8.1
   */
  public AlmSettings.ListWsResponse list(ListRequest request) {
    return call(
      new GetRequest(path("list"))
        .setParam("project", request.getProject())
        .setMediaType(MediaTypes.JSON),
      AlmSettings.ListWsResponse.parser());
  }

  /**
   *
   * This is a GET request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/alm_settings/list_definitions">Further information about this action online (including a response example)</a>
   * @since 8.1
   */
  public AlmSettings.ListDefinitionsWsResponse listDefinitions() {
    return call(
      new GetRequest(path("list_definitions")),
      AlmSettings.ListDefinitionsWsResponse.parser());
  }

  /**
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/alm_settings/set_azure_binding">Further information about this action online (including a response example)</a>
   * @since 8.1
   */
  public void setAzureBinding(SetAzureBindingRequest request) {
    call(
      new PostRequest(path("set_azure_binding"))
        .setParam("almSetting", request.getAlmSetting())
        .setParam("project", request.getProject())
        .setMediaType(MediaTypes.JSON)).content();
  }

  /**
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/alm_settings/set_github_binding">Further information about this action online (including a response example)</a>
   * @since 8.1
   */
  public void setGithubBinding(SetGithubBindingRequest request) {
    call(
      new PostRequest(path("set_github_binding"))
        .setParam("almSetting", request.getAlmSetting())
        .setParam("project", request.getProject())
        .setParam("repository", request.getRepository())
        .setMediaType(MediaTypes.JSON)).content();
  }

  /**
   *
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/alm_settings/update_azure">Further information about this action online (including a response example)</a>
   * @since 8.1
   */
  public void updateAzure(UpdateAzureRequest request) {
    call(
      new PostRequest(path("update_azure"))
        .setParam("key", request.getKey())
        .setParam("newKey", request.getNewKey())
        .setParam("personalAccessToken", request.getPersonalAccessToken())
        .setMediaType(MediaTypes.JSON)).content();
  }

  /**
   *
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/alm_settings/update_bitbucket">Further information about this action online (including a response example)</a>
   * @since 8.1
   */
  public void updateBitbucket(UpdateBitbucketRequest request) {
    call(
      new PostRequest(path("update_bitbucket"))
        .setParam("key", request.getKey())
        .setParam("newKey", request.getNewKey())
        .setParam("url", request.getUrl())
        .setParam("personalAccessToken", request.getPersonalAccessToken())
        .setMediaType(MediaTypes.JSON)).content();
  }

  /**
   *
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/alm_settings/update_github">Further information about this action online (including a response example)</a>
   * @since 8.1
   */
  public void updateGithub(UpdateGithubRequest request) {
    call(
      new PostRequest(path("update_github"))
        .setParam("appId", request.getAppId())
        .setParam("key", request.getKey())
        .setParam("newKey", request.getNewKey())
        .setParam("privateKey", request.getPrivateKey())
        .setParam("url", request.getUrl())
        .setMediaType(MediaTypes.JSON)).content();
  }
}

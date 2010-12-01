/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2009 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * Sonar is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Sonar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.api.web.gwt.client.webservices;

/**
 * @deprecated since 2.5, use {@link org.sonar.wsclient.services.Property} instead
 */
@Deprecated
public class Property extends ResponsePOJO {

  private String key;
  private String value;

  public Property() {
  }

  public Property(String key, String value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public Property setKey(String key) {
    this.key = key;
    return this;
  }

  public String getValue() {
    return value;
  }

  public Property setValue(String value) {
    this.value = value;
    return this;
  }
}

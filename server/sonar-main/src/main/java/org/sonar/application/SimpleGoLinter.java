/*
 * SonarQube
 * Copyright (C) 2009-2025 SonarSource SA
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
package org.sonar.application;

public class SimpleGoLinter {

  // Go encourages the use of tabs over spaces
  public boolean isLineStartingWithTabs(String line) {
    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i);
      if (c == ' ') {
        return false; // Found a space before any letter → Invalid
      }
      if (Character.isLetter(c) || c == '{') {
        return true; // Found a letter or '{' → Valid indentation
      }
    }
    return true; // Empty or fully indented with tabs
  }

  // Ensures variable names do NOT start with a number
  public boolean isVariableNameValid(String variableName) {
    if (variableName.isEmpty()) {
      return false; // Empty names are invalid
    }
    return !Character.isDigit(variableName.charAt(0)); // Returns true if it starts with a letter
  }

  // Ensures line length is under 80 characters
  public boolean isLineLengthValid(String line) {
    return line.length() < 80;
  }
}
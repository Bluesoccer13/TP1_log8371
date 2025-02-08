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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SimpleGoLinterTest {

  @Test
  public void testIndentationWithTabs() {
    SimpleGoLinter linter = new SimpleGoLinter();
    assertTrue(linter.isLineStartingWithTabs("\tfunc main() {}"));
    assertFalse(linter.isLineStartingWithTabs("  func main() {}"));
  }

  @Test
  public void testVariableNaming() {
    SimpleGoLinter linter = new SimpleGoLinter();
    assertTrue(linter.isVariableNameValid("myVariable"));
    assertFalse(linter.isVariableNameValid("1stVariable"));
  }

  @Test
  public void testLineLength() {
    SimpleGoLinter linter = new SimpleGoLinter();
    assertTrue(linter.isLineLengthValid("Short line"));
    assertFalse(linter.isLineLengthValid(
        "This is a very long line that exceeds eighty characters in length. This is a very long line that exceeds eighty characters in length."));
  }
}

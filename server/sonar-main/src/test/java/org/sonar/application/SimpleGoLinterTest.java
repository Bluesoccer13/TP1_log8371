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

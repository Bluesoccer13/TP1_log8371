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
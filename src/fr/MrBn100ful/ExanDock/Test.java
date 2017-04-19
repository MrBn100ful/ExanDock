package fr.MrBn100ful.ExanDock;

import junit.framework.TestResult;

public abstract interface Test
{
  public abstract int countTestCases();
  
  public abstract void run(TestResult paramTestResult);
}

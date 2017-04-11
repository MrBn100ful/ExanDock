package fr.MrBn100ful.ExanLauncher;

import junit.framework.TestResult;

public abstract interface Test
{
  public abstract int countTestCases();
  
  public abstract void run(TestResult paramTestResult);
}

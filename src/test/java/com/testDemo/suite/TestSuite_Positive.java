package com.testDemo.suite;

import com.testDemo.maintester.TestIMDB_ShouldSeeDirectorNameTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value={
        TestIMDB_ShouldSeeDirectorNameTest.class
})

public class TestSuite_Positive {}
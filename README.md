Bndtools: JUnit 3 & 4 Examples
=====================

These projects shows examples on how to setup JUnit tests.

Tested using bndtools-2.0.0 & Eclipse Juno Service Release 2 (4.2.2)

Notes on JUnit tests
------------
To run JUnit4 tests in your current projects: Bundle junit.osgi-3.8.2 must be replaced with com.springsource.org.junit-4.10.0 in the buildpath.
The bundle biz.aQute.junit exports the JUnit4 classes as version 4.10, so com.springsource.org.junit-4.11.0 will not work.

JUnit4 contains all of the JUnit3 classes, so tests can coexist.

/**
 * @package com.instinctools.reducerlinks
 * 
 * Packages located in the directory /src/test/java contains classes which exercise 
 * testing dao and service layer by mvc architecture.Classes used for test junit 
 * framework.
 */
package com.instinctools.reducerlinks;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * This class are general for all test classes. All test classes in package extends TestStarter.
 * TestStarter use annotation RunWith by spring framework. Annotation RunWith use to run tests
 * and takes as a parameter SpringJUnit4ClassRunner.Class TestStarter contains also annotation
 * ContextConfiguration to determine path to configuration file.Annotation TransactionConfiguration
 * use for configuring transactional tests.
 * 
 * @see org.junit
 * @see org.springframework.test
 * 
 * @version 1.0 03.10.2015
 * @author Zaerko Denis
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/config/spring-hibernate-config/spring-hibernate-config.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public abstract class TestStarter {
}

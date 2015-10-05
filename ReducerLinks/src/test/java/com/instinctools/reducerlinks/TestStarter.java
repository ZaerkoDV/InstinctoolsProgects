/**
 * 
 */
package com.instinctools.reducerlinks;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * @author Zaerko_DV
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/config/spring-hibernate-config/spring-hibernate-config.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public abstract class TestStarter {
}

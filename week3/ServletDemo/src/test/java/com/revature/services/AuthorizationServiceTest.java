package com.revature.services;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.exceptions.authorization.ActionNotPermittedException;
import com.revature.exceptions.authorization.AuthorizationException;
import com.revature.exceptions.authorization.NotLoggedInException;
import com.revature.models.Employee;
import com.revature.models.Role;

/*
 * TDD:
 * 
 * Start with Tests
 * 
 * Tests should simulate different scenarios that might happen in reality
 * 
 * Mock the dependencies to simulate these scenarios
 * 
 * The test should assert that the functions work "as expected" under the corresponding scenarios
 */
public class AuthorizationServiceTest {
	
	@Mock private HttpServletRequest mockRequest1;
	@Mock private HttpServletRequest mockRequest2;
	@Mock private HttpServletRequest mockRequest3;
	
	@Mock private HttpSession mockSessionFinanceManager;
	@Mock private HttpSession mockSessionNobody;
	
	private AuthorizationService instance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		when(mockRequest1.getSession(anyBoolean())).thenReturn(mockSessionFinanceManager);
		when(mockRequest1.getSession()).thenReturn(mockSessionFinanceManager);
		
		when(mockSessionFinanceManager.getAttribute("currentUser")).thenReturn(
					new Employee(1, "Matthew", "Oberlies", 
					new Role(1, "Finance Manager")));
		
		when(mockRequest2.getSession(anyBoolean())).thenReturn(null);
		
		when(mockRequest3.getSession(anyBoolean())).thenReturn(mockSessionNobody);
		
		when(mockSessionNobody.getAttribute("currentUser")).thenReturn(null);
		
		
		instance = new AuthorizationService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGuardDoesntThrowWhenLoggedIn() {
		try {
			instance.guard(mockRequest1);
		} catch(AuthorizationException e) {
			assumeNoException(e);
		}
	}
	
	@Test(expected = NotLoggedInException.class)
	public void testGuardThrowsNotLoggedInException() {
		instance.guard(mockRequest2);
	}
	
	@Test(expected = NotLoggedInException.class)
	public void testGuardNotLoggedInWithSession() {
		instance.guard(mockRequest3);
	}

	@Test
	public void testGuardFinanceManagerAllowed() {
		try {
			instance.guard(mockRequest1, new Role(1, "Finance Manager"));
		} catch(AuthorizationException e) {
			assumeNoException(e);
		}
	}
	
	@Test
	public void testGuardAnyRoleAllowed() {
		try {
			instance.guard(mockRequest1, new Role(1, "Finance Manager"), new Role(2, "Employee"));
		} catch(AuthorizationException e) {
			assumeNoException(e);
		}
	}
	
	@Test(expected = ActionNotPermittedException.class)
	public void testIncorrectRoleAllowed() {
		instance.guard(mockRequest1, new Role(2, "Employee"));
	}
}

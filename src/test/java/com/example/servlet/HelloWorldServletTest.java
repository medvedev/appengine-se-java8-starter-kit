package com.example.servlet;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;

import com.google.appengine.api.utils.SystemProperty;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldServletTest {

  private static final String TEST_ENV = "TEST_ENV";
  private static final String TEST_SDK_VERSION = "TEST_SDK_VERSION";

  @Mock private HttpServletRequest mockRequest;
  @Mock private HttpServletResponse mockResponse;

  private StringWriter responseWriter = new StringWriter();

  private HelloWorldServlet testee = new HelloWorldServlet();

  @Before
  public void setUp() throws Exception {
    when(mockResponse.getWriter()).thenReturn(new PrintWriter(responseWriter));
    SystemProperty.environment.set(TEST_ENV);
    SystemProperty.version.set(TEST_SDK_VERSION);
  }

  @Test
  public void helloResponse() {
    String expectedResponse =
        String.format(
            "Hello from App Engine Standard running in \"%s\" environment "
                + "using SDK \"%s\" "
                + "and Java \"%s\" by \"%s\"",
            TEST_ENV,
            TEST_SDK_VERSION,
            System.getProperty("java.specification.version"),
            System.getProperty("java.specification.vendor"));

    testee.doGet(mockRequest, mockResponse);

    assertThat(responseWriter.toString())
        .named("Greeting message with environment data")
        .isEqualTo(expectedResponse);
  }
}

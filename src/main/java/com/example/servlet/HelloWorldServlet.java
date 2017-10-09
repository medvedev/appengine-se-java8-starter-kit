package com.example.servlet;

import com.google.appengine.api.utils.SystemProperty;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

@Log
@WebServlet(name = "HelloWorldServlet", value = "/")
public class HelloWorldServlet extends HttpServlet {

  @Override
  @SneakyThrows
  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    log.info("Custom log message");
    response.setContentType("text/plain");
    response
        .getWriter()
        .printf(
            "Hello from App Engine Standard running in \"%s\" environment "
                + "using SDK \"%s\" "
                + "and Java \"%s\" by \"%s\"",
            SystemProperty.environment.get(),
            SystemProperty.version.get(),
            System.getProperty("java.specification.version"),
            System.getProperty("java.specification.vendor"));
  }
}

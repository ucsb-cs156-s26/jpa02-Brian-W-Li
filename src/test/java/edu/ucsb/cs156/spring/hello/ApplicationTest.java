package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ApplicationTest {

  @Test
  public void test_that_application_starts_without_crashing() {
    Application.main(new String[] { "--spring.main.web-application-type=none" });
    assertTrue(true);
  }
}

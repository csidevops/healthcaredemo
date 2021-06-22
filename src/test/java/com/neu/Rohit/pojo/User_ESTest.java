/*
 * This file was automatically generated by EvoSuite
 * Tue Jun 22 10:07:38 GMT 2021
 */

package com.neu.Rohit.pojo;

import org.junit.Test;
import static org.junit.Assert.*;
import com.neu.Rohit.pojo.Payment;
import com.neu.Rohit.pojo.User;
import java.util.Set;
import org.junit.runner.RunWith;

public class User_ESTest {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      User user0 = new User((String) null, (String) null, (String) null);
      user0.setUserID(960L);
      long long0 = user0.getUserID();
      assertEquals(960L, long0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      User user0 = new User("Ui}^R-Q<Gp'k?c1O{");
      user0.setUserID((-100L));
      long long0 = user0.getUserID();
      assertEquals((-100L), long0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      User user0 = new User("");
      user0.setPayment((Set<Payment>) null);
      Set<Payment> set0 = user0.getPayment();
      assertNull(set0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      User user0 = new User("wX7~p_", "wX7~p_", (String) null);
      user0.setPassword("");
      String string0 = user0.getPassword();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      User user0 = new User("B,U}", "B,U}", "B,U}");
      String string0 = user0.getName();
      assertEquals("B,U}", string0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      User user0 = new User();
      user0.setName("");
      String string0 = user0.getName();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      User user0 = new User("com.neu.Rohit.pojo.BookingDetails");
      String string0 = user0.getEmail();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      User user0 = new User("");
      user0.setEmail("");
      String string0 = user0.getEmail();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      User user0 = new User();
      String string0 = user0.getName();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      User user0 = new User(";R%8tE@cN");
      user0.setPassword(";R%8tE@cN");
      String string0 = user0.getPassword();
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      User user0 = new User(";R%8tE@cN");
      String string0 = user0.getPassword();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      User user0 = new User(";R%8tE@cN");
      Set<Payment> set0 = user0.getPayment();
      user0.setPayment(set0);
      assertEquals(0, set0.size());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      User user0 = new User("B,U}", "B,U}", "B,U}");
      String string0 = user0.getEmail();
      assertEquals("B,U}", string0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      User user0 = new User(";R%8tE@cN");
      long long0 = user0.getUserID();
      assertEquals(0L, long0);
  }
}

package org.ensure.forgetnot.utility;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Aldrich on 4/26/2017.
 */
public class ClockTest {

  public ClockTest() {

  }

  @Test
  public void getJam() throws Exception {
    Clock clock = new Clock("test");
    Assert.assertNotEquals(clock.getJam(), null);
  }

  @Test
  public void setJam() throws Exception {
    Clock clock = new Clock("test");
    clock.setJam(10);
    Assert.assertEquals(clock.getJam(), 10);
  }

  @Test
  public void getMenit() throws Exception {
    Clock clock = new Clock("test");
    Assert.assertNotEquals(clock.getMenit(), null);
  }

  @Test
  public void setMenit() throws Exception {
    Clock clock = new Clock("test");
    clock.setMenit(10);
    Assert.assertEquals(clock.getMenit(), 10);
  }

  @Test
  public void getDetik() throws Exception {
    Clock clock = new Clock("test");
    Assert.assertNotEquals(clock.getDetik(), null);
  }

  @Test
  public void setDetik() throws Exception {
    Clock clock = new Clock("test");
    clock.setDetik(10);
    Assert.assertEquals(clock.getDetik(), 10);
  }

  @Test
  public void addSecond() throws Exception {
    Clock clock = new Clock("test");
    clock.setJam(10);
    clock.setMenit(10);
    clock.setDetik(59);
    clock.addSecond(1);
    Assert.assertEquals(clock.getMenit(), 11);
  }
}
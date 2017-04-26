package org.ensure.forgetnot.utility;

import com.alee.laf.label.WebLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.SwingUtilities;
import java.time.LocalDateTime;


/**
 * class Clock.
 *
 * @author tasya
 */
public class Clock implements Runnable {
  static final Logger logger = LoggerFactory.getLogger(Clock.class);
  public static Clock clock = new Clock("ClockController");
  public boolean stopStatus = false;
  private int hh;
  private int mm;
  private int ss;
  private String threadname;
  private Thread thread;
  private WebLabel clockLabel = new WebLabel();

  /**
   * Constructor.
   */
  public Clock() {
    LocalDateTime now = LocalDateTime.now();
    hh = now.getHour();
    mm = now.getMinute();
    ss = now.getSecond();
    threadname = "ClockControler";
    clockLabel.setText(this.toString());
    logger.info("Creating " + threadname);
  }

  /**
   * Constructor with parameter.
   *
   * @param name Thread name
   */
  public Clock(String name) {
    LocalDateTime now = LocalDateTime.now();
    hh = now.getHour();
    mm = now.getMinute();
    ss = now.getSecond();
    threadname = name;
    clockLabel.setText(this.toString());
    logger.info("Creating " + threadname);
  }

  /**
   * getter jam.
   *
   * @return hh
   */
  public int getJam() {
    return hh;
  }

  /**
   * setter jam.
   *
   * @param jam jam in integer
   */
  public void setJam(int jam) {
    hh = jam;
  }

  /**
   * getter menit.
   *
   * @return mm
   */
  public int getMenit() {
    return mm;
  }

  /**
   * setter menit.
   *
   * @param menit minute in integer
   */
  public void setMenit(int menit) {
    mm = menit;
  }

  /**
   * getter detik.
   *
   * @return ss
   */
  public int getDetik() {
    return ss;
  }

  /**
   * setter detik.
   *
   * @param detik seconds in integer
   */
  public void setDetik(int detik) {
    ss = detik;
  }

  /**
   * Method untuk menambah detik dalam clock.
   *
   * @param second seconds in integer
   */
  public void addSecond(int second) {
    setDetik(getDetik() + second);

    if (getDetik() >= 60) {
      setMenit(getMenit() + getDetik() / 60);
      setDetik(getDetik() % 60);
    }

    if (getMenit() >= 60) {
      setJam(getJam() + getMenit() / 60);
      setMenit(getMenit() % 60);
    }

    if (getJam() >= 24) {
      setJam(getJam() % 24);
    }
  }

  @Override
  public void run() {
    logger.info("Running " + threadname);
    try {
      while (!stopStatus) {
        addSecond(1);
        logger.info("Thread: "
          + threadname
          + ", jam: "
          + getJam()
          + ", menit: "
          + getMenit()
          + ", detik: "
          + getDetik()
        );
        SwingUtilities.invokeLater(() -> clockLabel.setText(this.toString()));
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      logger.info("Thread " + threadname + " interrupted.");
    }
    logger.info("Thread " + threadname + " exiting.");
  }

  /**
   * Start clock.
   */
  public void start() {
    logger.info("Starting " + threadname);
    if (thread == null) {
      thread = new Thread(this, threadname);
      thread.start();
    }
  }

  /**
   * Stop clock, mengubah stop status menjadi true.
   */
  public void stop() {
    stopStatus = true;
  }

  /**
   * method untuk mendapatkan clockLabel.
   *
   * @return clockLabel sebuah WebLabel
   */
  public WebLabel getClockLabel() {
    return clockLabel;
  }

  @Override
  public String toString() {
    String jam = getJam() < 10
      ? "0" + String.valueOf(getJam()) : String.valueOf(getJam());
    String menit = getMenit() < 10
      ? "0" + String.valueOf(getMenit()) : String.valueOf(getMenit());
    String detik = getDetik() < 10
      ? "0" + String.valueOf(getDetik()) : String.valueOf(getDetik());

    return jam + ":" + menit + ":" + detik;
  }
}

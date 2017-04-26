package org.ensure.forgetnot.core;

import com.alee.laf.progressbar.WebProgressBar;
import org.ensure.forgetnot.controller.LoginController;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;

/**
 * Class SplashScreen.
 *
 * @author Rayandrew
 */
public class SplashScreen extends JWindow {
  public static SplashScreen execute;
  private static WebProgressBar progressBar = new WebProgressBar();
  private static int count;
  private static Timer timer1;

  /**
   * Konstruktor.
   *
   * @param image nama gambar
   */
  public SplashScreen(String image) {
    this.getContentPane().setBackground(new Color(0, 0, 0));
    Container container = getContentPane();
    container.setLayout(null);

    JPanel panel = new JPanel();
    panel.setBorder(new javax.swing.border.EtchedBorder());
    panel.setBackground(new Color(0, 0, 0));
    panel.setBounds(10, 10, 348, 150);
    panel.setLayout(null);
    container.add(panel);

    JLabel label = new JLabel(new ImageIcon(image));
    label.setBounds(27, 40, 300, 85);
    panel.add(label);

    JLabel labelCopyright = new JLabel("Created by Ensure 2017");
    labelCopyright.setFont(new Font("Verdana", Font.BOLD, 14));
    labelCopyright.setForeground(Color.white);
    labelCopyright.setBounds(80, 130, 348, 20);
    panel.add(labelCopyright);

    progressBar.setMaximum(100);
    progressBar.setBounds(55, 180, 250, 15);
    container.add(progressBar);
    loadProgressBar();
    setSize(370, 215);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  /**
   * Menampilkan Progress Bar.
   */
  private void loadProgressBar() {
    ActionListener al = evt -> {
      count++;
      progressBar.setValue(count);

      if (count == 100) {
        LoginController log = new LoginController();
        log.init();
        execute.setVisible(false);
        //launcher.launch();
        timer1.stop();
      }

    };
    timer1 = new Timer(50, al);
    timer1.start();
  }
}

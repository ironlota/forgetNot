package org.ensure.forgetnot.view;

import com.alee.extended.panel.GroupPanel;
import com.alee.extended.time.ClockType;
import com.alee.extended.time.WebClock;
import com.alee.laf.button.WebButton;
import com.alee.laf.panel.WebPanel;
import com.alee.managers.notification.NotificationIcon;
import com.alee.managers.notification.NotificationManager;
import com.alee.managers.notification.WebNotification;

import java.awt.Component;

/**
 * Kelas Reminder View.
 *
 * @author Girvandi
 */
public class ReminderView extends View {
  private int idReminder;

  /**
   * Konstruktor tanpa parameter.
   */
  public ReminderView() {
    super("Reminder");
  }

  @Override
  public Component init() {
    final WebButton notification2 = new WebButton("Limited duration notification");
    int x = 2;
    int y = 2;
    if (x == y) {
      final WebNotification notificationPopup = new WebNotification();
      notificationPopup.setIcon(NotificationIcon.clock);
      notificationPopup.setDisplayTime(8000);

      final WebClock clock = new WebClock();
      clock.setClockType(ClockType.timer);
      clock.setTimeLeft(8000);
      clock.setTimePattern("'This notification will close in' ss 'seconds'");
      WebPanel textingReminder = new WebPanel("WEW");
      GroupPanel gp = new GroupPanel();
      gp.add(textingReminder);
      gp.add(clock);
      notificationPopup.setContent(gp);

      NotificationManager.showNotification(notificationPopup);
      clock.start();
    }
    /*notification2.addActionListener ( new ActionListener()
    {
      @Override
      public void actionPerformed ( final ActionEvent e )
      {
        final WebNotification notificationPopup = new WebNotification();
        notificationPopup.setIcon(NotificationIcon.clock);
        notificationPopup.setDisplayTime(5000);
        final WebClock clock = new WebClock();
        clock.setClockType(ClockType.timer);
        clock.setTimeLeft(6000);
        clock.setTimePattern("'This notification will close in' ss 'seconds'");
        notificationPopup.setContent ( new GroupPanel( clock ) );
        NotificationManager.showNotification ( notificationPopup );
        clock.start ();
      }
    } );*/
    notification2.setVisible(false);
    return notification2;
  }
}

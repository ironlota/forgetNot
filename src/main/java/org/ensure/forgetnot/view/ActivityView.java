package org.ensure.forgetnot.view;

import com.alee.extended.layout.TableLayout;
import com.alee.extended.panel.GroupPanel;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebDialog;
import com.alee.laf.spinner.WebSpinner;
import com.alee.laf.text.WebTextField;

import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Button;
import java.awt.Component;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by rufus on 4/23/2017.
 */
public class ActivityView extends View {
  private Panel activityPanel;
  private JTable tab;
  private WebTextField textPane;
  private Button addActivityButton;
  private static String[] activityDescription;

  public ActivityView(int numOfActivities) {
    super("activityView");
    activityPanel = new Panel();
    textPane = new WebTextField(null, 10);
    addActivityButton = new Button("Add a Reminder");
    addActivityButton.addActionListener(new Dialog());
    activityDescription = new String[7];

    String[] columns = {"Activity", "Time"};
    Object[][] data = {{"Memasak", "20.20"}, {"Memasak", "20.20"}, {"Memasak", "20.20"}, {"Memasak", "20.20"}};

    tab = new JTable(data, columns);

    activityPanel.add(tab);
    activityPanel.add(textPane);
    activityPanel.add(addActivityButton);

    //TODO: buat array untuk simpan masukan pengguna
  }

  public void addWebContent(DefaultTableModel table) {
    tab.setModel(table);
  }

  private class Dialog extends WebDialog implements ActionListener{
    private WebTextField title;
    private WebTextField contentReminder;
    private WebSpinner dueDate;
    private WebButton confirm;

    public Dialog() {
      super();
      setSize(500,200);

      TableLayout layout = new TableLayout ( new double[][]{ { TableLayout.PREFERRED, TableLayout.FILL },
          { TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED } } );
      layout.setHGap ( 2 );
      layout.setVGap ( 2 );
      WebPanel content = new WebPanel( layout );
      content.setMargin ( 10, 10, 10, 10 );
      content.setOpaque ( false );

      //fields
      title = new WebTextField("Enter title",15);
      contentReminder = new WebTextField("Enter contentReminder",15);
      dueDate = new WebSpinner();
      SpinnerDateModel spinner = new SpinnerDateModel();
      spinner.setCalendarField(Calendar.YEAR);
      dueDate.setModel(spinner);
      dueDate.setValue(new Date());
      confirm = new WebButton("Set Reminder");

      content.add ( new WebLabel ( "Reminder Title", WebLabel.TRAILING ), "0,0" );
      content.add ( title, "1,0" );

      content.add ( new WebLabel ( "Content", WebLabel.TRAILING ), "0,1" );
      content.add ( contentReminder, "1,1" );

      content.add ( new WebLabel ( "Choose Due Date", WebLabel.TRAILING ), "0,2" );
      content.add ( dueDate, "1,2" );

      add(content);
      add(confirm);
      add(new GroupPanel(false,content, confirm));
      center();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      setVisible(true);
    }
  }

  @Override
  public Component init() {
    return activityPanel;
  }
}

package org.ensure.forgetnot.view;

import com.alee.laf.label.WebLabel;
import com.alee.laf.rootpane.WebFrame;
import org.ensure.forgetnot.utility.Clock;
import org.ensure.forgetnot.utility.Pair;

import javax.swing.SwingUtilities;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.List;

/**
 * Created by rufus on 4/15/2017.
 */
public class MainView extends View {
  public MainView(String componentName) {
    super(componentName);
  }

  public MainView(String componentName, String componentDescription) {
    super(componentName, componentDescription);
  }

  public MainView(String componentName,
                  String componentDescription,
                  List<Pair<String, Object>> dataInput
  ) {
    super(componentName, componentDescription, dataInput);
  }

  public MainView(List<Pair<String, Object>> dataInput) {
    super(dataInput);
  }

  @Override
  public Component init() {
    WebFrame mainWindow = new WebFrame(componentName);
    mainWindow.setSize(new Dimension(600, 400));
    ContainerView container = new ContainerView();
    container.setAxis(1);
    container.init();
    mainWindow.setContentPane(container);
    mainWindow.setState(WebFrame.NORMAL);
    mainWindow.pack();
    mainWindow.setLocationRelativeTo(null);
    mainWindow.setDefaultCloseOperation(WebFrame.EXIT_ON_CLOSE);
    mainWindow.setVisible(true);
    return mainWindow;
  }
}

package org.ensure.forgetnot.controller;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import org.ensure.forgetnot.utility.Pair;
import org.ensure.forgetnot.view.View;

/**
 * Created by rufus on 4/12/2017.
 */
public abstract class Controller {
  protected List<Pair<String, Object>> data = new ArrayList<>();
  protected View view;

  public abstract Component init();
}
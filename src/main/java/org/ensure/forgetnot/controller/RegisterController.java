package org.ensure.forgetnot.controller;

import org.ensure.forgetnot.core.Database;
import org.ensure.forgetnot.model.User;
import org.ensure.forgetnot.utility.PasswordEncryptor;
import org.ensure.forgetnot.utility.PasswordEncryptorException;
import org.ensure.forgetnot.view.RegisterView;

import java.awt.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author girvandi
 */
public class RegisterController extends Controller {
  /**
   * Constructor
   */
  public RegisterController() {
    view = new RegisterView("Register");
    show = false;
  }

  /**
   *
   * @param username username yang akan di register
   * @param password password yang akan di register
   * @param first_name
   * @param last_name
   * @param user_email
   */
  public void registerUser(
      String username,
      String password,
      String first_name,
      String last_name,
      String user_email
  ) {
    Database.connect();
    if(!User.findFirst("user_name = ?", username).exists()){
      try {
        User.createUser(username,
            PasswordEncryptor.generateMd5(password),
            first_name,
            last_name,
            user_email,
            LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            ),
            null);
      } catch (PasswordEncryptorException e) {
        e.printStackTrace();
      }
    }
    Database.close();
  }

  @Override
  public Component init() {
    return view.init();
  }
}

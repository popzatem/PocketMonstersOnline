package org.pokenet.client.ui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.pokenet.client.ui.frames.AboutDialog;
import org.pokenet.client.ui.frames.LoginDialog;
import org.pokenet.client.ui.frames.RegisterDialog;
import org.pokenet.client.ui.frames.ServerDialog;
import org.pokenet.client.ui.frames.ToSDialog;

import mdes.slick.sui.Button;
import mdes.slick.sui.Container;
import mdes.slick.sui.Label;
import mdes.slick.sui.Window;
import mdes.slick.sui.event.ActionEvent;
import mdes.slick.sui.event.ActionListener;

/**
 * The login screen (contains server selector, login and registration)
 * @author shadowkanji
 *
 */
public class LoginScreen extends Window {
	private Label m_bg;
	private ServerDialog m_select;
	private LoginDialog m_login;
	private RegisterDialog m_register;
	private AboutDialog m_about;
	private ToSDialog m_terms;
	private Button m_openAbout, m_openToS;
	private Color m_bgColor;

	/**
	 * Default constructor
	 */
	public LoginScreen() {
		try {
			m_bgColor = new Color(255, 255, 255, 70);
			
			/*
			 * Load the background image
			 */
			m_bg = new Label(new Image("res/pokenet.png"));
			m_bg.pack();
			m_bg.setLocation(0, 0);
			m_bg.setVisible(true);
			this.add(m_bg);
			
			/*
			 * Create the server selector container
			 */
			m_select = new ServerDialog();
			this.add(m_select);
			
			/*
			 * Create the login container
			 */
			m_login = new LoginDialog();
			this.add(m_login);
			
			m_register = new RegisterDialog();
			this.add(m_register);
			
			m_about = new AboutDialog();
			this.add(m_about);
			
			m_terms = new ToSDialog();
			this.add(m_terms);
			
			m_openAbout = new Button("About");
			m_openAbout.setSize(64, 32);
			m_openAbout.setLocation(800 - 64 - 8, 8);
			m_openAbout.setVisible(false);
			m_openAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					showAbout();
				}
			});
			this.add(m_openAbout);
			
			m_openToS = new Button("ToS");
			m_openToS.setSize(64, 32);
			m_openToS.setLocation(800 - 64 - 8, 40);
			m_openToS.setVisible(false);
			m_openToS.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					showToS();
				}
			});
			this.add(m_openToS);
			
			this.setLocation(0, 0);
			this.setSize(800, 600);
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Shows the login dialog
	 */
	public void showLogin() {
		m_select.setVisible(false);
		m_register.setVisible(false);
		m_login.setVisible(true);
		m_openAbout.setVisible(true);
		m_openToS.setVisible(true);
	}
	
	/**
	 * Shows the registration dialog
	 */
	public void showRegistration() {
		m_select.setVisible(false);
		m_login.setVisible(false);
		m_register.setVisible(true);
		m_openAbout.setVisible(true);
		m_openToS.setVisible(true);
	}
	
	/**
	 * Shows the server selection dialog
	 */
	public void showServerSelect() {
		m_register.setVisible(false);
		m_login.setVisible(false);
		m_select.setVisible(true);
		m_openAbout.setVisible(false);
		m_openToS.setVisible(false);
	}
	
	/**
	 * Shows about dialog
	 */
	public void showAbout() {
		m_about.setVisible(true);
	}
	
	/**
	 * Shows the terms of service dialog
	 */
	public void showToS() {
		m_terms.setVisible(true);
	}
}

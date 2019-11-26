package edu.metrostate.ejz360.ics425.p5.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import edu.metrostate.ejz360.ics425.p5.model.Game;

/**
 * Application Lifecycle Listener implementation class MastermindSessionListener
 *
 */
@WebListener
public class MastermindSessionListener implements HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public MastermindSessionListener() {

	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setAttribute("game", new Game());
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {

	}

}

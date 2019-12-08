package edu.metrostate.ejz360.ics425.p5.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.metrostate.ejz360.ics425.p5.model.Game;
import edu.metrostate.ejz360.ics425.p5.model.Guess;
import edu.metrostate.ejz360.ics425.p5.model.Guess.CodePeg;

/**
 * Servlet implementation class MastermindServlet
 */
@WebServlet({ "/mastermind", "/addGuess" })
public class MastermindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MastermindServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Get data from request
		String action = request.getParameter("action");
		log("Action: " + action);

		String[] guessPegs = new String[4];
		guessPegs[0] = request.getParameter("guessPeg1");
		guessPegs[1] = request.getParameter("guessPeg2");
		guessPegs[2] = request.getParameter("guessPeg3");
		guessPegs[3] = request.getParameter("guessPeg4");
		log("GuessPegs from parameters: " + guessPegs);

		guessPegs = validateCodePegs(guessPegs);

		CodePeg[] codePegs = new CodePeg[4];

		for (int i = 0; i < codePegs.length; i++) {
			codePegs[i] = guessPegs[i] != null ? CodePeg.valueOf(guessPegs[i]) : null;
		}
		log("Enums from parameters" + codePegs);

		Guess guess = new Guess();
		guess.setGuessPegs(codePegs[0], codePegs[1], codePegs[2], codePegs[3]);

		// 3. Do the thing
		Game game = (Game) request.getSession().getAttribute("game");
		if (game == null) {
			request.getSession().invalidate();
		} else {
			if (action != null && action.equals("addGuess"))
				game.addGuess(guess);

		}
		// 5. Forward control
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private String[] validateCodePegs(String[] pegsToCheck) {
		String [] codePegs = pegsToCheck.clone();
		HashMap<String, String> paramToColorMap = new HashMap<String, String>();
		paramToColorMap.put("R", "RED");
		paramToColorMap.put("O", "ORANGE");
		paramToColorMap.put("Y", "YELLOW");
		paramToColorMap.put("G", "GREEN");
		paramToColorMap.put("B", "BLUE");
		paramToColorMap.put("P", "PURPLE");

		// 2. Validate guesses
		for (int i = 0; i < codePegs.length; i++) {
			if (!paramToColorMap.containsKey(codePegs[i]))
				codePegs[i] = null;
			else
				codePegs[i] = paramToColorMap.get(codePegs[i]);
		}
		
		return codePegs;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

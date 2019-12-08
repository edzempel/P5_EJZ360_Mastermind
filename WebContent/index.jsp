<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">

<title>P5 EJZ360 Mastermind</title>
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<a class="navbar-brand" href="mastermind">Mastermind</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="mastermind">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="resetGame">New
						Game</a></li>
				<li class="nav-item"><a class="nav-link" href="about.jsp">About</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="container">

			<h2>Let's play!</h2>
			<p>${welcome}</p>
		</div>

		<div id="guesses" class="container">
			<div class="container border">
				<c:forEach items="${game.guesses }" var="guess">
					<div class="row game-column border-dark text-center">
						<c:forTokens items="${guess}" delims="," var="peg">
							<div class="col ${peg} rounded-circle border">${peg}</div>
						</c:forTokens>
					</div>
				</c:forEach>

				<form action="addGuess">
					<div class="form-group row game-column border-dark">
						<c:forTokens items="1,2,3,4" delims="," var="i">
							<div class="col-3">
								<label class="sr-only" for="guess${i}">Guess peg ${i}</label> <input
									class="form-control" list="colors" id="guess${i}"
									name="guessPeg${i}" required>
							</div>
						</c:forTokens>

						<div class="col">
							<input class="form-control" class=".d-none" type="hidden"
								name="action" value="addGuess" /> <input class="form-control"
								type="submit" value="Guess" id="submitGuess" />
						</div>
					</div>

					<datalist id="colors">
						<option value="R">
						<option value="O">
						<option value="Y">
						<option value="G">
						<option value="B">
						<option value="P">
					</datalist>
				</form>

			</div>

			<div class="container">
				<div class="row game-column border border-dark text-center">
					<div class="col peg-code rounded-circle border border-dark">?</div>
					<div class="col peg-code rounded-circle border">?</div>
					<div class="col peg-code rounded-circle border">?</div>
					<div class="col peg-code rounded-circle border">?</div>
				</div>
			</div>

		</div>


	</div>

	<div class="${!empty errMsg ? 'alert alert-danger' : '' }" role="alert">
		<c:forEach var="err" items="${errMsg}">
			<p>
				<span><c:out value="${err.key}" /> :</span>
				<c:out value="${err.value}" />
			</p>
		</c:forEach>

	</div>



</body>
</html>
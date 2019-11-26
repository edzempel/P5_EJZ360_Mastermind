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

		<h2>${game.hello}</h2>
		<p>${welcome}</p>
		<c:forEach var="athlete" items="${roster}">

		</c:forEach>


		<div class="${!empty errMsg ? 'alert alert-danger' : '' }"
			role="alert">
			<c:forEach var="err" items="${errMsg}">
				<p>
					<span><c:out value="${err.key}" /> :</span>
					<c:out value="${err.value}" />
				</p>
			</c:forEach>

		</div>

		<form name="form-add" id="form-add" action="add.jsp" method="post">
			<input class="btn btn-primary" type="submit" value="Add athlete"
				id="submit-add" />

		</form>

	</div>

</body>
</html>
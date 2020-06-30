
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
		<!-- Styles -->
	</head>
	<body>		<center>
			<div id="loginfondo">
				<div class="login">
					<div id="logo"></div>
					<section class="main">
						<form class="form-1" method="post" action="LoginServlet">
							<p class="field">
								<input type="text" id="user" name="user">
								<i class="icon-user icon-large"><img style="margin-top: 4PX;" src="images/usr.PNG"/></i>
							</p>
							<p class="field">
								<input type="password" id="pwd" name="pwd">
								<i class="icon-lock icon-large"><img style="margin-top: 4PX;" src="images/pass.PNG"/></i>
							</p>
							<p class="submit">
								<button type="submit" id="enviar" name="enviar"><i class="icon-arrow-right icon-large"><img style="margin-top: 4PX;" src="images/flecha.PNG"/></i></button>
							</p>
						</form>
					</section>
				</div>
			</div>
		</center>
	</body>
</html>
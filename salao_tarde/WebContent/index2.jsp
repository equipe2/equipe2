<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Projeto e Pratica - Salao Tarde</title>
</head>
<body>
	<c:import url="menu.jsp" />
	
	<form action="efetuarLogin" method="post">
		Login: <input type="text" name="login" /> <br /> 
		Senha: <input type="password" name="senha" /> <br /> 
		<input type="submit" value="Entrar" />
	</form>

</body>
</html>
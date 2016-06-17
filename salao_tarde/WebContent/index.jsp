<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Projeto e Pratica - Salao Tarde</title>
</head>
<body>
	<c:import url="menu.jsp" />
	
<link rel="stylesheet" type="text/css" href="login.css">

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
            <div class="form-login">
            <h4>Bem vindo de volta.</h4>
            <form action="efetuarLogin" method="post">
            <input type="text" id="userName" class="form-control input-sm chat-input" placeholder="login" name="login" />
           
            <input type="password" id="userPassword" class="form-control input-sm chat-input" placeholder="senha" name="senha" />
       
            <div class="wrapper">
            <span class="group-btn">    
            
            <button type="submit"> Login </button>
            </span>
           <br /> 
           </div>
           <a href='#'> Esqueci a senha </a>
            </div>
            </form>
            </div>
        </div>
    </div>
</body>
</html>
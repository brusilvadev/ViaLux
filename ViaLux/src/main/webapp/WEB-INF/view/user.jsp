<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="images/logo-ico.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/border.css">
    <link rel="stylesheet" href="css/place.css">
    <title>Via Lux - Lugar</title>
</head>
<body>
    
    <header>
        <div class="left">
            <a href="home"><img src="images/logo-png.png"></a>
        </div>
        <div class="right">
            <nav>
                <ul>
                    <li><a href="home">Início</a></li>
                    <li><a href="form">Cadastro</a></li>
                </ul>
            </nav>
        </div>
    </header>


    <main>
        <div class="container">
            <div class="left">
                <div class="card">
                    <div class="img-content">
                        <img src="images/funcionario.png">
                    </div>
                    <div class="text-content">
					    <h2>${funcionarios.nome}</h2>
					    <span>Departamento: ${funcionarios.departamento}</span>
					    <span>Cargo: ${funcionarios.cargo}</span>
					    <span>Idade: ${funcionarios.idade}</span>
					    <button><a href="formuser?idFuncionario=${funcionarios.id}">Editar</a></button>
					    <button><a href="deletarFuncionario?idFuncionario=${funcionarios.id}">Deletar</a></button>
					</div>

                        
                        
                </div>
            </div>
            <div class="right"></div>
        </div>
    </main>








    <footer>
        <p>© 2024 DESENVOLVIDO POR BRUNO OLIVEIRA SILVA</p>
        <span>Todos os direitos reservados</span>
    </footer>



</body>
</html>
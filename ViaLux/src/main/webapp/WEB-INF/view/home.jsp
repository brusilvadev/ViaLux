<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="images/logo-ico.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/card.css">
    <link rel="stylesheet" href="css/border.css">
    <link rel="stylesheet" href="css/banner.css">
    <link rel="stylesheet" href="css/general.css">
    <title>Via Lux - Home</title>
</head>
<body>


    <header>
        <div class="left">
            <a href="home"><img src="images/logo-png.png"></a>
        </div>
        <div class="right">
            <nav>
                <ul>
                    <li><a href="home">In�cio</a></li>
                    <li><a href="#about">Sobre N�s</a></li>
                    <li><a href="form">Cadastro</a></li>
                    <li><a href="formuser">Novo Integrante</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <div class="banner">
        <img src="images/banner.png" alt="">
     </div>
    
   <main>
        <h1>N�s providenciamos a sua pr�xima viagem inesquec�vel</h1>
        <h3>Conhe�a nossos pacotes!</h3>

        <div class="card-container">
        
        <c:forEach items="${lugares}" var ="lugar">
        	<div class="card">
                <div class="img-content">
                    <img src="images/Fatima.png">
                </div>
                <div class="text-content">
                    <a href="place?idLugar=${lugar.id}" class="link-form"> 
                    <h2>${lugar.nome}</h2></a>
                    <p>${lugar.descricao}</p>
                    <span>R$ ${lugar.preco}</span>
                </div>
            </div>
        </c:forEach>
            
            
            
        </div>


		<div class="separe">
        <h1>Conhe�a nosso time iluminado</h1>
        <h1>Clique nos nomes nos cards para ser redirecionado</h1>
       </div>

        <div class="card-container">
    <c:forEach items="${funcionarios}" var="funcionario">
        <div class="card">
            <div class="img-content">
                <img src="images/funcionario.png">
            </div>
            <div class="text-content">
                <a href="user?idFuncionario=${funcionario.id}" class="link-form">
                    <h2>${funcionario.nome}</h2>
                </a>
                <p>${funcionario.departamento}</p>
                <p>${funcionario.cargo}</p>
            </div>
        </div>
    </c:forEach>
</div>

	
		

        <div class="about" id="about">
            <div class="about-left">
                <img src="images/family.png">
            </div>
            <div class="about-right">
                <h1>Sobre n�s</h1>
                <p>Na ViaLux, acreditamos que viajar � uma oportunidade �nica de fortalecer la�os familiares e vivenciar a f� de maneira profunda. Somos uma ag�ncia cat�lica e conservadora, especializada em roteiros que promovem valores crist�os, tradi��o e espiritualidade, sempre com foco na fam�lia. Cada viagem � cuidadosamente planejada para proporcionar experi�ncias memor�veis e enriquecedoras, seja em peregrina��es a santu�rios sagrados ou em passeios culturais que inspiram f� e alegria. Viaje conosco e descubra destinos que iluminam a alma!</p>
                <p>Nosso compromisso vai al�m de oferecer destinos tur�sticos. Queremos proporcionar momentos de uni�o, aprendizado e reflex�o. A ViaLux preza pelo cuidado com cada detalhe, garantindo que todas as viagens sejam seguras, confort�veis e acess�veis para todas as idades. Seja em fam�lia, entre amigos ou em um retiro espiritual, nossos roteiros s�o desenhados para quem busca n�o apenas conhecer o mundo, mas tamb�m crescer espiritualmente, fortalecendo sua f� e suas rela��es.

                </p>
            </div>
        </div>
            
            
   </main>

    <br>

    <footer>
        <p>� 2024 DESENVOLVIDO POR BRUNO OLIVEIRA SILVA</p>
        <span>Todos os direitos reservados</span>
    </footer>

</body>
</html>

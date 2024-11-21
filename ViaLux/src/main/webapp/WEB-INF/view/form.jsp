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
    <link rel="stylesheet" href="css/form.css">
    <title>Form</title>
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
        <form method="POST" action="${lugares.id != null ? 'atualizarLugar' : 'adicionarLugar' }?idLugar=${lugares.id}">
            <div>
                <label>Foto</label>
                <input type="file">
            </div>
    
            <div>
                <label>Nome</label>
                <input value="${lugares.nome}" name="nome"  type="text" required>
            </div>
            
            <div>
                <label>Preço</label>
                <input value="${lugares.preco}" name="preco"  type="text" required>
            </div>
    
            <div>
                <label>Descrição</label>
                <input value="${lugares.descricao}" name="descricao"  type="text" required>
            </div>
    
            <div>
                <label>País</label>
                <input value="${lugares.pais}" name="pais"  type="text" required>
            </div>
    
            <div>
                <label>Idioma</label>
                <input value="${lugares.idioma}" name="idioma"  type="text" required>
            </div>
            
            <div>
                <label>Moeda</label>
                <input value="${lugares.moeda}" name="moeda"  type="text" required>
            </div>
    
    
    
            <button type="submit">Cadastrar</button>
    
        </form>
    </main>




    <footer>
        <p>© 2024 DESENVOLVIDO POR BRUNO OLIVEIRA SILVA</p>
        <span>Todos os direitos reservados</span>
    </footer>
</body>
</html>
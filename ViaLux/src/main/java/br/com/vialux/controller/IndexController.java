package br.com.vialux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.vialux.dao.ConnectionFactory;
import br.com.vialux.dao.FuncionarioDao;
import br.com.vialux.dao.LugarDao;
import br.com.vialux.model.Funcionario;
import br.com.vialux.model.Lugar;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String inicio() {
		// Conectar ao banco de dados
		ConnectionFactory.conectar();
		// Redirecionar para rota /home
		return "redirect:home";
	}

	@RequestMapping("/home") // http://localhost:8080 /
	// String -> Retorno de uma pagina
	public String index(Model model) { // org.springframework
		LugarDao dao = new LugarDao();
		FuncionarioDao dao2 = new FuncionarioDao();
		
		
		// items="${pizzas}"
		model.addAttribute("lugares", dao.listar());
		model.addAttribute("funcionarios", dao2.listar());
		
		
		return "home"; // home.html
	}

    @RequestMapping("/form")
    public String form(Long idLugar, Model model) {
    	LugarDao dao = new LugarDao();
    	Lugar l = new Lugar();
    	if (idLugar != null) {
			l = dao.buscar(idLugar);
		}
		
		model.addAttribute("lugares", l);
		
		return "form"; // form.html
    }
    @RequestMapping("/formuser")
    public String formuser(Long idFuncionario, Model model) {
    	FuncionarioDao dao2 = new FuncionarioDao();
    	Funcionario f = new Funcionario();
    	if (idFuncionario != null) {
			f = dao2.buscar(idFuncionario);
		}
		
		model.addAttribute("funcionarios", f);
		
		return "formuser"; //
    }

    @RequestMapping("/place")
	public String lugar(Long idLugar, Model model) {
		LugarDao dao = new LugarDao();
		
		model.addAttribute("lugares", dao.buscar(idLugar));
		
		return "place";
	}
    
    @RequestMapping("/user")
  	public String funcionario(Long idFuncionario, Model model) {
    	FuncionarioDao dao2 = new FuncionarioDao();
  		
  		model.addAttribute("funcionarios", dao2.buscar(idFuncionario));
  		
  		return "user";
  	}

    @RequestMapping(value = "adicionarLugar", method = RequestMethod.POST)
    public String adicionarLugar(Lugar lugar) {
        LugarDao dao = new LugarDao();
		dao.inserir(lugar);
		return "redirect:home";
    }
    
    @RequestMapping(value = "adicionarFuncionario", method = RequestMethod.POST)
    public String adicionarFuncionario(Funcionario funcionario) {
        FuncionarioDao dao2 = new FuncionarioDao();
		dao2.inserir(funcionario);
		return "redirect:home";
    }


    @RequestMapping(value = "atualizarLugar", method = RequestMethod.POST)
	public String atualizarLugar(Long idLugar, Lugar l) {
		LugarDao dao = new LugarDao();
		
		dao.atualizar(l, idLugar);
		
		return "redirect:home";
	}
    
    @RequestMapping(value = "atualizarFuncionario", method = RequestMethod.POST)
   	public String atualizarFuncionario(Long idFuncionario, Funcionario f) {
   		FuncionarioDao dao2 = new FuncionarioDao();
   		
   		dao2.atualizar(f, idFuncionario);
   		
   		return "redirect:home";
   	}

    @RequestMapping("deletarLugar")
	public String deletarLugar(Long idLugar) {
		
		LugarDao dao = new LugarDao();
		dao.excluir(idLugar);
		
		return "redirect:home";
	}
    
    @RequestMapping("deletarFuncionario")
	public String deletarFuncionario(Long idFuncionario) {
		
		FuncionarioDao dao2 = new FuncionarioDao();
		dao2.excluir2(idFuncionario);
		
		return "redirect:home";
	}
}

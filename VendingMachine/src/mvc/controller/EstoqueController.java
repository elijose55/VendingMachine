package mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.model.DepositoDAO;
import mvc.model.Material;


@Controller
public class EstoqueController {
	
	@RequestMapping("/")
	public String execute() {
		System.out.println("Lógica do MVC");
		return "redirect:inicio";
		}
	
	
	
	
	//pagina inicial de materiais
	@RequestMapping(value={"inicio"})
	public String inicio(Model model) throws SQLException, IOException, ParseException {
		DepositoDAO dao = new DepositoDAO();
		ArrayList<Material>  materiais =  (ArrayList<Material>) dao.getLista();
		model.addAttribute("material", materiais);
		return "index";	
	}
	
	@RequestMapping(value= {"cliente"})
	public String inicio_cliente(Model model) throws SQLException, IOException, ParseException {
		DepositoDAO dao = new DepositoDAO();
		ArrayList<Material>  materiais =  (ArrayList<Material>) dao.getLista();
		model.addAttribute("material", materiais);
		return "index_cliente";	
	}
	
	
	@RequestMapping("criaMaterial")
			 public String form() {
			 return "formMaterial";
			 }
	
	@RequestMapping("adicionaMaterial")
	 public String adicionaMaterial(
			 @RequestParam(value = "nome") String nome,
			 @RequestParam(value = "quantidade") Integer quantidade,
			 @RequestParam(value = "preco") Integer preco) throws SQLException, IOException{
		System.out.print(quantidade);
		System.out.print(nome);
		DepositoDAO dao = new DepositoDAO();
		Material material = new Material();
		
		material.setNome(nome);
		material.setQuantidade(quantidade);
		material.setPreco(preco);
		dao.adiciona(material);
		dao.close();
		return "redirect:inicio";
	 }
	
	@RequestMapping("criaSugestao")
	 public String sugestao() {
	 return "formSugestao";
	 }
	
	@RequestMapping("adicionaSugestao")
	 public String adicionaSugestao(
			 @RequestParam(value = "nome") String nome) throws SQLException, IOException{
		System.out.print(nome);
		DepositoDAO dao = new DepositoDAO();
		Material material = new Material();
		
		material.setNome(nome);
		dao.adicionaSugestao(material);
		dao.close();
		return "redirect:cliente";
	 }
	@RequestMapping(value= {"sugeridos"})
	public String inicio_sugestao(Model model) throws SQLException, IOException, ParseException {
		DepositoDAO dao = new DepositoDAO();
		ArrayList<Material>  materiais =  (ArrayList<Material>) dao.getListaSugestao();
		model.addAttribute("material", materiais);
		return "index_sugestoes";	
	}
	}



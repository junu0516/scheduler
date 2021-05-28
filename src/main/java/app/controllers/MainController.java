package app.controllers;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import app.models.product.Product;
import app.models.product.ProductService;
import app.models.purchase.PurchaseHistory;
import app.models.purchase.PurchaseService;

@Controller
@RequestMapping("/scheduler")
public class MainController {

	@Autowired
	ProductService productService;
	
	@Autowired
	PurchaseService purchaseService;
	
	@GetMapping("/main")
	public String showMain(Model model) throws Exception {
		
		List<Product> products = productService.selectProducts();
		model.addAttribute("products",products);
		
		return "main";
	}
	
	@GetMapping("/history")
	public String showHistories(Model model) throws Exception{
		
		List<PurchaseHistory> histories = purchaseService.selectHistories();
		model.addAttribute("histories",histories);
		
		return "history";
	}
	
	@PostMapping("/product")
	@ResponseBody
	public String insertProduct(@Valid @RequestBody Product product, HttpServletResponse response) throws Exception {
		
		product.setProductDate(new Timestamp(System.currentTimeMillis()).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
		PrintWriter out = response.getWriter();
		
		try {
			int result = productService.insertProduct(product);
			System.out.print(result+"건 등록");
		}catch(Exception e) {
			out.print("fail");
		}

		out.print("success");
		
		return null;
	}
	
	@PostMapping("/history")
	@ResponseBody
	public String insertHistory(@RequestBody PurchaseHistory purchaseHistory, HttpServletResponse response) throws Exception {
		
		System.out.println(purchaseHistory);
		
		PrintWriter out = response.getWriter();
		
		try {
			int result = purchaseService.insertHistory(purchaseHistory);
			System.out.println(result+"건 등록");
		}catch(Exception e) {
			out.print("fail");
		}
		
		out.print("success");
		
		return null;
	}
	
}

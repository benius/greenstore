package com.greenstyle.greenstore;

import com.greenstyle.greenstore.dao.ProductDao;
import com.greenstyle.greenstore.model.Product;
import com.greenstyle.greenstore.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GreenstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(GreenstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GreenstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ProductService productService) {
		return (args) -> {
			// Save Products for demonstration
			productService.createProduct(new Product("紅薏仁沖調粉單包", 74L, "PQ0000000382.png", "更換原料紅薏仁來源，採用喜願契作友善環境種植的紅薏仁碎粒製作，與台灣本地新鮮採收的「薏苡」，無農藥、無化肥管理種植，本品無添加糖、百分百呈現原味。可以加入其他穀粉、麥片食用。"));
			productService.createProduct(new Product("長秈白米(宜蘭)3kg", 295L, "PQ0000000378.jpg", "無使用農藥、化肥，生產者自己碾製，掌控安全，維持品質。本品品種為台中秈10號。口感不黏不膩，適合年長者食用。"));
			productService.createProduct(new Product("長秈糙米(宜蘭)3kg", 285L, "PQ0000000379.jpg", "無使用農藥、化肥，生產者自己碾製，掌控安全，維持品質。本品品種為台中秈10號。口感不黏不膩，適合年長者食用。"));
			productService.createProduct(new Product("黑麥汁整組(6入)", 228L, "PQ0000000371.jpg", "採用德國麥芽、忽布花、酵母，使用德國純釀法，不加其他輔料和焦糖色素，天然發酵而成，不稀釋。放入冷藏或加入冰塊，清涼又消暑！"));
			productService.createProduct(new Product("石斑魚頭(半邊)(2件)", 230L, "PQ0000000377.jpg", "指定生產者黃芬香海水養殖場，以純海水粗放養殖，過程中不使用抗生藥劑，收成時立刻放血，加工處理後以超低溫冷凍保存，確保魚肉鮮度。"));
			productService.createProduct(new Product("公平貿易有機綠豆單包", 166L, "PQ0000000367.jpg", "首次供應烏茲別克的農產品。烏茲別克大陸型氣候適合種植綠豆，通過奧地利有機驗證，當地農民組織因參與世界公平貿易組織(WFTO)，故收購價較好，農民收入穩定，並有公平貿易組織的社區發展基金得以改善生活。"));
			productService.createProduct(new Product("冷凍烤地瓜整組(2包)", 200L, "PQ0000000358.jpg", "採用合作社農友以無農藥、無化肥所種植的地瓜，經分級後烤熟，採急速冷凍方式，保留地瓜風味。退冰後可即食；或採微波、烤箱加熱食用。"));
			productService.createProduct(new Product("不漂白再生抽取衛生紙(130抽)整箱(48包)", 870L, "PQ0000000240.png", "使用100% 回收紙再製成再生衛生紙，沒有脫墨與漂白紙張的處理程序，不需備有廢水處理，可以節省更多水資源！"));

			// Find all products
			log.info("Find all products:\n==============================================");
			Iterable<Product> allProducts = productService.findAllProducts();
			for (Product product: allProducts) {
				log.info(product.toString());
			}
		};
	}
}

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    -Contains logic to retrieve products from the given site, sorts the products and generates Json file.
 */
public class ScrappingService {

    public ScrappingService() {
    }

    public String doScrape(){
        List<ProductDetails> productDetailsList = new ArrayList<>(0);
        ProductDetails productDetails = null;
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

//      Set up the URL with the search term and send the request
        String searchUrl = "https://wltest.dns-systems.net/";
        try {
            HtmlPage page = client.getPage(searchUrl);
            DomNodeList<DomNode> domNodeDomNodeList = page.querySelectorAll(".package ");
            for (DomNode domNode : domNodeDomNodeList) {
                String desc = domNode.querySelector(".package-description").asNormalizedText();
                String header = domNode.querySelector(".header").asNormalizedText();
                String price = domNode.querySelector(".package-price").asNormalizedText();

                //System.out.println("header :: " + header);

                String productPrice = price.substring(0, price.indexOf("(")).replace("£", "").trim();
                //System.out.println("productPrice :: " + productPrice);
                String discountPrice = price.indexOf("Save £") != -1 ? price.substring(price.indexOf("Save £"), price.indexOf("on")).replaceAll("Save £", "").trim() : "";
                //System.out.println("discountPrice :: " + discountPrice);
                productDetails = new ProductDetails(header, desc, new BigDecimal(productPrice), discountPrice);

                productDetailsList.add(productDetails);
            }

            Collections.sort(productDetailsList, Comparator.comparing(ProductDetails::getPrice).reversed());
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(productDetailsList);

            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "scrapping done successfully";
    }
}

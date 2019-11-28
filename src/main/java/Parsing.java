import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parsing {

    public static List<Product> getProductAtributes() throws IOException {
        String mainUrl = "https://www.aboutyou.de/maenner/bekleidung";
        Document docPage = Jsoup.connect(mainUrl).get();

        List<Product> productsList = new ArrayList<>();

        Elements productTitles = docPage
                .getElementsByAttributeValue("class", "sc-1n50fuf-0 kOgykq");
        productTitles.forEach(productTitle -> {
            for (int i = 0; i < 4; i++) {
                Element productElement = productTitle.child(i);
                String productId = productElement.attr("id");
                String brand = productElement
                        .getElementsByAttributeValue("class", "sc-1gv4rhx-1 khcmRE").text();
                String price = productElement
                        .getElementsByAttributeValue("class", "sc-1gv4rhx-5 dvRlpm").text();

                productsList.add(new Product(productId, brand, price));
            }

        });

        return productsList;
    }
}

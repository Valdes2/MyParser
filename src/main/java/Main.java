import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Product> products = Parsing.getProductAtributes();
        CreateXmlFile.createXmlFile(products);

        System.out.println("Amount of extracted products: " + products.size());
    }
}

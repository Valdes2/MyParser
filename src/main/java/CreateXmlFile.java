import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXmlFile {

    private static final Logger logger = Logger.getLogger(CreateXmlFile.class);

    private static final String FILENAME = "parsedData.xml";

    public static Document createXmlFile(List<Product> products) {

        try {
            Document document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().newDocument();
            Element shop = document.createElement("shop");
            document.appendChild(shop);

            for (Product prod:products) {
                Element product = document.createElement("product");
                shop.appendChild(product);
                product.setAttribute("id", prod.getProductId());

                Element brand = document.createElement("brand");
                brand.setTextContent(prod.getBrand());
                product.appendChild(brand);

                Element price = document.createElement("price");
                price.setTextContent(prod.getPrice());
                product.appendChild(price);
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(System.getProperty("user.dir")
                    + File.separator + FILENAME));
            transformer.transform(source, result);

            return document;
        } catch (ParserConfigurationException | TransformerConfigurationException e) {
            logger.error(e.getMessage());
            return null;
        } catch (TransformerException e) {
            logger.error(e);
            return null;
        }
    }

}

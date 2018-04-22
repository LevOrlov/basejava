import java.io.*;

import myPackage.TestSerial;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyClass {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        TestSerial ts = new TestSerial();
        oos.writeObject(ts);
        oos.flush();
        oos.close();
        //восставновление
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        TestSerial ts1 = (TestSerial) oin.readObject();
        System.out.println("version="+ts.version);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        try {
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            Document doc = factory.newDocumentBuilder().newDocument();
            Node item = null;
            Node item1 = null;

            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Element root = doc.createElement("booking");
            item = doc.createElement("bookingID");
            item1 = doc.createElement("bookingID1");
            item.appendChild(doc.createTextNode("115"));
            item1.appendChild(doc.createTextNode("1151111"));
            root.appendChild(item);
            root.appendChild(item1);
            doc.appendChild(root);
            File file = new File("C:\\Users\\Lev\\basejava\\temp1.xml");

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(doc), new StreamResult(file));
           // System.out.print(doc.getDocumentElement().getSchemaTypeInfo());
            Document document = builder.parse(new File("C:\\Users\\Lev\\basejava\\temp1.xml"));
            XPath xPath = XPathFactory.newInstance().newXPath();
            Node node = (Node) xPath.evaluate("/booking/bookingID1", document, XPathConstants.NODE);
            System.out.println(node.getTextContent());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

    }
}

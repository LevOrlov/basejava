import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
 class FileVisitor implements java.nio.file.FileVisitor<Path> {
    public FileVisitResult visitFile(Path path,
                                     BasicFileAttributes fileAttributes) {
       // System.out.println("file name:" + path.getFileName());
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path path,
                                             BasicFileAttributes fileAttributes) {
        for (int i=3; i< path.getNameCount();i++){
            System.out.print("\t");
        }
        System.out.println("Directory name:" + path);

        return FileVisitResult.CONTINUE;
    }
     public FileVisitResult visitFileFailed(Path file, IOException exc)
             throws IOException {
         System.out.println("visitFileFailed: " + file);
         return FileVisitResult.CONTINUE;
     }


     public FileVisitResult postVisitDirectory(Path dir, IOException exc)
             throws IOException {
         //System.out.println("postVisitDirectory: " + dir);
         return FileVisitResult.CONTINUE;
     }
}
public class MyClass {
   /* public static void main(String args[]) throws IOException, ClassNotFoundException {
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

    }*/

 /*  //STREAM
   public static void main(String[] args) {
       Stream.of(1, 2, 3)
               .forEach(System.out::println);
   }*/


  /*  public static void main(String[] args) {
        Path pathSource = Paths.get("C:\\Users\\Lev\\basejava\\temp.out");
        try {
            Files.createFile(pathSource);
           // Files.delete(pathSource);
            System.out.println("File deleted successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/



    public static void main(String[] args) throws IOException {

        Path pathSource = Paths.get("C:/Users/Lev/basejava");
        String path;
        path = pathSource+"\\kdkd";
        pathSource=Paths.get(path);
        System.out.println(pathSource.getFileName());

       /* try {

            Files.walkFileTree(pathSource, new FileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*String pathString = "C:\\Users\\Lev\\basejava";
        Files.walkFileTree(Paths.get(pathString), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                    throws IOException {
                System.out.println("preVisitDirectory: " + dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                System.out.println("visitFile: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc)
                    throws IOException {
                System.out.println("visitFileFailed: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                    throws IOException {
                System.out.println("postVisitDirectory: " + dir);
                return FileVisitResult.CONTINUE;
            }
        });
*/

    }
}


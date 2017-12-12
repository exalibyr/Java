import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MyParser {
    public void parse(String fileName, ArrayList<Song> songList) {
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse(fileName);

            // Получаем корневой элемент
            Node root = document.getDocumentElement();

            // Просматриваем все подэлементы корневого
            NodeList songs = root.getChildNodes();
            for (int i = 0; i < songs.getLength(); i++) {
                Node song = songs.item(i);
                Song newSong = new Song();
                // Если запись не текст, то это книга - заходим внутрь
                if (song.getNodeType() != Node.TEXT_NODE) {
                    NodeList songProps = song.getChildNodes();
                    for(int j = 0; j < songProps.getLength(); j++) {
                        Node songProp = songProps.item(j);
                        // Если запись не текст, то это один из параметров книги - печатаем
                        if (songProp.getNodeType() != Node.TEXT_NODE) {
                            String name = songProp.getNodeName();
                            String textContent = songProp.getChildNodes().item(0).getTextContent();
                            if ("Title".equals(name)){
                                newSong.setTitle(textContent);
                            }
                            if ("Album".equals(name)){
                                newSong.setAlbum(textContent);
                            }
                            if ("Author".equals(name)){
                                newSong.setAuthor(textContent);
                            }
                            if ("Duration".equals(name)){
                                newSong.setDuration(textContent);
                            }
                        }
                    }
                    songList.add(newSong);
                }
            }

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    public Song parseJAXB(String fileName) {
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(Song.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (Song) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }


    public Music parseList(String fileName) {
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(Music.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Music parsedCustomerList = (Music) jaxbUnmarshaller.unmarshal(file);

            return  parsedCustomerList;

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;

    }
}


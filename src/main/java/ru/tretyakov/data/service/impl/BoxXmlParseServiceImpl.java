package ru.tretyakov.data.service.impl;

import org.springframework.stereotype.Component;
import ru.tretyakov.data.models.Box;
import ru.tretyakov.data.models.ElementLestener;
import ru.tretyakov.data.service.api.XmlParseService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.util.Optional;

import static java.util.Optional.ofNullable;

/**
 * @author A.Tretyakov.
 * @since 05.10.19
 */
@Component
public class BoxXmlParseServiceImpl implements XmlParseService {

    private static final String ELEMENT_NAME = "Box";

    @Override
    public Optional<Box> parse(String path) {
        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource(path);
        XMLStreamReader xsr = null;
        Optional<Box> box = Optional.empty();

        try {
            xsr = xif.createXMLStreamReader(xml);
            xsr.nextTag();
            while(!ELEMENT_NAME.equals(xsr.getLocalName())) {
                xsr.nextTag();
            }

            JAXBContext jc = JAXBContext.newInstance(Box.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshaller.setListener(new ElementLestener());
            box = ofNullable(unmarshaller.unmarshal(xsr, Box.class))
                      .map(JAXBElement::getValue);

        } catch (JAXBException | XMLStreamException e) {
            System.err.println(e.getMessage());
        } finally {
            if (xsr != null) {
                try {
                    xsr.close();
                } catch (XMLStreamException e) {
                     System.err.println(e.getMessage());
                }
            }
        }
        return box;
    }
}

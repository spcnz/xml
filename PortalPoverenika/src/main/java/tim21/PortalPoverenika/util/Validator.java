package tim21.PortalPoverenika.util;

import org.springframework.util.ResourceUtils;
import tim21.PortalPoverenika.jaxb.JaxB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import java.io.StringReader;

import static tim21.PortalPoverenika.util.constants.XSDConstants.xsdPathMap;

import static tim21.PortalPoverenika.util.constants.NamespaceConstants.schemaNamespace;

public class Validator {

    private static JaxB jaxB = new JaxB();

    public static <T> boolean validate(Class genericClass, T objectValidate){

        String path = xsdPathMap.get(genericClass.getSimpleName());

        try {
            String objectValidateString = jaxB.marshall(genericClass, objectValidate);

            SchemaFactory factory = SchemaFactory.newInstance(schemaNamespace);
            Schema schema = factory.newSchema(ResourceUtils.getFile(path));

            JAXBContext context = JAXBContext.newInstance(genericClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setSchema(schema);

            unmarshaller.unmarshal(new StringReader(objectValidateString));

        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
}

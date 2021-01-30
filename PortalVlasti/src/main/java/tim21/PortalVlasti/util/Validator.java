package tim21.PortalVlasti.util;

import org.springframework.util.ResourceUtils;
import tim21.PortalVlasti.jaxb.JaxB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.StringReader;

import static tim21.PortalVlasti.util.constants.NamespaceConstants.SCHEMA_NAMESPACE;
import static tim21.PortalVlasti.util.constants.XSDConstants.xsdPathMap;

public class Validator {

    private static JaxB jaxB = new JaxB();

    public static <T> boolean validate(Class genericClass, T objectValidate){

        String path = xsdPathMap.get(genericClass.getSimpleName());

        try {
            String objectValidateString = jaxB.marshall(genericClass, objectValidate);

            SchemaFactory factory = SchemaFactory.newInstance(SCHEMA_NAMESPACE);
            Schema schema = factory.newSchema(ResourceUtils.getFile(path));

            JAXBContext context = JAXBContext.newInstance(genericClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setSchema(schema);

            unmarshaller.unmarshal(new StringReader(objectValidateString));

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }

        return true;
    }
}

package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@RestController
public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Value("classpath:pain.001.001.02.xsd")
    private Resource xsdResource;

    @RequestMapping(value = "/submit/",  method = RequestMethod.POST)
    @ResponseBody
    public String home(@RequestBody byte[] requestBody) throws Exception {
        logger.info("submit post method called");
        //String fileName = "target.filename.xml";
        //Files.write(Paths.get(fileName), requestBody);
        logger.info("file received:\n" + new String(requestBody));
        try {
            //ClassLoader classLoader = getClass().getClassLoader();
            //File xsdFile = new File(classLoader.getResource("pain.001.001.02.xsd").getFile());
            File xsdFile = xsdResource.getFile();
            InputStream xsdStream = new FileInputStream(xsdFile);

            ByteArrayInputStream xmlFile = new ByteArrayInputStream(requestBody);

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsdStream));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));

            return "<message>OK</message>";
        }
        catch(Exception ex)
        {
            logger.info("exception handled" + ex.getMessage());
            return "<message>" + ex.getMessage() + "</message>";
        }
    }

}

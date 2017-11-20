package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @RequestMapping(value = "/submit/",  method = RequestMethod.POST)
    @ResponseBody
    public String home(@RequestBody byte[] requestBody) throws Exception {
        logger.info("submit post method called");
        String fileName = "target.filename.xml";
        Files.write(Paths.get(fileName), requestBody);
        return "<message>OK</message>";
    }

}

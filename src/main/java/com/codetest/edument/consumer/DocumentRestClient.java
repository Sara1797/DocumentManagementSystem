package com.codetest.edument.consumer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Creating RestApi Client
public class DocumentRestClient {
    static final String URL_IMPORT_DOCUMENT = "http://localhost:8080/import"; // localhost Url for importDocuments
    static final String URL_STATUS_DOCUMENT = "http://localhost:8080/status"; // localhost Url for status of operations

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        DocumentRestClient clientObj = new DocumentRestClient();

        for (int i = 0; i < 5; i++) {
            clientObj.callImportDocumentAPI();
            clientObj.callGetStatus();
        }

    }

    // Making Call to importDocument Method
    public void callImportDocumentAPI() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> res = restTemplate.postForEntity(URL_IMPORT_DOCUMENT, null, String.class);
        logger.info(res.toString());
    }

    // Making Call getStatus Method
    public void callGetStatus() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> res = restTemplate.getForEntity(URL_STATUS_DOCUMENT, String.class);
        logger.info(res.toString());

    }

}

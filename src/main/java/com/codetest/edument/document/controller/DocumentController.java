package com.codetest.edument.document.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codetest.edument.document.service.DocumentService;
import com.codetest.edument.document.util.ResponseMessage;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    // Importing the document post mapping
    @PostMapping("/import")
    public ResponseEntity<ResponseMessage> importDocument() {
        // no-op Importing a document
        String message = "";
        try {
            documentService.importDocument();
            message = "Document Imported Successfully";
            // returning Created Status Code and returning successful responseMessage
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to import files!";
            //// returning Expectation Failed Status Code and returning failed
            //// responseMessage
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    // getting the status of operations using Threads get mapping
    @GetMapping("/status")
    public void getStatus() {
        documentService.getStatus();
    }

}
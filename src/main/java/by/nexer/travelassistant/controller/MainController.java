package by.nexer.travelassistant.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping()
    public String getPublicPage(){
        return "Main page";
    }

    @GetMapping("/admin")
    public ResponseEntity<String> getAdminPage() {
        return ResponseEntity.ok("Admin page");
    }
}

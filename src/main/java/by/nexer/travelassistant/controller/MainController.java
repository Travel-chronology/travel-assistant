package by.nexer.travelassistant.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MainController {
    @Operation(summary = "Admin page", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/api/v1/admin")
    public ResponseEntity<String> getAdminPage() {
        return ResponseEntity.ok("Admin page");
    }
}

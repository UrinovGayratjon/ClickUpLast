package uz.urinov.clickuplast.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.urinov.clickuplast.payload.LoginRequest;
import uz.urinov.clickuplast.payload.RegisterRequest;
import uz.urinov.clickuplast.service.AuthService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Auth Controller")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(summary = "Login", description = "Tizimga kirish")
    @ApiResponse(responseCode = "200", description = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c", content = @Content)
    @PostMapping(path = "/login", consumes = APPLICATION_JSON_VALUE, produces = "text/plain")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    @Operation(summary = "Registration", description = "Yangi foydalanuvchini ro'yhatga olish")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "422", description = "Username already exists", content = {@Content}),
            @ApiResponse(responseCode = "201", description = "User registered successfully", content = @Content)
    })
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @Operation(summary = "Account activated", description = "Email orqali hisobni faollashtirish uchun mo'ljallangan havola")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User verified successfully", content = {@Content}),
            @ApiResponse(responseCode = "400", description = "Invalid code", content = {@Content}),
            @ApiResponse(responseCode = "404", description = "User not found", content = {@Content}),
            @ApiResponse(responseCode = "406", description = "The user account cannot be activated because you do not have an active activation code. Please contact the developer if you want to know the reason.", content = {@Content}),
    })
    @GetMapping(value = "/verify")
    public ResponseEntity<?> verifyEmailCode(@RequestParam(name = "code") String code, @RequestParam(name = "email") String email) {
        return authService.verifyEmailCode(code, email);
    }
}

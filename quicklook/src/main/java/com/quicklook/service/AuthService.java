	package com.quicklook.service;

import com.quicklook.dto.JwtResponse;
import com.quicklook.dto.LoginRequest;
import com.quicklook.model.Usuario;
import com.quicklook.repository.UsuarioRepository;
import com.quicklook.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public JwtResponse authenticate(LoginRequest request) {
        Usuario usuario = usuarioRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        String token = jwtUtil.generateToken(usuario.getEmail());
        return new JwtResponse(token);
    }
}

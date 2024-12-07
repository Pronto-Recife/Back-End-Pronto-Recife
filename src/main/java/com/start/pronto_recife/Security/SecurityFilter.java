//package com.start.pronto_recife.Security;
//
//import com.start.pronto_recife.Exceptions.AuthorizationHeaderException;
//import com.start.pronto_recife.Exceptions.CustomException;
//import com.start.pronto_recife.Service.TokenService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.validation.constraints.NotNull;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//@RequiredArgsConstructor
//public class SecurityFilter extends OncePerRequestFilter {
//
//    private final TokenService tokenService;
//
//    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
//        if (request.getRequestURI().startsWith("/swagger") ||
//        request.getRequestURI().startsWith("/v3/api-docs") ||
//        request.getRequestURI().startsWith("/paciente/register") ||
//        request.getRequestURI().startsWith("/medico/register") ||
//        request.getRequestURI().startsWith("/profissional-saude/register") ||
//        request.getRequestURI().startsWith("/authorization/login")){
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String token = this.recoverToken(request);
//        String validatedToken = tokenService.validateToken(token);
//        String email = tokenService.getEmailFromToken(validatedToken);
//
//        if (email == null || email.isEmpty()) {
//            throw new CustomException("Não foi possivel receber o email de autenticação do usuário ou o token!", HttpStatus.UNAUTHORIZED, null);
//        }
//        if (validatedToken.isEmpty()) {
//            throw new CustomException("Não foi possivel receber o email de autenticação do usuário ou o token!", HttpStatus.UNAUTHORIZED, null);
//        }
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, null);
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//        filterChain.doFilter(request, response);
//    }
//    private String recoverToken (@NonNull HttpServletRequest request){
//        String authHeader = request.getHeader("Authorization");
//        if (authHeader == null || authHeader.isEmpty()) {
//            throw new AuthorizationHeaderException();
//        }
//        return authHeader.substring(7);
//    }
//}

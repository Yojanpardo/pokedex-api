package dev.yojanpardo.common.authorization;

import dev.yojanpardo.user.application.service.UserService;
import dev.yojanpardo.user.domain.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtToken jwtTokenService;
    private final UserService userService;

    private static final String AUTH_HEADER = "Authorization";
    private static final String BEARER = "Bearer ";


    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader(AUTH_HEADER);

        if (Objects.isNull(authHeader) || !authHeader.startsWith(BEARER)){
            filterChain.doFilter(request, response);
            return;
        }

        final String jwt = authHeader.substring(7);
        final String username = jwtTokenService.getUsername(jwt);

        if (
                !username.isEmpty()
                && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())
        ) {

            final User user = userService.getUserByUsername(username);

            if (jwtTokenService.isTokenValid(jwt, user)){
                final SecurityContext context = SecurityContextHolder.createEmptyContext();
                final UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        user, null, user.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                context.setAuthentication(authToken);
                SecurityContextHolder.setContext(context);
            }
        }
        filterChain.doFilter(request, response);

    }
}

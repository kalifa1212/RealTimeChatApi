package com.theh.realchatapi.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    String Email;
    String passwd;
}

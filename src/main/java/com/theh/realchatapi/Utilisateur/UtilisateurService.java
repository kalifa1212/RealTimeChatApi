package com.theh.realchatapi.Utilisateur;


import com.theh.realchatapi.Exceptions.ErrorCodes;
import com.theh.realchatapi.Exceptions.InvalidEntityException;
import com.theh.realchatapi.Message.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UtilisateurService {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_PATTERN);
    private final UtilisateurRepository repository;
    List<String> errors = new ArrayList<>();
    @Autowired
    private SimpMessagingTemplate template;
    public Utilisateur authentication(String Email, String Password){
        Utilisateur utilisateur =repository.findUserByEmail(Email);
        if(utilisateur!=null){
            if(Password.equals(utilisateur.getMotDePasse())){
                utilisateur.setStatus(Status.ONLINE);
                repository.save(utilisateur);
                return utilisateur;
            }
            throw new InvalidEntityException("mot de passe incorrect", ErrorCodes.BAD_CREDENTIAL);
        }
        throw new InvalidEntityException("l'utilisaeur n'existe pas", ErrorCodes.USER_NOT_EXIST);


    }

    public Utilisateur saveUser(SingIn user) {
        Utilisateur utilisateur =repository.findByEmail(user.getEmail());
        if(utilisateur!=null) {
           throw new InvalidEntityException("l'utilisaeur existe", ErrorCodes.USER_EXIST);
        }
        if(!PATTERN.matcher(user.getEmail()).matches())
        {
            throw new InvalidEntityException("Email incorrect", ErrorCodes.EMAIL_INCORRECT,errors);
        }
        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setNom(user.getNom());
        utilisateur1.setPrenom(user.getPrenom());
        utilisateur1.setEmail(user.getEmail());
        utilisateur1.setMotDePasse(user.getMotDePasse());
        utilisateur1.setStatus(Status.ONLINE);
        utilisateur1.setIdentifiant(user.getIdentifiant());
        utilisateur1.setDateDeNaissance(user.getDateDeNaissance());

        utilisateur1=repository.save(utilisateur1);
        this.template.convertAndSend("/topic/public",new Notification(utilisateur1.getId(),
                utilisateur1.getIdentifiant(), "ONLINE"));
        return utilisateur1;
    }

    public Utilisateur disconnect(Utilisateur utilisateur) {
        var storedUser = repository.findByEmail(utilisateur.getEmail());
        if (storedUser != null) {
            storedUser.setStatus(Status.OFFLINE);
            storedUser.setLastSeen(new Date());
            return repository.save(storedUser);
        }
        return null;
    }

    public List<Utilisateur> findConnectedUsers() {
        return repository.findAllByStatus(Status.ONLINE);
    }
    public Optional<Utilisateur> findUsers(Long id) {
        return repository.findById(id);
    }
}
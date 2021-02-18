package ir.team.eventmanager.domain;

import static ir.team.eventmanager.domain.Authority.*;

public enum Role {

    MANAGER(SAVE_USER,DELETE_USER,UPDATE_USER,LOAD_USER),USER();

    private Authority[] authorities;

    Role(Authority... authorities) {
        this.authorities = authorities;
    }
}

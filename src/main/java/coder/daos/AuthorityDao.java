package coder.daos;

import coder.models.Authority;
import org.springframework.stereotype.Component;

@Component
public interface AuthorityDao {

    void addAuthority(Authority authority);
}

package org.its.dl.user;

import java.util.List;

public interface UserDL {
    List<UtenteDL> getAll();

    UtenteDL add(UtenteDL utenteDL);

    boolean delete(Integer id);

    UtenteDL getUserById(Integer id);

    void update(UtenteDL utenteDL) throws Exception;
}

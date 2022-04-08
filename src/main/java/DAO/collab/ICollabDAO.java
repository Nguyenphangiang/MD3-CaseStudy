package DAO.collab;

import DAO.IDAO;
import entity.Account;
import model.Collab;

public interface ICollabDAO extends IDAO<Collab> {
    public Account checkLogin(String email, String pass);
}

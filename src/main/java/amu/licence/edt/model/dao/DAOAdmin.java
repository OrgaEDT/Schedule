package amu.licence.edt.model.dao;

import amu.licence.edt.model.beans.Admin;

public interface DAOAdmin extends DAO<Admin> {

    Admin findByLoginPassword(String login, String password);

}

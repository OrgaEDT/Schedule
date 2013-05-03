package amu.licence.edt.model.dao;

import amu.licence.edt.model.beans.TU;

public interface DAOTU extends DAO<TU> {

    TU getByLibel(String libel);

}

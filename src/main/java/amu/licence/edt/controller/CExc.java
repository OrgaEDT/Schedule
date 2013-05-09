package amu.licence.edt.controller;

import java.sql.SQLException;

public class CExc extends Exception {
    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;

    public CExc(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public CExc(Exception e) {
        super();
        // convert to sql exception and parse msg to get the user defined message
        SQLException sqle = toSQLException(e);
        if (sqle == null) {
            code = 42;
            msg = "Unknown error : " + e.getMessage();
        } else {
            code  = sqle.getErrorCode();
            msg = sqle.getMessage();
            String errorCode = String.valueOf(code);
            int msgIndex = msg.indexOf(errorCode)+errorCode.length()+2;
            msg = msg.substring(msgIndex, msg.indexOf("\n", msgIndex));
        }
    }

    private SQLException toSQLException(Exception e) {
        if (null == e.getCause()) return null;
        try {
            SQLException sqlExc = (SQLException) e.getCause().getCause();
            if (null == sqlExc) {
                sqlExc = (SQLException) e.getCause();
            }
            return (sqlExc instanceof SQLException) ? sqlExc : null;
        } catch (ClassCastException cce) {
            return null;
        }
    }

    public String getDefaultTitle() {
        return "Erreur " + getCode();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return msg;
    }

}

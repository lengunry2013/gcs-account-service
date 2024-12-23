package com.gcs.account.common.exception;

/**
 * exception when search or update the database.
 */

public class DBException extends Exception {

    /**
     * VersionUID.
     */
    private static final long serialVersionUID = -1354900322422944802L;

    /**
     * constructor.
     *
     * @param messageNo
     * @param cause
     * @author ninghl 2009-7-27
     */
    public DBException(String messageNo, Throwable cause) {
        super(messageNo, cause);
    }
}

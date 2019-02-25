package com.murtaza.employeemanagement;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class ServiceUnavailableException extends Exception {

}

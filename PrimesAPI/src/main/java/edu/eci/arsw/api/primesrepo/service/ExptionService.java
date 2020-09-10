/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.api.primesrepo.service;

import org.springframework.http.HttpStatus;

/**
 *
 * @author diego
 */
public class ExptionService extends Exception{
    
    
    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    
    public ExptionService(String message) {
        super(message);
    }

    public ExptionService(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
    
}

package com.startdis.comm.web.auth;

import com.startdis.comm.util.auth.AuthInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc AuthHandler
 */
public interface AuthHandler {
    AuthInfo getAuthInfo(HttpServletRequest request, HttpServletResponse response);
}

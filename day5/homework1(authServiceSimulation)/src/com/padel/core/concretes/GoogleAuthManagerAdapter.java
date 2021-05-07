package com.padel.core.concretes;

import com.padel.GoogleService.GoogleAuthManager;
import com.padel.core.abstracts.AuthService;

public class GoogleAuthManagerAdapter implements AuthService {
    @Override
    public void signInWithExternalService() {
        GoogleAuthManager googleAuthManager = new GoogleAuthManager();
        googleAuthManager.signInWithGoogle();
    }
}

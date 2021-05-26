package com.padel.HRMS.core.utilities;

import com.padel.HRMS.FakeMernis;

public class IdentityValidation {
    public static boolean isRealPerson(String idNumber) {
        FakeMernis mernis = new FakeMernis();
        return FakeMernis.validate(idNumber);
    }
}

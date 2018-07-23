package com.ke.auth.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence charSequence) {
		return DigestUtils.sha256Hex(charSequence.toString());
	}

	@Override
	public boolean matches(CharSequence charSequence, String s) {
		return encode(charSequence).equals(s);
	}
}

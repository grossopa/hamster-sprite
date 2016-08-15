/**
 * 
 */
package org.hamster.sprite.service.user.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.ByteSource;
import org.hamster.sprite.dao.entity.UserLoginEntity;
import org.hamster.sprite.service.user.UserPasswordService;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Service
public class UserPasswordServiceImpl implements UserPasswordService {

    private static final int HASH_ITERATIONS = 3355;

    @Override
    public String hashPassword(String password, ByteSource salt) {
        String hashedPasswordBase64 = new Sha256Hash(password, salt, HASH_ITERATIONS).toBase64();
        return hashedPasswordBase64;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.user.UserPasswordService#generateSalt()
     */
    @Override
    public ByteSource generateSalt() {
        RandomNumberGenerator rng = new SecureRandomNumberGenerator();
        return rng.nextBytes(12);
    }

    /* (non-Javadoc)
     * @see org.hamster.sprite.service.user.UserPasswordService#generateToken()
     */
    @Override
    public String generateToken() {
        return RandomStringUtils.random(UserLoginEntity.TOKEN_LENGTH);
    }

}

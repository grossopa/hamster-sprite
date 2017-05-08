/**
 * 
 */
package org.hamster.sprite.service.password.impl;

import java.security.SecureRandom;
import java.util.List;

import javax.annotation.Resource;

import org.hamster.sprite.service.password.ifc.PasswordCharacterSupplier;
import org.hamster.sprite.service.password.ifc.PasswordGenerationService;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.hamster.sprite.api.exception.Exceptions;
import com.hamster.sprite.api.password.PasswordGenerationType;

/**
 * generate password, seed comes from Math.random()
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
@Service("DefaultPasswordGenerationService")
public class DefaultPasswordGenerationServiceImpl implements PasswordGenerationService {

    @Resource(name = "DefaultPasswordCharacterSupplier")
    private PasswordCharacterSupplier supplier;

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.sprite.service.password.PasswordGenerationService#generatePassword(int)
     */
    @Override
    public String generatePassword(int length, int passwordGenerationType) {
        SecureRandom random = new SecureRandom();

        if (length <= PasswordGenerationType.values().length) {
            throw Exceptions.PWDC002.create(null, PasswordGenerationType.values().length);
        }

        char[] password = new char[length];
        List<Integer> typeIndexList = Lists.newArrayList();
        for (int i = 0; i < PasswordGenerationType.values().length; i++) {
            int type = PasswordGenerationType.values()[i];
            if ((passwordGenerationType & type) != 0) {
                password[this.nextRandomEmptyIndex(random, password)] = randomCharacter(random, supplier.get(type));
                typeIndexList.add(i);
            }
        }

        int index;
        while ((index = nextRandomEmptyIndex(random, password)) != -1) {
            password[index] = randomCharacter(random, supplier.get(randomType(random, typeIndexList)));
        }

        return String.valueOf(password);
    }

    protected int nextRandomEmptyIndex(SecureRandom random, char[] password) {
        int nullCount = 0;
        for (char ch : password) {
            if (ch == 0) {
                nullCount++;
            }
        }

        if (nullCount == 0) {
            return -1;
        }

        int randomNumber = random.nextInt(nullCount);
        for (int i = 0; i < password.length; i++) {
            if (password[i] != 0) {
                randomNumber++;
                continue;
            } else if (i == randomNumber) {
                return randomNumber;
            }
        }

        throw new IndexOutOfBoundsException("randomNumber " + randomNumber + " and password nullCount " + nullCount);
    }

    protected char randomCharacter(SecureRandom random, char[] list) {
        return list[random.nextInt(list.length)];
    }

    protected int randomType(SecureRandom random, List<Integer> types) {
        return PasswordGenerationType.values()[types.get(random.nextInt(types.size()))];
    }

    /**
     * @param supplier
     *            the supplier to set
     */
    public void setSupplier(PasswordCharacterSupplier supplier) {
        this.supplier = supplier;
    }

}

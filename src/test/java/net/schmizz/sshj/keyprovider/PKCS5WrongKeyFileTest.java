/*
 * Copyright (C)2009 - SSHJ Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.schmizz.sshj.keyprovider;

import net.schmizz.sshj.userauth.keyprovider.FileKeyProvider;
import net.schmizz.sshj.userauth.keyprovider.PKCS5KeyFile;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class PKCS5WrongKeyFileTest {

    @Test
    public void doesNotLeak() throws IOException {
        FileKeyProvider rsa = new PKCS5KeyFile();
        rsa.init(new File("src/test/resources/rsa_no_new_line.pk5"));
        try {
            rsa.getPublic();
        } catch (PKCS5KeyFile.FormatException e) {
            assertEquals("Unrecognized PKCS5 key type", e.getMessage());
        }
    }
}

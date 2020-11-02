/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webauthn4j.util;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A Utility class for MessageDigest
 */
public class MessageDigestUtil {


    private MessageDigestUtil() {
    }

    public static @NonNull MessageDigest createMessageDigest(@NonNull String hashAlgorithm) {
        try {
            switch (hashAlgorithm) {
                case "S256":
                    return MessageDigest.getInstance("SHA-256");
                case "S384":
                    return MessageDigest.getInstance("SHA-384");
                case "S512":
                    return MessageDigest.getInstance("SHA-512");
                default:
                    return MessageDigest.getInstance(hashAlgorithm);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static @NonNull MessageDigest createSHA256() {
        return createMessageDigest("SHA-256");
    }

}

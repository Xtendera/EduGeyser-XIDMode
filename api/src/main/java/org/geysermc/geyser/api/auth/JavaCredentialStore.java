/*
 * Copyright (c) 2019-2026 GeyserMC. http://geysermc.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/Geyser
 */

package org.geysermc.geyser.api.auth;

import org.geysermc.geyser.api.GeyserApi;
import org.geysermc.geyser.api.connection.GeyserConnection;
import org.jspecify.annotations.Nullable;

/**
 * Stores the Microsoft authentication chains Geyser uses to log sessions in to online-mode Java servers.
 * When registered with {@link GeyserApi#javaCredentialStore(JavaCredentialStore)}, it replaces the
 * {@code saved-user-logins} config option: every session connecting to an online-mode server may have
 * its login saved, and the store decides how it is keyed and persisted.
 */
public interface JavaCredentialStore {

    /**
     * Gets the saved authentication chain for this connection.
     *
     * @param connection the connection logging in
     * @return the serialized authentication chain, or null if the player must sign in again
     */
    @Nullable String load(GeyserConnection connection);

    /**
     * Saves an authentication chain for this connection. Called after a successful sign-in and
     * whenever a saved chain is refreshed.
     *
     * @param connection the connection that logged in
     * @param authChain the serialized authentication chain
     */
    void save(GeyserConnection connection, String authChain);
}

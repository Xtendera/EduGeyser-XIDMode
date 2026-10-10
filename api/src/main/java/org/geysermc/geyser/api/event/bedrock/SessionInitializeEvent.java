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

package org.geysermc.geyser.api.event.bedrock;

import org.geysermc.geyser.api.connection.GeyserConnection;
import org.geysermc.geyser.api.event.connection.ConnectionEvent;
import org.geysermc.geyser.api.network.RemoteServer;
import org.geysermc.geyser.api.util.PlatformType;

import java.util.Objects;

/**
 * Called when Geyser initialises a session for a new bedrock client.
 */
public final class SessionInitializeEvent extends ConnectionEvent {
    private RemoteServer remoteServer;

    public SessionInitializeEvent(GeyserConnection connection, RemoteServer remoteServer) {
        super(connection);
        this.remoteServer = remoteServer;
    }

    /**
     * Gets the {@link RemoteServer} the session will connect to.
     *
     * @return the remote server for this session
     */
    public RemoteServer remoteServer() {
        return this.remoteServer;
    }

    /**
     * Sets the {@link RemoteServer} for this session. Unlike {@link SessionLoginEvent#remoteServer(RemoteServer)},
     * this runs before authentication, so the {@link RemoteServer#authType()} of the given server decides
     * whether the session logs in to the Java server with a Microsoft account or connects in offline mode.
     * This method will only work as expected on {@link PlatformType#STANDALONE}.
     *
     * @param remoteServer the remote server for this session
     */
    public void remoteServer(RemoteServer remoteServer) {
        this.remoteServer = Objects.requireNonNull(remoteServer, "remoteServer");
    }
}

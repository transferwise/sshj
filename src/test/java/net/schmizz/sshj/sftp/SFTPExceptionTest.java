package net.schmizz.sshj.sftp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SFTPExceptionTest {

    @Test
    public void testNullStatusCode() {
        SFTPException ex = new SFTPException((Response.StatusCode) null, "message");
        assertEquals("message[null]", ex.getMessage());
    }

    @Test
    public void testNotNullStatusCode() {
        SFTPException ex = new SFTPException(Response.StatusCode.CONNECITON_LOST, "message");
        assertEquals("message[CONNECITON_LOST]", ex.getMessage());
    }
}

package org.acme.mspoc.emp;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Random;

@Mock
@RestClient
public class MockTIdProxy implements TIdProxy{

    public TId generate(){
        TId id = new TId();
        id.setTid("T0" + new Random().nextInt(1000000));

        return id;
    }
}

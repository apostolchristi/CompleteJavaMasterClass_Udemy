package com.timbuchalka;

import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;

public class Moon extends HeavenlyBody {

    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.MOON);
    }
}

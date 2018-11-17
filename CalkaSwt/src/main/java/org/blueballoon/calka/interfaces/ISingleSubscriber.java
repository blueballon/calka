package org.blueballoon.calka.interfaces;


public interface ISingleSubscriber
{
    // the publisher passes a reference to itself so that the subscriber can access the updated data
    // evtl weglassen - bei 1:1 eher vorher merken und dann daten direkt abfragen
    public void updateFromPublisher(Object publisher);
}

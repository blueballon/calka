package org.blueballoon.calka.interfaces;

// Interface for 1:1 Publisher-Subscriber-Implementations

public interface ISinglePublisher
{
    public void registerSubscriber(ISingleSubscriber subscriber);
    public void deleteSubscriber();
    public void notifySubscriber();
}

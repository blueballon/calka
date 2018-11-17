package org.blueballoon.calka;

import org.blueballoon.calka.uiwrapper.UiEvents;


// central controller calls for Calka, implemented as singelton
public class CalkaController
{
  // for singelton: controller instance
  private static CalkaController controllerInstance;

  // for singelton: hidden constructor
  private CalkaController () {}

  // for singelton: instance method
  public static CalkaController getInstance () {
    if (CalkaController.controllerInstance == null) {
      CalkaController.controllerInstance = new CalkaController ();
    }
    return CalkaController.controllerInstance;
  }

  // receives framework-neutral ui-events
  // intended to be called from ui-listeners
  public void receiveUiEvent(UiEvents event)
  {
      System.out.println("The event was: " + event);
  }


}

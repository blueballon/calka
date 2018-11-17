package org.blueballoon.calka.calkaswt;

import org.eclipse.swt.events.*;
import org.blueballoon.calka.uiwrapper.UiEvents;
import org.blueballoon.calka.CalkaController;


// class to reduce boilerplate code within calculator buttons
// SelectionEdapter is directly instantiated with the wrapped ui events
// and sends it directly to the controller singleton
class CalkaSwtSelectionAdapter extends SelectionAdapter
{
    private UiEvents m_event;

    public CalkaSwtSelectionAdapter(UiEvents event)
    {
        m_event=event;
    }

    public void widgetSelected(SelectionEvent e) {
        CalkaController controller = CalkaController.getInstance();
        controller.receiveUiEvent(m_event);
    }
}

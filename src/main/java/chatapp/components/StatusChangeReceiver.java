/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.components;

import chatapp.components.Statuses;

import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author alexis
 */

@MessageDriven(mappedName = "jms/ParticipantStatusBroadcast")

public class StatusChangeReceiver implements MessageListener {
    
  @Inject
  private Statuses statuses;

  @Override
  public void onMessage(Message message) {
    if (message instanceof TextMessage) {
      try {
        TextMessage myStatus = (TextMessage) message;
        String status = myStatus.getText();
        String [] nameStatus = status.split(":");
        statuses.statusMap.put(nameStatus[0], nameStatus[1]);
      } catch (JMSException ex) { 
       
      }
    }
  }
}

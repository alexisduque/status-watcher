/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.components;

import chatapp.components.Statuses;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.annotation.Resource;
import javax.ejb.*;
/**
 *
 * @author alexis
 */

@MessageDriven(mappedName = "jms/ParticipantStatusBroadcast")

public class StatusChangeReceiver implements MessageListener {
   
  private static final Logger logger = Logger.getLogger(StatusChangeReceiver.class. getCanonicalName());

  @EJB
  public Statuses statuses;

  @Resource
  private MessageDrivenContext context;
  public void onMessage(Message message) {
    if (message instanceof TextMessage) {
      try {
        TextMessage myStatus = (TextMessage) message;
        String status = myStatus.getText();
        String [] nameStatus = status.split(":");
        statuses.statusMap.put(nameStatus[0], nameStatus[1]);
        logger.log(Level.INFO, nameStatus[0]+" is "+nameStatus[1]);

      } catch (JMSException e) {
        logger.log(Level.SEVERE, "Could not get the message body", e);
        context.setRollbackOnly();
      }

    }
  }
}

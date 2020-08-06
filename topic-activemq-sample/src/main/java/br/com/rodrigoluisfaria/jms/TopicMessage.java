package br.com.rodrigoluisfaria.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.rodrigoluisfaria.controller.MessageController;

public class TopicMessage {

	private Connection connection;
	private Session session;
	private Topic topic;

	public TopicMessage() throws NamingException, JMSException  {
		InitialContext context = new InitialContext();

		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		connection = factory.createConnection();

		connection.start();

		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		topic = session.createTopic("knowledge-sharing");
	}

	public void send(String message) {
		try {
			Message msg = session.createTextMessage(message);
			MessageProducer producer = session.createProducer(topic);

			producer.send(msg);
		} catch (JMSException e) {
			throw new RuntimeException("Erro ao enviar a mensagem");
		}
	}

	public void startListener(MessageController messageController) {
		try {
			MessageConsumer messageConsumer = session.createConsumer(topic);
			messageConsumer.setMessageListener(new MessageListener() {

				@Override
				public void onMessage(Message message) {
					TextMessage textMessage = (TextMessage) message;
					try {
						messageController.updateMessage(textMessage.getText());
					} catch (JMSException e) {
						throw new RuntimeException("Erro ao capturar a mensagem");
					}
				}
			});

		} catch (JMSException e) {
			throw new RuntimeException("Erro ao capturar a mensagem");
		}
	}

	
}

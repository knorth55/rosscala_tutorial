package com.github.rosscala_tutorial.rosscala_tutorial_pubsub

import org.ros.message.MessageListener
import org.ros.node.AbstractNodeMain
import org.ros.namespace.GraphName
import org.ros.node.ConnectedNode
import org.ros.node.NodeMain
import org.ros.node.topic.Subscriber
import org.apache.commons.logging.Log

class Listener extends AbstractNodeMain {

  override def getDefaultNodeName(): GraphName = {
    GraphName.of("rosscala_tutorial_pubsub/listener")
  }

  override def onStart(connectedNode: ConnectedNode) {
    val log = connectedNode.getLog();
    var subscriber: Subscriber[std_msgs.String] = connectedNode.newSubscriber("chatter", std_msgs.String._TYPE)
    subscriber.addMessageListener(new MessageListener[std_msgs.String]() {
      override def onNewMessage(message: std_msgs.String) {
        log.info("I heard: \"" + message.getData() + "\"")
      }
    })
  }
}

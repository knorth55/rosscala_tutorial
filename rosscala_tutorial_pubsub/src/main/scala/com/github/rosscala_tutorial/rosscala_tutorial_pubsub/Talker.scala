package com.github.rosjava.rosscala_tutorial.rosscala_tutorial_pubsub

import org.ros.concurrent.CancellableLoop
import org.ros.namespace.GraphName
import org.ros.node.AbstractNodeMain
import org.ros.node.ConnectedNode
import org.ros.node.NodeMain
import org.ros.node.topic.Publisher

class Talker extends AbstractNodeMain {
  
  override def getDefaultNodeName() : GraphName = {
    GraphName.of("rosscala_tutorial_pubsub/talker")
  }

  override def onStart(connectedNode:ConnectedNode) {
    var publisher: Publisher[std_msgs.String] = connectedNode.newPublisher("chatter", std_msgs.String._TYPE)
    connectedNode.executeCancellableLoop(new CancellableLoop() {
      var sequenceNumber = Int()

      override def setup() {
        sequenceNumber = 0
      }

      @throws(classOf[InterruptedException])
      def loop() {
        var str: std_msgs.String = publisher.newMessage()
        str.setData("Hello world! " + sequenceNumber)
        publisher.publish(str)
        sequenceNumber++
        Thread.sleep(1000)
      }
    })
  }
}

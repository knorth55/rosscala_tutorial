# rosscala_tutorial
## OverView
rosjava + gradle + scala tutorial package

## Description
### rosscala_tutorial_pubsub
Simple Talker and Listener

## Requirement
* ros (indigo)
* rosjava
* java (java-8-oracle)
* scala (2.9.2)  

## Build

```bash
$ mkdir -p catkin_ws/src
$ cd catkin_ws/src
$ git clone https://github.com/knorth55/rosscala_tutorial.git
$ rosdep install --from-path . --ignore-src -y -r
$ cd ..
$ catkin build
```
## Sample Launch

```bash
$ source catkin_ws/devel/setup.bash
$ roslaunch rosscala_tutorial simpleTalkerListener.launch
```
## Author
[knorth55](https://github.com/knorth55)

##############################################################################
# CMake
##############################################################################

cmake_minimum_required(VERSION 2.8.3)
project(rosscala_tutorial)

##############################################################################
# Catkin
##############################################################################

find_package(catkin REQUIRED 
    rosjava_build_tools
    std_msgs
)

# Set the gradle targets you want catkin's make to run by default, e.g.
#   catkin_rosjava_setup(installApp)
# Note that the catkin_create_rosjava_xxx scripts will usually automatically
# add tasks to this for you when you create subprojects.
catkin_rosjava_setup(installApp)

catkin_package()

add_custom_command(OUTPUT ${PROJECT_SOURCE_DIR}/rosscala_tutorial_pubsub/bin/execute
  DEPENDS ${PROJECT_SOURCE_DIR}/rosscala_tutorial_pubsub/build.gradle
  COMMAND ../gradlew deployApp
  WORKING_DIRECTORY ${PROJECT_SOURCE_DIR}/rosscala_tutorial_pubsub/)
add_custom_target(link_execute ALL
  DEPENDS ${PROJECT_SOURCE_DIR}/rosscala_tutorial_pubsub/bin/execute)
##############################################################################
# Installation
##############################################################################

# Change this to match the maven group name you have specified in the 
# allprojects closure the root build.gradle
install(DIRECTORY ${CATKIN_DEVEL_PREFIX}/${CATKIN_GLOBAL_MAVEN_DESTINATION}/com/github/${PROJECT_NAME}/
        DESTINATION ${CATKIN_GLOBAL_MAVEN_DESTINATION}/com/github/${PROJECT_NAME})

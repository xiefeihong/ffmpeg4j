cmake_minimum_required(VERSION 3.28)
project(ffmpeg)

set(CMAKE_CXX_STANDARD 20)
set(JAVA_HOME /usr/local/oracle/jdk-21)
#set(JDK_INCLUDE $ENV{JAVA_HOME}/include $ENV{JAVA_HOME}/include/linux)
set(JDK_INCLUDE ${JAVA_HOME}/include ${JAVA_HOME}/include/linux)

message("JDK INCLUDE: " ${JDK_INCLUDE})

file(GLOB FFLIBS_SRC
        src/libffmpeg/*.c
        src/fftools/*.c
)

include_directories(
        ${JDK_INCLUDE}
        /usr/local/ffmpeg-6.1.2/include
        include/fftools
        include
)

link_directories(
        /usr/local/ffmpeg-6.1.2/lib
)

add_library(ffmpeg SHARED
        ${FFLIBS_SRC}
)

target_link_libraries(ffmpeg PRIVATE
        avcodec avdevice avfilter avformat avutil swresample swscale
)

install(TARGETS ffmpeg
        LIBRARY DESTINATION lib
)
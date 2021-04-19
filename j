#!/bin/bash

my_exit() {
    echo $1
    exit $2
}

java_file() {
    cat >> $filename << EOF
public class $classname {
    static public void main(String [] args) {
    }
}
EOF
    vim ${filename} +2 "+normal o"
}

java_run() {
    javac $filename && java $classname && rm *.class -rf
}

classname=${1}
test -z "$classname" && my_exit "必须指定目标!" 1
classname=${classname%.java*}
filename=${classname}.java

if test -f "$filename" ; then
    java_run
else
    java_file
fi


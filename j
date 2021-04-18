#!/bin/bash

classname=${1-kyo}

cat >> ${classname}.java << EOF
public class ${classname} {
    static public void main(String [] args) {
    }
}
EOF

vim ${classname}.java +2 "+normal o"

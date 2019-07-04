#!/usr/bin/env bash

script_dir=$(cd -P -- "$(dirname -- "$0")" && pwd -P)

javac "$script_dir/src/Server.java"
mv src/Server.class "$script_dir"
jar cvfm "$script_dir/server.jar" "$script_dir/src/MANIFEST.MF" Server.class
rm -f "$script_dir/Server.class"
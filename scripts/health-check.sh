#!/bin/bash -ex

pushd `dirname $0` > /dev/null
base=$(pwd -P)
popd > /dev/null

# gather some data about the repo
source $base/vars.sh

[ `curl -s -o /dev/null -w "%{http_code}" http://$APP-$SHA.apps.cf2.piazzageo.io` = 200 ]
